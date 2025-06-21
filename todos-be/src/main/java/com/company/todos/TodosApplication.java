package com.company.todos;

import com.company.todos.entity.Todo;
import com.company.todos.entity.TodoUser;
import com.company.todos.repository.TodoRepository;
import com.company.todos.repository.TodoUserRepository;
import com.company.todos.service.TodoServiceImpl;
import com.company.todos.service.TodoUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TodosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TodosApplication.class, args);
	}

	@Autowired
	TodoUserRepository todoUserRepository;
	@Autowired
	TodoRepository todoRepository;

	@Autowired
	TodoUserServiceImpl todoUserService;

	@Override
	public void run(String... args) throws Exception {

		ArrayList<TodoUser> users = new ArrayList<>();
		TodoUser user1 = new TodoUser();
		user1.setFirstName("pera");
		user1.setLastName("peric");
		user1.setUsername("pera");
		TodoUser user2 = new TodoUser();
		user2.setFirstName("mika");
		user2.setLastName("mikic");
		user2.setUsername("mika");
		users.add(user1);
		users.add(user2);

		for(TodoUser user : users) {
			todoUserRepository.save(user);
		}

		ArrayList<Todo> todos = new ArrayList<>();
		Todo todo1 = new Todo();
		todo1.setTitle("pera title 1");
		todo1.setDescription("pera description 1");
		Todo todo2 = new Todo();
		todo2.setTitle("pera title 2");
		todo2.setDescription("pera description 2");
		Todo todo3 = new Todo();
		todo3.setTitle("mika title 1");
		todo3.setDescription("mika description 1");
		Todo todo4 = new Todo();
		todo4.setTitle("mika title 2");
		todo4.setDescription("mika description 2");
		Todo todo5 = new Todo();
		todo5.setTitle("mika title 3");
		todo5.setDescription("mika description 3");
		todo5.setCompletedAt(LocalDateTime.now());

		todos.add(todo1);
		todos.add(todo2);
		todos.add(todo3);
		todos.add(todo4);
		todos.add(todo5);

		for(Todo todo : todos) {
			todo.setCreatedAt(LocalDateTime.now());

			Long id = todos.indexOf(todo) < 2 ? 1L : 2L;

			System.out.println(todoUserService.getUser(id));

			todo.setTodoUser(todoUserService.getUser(id));
			todoRepository.save(todo);
		}
	}
}
