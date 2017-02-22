package su.doma_dachi.lab.domain;

import su.doma_dachi.lab.dao.Identified;

/**
 * Created by User on 21.02.2017.
 */
public class Author implements Identified<Integer> {
    private Integer idAuthor = null;
    private User user;
    private Article article;

    @Override
    public Integer getId() {
        return idAuthor;
    }

    public void setId(Integer idAuthor) {
        this.idAuthor = idAuthor;
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
}
