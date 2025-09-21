package com.genesysafrica.pensionr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootTest
class PensionrApplicationTests {

	@Test
	void contextLoads() {
        var modules = ApplicationModules.of(PensionrApplication.class).verify();
        System.out.println(modules.toString());
	}

}
