package pe.marcolopez.solutions.requirium.adapters.in.web.rest.mappers;

import org.springframework.stereotype.Component;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.dto.response.BancoResponse;
import pe.marcolopez.solutions.requirium.domain.logistica.Banco;

@Component
public class BancoRESTMapper {

    public BancoResponse toBancoResponse(Banco banco) {
        if (banco == null) return null;

        return BancoResponse.builder()
                .id(banco.getId())
                .nombre(banco.getNombre())
                .abreviado(banco.getAbreviado())
                .build();
    }
}
