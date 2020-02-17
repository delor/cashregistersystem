//package me.plich.cashregistersystem.config;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//public class DateParser {
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
//
//    public LocalDate stringToDate(String date) {
//        LocalDate localDate = LocalDate.parse(date, formatter);
//        return localDate;
//    }
//
//    public String localDateToString(LocalDate date) {
//        String localDate = date.format(formatter);
//        return localDate;
//    }
//}
