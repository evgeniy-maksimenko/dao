package com.company;

import java.io.File;
import java.io.FileWriter;

public class MainApp {

    public static void main(String[] args) {

        PersonDAO_MySQL person = new PersonDAO_MySQL();
//        person.insertDB(new PersonModel(0, "jag", "ru"));
//        person.deleteDB(2);
//        person.updateDB(new PersonModel(3, "jag101", "ru"));
//        System.out.println(person.selectDB());


        Utils resultPerson = new Utils(person.selectDB());
        System.out.println("===== CSV =====");
        resultPerson.printCSV();
        resultPerson.saveCSV();

        System.out.println("===== XML =====");
        resultPerson.printXML();
        resultPerson.saveXML();

        System.out.println("===== JSON =====");
        resultPerson.printJSON();
        resultPerson.saveJSON();
        

    }
}
