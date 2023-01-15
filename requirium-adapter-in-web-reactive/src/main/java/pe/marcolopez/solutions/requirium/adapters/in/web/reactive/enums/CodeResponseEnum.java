package pe.marcolopez.solutions.requirium.adapters.in.web.reactive.enums;

import lombok.Getter;

@Getter
public enum CodeResponseEnum {
    ERROR(-1, "Error"),
    ALERTA(0, "Alerta"),
    EXITO(1, "Exito");

    private Integer valor;
    private String descripcion;

    CodeResponseEnum(Integer valor, String descripcion) {
        this.valor = valor;
        this.descripcion = descripcion;
    }
}
