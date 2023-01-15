package pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.repository;

import org.springframework.stereotype.Repository;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.logistica.EmpleadoOracleEntity;

@Repository
public interface EmpleadoOracleRepository extends GenericOracleRepository<EmpleadoOracleEntity, Integer>{
}
