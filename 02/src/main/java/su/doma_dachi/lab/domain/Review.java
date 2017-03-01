package su.doma_dachi.lab.domain;

import su.doma_dachi.lab.dao.Identified;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 * Created by User on 21.02.2017.
 */
@XmlType(propOrder = {"id","user","article","pathReview","dateOfReceipt","dateReview"})
public class Review implements Identified<Integer> {
    private Integer id = null;
    private User user;
    private Article article;
    private String pathReview;
    private Date dateOfReceipt;
    private Date dateReview;

    @Override
    @XmlElement(name = "id")
    public Integer getId() {
        return id;
    }

    @XmlElement(name = "user")
    public User getUser() {
        return user;
    }

    @XmlElement(name = "user")
    public Article getArticle() {
        return article;
    }

    @XmlElement(name = "pathReview")
    public String getPathReview() {
        return pathReview;
    }

    @XmlElement(name = "dateOfReceipt")
    public Date getDateOfReceipt() {
        return dateOfReceipt;
    }

    @XmlElement(name = "dateReview")
    public Date getDateReview() {
        return dateReview;
    }

    public void setId(Integer idReview) {
        this.id = idReview;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setPathReview(String pathReview) {
        this.pathReview = pathReview;
    }

    public void setDateOfReceipt(Date dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }

    public void setDateReview(Date dateReview) {
        this.dateReview = dateReview;
    }
}
