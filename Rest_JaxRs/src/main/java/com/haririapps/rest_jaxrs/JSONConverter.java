/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haririapps.rest_jaxrs;

import com.google.gson.Gson;
import entity.Person;
import entity.PersonDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mohammahomarhariri
 */
public class JSONConverter {
    
    

    public static Person getPersonFromJson(String js) {
        Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
        
        return gson.fromJson(js,Person.class);
        
    }

    public static String getJSONFromPerson(PersonDTO p) {
        Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
        
        return gson.toJson(p);
        
    }

    public static String getJSONFromPersons(List<PersonDTO> persons){
        System.out.println("getJSON --- FROM -- - PERSON ---  ");
        Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
        StringBuilder sb = new StringBuilder();
        List<PersonDTO> res = new ArrayList<>();
           
          
        System.out.println("REALLY FINISHED");
        
        return gson.toJson(persons);
        
    }
}
