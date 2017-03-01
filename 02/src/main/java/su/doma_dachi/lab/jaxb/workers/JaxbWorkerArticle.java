package su.doma_dachi.lab.jaxb.workers;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import su.doma_dachi.lab.dao.DaoFactory;
import su.doma_dachi.lab.dao.GenericDao;
import su.doma_dachi.lab.dao.PersistException;
import su.doma_dachi.lab.domain.Article;
import su.doma_dachi.lab.domain.Level;
import su.doma_dachi.lab.jaxb.decarators.Articles;
import su.doma_dachi.lab.jaxb.decarators.Levels;
import su.doma_dachi.lab.postgres.PostgresDaoFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JaxbWorkerArticle {

    private static final Logger logger = Logger.getLogger(JaxbWorkerArticle.class);
    static {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }

    // восстанавливаем объект из XML файла
    public static void fromXmlToObject(String filePath) {
        DaoFactory daoFactory = new PostgresDaoFactory();
        List<Article> list;
        try (Connection connection = (Connection) daoFactory.getContext()) {
            GenericDao articleDao = daoFactory.getDao(connection, Article.class);
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Articles.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            Articles o = (Articles) un.unmarshal(new File(filePath));
            logger.info(o.getArticles().size());
            for (Article article : o.getArticles()) {
                //check arcticle ids
                // while(!checkarticleids)
                // Thread.yield();
                articleDao.persist(article);
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
    private static void convertObjectToXml(List<Article> list, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Articles.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            Articles obj = new Articles();
            obj.setArticles(list);
            //маршаллинг объекта в файл
            marshaller.marshal(obj, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void parseArticleToXml(){
        logger.info("Application started");
        /**
         * определяем название файла, куда будем сохранять
         */
        String fileName = "Articles.xml";
        //создаем объект Article с данными из бд
        DaoFactory daoFactory = new PostgresDaoFactory();
        List<Article> list;
        try (Connection connection = (Connection) daoFactory.getContext()) {
            GenericDao artilceDao = daoFactory.getDao(connection, Article.class);
            list = artilceDao.getAll();
            convertObjectToXml(list, fileName);
        } catch (SQLException e) {
            logger.error("Проблема с БД", e);
        } catch (PersistException e) {
            logger.error("Проблема с таблицей", e);
            e.printStackTrace();
        }
        logger.info("Application finished");
    }
}


