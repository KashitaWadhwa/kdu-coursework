package com.kdu.myapplication.service;


import com.kdu.myapplication.dao.PersonDAO;
import com.kdu.myapplication.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    PersonDAO personDAO;

    @Autowired
    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public void addPerson(Person person){
        personDAO.addPerson(person);
    }

    public Person getPersonById(int id){
        return personDAO.getPersonById(id);
    }

    public String getRoleById(int id){
        return personDAO.getRoleByPersonId(id);
    }

    public Person getPersonUserName(String name){
        for(Person p: personDAO.getAllPersons()){
            if(p.getUserName().equals(name)){
                return p;
            }
        }
        return null;
    }
}
