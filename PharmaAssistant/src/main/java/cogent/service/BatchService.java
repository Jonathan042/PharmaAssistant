package cogent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cogent.dao.BatchRepository;
import cogent.entities.Batch;
import cogent.exception.BatchException;

@Service
public class BatchService {
	
	@Autowired
	private BatchRepository bdao;
	
	public void insertBatch(Batch b) throws BatchException {
		
		if(bdao.findByBatchCode(b.getBatchCode()).isEmpty()) {
			bdao.save(b);
			}
		else throw new BatchException();
		
	
	}

}
