package org.sravan;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest
public class WebTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private HelloService service;

	@Test
	public void testShouldReturnMessage() throws Exception {

		when(service.sayHello()).thenReturn("Hello World");

		mockMvc.perform(MockMvcRequestBuilders.get("/hello")).andExpect(MockMvcResultMatchers.status().is(200))
				.andExpect(MockMvcResultMatchers.content().string("Hello World"))
				.andExpect(MockMvcResultMatchers.header().string("Content-Type", "text/plain;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.header().string("Content-Length", "11"));
	}
}
