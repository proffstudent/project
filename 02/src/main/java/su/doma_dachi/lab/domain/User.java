package su.doma_dachi.lab.domain;

import su.doma_dachi.lab.dao.Identified;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 * Created by User on 21.02.2017.
 */

@XmlType(propOrder = {"id","name","lastName","email","login","password","createdAt","updatedAt",
        "enabled","sex","birth","residence","education","workplace","position","passport",
        "issuedBy","addressReg","level"})
public class User implements Identified<Integer> {
    private Integer id = null;
    private String name;
    private String lastName;
    private String email;
    private String login;
    private String password;
    private Date createdAt;
    private Date updatedAt;
    private boolean enabled;
    private String sex;
    private Date birth;
    private String residence;
    private String education;
    private String workplace;
    private String position;
    private String passport;
    private String issuedBy;
    private String addressReg;
    private Level level;

    @Override
    @XmlElement(name = "id")
    public Integer getId() {
        return id;
    }

    @XmlElement(name = "getName")
    public String getName() {
        return name;
    }

    @XmlElement(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    @XmlElement(name = "email")
    public String getEmail() {
        return email;
    }

    @XmlElement(name = "login")
    public String getLogin() {
        return login;
    }

    @XmlElement(name = "password")
    public String getPassword() {
        return password;
    }

    @XmlElement(name = "createdAt")
    public Date getCreatedAt() {
        return createdAt;
    }

    @XmlElement(name = "updatedAt")
    public Date getUpdatedAt() {
        return updatedAt;
    }

    @XmlElement(name = "enabled")
    public boolean isEnabled() {
        return enabled;
    }

    @XmlElement(name = "sex")
    public String getSex() {
        return sex;
    }

    @XmlElement(name = "birth")
    public Date getBirth() {
        return birth;
    }

    @XmlElement(name = "residence")
    public String getResidence() {
        return residence;
    }

    @XmlElement(name = "education")
    public String getEducation() {
        return education;
    }

    @XmlElement(name = "workplace")
    public String getWorkplace() {
        return workplace;
    }

    @XmlElement(name = "position")
    public String getPosition() {
        return position;
    }

    @XmlElement(name = "passport")
    public String getPassport() {
        return passport;
    }

    @XmlElement(name = "issuedBy")
    public String getIssuedBy() {
        return issuedBy;
    }

    @XmlElement(name = "addressReg")
    public String getAddressReg() {
        return addressReg;
    }

    @XmlElement(name = "level")
    public Level getLevel() {
        return level;
    }

    public void setId(Integer idUser) {
        this.id = idUser;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public void setAddressReg(String addressReg) {
        this.addressReg = addressReg;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
