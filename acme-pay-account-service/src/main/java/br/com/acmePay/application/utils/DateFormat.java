package br.com.acmePay.application.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormat {

    public static String format(){

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formated = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return now.format(formated);
    }
}
