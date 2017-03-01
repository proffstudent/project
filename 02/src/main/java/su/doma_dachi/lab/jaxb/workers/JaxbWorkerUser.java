package su.doma_dachi.lab.jaxb.workers;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import su.doma_dachi.lab.dao.DaoFactory;
import su.doma_dachi.lab.dao.GenericDao;
import su.doma_dachi.lab.dao.PersistException;
import su.doma_dachi.lab.domain.Level;
import su.doma_dachi.lab.domain.User;
import su.doma_dachi.lab.jaxb.decarators.Levels;
import su.doma_dachi.lab.jaxb.decarators.Users;
import su.doma_dachi.lab.postgres.PostgresDaoFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JaxbWorkerUser {

    private static final Logger logger = Logger.getLogger(JaxbWorkerUser.class);
    static {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }

    // восстанавливаем объект из XML файла
    private static Level fromXmlToObject(String filePath) {
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Level.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            return (Level) un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    // сохраняем объект в XML файл
    private static void convertObjectToXml(List<User> list, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            Users obj = new Users();
            obj.setUsers(list);
            //маршаллинг объекта в файл
            marshaller.marshal(obj, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void parseUserToXml(){
        logger.info("Application started");
        /**
         * определяем название файла, куда будем сохранять
         */
        String fileName = "Users.xml";
        //создаем объект Level с данными из бд
        DaoFactory daoFactory = new PostgresDaoFactory();
        List<User> list;
        try (Connection connection = (Connection) daoFactory.getContext()) {
            GenericDao userDao = daoFactory.getDao(connection, User.class);
            list = userDao.getAll();
            //for (Level level:list) {
            // сохраняем объект в XML файл
            convertObjectToXml(list, fileName);
            // восстанавливаем объект из XML файла
            //Level unmarshStudent = fromXmlToObject(fileName);
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


