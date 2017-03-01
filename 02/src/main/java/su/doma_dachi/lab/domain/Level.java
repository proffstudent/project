package su.doma_dachi.lab.domain;


import su.doma_dachi.lab.dao.Identified;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * определяем корневой элемент
 */


/**
 * определяем последовательность тегов в XML
 */
@XmlRootElement
@XmlType(propOrder = {"id","access"})
public class Level implements Identified<Integer> {
    private Integer id = null;
    private String access;

    /**
     * указываем, что id должен быть атрибутом
     */

    @Override
    @XmlElement(name = "id")
    public Integer getId() {
        return id;
    }

    /**
     * указываем, что поле access должно быть представлено в XML как access
     */
    @XmlElement(name = "access")
    public String getAccess(){
        return access;
    }

    public void setId(int id){
        this.id = id;
    }


    public void setAccess(String access){
        this.access = access;
    }

}
