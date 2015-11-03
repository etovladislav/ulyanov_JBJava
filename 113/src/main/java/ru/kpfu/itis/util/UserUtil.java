package ru.kpfu.itis.util;

import org.springframework.security.core.context.SecurityContextHolder;
import ru.kpfu.itis.model.User;


/**
 * Created by Vladislav on 01.11.2015.
 */
public class UserUtil {

    public static boolean isAuthUser() {
        return SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
    }

    public static User getPrincipal() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
