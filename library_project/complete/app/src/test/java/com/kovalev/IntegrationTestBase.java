package com.kovalev;


import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.kovalev.initalizer.PostreSQL;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = {
		PostreSQL.Initializer.class
})
public abstract class IntegrationTestBase {
	@LocalServerPort
	protected int port;

	@BeforeAll
	static void initTestContainer() {
		PostreSQL.container.start();
	}

	protected String getHost() {
		return "http://localhost:" + port;
	}

}
