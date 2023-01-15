package pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.logistica.RequerimientoOracleEntity;

@Repository
public interface RequerimientoOracleRepository extends GenericOracleRepository<RequerimientoOracleEntity, Integer> {

    @Modifying
    @Query(value = """
                UPDATE TBL_REQUERIMIENTO SET
                    FECHA_APROBACION_EVALUADOR = CURRENT_DATE,
                    EVALUADOR_ID = :empleadoId
                WHERE ID = :requerimientoId
            """, nativeQuery = true)
    void aprobar(@Param("requerimientoId") Integer requerimientoId,
                 @Param("empleadoId") Integer empleadoId);

    @Modifying
    @Query(value = """
                UPDATE TBL_REQUERIMIENTO SET
                    FECHA_ANULACION = CURRENT_DATE,
                    ANULADOR_ID = :empleadoId
                WHERE ID = :requerimientoId
            """, nativeQuery = true)
    void anular(@Param("requerimientoId") Integer requerimientoId,
                 @Param("empleadoId") Integer empleadoId);

    @Modifying
    @Query(value = """
                UPDATE TBL_REQUERIMIENTO SET
                    FECHA_CIERRE = CURRENT_DATE,
                    CERRADOR_ID = :empleadoId
                WHERE ID = :requerimientoId
            """, nativeQuery = true)
    void cerrar(@Param("requerimientoId") Integer requerimientoId,
                 @Param("empleadoId") Integer empleadoId);

}
