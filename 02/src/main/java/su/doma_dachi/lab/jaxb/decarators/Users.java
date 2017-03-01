package su.doma_dachi.lab.jaxb.decarators;

import su.doma_dachi.lab.domain.Article;
import su.doma_dachi.lab.domain.User;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Users {
    List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
