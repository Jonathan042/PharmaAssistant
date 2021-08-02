package cogent.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import cogent.entities.Batch;
import cogent.entities.Medicine;


@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		Class[] domainTypes = {Batch.class, Medicine.class};
		config.exposeIdsFor(domainTypes);
	}

	


}
