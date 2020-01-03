package com.example.restservice.presentation;

import com.example.restservice.presentation.HelloRestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestserviceApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testShowHelloWorld() throws Exception{
		HelloRestController hello = new HelloRestController();
		String message = hello.showHelloWorld();
		assertThat(message,is("hello world"));

	}

}
