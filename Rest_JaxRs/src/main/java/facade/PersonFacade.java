/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import entity.PersonDTO;
import static java.util.Collections.list;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author mohammahomarhariri
 */
public class PersonFacade {

    private EntityManagerFactory emf;

    public PersonFacade(EntityManagerFactory emf) {

        this.emf = emf;

    }

    public void addEntityManagerFactory(EntityManagerFactory emf) {

    }

    public Person createPerson(Person p) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();

        } catch (Error e) {
            System.out.println(e);
        } finally {
            em.close();
        }

        return p;
    }

    public Person deletePerson(Person p) {
        EntityManager em = emf.createEntityManager();

        // PersonDTO deletedPerson = em.find(PersonDTO.class, p.getId()); hvorfor ikke bruge det her? 
        em.getTransaction().begin();
        Query query = em.createQuery("select p from Person p where p.fName = :fn and p.lName = :ln", Person.class);
        query.setParameter("fn", p.getfName());
        query.setParameter("ln", p.getlName());
        Person delPerson = (Person) query.getSingleResult();
        // int executeCount = query.executeUpdate(); (NOT NESSESARY) counting how many changes have been done in the database

        if (delPerson != null) {

            em.remove(delPerson);
            em.getTransaction().commit();

        }

        return delPerson;

    }

//    public PersonDTO getPerson(int id) {
//        EntityManager em = emf.createEntityManager();
//
//        PersonDTO pDTO;
//        
//        try {
//            
//            Person p = em.find(Person.class, id);
//            pDTO = new PersonDTO(p);
//            return pDTO;
////          
////            Query query = em.createQuery("select pers from Person pers where pers.fName = :firstname and pers.lName = :lastname", Person.class);
////            query.setParameter("firstname", p.getfName());
////            query.setParameter("lastname", p.getlName());
////            Person pers = (Person) query.getSingleResult();
////
////            if (pers != null) {
////
////                pDTO.setId(pers.getId());
////                pDTO.setPhone(pers.getpNumber());
////                pDTO.setfName(pers.getfName());
////                pDTO.setlName(pers.getlName());
////
////            }
//        } finally {
//            em.close();
//        }
//        return pDTO;
//
//    }
    
    public List<PersonDTO> getAllPersonDTOs() {
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT p FROM Person p");
        List<PersonDTO> list = query.getResultList();
        if (list != null) {
            
            return list;
            
        } else {
            return null;
        }

    }
        public List<PersonDTO> getAllPersons() {
        EntityManager em = emf.createEntityManager();

        try{
        Query query = em.createQuery("SELECT p FROM Person p");
        List<PersonDTO> list = query.getResultList();
        if (list != null) {
            
            return list;
        } else {
            return null;
            
        }}finally{
            System.out.println("GETALLPERSONS FINISHED PFACADE GOOD ----------");
        }

    }

    //Used to change number and not name and lastname
    public Person editPerson(Person p) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();

        } finally {
            em.close();
        }

        return p;
    }

    public PersonDTO getPerson(Integer id) {
        EntityManager em = emf.createEntityManager();

        try {
            Person p = em.find(Person.class, id);
            return new PersonDTO(p);
        } finally {
            em.close();
        }

    }

}
