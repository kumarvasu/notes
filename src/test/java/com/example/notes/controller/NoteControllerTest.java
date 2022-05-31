package com.example.notes.controller;

import com.example.notes.exception.NoteNotFoundException;
import com.example.notes.model.ErrorResponseDto;
import com.example.notes.model.NoteDto;
import com.example.notes.service.NoteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = NoteController.class)
class NoteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NoteService noteService;

    @Test
    public void whenCreateSuccess_thenReturn200() throws Exception {

        NoteDto noteDto = new NoteDto();
        noteDto.setNoteId(1L);

        Mockito.when(noteService.create()).thenReturn(noteDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/note/create"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                //.andExpect(MockMvcResultMatchers.content().string("test"));
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(noteDto)));
    }

    public void whenCreateFailed_thenReturn500(){

    }

    @Test
    public void whenFetchIdNotFound_thenReturn404() throws Exception {

        Mockito.when(noteService.fetch(1L)).thenThrow(new NoteNotFoundException("Note not found"));

        mockMvc.perform(MockMvcRequestBuilders.get("/note/fetch/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(new ErrorResponseDto("Custom status", "Note not found"))));
    }



}