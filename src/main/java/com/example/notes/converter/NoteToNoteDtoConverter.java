package com.example.notes.converter;

import com.example.notes.domain.Note;
import com.example.notes.model.NoteDto;
import org.springframework.stereotype.Component;

@Component
public class NoteToNoteDtoConverter {

    public NoteDto convert(Note note){
        NoteDto noteDto = new NoteDto();
        noteDto.setNoteId(note.getId());
        return noteDto;
    }
}
