package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.form.UserRegistrationForm;
import ru.kpfu.itis.form.UserSettingsForm;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.UserRegistrationFormToUser;
import ru.kpfu.itis.util.UserSettingsFormToUser;

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
    public void updateUserInfo(UserSettingsForm settingsForm, User aUser) {
        User user = UserSettingsFormToUser.transformToUser(settingsForm, aUser);
        userRepository.save(user);
    }

    @Override
    public boolean checkUser(String username) {
        return userRepository.findOneByUsername(username) != null;
    }
}
