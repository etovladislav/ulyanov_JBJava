package ru.kpfu.itis.util;

/**
 * Created by Vladislav on 03.11.2015.
 */
public class UserAvatar {

    public static final String CAT = "/uploadsFileUser/cat.jpg";
    public static final String DOG = "/uploadsFileUser/dog.jpg";
    public static final String ENOT = "/uploadsFileUser/enot.jpg";
    public static final String ANDREY = "/uploadsFileUser/andrey.jpg";

    public static String getDefaultAvatar(int i) {
        switch (i) {
            case 1:
                return CAT;
            case 2:
                return DOG;
            case 3:
                return ENOT;
            case 4:
                return ANDREY;
            default:
                return null;
        }
    }
}
