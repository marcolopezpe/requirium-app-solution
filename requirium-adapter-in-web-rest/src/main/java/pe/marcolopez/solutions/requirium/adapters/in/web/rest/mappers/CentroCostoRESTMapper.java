package pe.marcolopez.solutions.requirium.adapters.in.web.rest.mappers;

import org.springframework.stereotype.Component;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.dto.response.CentroCostoResponse;
import pe.marcolopez.solutions.requirium.domain.logistica.CentroCosto;

@Component
public class CentroCostoRESTMapper {

    public CentroCostoResponse toCentroCostoResponse(CentroCosto centroCosto) {
        if (centroCosto == null) return null;

        return CentroCostoResponse.builder()
                .id(centroCosto.getId())
                .nombre(centroCosto.getNombre())
                .abreviado(centroCosto.getAbreviado())
                .build();
    }
}
