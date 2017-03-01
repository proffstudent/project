package su.doma_dachi.lab.domain;

import su.doma_dachi.lab.dao.Identified;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"id","user","article"})
public class Author implements Identified<Integer> {
    private Integer id = null;
    private User user;
    private Article article;

    @Override
    @XmlElement(name = "id")
    public Integer getId() {
        return id;
    }

    @XmlElement(name = "user")
    public User getUser() {
        return user;
    }

    @XmlElement(name = "article")
    public Article getArticle() {
        return article;
    }

    public void setId(Integer idAuthor) {
        this.id = idAuthor;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
