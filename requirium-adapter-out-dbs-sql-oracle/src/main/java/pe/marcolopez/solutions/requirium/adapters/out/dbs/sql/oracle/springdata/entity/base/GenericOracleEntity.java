package pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.base;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@MappedSuperclass
public class GenericOracleEntity implements Serializable {

    @Builder.Default
    private String usuarioCreacion = "SYSTEM";
    @Builder.Default
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    @Builder.Default
    private String usuarioModificacion = "SYSTEM";
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaModificacion;
    @Builder.Default
    private String estado = "1";
}
