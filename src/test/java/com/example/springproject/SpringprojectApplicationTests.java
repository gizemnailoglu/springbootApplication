package com.example.springproject;

import com.example.springproject.domainObject.User;
import com.example.springproject.domainObject.rule;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class SpringprojectApplicationTests {

	@Autowired
	private MockMvc mockMvc; // kod tarafında kolay test yapabilmemizi sağlıyor.

    @Test
	public void GetAllUsers() throws Exception{
    	mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[*].username").exists())
				.andExpect(jsonPath("$[*].name").exists())
				.andExpect(jsonPath("$[*].surname").exists())
				.andExpect(jsonPath("$[*].password").exists());
	}

	@Test
	public void testGetUserById() throws Exception {
		String userId = "2";

		mockMvc.perform(get("/api/v1/users/{user Id}", userId)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.username").exists())
				.andExpect(jsonPath("$.name").exists())
				.andExpect(jsonPath("$.surname").exists());

	}

	@Test
	public void testCreateUser() throws Exception {
		User newUser = new User();
		newUser.setUsername("umitaksoylu");
		newUser.setName("Umit");
		newUser.setEmail("umitaksoylu@gmail.com");
		newUser.setSurname("Aksoylu");

		newUser.setRol(rule.USER);

		mockMvc.perform(post("/api/v1/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(newUser)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.username").exists())
				.andExpect(jsonPath("$.name").exists())
    			.andExpect(jsonPath("$.surname").exists())
				.andExpect(jsonPath("$.rol").exists());
	}
@Test
public void testUpdateUser() throws Exception {
	User newUser = new User();
	newUser.setId(6L);
	newUser.setUsername("gizemnailoglu");
	newUser.setName("Gizem");
	newUser.setSurname("Nailoglu");
	newUser.setEmail("gizem.nailoglu@gmail.com");;
	newUser.setRol(rule.ADMIN);

	mockMvc.perform(put("/api/v1/user")
			.contentType(MediaType.APPLICATION_JSON)
			.content(asJsonString(newUser)))
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$.id").exists())
//			.andExpect(jsonPath("$.username").exists())
			.andExpect(jsonPath("$.name").exists())
			.andExpect(jsonPath("$.email").exists())
			.andExpect(jsonPath("$.surname").exists())
			.andExpect(jsonPath("$.rol").exists());



}
	@Test
	public void testDeleteUser() throws Exception {
		String userId = "1";

		mockMvc.perform(delete("/api/v1/users/{userId}", userId)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void contextLoads() {
	}

	public static String asJsonString(final Object object) {
		try {
			return new ObjectMapper().writeValueAsString(object);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}



}