package pe.marcolopez.solutions.requirium.adapters.in.web.rest.mappers;

import org.springframework.stereotype.Component;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.dto.request.AreaRequest;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.dto.response.AreaResponse;
import pe.marcolopez.solutions.requirium.domain.logistica.Area;

@Component
public class AreaRESTMapper {

    public Area toDomain(AreaRequest areaRequest) {
        if (areaRequest == null) return null;

        return Area.builder()
                .nombre(areaRequest.getNombre())
                .abreviado(areaRequest.getAbreviado())
                .build();
    }

    public AreaResponse toAreaResponse(Area area) {
        if (area == null) return null;

        return AreaResponse.builder()
                .id(area.getId())
                .nombre(area.getNombre())
                .abreviado(area.getAbreviado())
                .build();
    }
}
