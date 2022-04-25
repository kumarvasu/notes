package com.example.notes.service.impl;

import com.example.notes.converter.NoteToNoteDtoConverter;
import com.example.notes.domain.Note;
import com.example.notes.domain.repository.NoteRepository;
import com.example.notes.exception.NoteNotFoundException;
import com.example.notes.model.NoteDto;
import com.example.notes.service.NoteService;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {

    private NoteRepository noteRepository;
    private NoteToNoteDtoConverter noteToNoteDtoConverter;

    public NoteServiceImpl(NoteRepository noteRepository, NoteToNoteDtoConverter noteToNoteDtoConverter) {
        this.noteRepository = noteRepository;
        this.noteToNoteDtoConverter = noteToNoteDtoConverter;
    }

    @Override
    public NoteDto create() {
        Note note = new Note();
        Note savedNote = noteRepository.save(note);
        return noteToNoteDtoConverter.convert(savedNote);
    }

    @Override
    public NoteDto fetch(Long noteId) {
        Note note = noteRepository.findById(noteId).orElseThrow(() -> new NoteNotFoundException("Note not found"));
        return noteToNoteDtoConverter.convert(note);
    }

}
