package com.company;

import java.util.ArrayList;

public class MainApp {

    public static void main(String[] args) {


        PersonDAO_MySQL person = new PersonDAO_MySQL();
//        person.insertDB(new PersonModel(0, "jag", "ru"));
//        person.deleteDB(2);
//        person.updateDB(new PersonModel(3, "jag101", "ru"));
//        System.out.println(person.selectDB());


        Utils utils = new Utils(person.selectDB());
        System.out.println("===== CSV =====");
//        utils.printCSV();
//        utils.saveCSV();

        System.out.println("===== XML =====");
//        utils.printXML();
//        utils.saveXML();

        System.out.println("===== JSON =====");
 //       utils.printJSON();
 //       utils.saveJSON();

        ArrayList<PersonModel> arrayListPerson = new ArrayList<PersonModel>();
//        JSONParser Parser = new JSONParser();
//        System.out.println(Parser.parse());
        
//        CSVParser parser = new CSVParser();
//        System.out.println(parser.parse());

        XMLParser parser = new XMLParser();
        System.out.println(parser.parse());
        
    }
}
