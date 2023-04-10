package com.connectify.api.posts.service;

import com.connectify.api.posts.model.Post;
import com.connectify.api.posts.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post getById(UUID uuid) {
        return postRepository.getById(uuid);
    }

    @Override
    public List<Post> getByUserId(String id) {
        List<Post> posts = new ArrayList<>();

        postRepository.findAllByIdAnd All().forEach(post -> {
                    if (post.getUsedId().equals(id)) {
                        posts.add(post);
                    }});

        return posts;
    }

    @Override
    public Post update(UUID uuid) {
        return postRepository.save(postRepository.getById(uuid));
    }

    @Override
    public void delete(UUID uuid) {
        postRepository.deleteById(uuid);

    }
}
