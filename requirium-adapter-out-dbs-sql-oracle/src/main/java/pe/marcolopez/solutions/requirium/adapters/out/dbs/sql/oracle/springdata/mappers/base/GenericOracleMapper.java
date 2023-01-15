package pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.mappers.base;

import java.util.List;

public interface GenericOracleMapper<E, D> {

    D toDomain(E e);

    E toEntity(D d);

    void toEntityUpdating(D d, E e);

    List<D> toDomains(List<E> es);

    List<E> toEntities(List<D> ds);
}
