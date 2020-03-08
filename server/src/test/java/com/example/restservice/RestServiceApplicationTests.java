package com.example.restservice;

import com.example.restservice.presentation.HelloRestController;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestServiceApplicationTests {

	@Autowired
	HelloRestController helloRestController;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testShowHelloWorld() throws Exception{
		String message = helloRestController.showHelloWorld();
		assertThat(message, is("hello world"));
	}
}
