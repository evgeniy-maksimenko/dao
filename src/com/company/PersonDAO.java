package com.company;

import java.util.ArrayList;

public interface PersonDAO {
    public ArrayList<PersonModel> selectDB();
    public void insertDB(PersonModel modelPerson);
    public void updateDB(PersonModel modelPerson);
    public void deleteDB(int id);
}
