package system.design.services;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ServicesApplicationTests {

	@Test
	void contextLoads() {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 55; i++) {
			list.add(i);
		}

		for (int i = 0; i < list.size(); i = i+10) {
			System.out.println(new ArrayList<>(list.subList(i, Math.min(i+10, list.size()))));
		}
	}

}
