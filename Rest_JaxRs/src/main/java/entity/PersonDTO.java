/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mohammahomarhariri
 */
public class PersonDTO{

    private int id;
    
    private String fName;
    private String lName;
    private String phone;
    
    public PersonDTO(Integer id, String fName, String lName, String phone) {
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.id = id;
    }

    public PersonDTO(String fName, String lName, String phone) {
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
    }
    
    public PersonDTO(Person p){
        this.fName = p.getfName();
        this.lName = p.getlName();
        this.phone = p.getpNumber();
        this.id = p.getId();
    }

    public PersonDTO() {
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.fName);
        hash = 67 * hash + Objects.hashCode(this.lName);
        hash = 67 * hash + Objects.hashCode(this.phone);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PersonDTO other = (PersonDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.fName, other.fName)) {
            return false;
        }
        if (!Objects.equals(this.lName, other.lName)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PersonDTO{" + "id=" + id + ", fName=" + fName + ", lName=" + lName + ", phone=" + phone + '}';
    }

}
