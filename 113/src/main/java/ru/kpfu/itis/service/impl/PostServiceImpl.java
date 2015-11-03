package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Post;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.PostRepository;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.PostService;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public void addPost(User user, String username, String text) {
        Post post = new Post();
        post.setDate(new Date());
        post.setSendUser(user);
        post.setText(text);
        post.setUser(userRepository.findOneByUsername(username));
        postRepository.save(post);
    }

    @Override
    @Transactional
    public void deletePost(User user, String postId) {
        postRepository.delete(Long.valueOf(postId));
    }
}
