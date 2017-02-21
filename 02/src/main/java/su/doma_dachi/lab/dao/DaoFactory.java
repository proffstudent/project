package su.doma_dachi.lab.dao;

import su.doma_dachi.lab.dao.Tables.*;

/**
 * Created by User on 21.02.2017.
 */
public abstract class DaoFactory {
    public static final int XML = 1;
    public static final int POSTGRES = 2;

    public abstract LevelDao getLevelDao();
    public abstract UserDao getUserDao();
    public abstract ArticleDao getArticleDao();
    public abstract ReviewDao getReviewDao();
    public abstract AuthorDao getAuthorDao();

    public static DaoFactory getDaoFactory(int whichFactory){
        switch (whichFactory){
            case XML:
              //  return new XmlDaoFactory();
            case POSTGRES:
                return new PostgresDaoFactory();
            default:
                return null;
        }

    }




}
