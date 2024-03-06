package com.example.spring2;

import com.opencsv.CSVWriter;

import java.io.StringWriter;
import java.util.List;

public class CSVGenerator {

    public static String generateCsv(List<Teacher> objects) {
        try (StringWriter writer = new StringWriter(); CSVWriter csvWriter = new CSVWriter(writer)) {
            // Nagłówki CSV (jeśli potrzebne)
            String[] headers = {"Id", "Imię", "Nazwisko","Stan", "Rok urodzenia", "Wynagrodzenie"};
            csvWriter.writeNext(headers);

            // Dla każdego obiektu w liście
            for (Teacher obj : objects) {
                // Tworzenie tablicy z wartościami obiektu
                String[] data = {
                        String.valueOf(obj.getId()),
                        obj.getImie(),
                        obj.getNazwisko(),
                        obj.getTeacherCondition().name(),
                        String.valueOf(obj.getRok_urodzenia()),
                        String.valueOf(obj.getWynagrodzenie())
                };

                // Dodawanie wiersza do pliku CSV
                csvWriter.writeNext(data);
            }

            // Zwracanie danych CSV w postaci String
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return ""; // Obsługa błędu
        }
    }

    // Poniżej umieść getter-y dla pól Twojego obiektu (YourObject)
}