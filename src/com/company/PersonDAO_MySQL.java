package com.company;

import java.sql.*;
import java.util.ArrayList;

public class PersonDAO_MySQL implements PersonDAO{
    public Statement st;

    public PersonDAO_MySQL() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","");
            this.st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<PersonModel> selectDB() {

        ArrayList<PersonModel> PersonModel = new ArrayList<PersonModel>();
        try {
            ResultSet rs = this.st.executeQuery("SELECT * FROM Person");

            while (rs.next()) {
                PersonModel p = new PersonModel(rs.getInt("id"), rs.getString(2), rs.getString(3));
                PersonModel.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return PersonModel;

    }

    @Override
    public void insertDB(PersonModel modelPerson) {
        try {
            this.st.executeUpdate("INSERT INTO Person (id, first_name, last_name) VALUES (NULL,'" + modelPerson.first_name + "','" + modelPerson.last_name + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDB(PersonModel modelPerson) {
        try {
            this.st.executeUpdate("UPDATE Person SET first_name='"+modelPerson.first_name +"' WHERE id="+modelPerson.id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteDB(int id) {
        try {
            this.st.executeUpdate("DELETE FROM Person WHERE id="+id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
