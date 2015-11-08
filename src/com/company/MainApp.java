package com.company;

public class MainApp {

    public static void main(String[] args) {

        PersonDAO_MySQL person = new PersonDAO_MySQL();
        person.insertDB(new PersonModel(0, "jag", "ru"));
        person.deleteDB(2);
        person.updateDB(new PersonModel(3, "jag101", "ru"));
        System.out.println(person.selectDB());

    }
}
