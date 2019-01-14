package net.nikosath.springbootrestunittest.controller;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import net.nikosath.springbootrestunittest.business.FictionalCharacterService;
import net.nikosath.springbootrestunittest.model.FictionalCharacter;
import net.nikosath.springbootrestunittest.model.Gender;

@RunWith(SpringRunner.class)
@WebMvcTest(FictionalCharacterControllerImpl.class)
public class FictionalCharacterControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FictionalCharacterService businessService;

	@Test
	public void retrieveFictCharacters_basic() throws Exception {
		List<FictionalCharacter> list = new ArrayList<>();
		list.add(new FictionalCharacter(1000L, "Mike", "Papakis", Gender.Male, LocalDate.of(1990, 3, 7)));
		when(businessService.retrieveFictCharacters(anyString(), anyString(), anyInt()))
			.thenReturn(list);

		RequestBuilder request = MockMvcRequestBuilders.get("/fictional-characters")
				.accept(MediaType.ALL);

		String expectedJson = "[{\"fictionalCharacterId\":1000,\"firstName\":\"Mike\","
				+ "\"lastName\":\"Papakis\",\"fullName\":\"Mike Papakis\",\"gender\":\"Male\","
				+ "\"birthdate\":\"1990-03-07\"}]";
		
		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json(expectedJson)).andReturn();
	}
	
}
