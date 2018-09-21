package entity;

import entity.Address;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-21T23:59:32")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, String> lName;
    public static volatile ListAttribute<Person, Address> addresses;
    public static volatile SingularAttribute<Person, String> fName;
    public static volatile SingularAttribute<Person, Integer> id;
    public static volatile SingularAttribute<Person, String> pNumber;

}