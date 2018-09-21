/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runner;

import entity.Address;
import entity.Person;
import facade.PersonFacade;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author mohammahomarhariri
 */
public class Runner {
    
    public static void main(String[] args) {
        
        Persistence.generateSchema("pu", null);
        PersonFacade pf = new PersonFacade(Persistence.createEntityManagerFactory("pu"));
        
        Person p1 = new Person("moe", "Jack", "89272334");
        Person p2 = new Person("snoop", "Dog", "16444334");
        Person p3 = new Person("SyncMan", "Master", "84433334");
        Person p4 = new Person("Drops", "Camp", "32244564");
        
        Address a1 = new Address("Magnem Street", "JackTown");
        Address a2 = new Address("maker street", "pen town");
        Address a3 = new Address("Spankin Street", "New York");
        Address a4 = new Address("headQuater", "Washington");
        
        a1.addPerson(p1);
        a1.addPerson(p2);
        a1.addPerson(p3);
        
        a2.addPerson(p4);
        a2.addPerson(p2);
        
        p1.addAddress(a1);
        p1.addAddress(a2);
        p1.addAddress(a3);
        p1.addAddress(a4);
        
        p4.addAddress(a3);
        p4.addAddress(a4);
        
        EntityManager em = Persistence.createEntityManagerFactory("pu").createEntityManager();
        
        em.getTransaction().begin();
        em.persist(a1);
        em.persist(a2);
        em.persist(a3);
        em.persist(a4);
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(p4);
        em.getTransaction().commit();
        
        pf.createPerson(new Person("abed", "hariri", "20712030"));
        pf.createPerson(new Person("peter", "griffin", "58430229"));
        pf.createPerson(new Person("george", "petersen", "22103044"));
        pf.createPerson(new Person("scott", "padkins", "96055480"));
        
        
        
        
    }
}
