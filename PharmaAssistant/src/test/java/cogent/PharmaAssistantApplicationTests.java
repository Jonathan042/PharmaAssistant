package cogent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import cogent.dao.BatchRepository;
import cogent.dao.UserRepository;
import cogent.entities.Batch;
import cogent.entities.User;
import cogent.exception.BatchException;
import cogent.service.BatchService;
import cogent.service.UserDetailsServiceImpl;



@SpringBootTest
class PharmaAssistantApplicationTests {
	
	@MockBean
	private UserRepository repository;
	
	@MockBean
	private BatchRepository batchRep;
	
	@Autowired
	private UserDetailsServiceImpl usds;
	
	@Autowired
	private BatchService batchServ;

	@Test
	public void loadUserByUsernameTest() {
		
		User user = new User("patsums","123");
		Optional<User> us = Optional.of(user);
		when(repository.findByUsername("patsums")).thenReturn(us);
		//assertEquals(user,usds.loadUserByUsername("patsums"));
		assertEquals(user.getUsername(),usds.loadUserByUsername("patsums").getUsername());
		assertEquals(user.getPassword(),usds.loadUserByUsername("patsums").getPassword());
		
	}
	
	
	@Test
	public void insertBatchTest() throws BatchException {
		Batch bt = new Batch();
		bt.setBatchCode("BTC-KHKA");
		bt.setPrice(45);
		bt.setRefrigeration(false);
		bt.setWeight(108);
		when(batchRep.save(bt)).thenReturn(bt);
		assertEquals(bt, batchServ.insertBatch(bt));
	}
	
	@Test
	public void insertBatchExceptionTest() {
		Batch bt = new Batch();
		bt.setBatchCode("BTC-KHKA");
		bt.setPrice(45);
		bt.setRefrigeration(false);
		bt.setWeight(108);
		when(batchRep.findByBatchCode("BTC-KHKA")).thenReturn(Optional.of(bt));
		try {
			batchServ.insertBatch(bt);
			assert(false);
		}catch(BatchException be) {
			assert(true);
		}

	}
	
	
	

}
