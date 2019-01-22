package com.sg.fileconverter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatToCSV {

    public static void main(String[] args) {
        Scanner scanner = null;
        List<String> datFileList = new ArrayList<>();
        String FILE_NAME = "File.dat";
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(FILE_NAME)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (scanner.hasNextLine()) {

            datFileList.add(scanner.nextLine());
        }
        scanner.close();
        convertDatToCsv("csvfile.csv", datFileList);
    }

    public static void convertDatToCsv(String FileName, List<String> datFile) {
        PrintWriter csvWriter = null;
        try {
            csvWriter = new PrintWriter(new FileWriter(FileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for (int x = 0; x <= datFile.size() - 1; x++) {
            String Sample = datFile.get(x);
            csvWriter.println(Sample);
            csvWriter.flush();
        }
        csvWriter.close();
    }
}
