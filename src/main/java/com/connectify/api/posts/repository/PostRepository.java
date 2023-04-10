package com.connectify.api.posts.repository;

import com.connectify.api.posts.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {

    findByUser
}
