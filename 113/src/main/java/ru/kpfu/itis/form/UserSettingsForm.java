package ru.kpfu.itis.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Vladislav on 02.11.2015.
 */
public class UserSettingsForm {

    @NotNull(message = "Заполните это поле")
    @Size(min = 2, max = 30, message = "Не менее 2-и символов и не более 30")
    private String firstname;

    @NotNull(message = "Заполните это поле")
    @Size(min = 2, max = 30, message = "Не менее 2-и символов и не более 30")
    private String lastname;

    private Integer sex;

    private Integer avatar;

    public Integer getAvatar() {
        return avatar;
    }

    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    @NotNull(message = "Заполните это поле")
    private String city;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
