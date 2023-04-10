package com.connectify.api.posts.controllers;

import com.connectify.api.posts.model.Comment;
import com.connectify.api.posts.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("comments")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/")
    public List<Comment> getAllComments() {
        return commentService.findAll();
    }

    @GetMapping("/{comment_id}")
    public Comment getComment(@PathVariable(name = "comment_id")String uuid) {
        return commentService.getById(UUID.fromString(uuid));
    }

    @PostMapping("/")
    public Comment addComment(@RequestBody Comment comment) {
        comment.setDate(LocalDateTime.now());
        return commentService.save(comment);
    }

}
