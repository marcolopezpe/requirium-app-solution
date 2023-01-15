package pe.marcolopez.solutions.requirium.adapters.out.dbs.nosql.mongodb.springdata.mappers.logistica;

import org.springframework.stereotype.Component;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.nosql.mongodb.springdata.mappers.base.GenericMongoMapper;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.nosql.mongodb.springdata.model.logistica.AreaMongoDocument;
import pe.marcolopez.solutions.requirium.domain.logistica.Area;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AreaMongoMapper implements GenericMongoMapper<AreaMongoDocument, Area> {

    @Override
    public Area toDomain(AreaMongoDocument areaMongoDocument) {
        if (areaMongoDocument == null) return null;

        return Area.builder()
                //.id(areaMongoDocument.getId())
                .nombre(areaMongoDocument.getNombre())
                .abreviado(areaMongoDocument.getAbreviado())
                .build();
    }

    @Override
    public AreaMongoDocument toDocument(Area area) {
        if (area == null) return null;

        return AreaMongoDocument.builder()
                //.id(area.getId())
                .nombre(area.getNombre())
                .abreviado(area.getAbreviado())
                .build();
    }

    @Override
    public List<Area> toDomains(List<AreaMongoDocument> es) {
        if (es == null) return null;

        return es.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<AreaMongoDocument> toDocuments(List<Area> areas) {
        if (areas == null) return null;

        return areas.stream()
                .map(this::toDocument)
                .collect(Collectors.toList());
    }
}
