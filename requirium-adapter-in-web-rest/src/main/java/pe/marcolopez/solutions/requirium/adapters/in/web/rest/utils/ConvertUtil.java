package pe.marcolopez.solutions.requirium.adapters.in.web.rest.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

public class ConvertUtil {

    public static LocalDate toLocalDate(Long value) {
        return Instant.ofEpochMilli(value).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime toLocalDateTime(Long value) {
        return Instant.ofEpochMilli(value).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static String generateCodigo() {
        String codigo = UUID.randomUUID().toString();
        return codigo.replace("-", "");
    }
}
