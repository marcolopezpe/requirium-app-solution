package pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.repository;

import org.springframework.stereotype.Repository;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.logistica.CentroCostoOracleEntity;

@Repository
public interface CentroCostoRepository extends GenericOracleRepository<CentroCostoOracleEntity, Integer> {
}
