package com.example.notes;

import com.example.notes.model.NoteDto;
import com.example.notes.service.NoteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@SpringBootTest
@Profile("test")
class NotesApplicationTests {

	@Autowired
	private NoteService noteService;

	@Test
	void contextLoads() {
	}

	@Test
	void whenCreateNoteIsCalled_thenReturnNoteId(){
		NoteDto noteDto = noteService.create();
		System.out.println(noteDto);
	}

}
