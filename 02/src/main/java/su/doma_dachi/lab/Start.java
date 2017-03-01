package su.doma_dachi.lab;

/**
 * Created by User on 20.02.2017.
 */

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import su.doma_dachi.lab.jaxb.workers.*;

import static su.doma_dachi.lab.jaxb.workers.JaxbWorkerArticle.parseArticleToXml;
import static su.doma_dachi.lab.jaxb.workers.JaxbWorkerLevel.parseLevelToXml;

public class Start {
    private static final Logger logger = Logger.getLogger(Start.class);
    static {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }
    public static void main(String[] args) {

        JaxbWorkerArticle.parseArticleToXml();
        JaxbWorkerArticle.fromXmlToObject("Articles.xml");
       // JaxbWorkerAuthor.parseAuthorToXml();
        JaxbWorkerLevel.parseLevelToXml();
        JaxbWorkerLevel.fromXmlToObject("Levels.xml");

        //JaxbWorkerReview.parseLevelToXml();
       // JaxbWorkerUser.parseUserToXml();
    }
}
