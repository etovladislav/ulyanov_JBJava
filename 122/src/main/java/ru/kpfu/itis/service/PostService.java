package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.User;

public interface PostService {
    void addPost(User user, String username, String text);

    void deletePost(User user, String postId);
}
