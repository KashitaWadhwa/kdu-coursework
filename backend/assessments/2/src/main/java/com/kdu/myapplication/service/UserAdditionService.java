package com.kdu.myapplication.service;

import com.kdu.myapplication.dao.PersonDAO;
import com.kdu.myapplication.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAdditionService implements CommandLineRunner {

    /** The data access object for interacting with the database. */
    PersonDAO personDAO;

    /** The password encoder for securely encoding passwords. */
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserAdditionService(PersonDAO personDAO, PasswordEncoder passwordEncoder) {
        this.personDAO = personDAO;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Adds initial user data to the database on application startup.
     *
     * @param args Command line arguments (not used in this implementation).
     * @throws Exception If an exception occurs during the execution of the command line runner.
     */

    @Override
    public void run(String... args) throws Exception{
        personDAO.addPerson(new Person("Kashita", "kashita", passwordEncoder.encode("kashita"), "ROLE_ADMIN"));
        personDAO.addPerson(new Person("Manya", "manya", passwordEncoder.encode("manya"), "ROLE_BASIC"));
    }

}
