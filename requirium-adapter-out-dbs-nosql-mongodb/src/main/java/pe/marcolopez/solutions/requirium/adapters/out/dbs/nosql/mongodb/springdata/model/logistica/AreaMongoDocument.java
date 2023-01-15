package pe.marcolopez.solutions.requirium.adapters.out.dbs.nosql.mongodb.springdata.model.logistica;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@ToString
@Document(collection = "area")
public class AreaMongoDocument {

    @Id
    private String id;
    private String nombre;
    private String abreviado;
}
