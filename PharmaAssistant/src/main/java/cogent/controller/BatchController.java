package cogent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cogent.entities.Batch;
import cogent.exception.BatchException;
import cogent.service.BatchService;

@CrossOrigin
@RestController
@RequestMapping(path="/api")
public class BatchController {
	
	@Autowired
	private BatchService bs;
	
	@PostMapping(path="/batches")
	public Batch addBatch(@RequestBody Batch b) throws BatchException {
		
		bs.insertBatch(b);
		
		return b;
	}

}
