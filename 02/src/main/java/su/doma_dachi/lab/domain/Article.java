package su.doma_dachi.lab.domain;

import su.doma_dachi.lab.dao.Identified;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 * Created by User on 21.02.2017.
 */
@XmlRootElement
@XmlType(propOrder = {"id","title","subject","dontPubl","pathArticle","pathAnnotRus","pathAnnotEng","pathListLiter",
"dateSend","dateAdoption","datePubl","url"})
public class Article implements Identified<Integer> {
    private Integer id = null;
    private String title;
    private String subject;
    private boolean dontPubl;
    private String pathArticle;
    private String pathAnnotRus;
    private String pathAnnotEng;
    private String pathListLiter;
    private Date dateSend;
    private Date dateAdoption;
    private Date datePubl;
    private String url;

    @Override
    @XmlElement(name = "id")
    public Integer getId() {
        return id;
    }

    @XmlElement(name = "title")
    public String getTitle() {
        return title;
    }

    @XmlElement(name = "subject")
    public String getSubject() {
        return subject;
    }

    @XmlElement(name = "dontPubl")
    public boolean isDontPubl() {
        return dontPubl;
    }

    @XmlElement(name = "pathArticle")
    public String getPathArticle() {
        return pathArticle;
    }

    @XmlElement(name = "pathAnnotRus")
    public String getPathAnnotRus() {
        return pathAnnotRus;
    }

    @XmlElement(name = "pathAnnotEng")
    public String getPathAnnotEng() {
        return pathAnnotEng;
    }

    @XmlElement(name = "pathListLiter")
    public String getPathListLiter() {
        return pathListLiter;
    }

    @XmlElement(name = "dateSend")
    public Date getDateSend() {
        return dateSend;
    }

    @XmlElement(name = "dateAdoption")
    public Date getDateAdoption() {
        return dateAdoption;
    }

    @XmlElement(name = "datePubl")
    public Date getDatePubl() {
        return datePubl;
    }

    @XmlElement(name = "url")
    public String getUrl() {
        return url;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDontPubl(boolean dontPubl) {
        this.dontPubl = dontPubl;
    }

    public void setPathArticle(String pathArticle) {
        this.pathArticle = pathArticle;
    }

    public void setPathAnnotRus(String pathAnnotRus) {
        this.pathAnnotRus = pathAnnotRus;
    }

    public void setPathAnnotEng(String pathAnnotEng) {
        this.pathAnnotEng = pathAnnotEng;
    }

    public void setPathListLiter(String pathListLiter) {
        this.pathListLiter = pathListLiter;
    }

    public void setDateSend(Date dateSend) {
        this.dateSend = dateSend;
    }

    public void setDateAdoption(Date dateAdoption) {
        this.dateAdoption = dateAdoption;
    }

    public void setDatePubl(Date datePubl) {
        this.datePubl = datePubl;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
