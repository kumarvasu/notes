package com.example.notes.service;

import com.example.notes.model.NoteDto;

public interface NoteService {

    NoteDto create();

    NoteDto fetch(Long noteId);
}
