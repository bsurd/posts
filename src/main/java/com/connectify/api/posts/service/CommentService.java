package com.connectify.api.posts.service;

import com.connectify.api.posts.model.Comment;
import com.connectify.api.posts.model.Post;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    List<Comment> findAll();

    Comment save(Comment comment);

    Comment getById(UUID uuid);

    Comment update(UUID uuid);

    void delete(UUID uuid);
}
