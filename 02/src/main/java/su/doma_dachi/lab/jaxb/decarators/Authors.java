package su.doma_dachi.lab.jaxb.decarators;

import su.doma_dachi.lab.domain.Author;
import su.doma_dachi.lab.domain.Level;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Authors {
    List<Author> authors;

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
