package com.connectify.api.posts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Post extends Entry {

    @Column
    private String usedId;

    private String title;
    private Visibility visibility;
    @OneToMany(mappedBy = "post")
    private Set<Comment> comments = new HashSet<>();

}
