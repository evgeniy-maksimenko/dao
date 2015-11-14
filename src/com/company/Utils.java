package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {
    ArrayList<PersonModel> arrayListPerson = new ArrayList<PersonModel>();
    
    public Utils(ArrayList<PersonModel> initArrayListPerson) {
        arrayListPerson = initArrayListPerson;
    }

    public String toCSV() {
        String result = "id,first_name,last_name";
        for (int i = 0; i < arrayListPerson.size(); i++){
            result += "\n"+arrayListPerson.get(i).id+","+arrayListPerson.get(i).first_name+","+arrayListPerson.get(i).last_name;
        }
        return result;
    }

    public String toXML() {
        String result = "<Person>";
        for (int i = 0; i < arrayListPerson.size(); i++){
            result += "\n\t<id>"+arrayListPerson.get(i).id+"</id>";
            result += "\n\t<first_name>"+arrayListPerson.get(i).first_name+"</first_name>";
            result += "\n\t<last_name>"+arrayListPerson.get(i).last_name+"</last_name>";
        }
        result += "\n</Person>";
        return result;
    }

    public String toJSON() {
        String result = "[";
        for (int i = 0; i < arrayListPerson.size(); i++){

            result += "\n\t{";
            result += "\n\t\t\"id\":"+arrayListPerson.get(i).id+",";
            result += "\n\t\t\"first_name\":\""+arrayListPerson.get(i).first_name+"\",";
            result += "\n\t\t\"last_name\":\""+arrayListPerson.get(i).last_name+"\"";
            result += (i ==  arrayListPerson.size() -1 ) ? "\n\t}" : "\n\t},";

        }
        result += "\n]";
        return result;
    }
    
    public void printCSV(){
        System.out.println(toCSV());
    }

    public void printXML(){
        System.out.println(toXML());
    }

    public void printJSON(){
        System.out.println(toJSON());
    }
    
    
    public void saveCSV() {
        saveToFile("person.csv",toCSV());
    }

    public void saveJSON() {
        saveToFile("person.json",toJSON());
    }

    public void saveXML() {
        saveToFile("person.xml",toXML());
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
