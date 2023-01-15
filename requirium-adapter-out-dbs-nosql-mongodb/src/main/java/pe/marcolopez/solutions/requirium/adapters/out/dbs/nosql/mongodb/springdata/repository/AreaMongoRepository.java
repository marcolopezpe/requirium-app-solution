package pe.marcolopez.solutions.requirium.adapters.out.dbs.nosql.mongodb.springdata.repository;

import org.springframework.stereotype.Repository;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.nosql.mongodb.springdata.model.logistica.AreaMongoDocument;

@Repository
public interface AreaMongoRepository extends GenericMongoRepository<AreaMongoDocument, String> {
}
