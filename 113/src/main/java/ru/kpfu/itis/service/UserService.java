package ru.kpfu.itis.service;

import ru.kpfu.itis.form.UserRegistrationForm;
import ru.kpfu.itis.form.UserSettingsForm;
import ru.kpfu.itis.model.User;


public interface UserService {
    void saveUser(UserRegistrationForm form);

    void updateUserInfo(UserSettingsForm settingsForm, User user);

    boolean checkUser(String username);

}
