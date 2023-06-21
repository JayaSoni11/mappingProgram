package com.demo.mapping;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import com.demo.mapping.entity.Instructor;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MappingApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRepo testRepo;

	private String baseurl = "http://localhost";

	private static RestTemplate restTemplate;

	@BeforeAll
	public static void init() {
		restTemplate = new RestTemplate();
	}

	@BeforeEach
	public void setup() {
		baseurl = baseurl.concat(":").concat(port + "").concat("/save");
	}

	@Test
	public void testAddInstructor() {
		Instructor ins = new Instructor(1, "Soni", "Waiting");
		Instructor response = restTemplate.postForObject(baseurl, ins, Instructor.class);
		assertEquals("Soni", response.getName());
		assertEquals(1, testRepo.findAll().size());

	}

}
