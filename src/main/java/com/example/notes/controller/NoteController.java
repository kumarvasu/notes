package com.example.notes.controller;

import com.example.notes.model.NoteDto;
import com.example.notes.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/note")
@AllArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteDto create(){
        return noteService.create();
    }
}
