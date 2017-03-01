package su.doma_dachi.lab.jaxb.decarators;

import su.doma_dachi.lab.domain.Level;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement
public class Levels {

    List<Level> levels;

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    // указываем, что levels должно быть атрибутом
    @XmlElement(name = "levels")
    public List<Level> getLevels() {
        return levels;
    }
}
