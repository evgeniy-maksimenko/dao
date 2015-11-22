package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVParser {
    ArrayList<PersonModel> arrayListPerson = new ArrayList<PersonModel>();

    public ArrayList parse() {
        readFromFile("person.csv");
        return arrayListPerson;
    }

    public String readFromFile(String Name) {

        String result = "";
        int pos = 0;
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(Name));
            String currentLine;
            while ((currentLine = buffer.readLine()) != null) {
                pos++;
                if (pos != 1) {
                    String[] str = currentLine.split(",");

                    arrayListPerson.add(new PersonModel(Integer.parseInt(str[0]), str[1], str[2]));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
