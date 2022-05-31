package com.example.notes.service.impl;

import com.example.notes.converter.NoteToNoteDtoConverter;
import com.example.notes.domain.Note;
import com.example.notes.domain.repository.NoteRepository;
import com.example.notes.exception.NoteNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NoteServiceImplTest {

    @InjectMocks
    private NoteServiceImpl noteService;

    @Mock
    private NoteRepository noteRepository;
    @Mock
    private NoteToNoteDtoConverter noteToNoteDtoConverter;

    @Test
    public void whenCreateExecuted_thenExpectSuccess(){
        //Given- in -1,1
        Note note = new Note();
        Mockito.when(noteRepository.save(Mockito.any(Note.class))).thenReturn(note);

        //when- add()
        noteService.create();

        //then - result -2
        Mockito.verify(noteRepository).save(Mockito.any(Note.class));
        Mockito.verify(noteToNoteDtoConverter).convert(note);
    }

    @Test
    public void whenNoteIdNotFound_ThenFetchThrowsException(){
        Mockito.when(noteRepository.findById(1L)).thenReturn(Optional.empty());

        NoteNotFoundException exception = assertThrows(NoteNotFoundException.class, () -> noteService.fetch(1L));
        assertEquals("Note not found", exception.getMessage());
    }

    @Test
    public void whenCreateConverterExecuted_thenExpectException(){

    }

}