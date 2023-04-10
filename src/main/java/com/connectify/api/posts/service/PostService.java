package com.connectify.api.posts.service;

import com.connectify.api.posts.model.Post;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface PostService {
    List<Post> findAll();

    Post save(Post post);

    Post getById(UUID uuid);

    List<Post> getByUserId(String id);

    Post update(UUID uuid);

    void delete(UUID uuid);
}
