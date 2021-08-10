package cogent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import cogent.dao.UserRepository;
import cogent.entities.User;
import cogent.service.UserDetailsServiceImpl;



@SpringBootTest
class PharmaAssistantApplicationTests {
	
	@MockBean
	private UserRepository repository;
	
	@Autowired
	private UserDetailsServiceImpl usds;

	@Test
	public void loadUserByUsernameTest() {
		
		User user = new User("patsums","123");
		Optional<User> us = Optional.of(user);
		when(repository.findByUsername("patsums")).thenReturn(us);
		//assertEquals(user,usds.loadUserByUsername("patsums"));
		assertEquals(user.getUsername(),usds.loadUserByUsername("patsums").getUsername());
		assertEquals(user.getPassword(),usds.loadUserByUsername("patsums").getPassword());
		
	}
	
	

}
