package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.PostRepository;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.PostService;
import ru.kpfu.itis.util.UserUtil;

@Controller
public class PostControllers {

    @Autowired
    PostService postService;

    @Autowired
    UserRepository user;

    @Autowired
    PostRepository postRepository;

    @RequestMapping("/posts/add/{username}")
    @ResponseStatus(HttpStatus.OK)
    public void addPost(@RequestParam("text") String text, @PathVariable("username") String username) {
        User user = UserUtil.getPrincipal();
        postService.addPost(user, username, text);
    }

    @RequestMapping(value = "/posts/delete", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@RequestParam("id") String id) {
        User user = UserUtil.getPrincipal();
        postService.deletePost(user, id);
    }

    @RequestMapping("/posts/getAll/{username}")
    @ResponseStatus(HttpStatus.OK)
    public String getAllPosts(@PathVariable("username") String username, Model model) {
        User principalUser = UserUtil.getPrincipal();
        model.addAttribute("posts", postRepository.findByUserOrderByDateDesc(user.findOneByUsername(username)));
        model.addAttribute("page", principalUser.getId());
        return "postsList";
    }
}
