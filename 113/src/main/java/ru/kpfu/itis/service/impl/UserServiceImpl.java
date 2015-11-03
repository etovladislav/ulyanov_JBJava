package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.form.UserRegistrationForm;
import ru.kpfu.itis.form.UserSettingsForm;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.enums.Sex;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.UserAvatar;
import ru.kpfu.itis.util.UserRegistrationFormToUser;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public void saveUser(UserRegistrationForm form) {
        User user = UserRegistrationFormToUser.transformToUser(form);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void updateUserInfo(UserSettingsForm settingsForm, User user) {
        user.setCity(settingsForm.getCity());
        user.setFirstname(settingsForm.getFirstname());
        user.setLastname(settingsForm.getLastname());
        if (settingsForm.getSex() != null) {
            user.setSex(settingsForm.getSex() == 0 ? Sex.MALE : Sex.FEMALE);//А вдруг пол сменил(a)?
        }
        if (settingsForm.getAvatar() != null) {
            user.setAvatar(UserAvatar.getDefaultAvatar(settingsForm.getAvatar()));
        }
        userRepository.save(user);
    }

    @Override
    public boolean checkUser(String username) {
        return userRepository.findOneByUsername(username) != null;
    }
}
