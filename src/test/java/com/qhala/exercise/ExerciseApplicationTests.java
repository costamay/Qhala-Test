package com.qhala.exercise;

import com.qhala.exercise.entities.User;
import com.qhala.exercise.entities.Video;
import com.qhala.exercise.repositories.BookRepository;
import com.qhala.exercise.services.BookService;
import com.qhala.exercise.services.UserService;
import com.qhala.exercise.services.VideoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
@SpringBootTest
class ExerciseApplicationTests {

	@Autowired
	UserService userService;

	@Autowired
	VideoService videoService;

	@Autowired
	BookService bookService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateUser(){
		User user = new User("Qhala", "1234");
		userService.createUser(user);
	}

	@Test
	public void testGetAllUsers(){
		User user = new User("Angi", "1234");
		userService.createUser(user);
		userService.getAll();
	}

	@Test
	public void testFindUserById(Long id){
		User user = new User("Titus", "1234");
		user.setId(3L);
		userService.createUser(user);
		userService.findUserById(3L);
	}

	@Test
	public void testDeleteUserById(Long id){
		User user = new User("Mary", "1234");
		user.setId(4L);
		userService.createUser(user);
		userService.deleteUserById(4L);
	}

	@Test
	public void testAddVideo(){
		Video video = new Video("Act of Velor", "1L");
		videoService.addVideo(video);
	}

}
