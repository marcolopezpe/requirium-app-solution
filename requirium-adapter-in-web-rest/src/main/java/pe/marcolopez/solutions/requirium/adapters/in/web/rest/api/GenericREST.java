package pe.marcolopez.solutions.requirium.adapters.in.web.rest.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.commons.APIMessageConst;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.commons.CustomResponse;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.enums.CodeResponseEnum;

public class GenericREST {

    protected ResponseEntity<?> internalError() {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        CustomResponse.builder()
                                .code(CodeResponseEnum.ERROR)
                                .message(APIMessageConst.MSG_INTERNAL_SERVER_ERROR)
                                .build()
                );
    }
}
