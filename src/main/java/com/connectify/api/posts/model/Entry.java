package com.connectify.api.posts.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public abstract class Entry extends BaseEntity {

    private LocalDateTime date;
    //TODO: leave description for post and add message in comments
    private String description;
    private int likes;
}
