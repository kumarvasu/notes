package com.example.notes.service.impl;

import com.example.notes.converter.NoteToNoteDtoConverter;
import com.example.notes.domain.Note;
import com.example.notes.domain.repository.NoteRepository;
import com.example.notes.exception.NoteNotFoundException;
import com.example.notes.model.NoteDto;
import com.example.notes.service.NoteService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService {

    private NoteRepository noteRepository;
    private NoteToNoteDtoConverter noteToNoteDtoConverter;

    public NoteServiceImpl(NoteRepository noteRepository, NoteToNoteDtoConverter noteToNoteDtoConverter) {
        this.noteRepository = noteRepository;
        this.noteToNoteDtoConverter = noteToNoteDtoConverter;
    }

    @Override
    public NoteDto create(NoteDto noteDto) {
        Note note = noteToNoteDtoConverter.convert(noteDto);
        Note savedNote = noteRepository.save(note);
        return noteToNoteDtoConverter.convert(savedNote);
    }

    @Override
    public NoteDto fetch(Long noteId) {
        Note note = noteRepository.findById(noteId).orElseThrow(() -> new NoteNotFoundException("Note not found"));
        return noteToNoteDtoConverter.convert(note);
    }

    @Override
    public NoteDto update(NoteDto noteDto) {
        Note note = noteRepository.findById(noteDto.getNoteId()).orElseThrow(() ->
                new NoteNotFoundException("Note not found"));
        note.setContent(noteDto.getContent());
        note.setTitle(noteDto.getTitle());
        note.setUpdatedDate(currentDate());
        noteRepository.save(note);
        return noteDto;

    }

    @Override
    public List<NoteDto> getAllNotes() {
        List<Note> notes = noteRepository.findAllByDeletedFalse();
        return notes.stream().map(note -> new NoteDto(note.getId(),
                note.getTitle(), note.getContent(), note.isDeleted())).collect(Collectors.toList());
    }

    @Override
    public void delete(long noteId) {
        Note note = noteRepository.findById(noteId).orElseThrow(() -> new NoteNotFoundException("Note not found"));
        note.setDeleted(true);
        noteRepository.save(note);
    }

    private Date currentDate() {
        Calendar date = Calendar.getInstance();
        return new Date(date.getTimeInMillis());
    }

}
