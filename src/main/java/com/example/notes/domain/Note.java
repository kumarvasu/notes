package com.example.notes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "note")
@Entity
@Setter
@Getter
public class Note {

    @Id
    private Long id;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private String title;

    private String content;

    private Boolean deleted;
}
