package com.connectify.api.posts.bootstrap;

import com.connectify.api.posts.model.Comment;
import com.connectify.api.posts.model.Post;
import com.connectify.api.posts.model.Visibility;
import com.connectify.api.posts.service.CommentService;
import com.connectify.api.posts.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final PostService postService;
    private final CommentService commentService;

    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i <10; i++) {
            String userId = UUID.randomUUID().toString();

            Post postA = new Post();
            postA.setTitle("titleA " + i);
            postA.setVisibility(Visibility.PUBLIC);
            postA.setLikes(i);
            postA.setDate(LocalDateTime.now());
            postA.setDescription("postDescriptionA " + i);
            postA.setUsedId(userId);

            Post postB = new Post();
            postB.setTitle("titleB " + i);
            postB.setVisibility(Visibility.GROUP);
            postB.setLikes(i);
            postB.setDate(LocalDateTime.now());
            postB.setDescription("postDescriptionB " + i);
            postB.setUsedId(userId);

            Post postC = new Post();
            postC.setTitle("titleC " + i);
            postC.setVisibility(Visibility.PRIVATE);
            postC.setLikes(i);
            postC.setDate(LocalDateTime.now());
            postC.setDescription("postDescriptionC " + i);
            postC.setUsedId(userId);

            postService.save(postA);
            postService.save(postB);
            postService.save(postC);
        }

        for (Post post : postService.findAll()) {
            Comment commentA = new Comment();
            commentA.setDescription("commentDescriptionA " + post.getLikes());
            commentA.setDate(LocalDateTime.now());
            commentA.setLikes(post.getLikes());
            commentA.setPost(post);
            commentA.setUsedId(UUID.randomUUID().toString());

            Comment commentB = new Comment();
            commentB.setDescription("commentDescriptionB " + post.getLikes());
            commentB.setDate(LocalDateTime.now());
            commentB.setLikes(post.getLikes());
            commentB.setPost(post);
            commentB.setUsedId(UUID.randomUUID().toString());

            commentService.save(commentA);
            commentService.save(commentB);

        }
    }

}