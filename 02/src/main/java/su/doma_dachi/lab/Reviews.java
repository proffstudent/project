package su.doma_dachi.lab;

/**
 * Created by User on 20.02.2017.
 */
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Reviews {
    private static final Logger logger = Logger.getLogger(Reviews.class);
    static {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }
    public static void main(String[] args) {
        logger.info("Application started");
        System.out.println("I'm the main project");
        logger.info("Application finished");
    }
}
