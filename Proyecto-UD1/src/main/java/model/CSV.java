package model;

import java.io.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class CSV {
            public  void extraerCSV(File exportarCSV, Users users)  {

                try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(exportarCSV.getAbsolutePath()));
                     CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {

                    csvPrinter.printRecord("Nombre", "Edad", "Email");

                    for (User user: users.getUsers().values()) {
                        csvPrinter.printRecord(user.getName(), String.valueOf(user.getAge()), user.getEmail());
                    }
                    csvPrinter.flush();

                }  catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
}
