package ru.kpfu.itis.util;

import ru.kpfu.itis.form.UserSettingsForm;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.enums.Sex;

public class UserSettingsFormToUser {
    public static User transformToUser(UserSettingsForm settingsForm, User user) {
        user.setCity(settingsForm.getCity());
        user.setFirstname(settingsForm.getFirstname());
        user.setLastname(settingsForm.getLastname());
        if (settingsForm.getSex() != null) {
            user.setSex(settingsForm.getSex() == 0 ? Sex.MALE : Sex.FEMALE);//А вдруг пол сменил(a)?
        }
        if (settingsForm.getAvatar() != null) {
            user.setAvatar(UserAvatar.getDefaultAvatar(settingsForm.getAvatar()));
        }
        return user;
    }
}
