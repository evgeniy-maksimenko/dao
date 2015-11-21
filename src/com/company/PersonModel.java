package com.company;

public class PersonModel {
    public int id;
    public String first_name;
    public String last_name;

    public PersonModel() {}
    
    public PersonModel(int id, String firstName, String lastName) {
        this.id = id;
        this.first_name = firstName;
        this.last_name = lastName;
    }

    @Override
    public String toString()
    {
        return "Person [id=" + id + ", fname=" + first_name + ", lname=" + last_name +  "]";
    }

}
