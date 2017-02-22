package su.doma_dachi.lab.domain;

import su.doma_dachi.lab.dao.Identified;

import java.util.Date;

/**
 * Created by User on 21.02.2017.
 */
public class Article implements Identified<Integer> {
    private Integer idArticle = null;
    private String title;
    private String subject;
    private boolean dontPubl;
    private String pathArticle;
    private String pathAnnotRus;
    private String pathAnnotEng;
    private String pathListLiter;
    private Date dateSend;
    private Date dateAdoptation;
    private Date datePubl;
    private String url;

    @Override
    public Integer getId() {
        return idArticle;
    }

    public void setidArticle(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean isDontPubl() {
        return dontPubl;
    }

    public void setDontPubl(boolean dontPubl) {
        this.dontPubl = dontPubl;
    }

    public String getPathArticle() {
        return pathArticle;
    }

    public void setPathArticle(String pathArticle) {
        this.pathArticle = pathArticle;
    }

    public String getPathAnnotRus() {
        return pathAnnotRus;
    }

    public void setPathAnnotRus(String pathAnnotRus) {
        this.pathAnnotRus = pathAnnotRus;
    }

    public String getPathAnnotEng() {
        return pathAnnotEng;
    }

    public void setPathAnnotEng(String pathAnnotEng) {
        this.pathAnnotEng = pathAnnotEng;
    }

    public String getPathListLiter() {
        return pathListLiter;
    }

    public void setPathListLiter(String pathListLiter) {
        this.pathListLiter = pathListLiter;
    }

    public Date getDateSend() {
        return dateSend;
    }

    public void setDateSend(Date dateSend) {
        this.dateSend = dateSend;
    }

    public Date getDateAdoptation() {
        return dateAdoptation;
    }

    public void setDateAdoptation(Date dateAdoptation) {
        this.dateAdoptation = dateAdoptation;
    }

    public Date getDatePubl() {
        return datePubl;
    }

    public void setDatePubl(Date datePubl) {
        this.datePubl = datePubl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
