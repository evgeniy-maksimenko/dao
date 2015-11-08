package com.company;

import java.util.ArrayList;

public class PersonDAO_Mock implements PersonDAO{

    public ArrayList<PersonModel> arrayModelPerson = new ArrayList<PersonModel> ();

    @Override
    public ArrayList<PersonModel> selectDB() {
        return arrayModelPerson;
    }

    @Override
    public void insertDB(PersonModel modelPerson) {
        this.arrayModelPerson.add(modelPerson);
    }

    @Override
    public void updateDB(PersonModel modelPerson) {

    }

    @Override
    public void deleteDB(int id) {
        this.arrayModelPerson.remove(id);
    }
}
