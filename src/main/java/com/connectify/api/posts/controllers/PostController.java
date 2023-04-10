package com.connectify.api.posts.controllers;

import com.connectify.api.posts.model.Post;
import com.connectify.api.posts.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping(value = "/")
    public List<Post> getAllPosts() {
        return postService.findAll();
    }

    @PostMapping(value = "/")
    public Post createPost(@RequestBody Post post) {
        post.setDate(LocalDateTime.now());
        return postService.save(post);
    }

    @GetMapping(value ="/{user_id}")
    public List<Post> getUserPosts(@PathVariable(name = "user_id")String userId) {
        return postService.getByUserId(userId);
    }

}
