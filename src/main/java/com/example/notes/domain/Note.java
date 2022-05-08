package com.example.notes.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "note")
@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "created_date", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;

    @Column(name = "update_date", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Date updatedDate;

    @Column(name = "title", columnDefinition = "VARCHAR(60) DEFAULT NULL")
    private String title;

    @Column(name = "content", columnDefinition = "VARCHAR(60) DEFAULT NULL")
    private String content;

    @Column(name = "deleted", columnDefinition = "bit(1) DEFAULT 0")
    private boolean deleted = false;
}
