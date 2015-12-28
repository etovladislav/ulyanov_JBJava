package ru.kpfu.itis.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kpfu.itis.form.UserRegistrationForm;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.enums.Sex;
import ru.kpfu.itis.model.enums.UserRole;

/**
 * Created by Vladislav on 30.10.2015.
 */
public class UserRegistrationFormToUser {

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static User transformToUser(UserRegistrationForm form) {
        if (form == null) {
            return null;
        }
        User user = new User();
        user.setUsername(form.getUsername());
        user.setFirstname(form.getFirstname());
        user.setLastname(form.getLastname());
        user.setSex(form.getSex() == 0 ? Sex.MALE : Sex.FEMALE);
        user.setPassword(encoder.encode(form.getPassword()));
        user.setRole(UserRole.ROLE_USER);
        user.setOpenAccount(form.getOpenAccount());
        user.setCity(form.getCity());
        user.setAvatar("/uploadsFileUser/" + "defaultavatar.jpg");
        return user;
    }
}
