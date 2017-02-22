package su.doma_dachi.lab.domain;

import su.doma_dachi.lab.dao.Identified;

import java.util.Date;

/**
 * Created by User on 21.02.2017.
 */
public class Review implements Identified<Integer> {
    private Integer idReview = null;
    private User user;
    private Article article;
    private String pathReview;
    private Date dateOfReceipt;
    private Date dateReview;

    @Override
    public Integer getId() {
        return idReview;
    }

    public void setIdReview(Integer idReview) {
        this.idReview = idReview;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getPathReview() {
        return pathReview;
    }

    public void setPathReview(String pathReview) {
        this.pathReview = pathReview;
    }

    public Date getDateOfReceipt() {
        return dateOfReceipt;
    }

    public void setDateOfReceipt(Date dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }

    public Date getDateReview() {
        return dateReview;
    }

    public void setDateReview(Date dateReview) {
        this.dateReview = dateReview;
    }
}
