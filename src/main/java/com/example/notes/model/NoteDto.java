package com.example.notes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class NoteDto {

    private Long noteId;
    private String title;
    private String content;
    private boolean deleted;
}
