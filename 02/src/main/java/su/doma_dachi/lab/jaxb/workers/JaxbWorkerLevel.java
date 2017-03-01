package su.doma_dachi.lab.jaxb.workers;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import su.doma_dachi.lab.dao.DaoFactory;
import su.doma_dachi.lab.dao.GenericDao;
import su.doma_dachi.lab.dao.PersistException;
import su.doma_dachi.lab.domain.Level;
import su.doma_dachi.lab.jaxb.decarators.Levels;
import su.doma_dachi.lab.postgres.PostgresDaoFactory;
import su.doma_dachi.lab.postgres.PostgresLevelDao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JaxbWorkerLevel {

    private static final Logger logger = Logger.getLogger(JaxbWorkerLevel.class);

    static {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }

    // восстанавливаем объект из XML файла
    public static void fromXmlToObject(String filePath) {
        DaoFactory daoFactory = new PostgresDaoFactory();
        List<Level> list;
        try (Connection connection = (Connection) daoFactory.getContext()) {
            GenericDao levelDao = daoFactory.getDao(connection, Level.class);
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Levels.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            Levels o = (Levels) un.unmarshal(new File(filePath));
            logger.info(o.getLevels().size());
            for (Level level : o.getLevels()) {
                levelDao.persist(level);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (PersistException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        // сохраняем объект в XML файл
    private static void convertObjectToXml(List<Level> list, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Levels.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            Levels obj = new Levels();
            obj.setLevels(list);
            //маршаллинг объекта в файл
            marshaller.marshal(obj, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void parseLevelToXml() {
        logger.info("Application started");
        /**
         * определяем название файла, куда будем сохранять
         */
        String fileName = "Levels.xml";
        //создаем объект Level с данными из бд
        DaoFactory daoFactory = new PostgresDaoFactory();
        List<Level> list;
        try (Connection connection = (Connection) daoFactory.getContext()) {
            GenericDao levelDao = daoFactory.getDao(connection, Level.class);
            list = levelDao.getAll();

            //for (Level level:list) {
            // сохраняем объект в XML файл
            convertObjectToXml(list, fileName);
            // восстанавливаем объект из XML файла
            fromXmlToObject(fileName);
            // }
        } catch (SQLException e) {
            logger.error("Проблема с БД", e);
        } catch (PersistException e) {
            logger.error("Проблема с таблицей", e);
            e.printStackTrace();
        }
        logger.info("Application finished");
    }
}


