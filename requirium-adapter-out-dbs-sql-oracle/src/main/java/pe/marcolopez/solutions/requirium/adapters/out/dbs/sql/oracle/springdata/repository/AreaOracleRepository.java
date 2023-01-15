package pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.repository;

import org.springframework.stereotype.Repository;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.logistica.AreaOracleEntity;

@Repository
public interface AreaOracleRepository extends GenericOracleRepository<AreaOracleEntity, Integer> {
}
