package pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericOracleRepository<T, ID> extends JpaRepository<T, ID> {
}
