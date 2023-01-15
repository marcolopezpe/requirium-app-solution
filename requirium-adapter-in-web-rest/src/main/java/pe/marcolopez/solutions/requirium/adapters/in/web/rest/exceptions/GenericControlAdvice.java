package pe.marcolopez.solutions.requirium.adapters.in.web.rest.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.commons.CustomResponse;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.enums.CodeResponseEnum;

@Slf4j
@Controller
@ControllerAdvice
public class GenericControlAdvice {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<CustomResponse<Object>> handleCustomException(Exception ex, WebRequest request) {
        CustomResponse<Object> customResponse = CustomResponse.builder()
                .code(CodeResponseEnum.ERROR)
                .status(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .message(ex.getMessage())
                .details(request.getDescription(false))
                .build();
        log.error("handleCustomException: ", ex);
        return new ResponseEntity<>(customResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
