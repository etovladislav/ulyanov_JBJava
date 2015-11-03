package ru.kpfu.itis.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UserRegistrationForm {

    @NotNull(message = "��������� ��� ����")
    @Size(min = 2, max = 30, message = "�� ����� 2-� �������� � �� ����� 30")
    private String firstname;

    @NotNull(message = "��������� ��� ����")
    @Size(min = 2, max = 30, message = "�� ����� 2-� �������� � �� ����� 30")
    private String lastname;

    @NotNull(message = "��������� ��� ����")
    @Size(min = 5, max = 30, message = "�� ����� 5-� �������� � �� ����� 30")
    private String username;

    private Integer sex;

    @NotNull(message = "��������� ��� ����")
    private String city;

    private Boolean openAccount;

    @NotNull(message = "��������� ��� ����")
    @Size(min = 6, max = 30, message = "�� ����� 6-� �������� � �� ����� 30")
    private String password;

    public UserRegistrationForm() {
    }

    public UserRegistrationForm(String firstname, String lastname, String username, Integer sex, String city, Boolean openAccount, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.sex = sex;
        this.city = city;
        this.openAccount = openAccount;
        this.password = password;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Boolean getOpenAccount() {
        return openAccount;
    }

    public void setOpenAccount(Boolean openAccount) {
        this.openAccount = openAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
