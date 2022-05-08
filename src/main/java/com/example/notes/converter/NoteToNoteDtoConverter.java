package com.example.notes.converter;

import com.example.notes.domain.Note;
import com.example.notes.model.NoteDto;
import org.springframework.stereotype.Component;

@Component
public class NoteToNoteDtoConverter {

    public NoteDto convert(Note note){
        return NoteDto.builder()
                .noteId(note.getId())
                .title(note.getTitle())
                .content(note.getContent())
                .deleted(note.isDeleted()).build();
    }

    public Note convert(NoteDto noteDto) {
        return Note.builder()
                .id(noteDto.getNoteId())
                .title(noteDto.getTitle())
                .content(noteDto.getContent())
                .deleted(noteDto.isDeleted()).build();
    }


}
