package su.doma_dachi.lab.domain;

import su.doma_dachi.lab.dao.Identified;

import java.io.Serializable;

/**
 * Created by User on 21.02.2017.
 */
public class Level implements Identified {
    private Integer idLevel = null;
    private int number;
    private String access;

    @Override
    public Integer getId() {
        return idLevel;
    }

    public void setId(int idLevel){
        this.idLevel = idLevel;
    }

    public String getAccess(){
        return access;
    }
    public void setAccess(String access){
        this.access = access;
    }

}
