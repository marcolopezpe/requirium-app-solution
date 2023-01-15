package pe.marcolopez.solutions.requirium.adapters.out.dbs.nosql.mongodb.springdata.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericMongoRepository<T, ID> extends ReactiveMongoRepository<T, ID> {
}
