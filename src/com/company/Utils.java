package com.company;


import java.io.*;
import java.util.ArrayList;

public class Utils {
    ArrayList<PersonModel> arrayListPerson = new ArrayList<PersonModel>();

    public Utils() {}

    public Utils(ArrayList<PersonModel> initArrayListPerson) {
        arrayListPerson = initArrayListPerson;
    }

    public String toCSV() {
        String result = "id,first_name,last_name";
        for (PersonModel anArrayListPerson : arrayListPerson) {
            result += "\n" + anArrayListPerson.id + "," + anArrayListPerson.first_name + "," + anArrayListPerson.last_name;
        }
        return result;
    }

    public String toXML() {
        String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        result += "<Persons>";
        for (PersonModel anArrayListPerson : arrayListPerson) {
            result += "\n\t<Person>";
            result += "\n\t\t<id>" + anArrayListPerson.id + "</id>";
            result += "\n\t\t<first_name>" + anArrayListPerson.first_name + "</first_name>";
            result += "\n\t\t<last_name>" + anArrayListPerson.last_name + "</last_name>";
            result += "\n\t</Person>";
        }
        result += "\n</Persons>";
        return result;
    }

    public String toJSON() {
        String result = "[";
        for (int i = 0; i < arrayListPerson.size(); i++) {

            result += "{";
            result += "\"id\":" + arrayListPerson.get(i).id + ",";
            result += "\"first_name\":\"" + arrayListPerson.get(i).first_name + "\",";
            result += "\"last_name\":\"" + arrayListPerson.get(i).last_name + "\"";
            result += (i == arrayListPerson.size() - 1) ? "}" : "},";

        }
        result += "]";
        return result;
    }

    public void printCSV() {
        System.out.println(toCSV());
    }

    public void printXML() {
        System.out.println(toXML());
    }

    public void printJSON() {
        System.out.println(toJSON());
    }


    public void saveCSV() {
        saveToFile("person.csv", toCSV());
    }

    public void saveJSON() {
        saveToFile("person.json", toJSON());
    }

    public void saveXML() {
        saveToFile("person.xml", toXML());
    }

    public void saveToFile(String Name, String Body) {

        try {
            File newTextFile = new File(Name);

            FileWriter fw = new FileWriter(newTextFile);
            fw.write(Body);
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
