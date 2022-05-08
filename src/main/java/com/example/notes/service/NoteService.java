package com.example.notes.service;

import com.example.notes.model.NoteDto;

import java.util.List;

public interface NoteService {

    NoteDto create(NoteDto noteDto);

    NoteDto fetch(Long noteId);

    NoteDto update(NoteDto noteDto);

    List<NoteDto> getAllNotes();

    void delete(long noteId);
}
