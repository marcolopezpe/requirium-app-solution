package pe.marcolopez.solutions.requirium.adapters.out.dbs.nosql.mongodb.springdata.mappers.base;

import java.util.List;

public interface GenericMongoMapper<T, D> {

    D toDomain(T t);

    T toDocument(D d);

    List<D> toDomains(List<T> es);

    List<T> toDocuments(List<D> ds);
}
