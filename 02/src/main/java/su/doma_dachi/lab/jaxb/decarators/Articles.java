package su.doma_dachi.lab.jaxb.decarators;

import su.doma_dachi.lab.domain.Article;
import su.doma_dachi.lab.domain.Level;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Articles {
    List<Article> articles;

    @XmlElement(name = "articles")
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
