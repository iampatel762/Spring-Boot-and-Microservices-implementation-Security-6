package com.security.SecurityFeature.implemented;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SecurityFeatureImplementedApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	Calculator c = new Calculator();
	@Test
	void testSum(){
		int expectedResult  = 1;
		int actualResult = c.doSum(3,4,6);
		assertThat(actualResult).isEqualTo(expectedResult);
	}


}
