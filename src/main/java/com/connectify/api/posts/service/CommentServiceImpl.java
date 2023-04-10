package com.connectify.api.posts.service;

import com.connectify.api.posts.model.Comment;
import com.connectify.api.posts.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment getById(UUID uuid) {
        return commentRepository.getById(uuid);
    }

    @Override
    public Comment update(UUID uuid) {
        return commentRepository.save(commentRepository.getById(uuid));
    }

    @Override
    public void delete(UUID uuid) {
        commentRepository.deleteById(uuid);
    }
}
