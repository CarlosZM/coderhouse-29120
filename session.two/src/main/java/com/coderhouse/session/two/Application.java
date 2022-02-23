package com.coderhouse.session.two;

import com.coderhouse.session.two.orm.Document;
import com.coderhouse.session.two.orm.DocumentRepository;
import com.coderhouse.session.two.orm.Person;
import com.coderhouse.session.two.orm.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DocumentRepository documentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        this.insertData();

        this.selectData();

        this.filterData();

    }

    private void filterData() {

        List<Person> filterType1 = this.personRepository.getFiltered(25);

        System.out.println("System has to show some records from table 'person' filtered by age");

        for (Person person : filterType1) {
            System.out.printf("Record id: %d with name %s and age %d in 'person' table %n", person.getId(), person.getName(), person.getAge());

        }

        List<Person> filterType2 = this.personRepository.getAllByAgeGreaterThan(25);


        System.out.println("System has to show some records from table 'person' filtered by age");

        for (Person person : filterType2) {
            System.out.printf("Record id: %d with name %s and age %d in 'person' table %n", person.getId(), person.getName(), person.getAge());

        }
    }

    private void selectData() {
        System.out.println("System has to show some records from table 'person'");

        List<Person> personList = this.personRepository.findAll();
        for (Person person : personList) {
            System.out.printf("Record id: %d with name %s and age %d in 'person' table %n", person.getId(), person.getName(), person.getAge());

        }
    }

    private void insertData() {

        Person person = new Person();
        person.setAge(30);
        person.setName("Carlos");
        Document document=new Document();
        document.setName("Documento");

        person.setDocumentList(Collections.singletonList(
                this.documentRepository.save(document)
        ));

        Person persistedPerson = this.personRepository.saveAndFlush(person);

        System.out.printf("System has added a record in 'tbl_person' table with id %d %n", persistedPerson.getId());

        person = new Person();
        person.setAge(20);
        person.setName("Juan");
        document=new Document();
        document.setName("Documento1");
        person.setDocumentList(Collections.singletonList(
                this.documentRepository.save(document)
        ));

        persistedPerson = this.personRepository.saveAndFlush(person);

        System.out.printf("System has added a record in 'tbl_person' table with id %d %n", persistedPerson.getId());
    }
}
