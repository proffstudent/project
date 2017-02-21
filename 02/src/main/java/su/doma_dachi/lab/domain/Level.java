package su.doma_dachi.lab.domain;

import su.doma_dachi.lab.dao.Identified;

import java.io.Serializable;

/**
 * Created by User on 21.02.2017.
 */
public class Level implements Identified<Integer> {
    private Integer id = null;
    private int number;
    private String access;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(int idLevel){
        this.id = idLevel;
    }

    public String getAccess(){
        return access;
    }
    public void setAccess(String access){
        this.access = access;
    }

}
