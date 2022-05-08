package com.example.notes.controller;

import com.example.notes.model.NoteDto;
import com.example.notes.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
@AllArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteDto create(@RequestBody NoteDto noteDto) {
        return noteService.create(noteDto);
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteDto update(@RequestBody NoteDto noteDto) {
        return noteService.update(noteDto);
    }

    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDto> noteList() {
        return noteService.getAllNotes();
    }

    @GetMapping("/get/{noteId}")
    public NoteDto getNote(@PathVariable long noteId) {
        return noteService.fetch(noteId);
    }

    @DeleteMapping("/delete/{noteId}")
    public String delete(@PathVariable long noteId) {
        noteService.delete(noteId);
        return "Deleted Successfully";
    }
}
