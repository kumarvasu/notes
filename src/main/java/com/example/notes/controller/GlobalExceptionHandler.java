package com.example.notes.controller;

import com.example.notes.exception.NoteNotFoundException;
import com.example.notes.model.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

/*
    @ExceptionHandler(NoteNotFoundException.class)
    //@ResponseStatus(HttpStatus.NOT_FOUND)
    //@ResponseBody
    public ResponseEntity<ErrorResponseDto> handleNoteNotFoundException(NoteNotFoundException noteNotFoundException){
        //return ResponseEntity.notFound().build();
        ErrorResponseDto responseDto = new ErrorResponseDto(HttpStatus.NOT_FOUND.name(), noteNotFoundException.getMessage());
        return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
    }
*/

    @ExceptionHandler(NoteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponseDto handleNoteNotFoundException(NoteNotFoundException noteNotFoundException){
        //return ResponseEntity.notFound().build();
        return new ErrorResponseDto("Custom status", noteNotFoundException.getMessage());
        //return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
    }

}

/*

Controller - @Webmvc
repository - @DataJpaTest
service - @Mock/real logic test
integration test - @SpringBootTest
 */