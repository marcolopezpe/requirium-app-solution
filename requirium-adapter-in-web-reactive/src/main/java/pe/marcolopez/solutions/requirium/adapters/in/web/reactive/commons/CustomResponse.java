package pe.marcolopez.solutions.requirium.adapters.in.web.reactive.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import pe.marcolopez.solutions.requirium.adapters.in.web.reactive.enums.CodeResponseEnum;

import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomResponse<T> {

    @Builder.Default
    private CodeResponseEnum code = CodeResponseEnum.EXITO;
    @Builder.Default
    private LocalDateTime datetTime = LocalDateTime.now();
    private String status;
    private String message;
    private String details;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

}
