package com.coderhouse.session.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        this.createTable();

        this.insertData();

        this.listData();

        //this.updateData();

        this.listData();

        //this.deleteData();

        this.listData();

        //this.dropTable();
    }

    private void createTable() {
        String createSql = "CREATE TABLE person (id SERIAL NOT NULL, name varchar NULL, " +
                "age INTEGER NULL, CONSTRAINT person_pkey PRIMARY KEY(id));";

        this.jdbcTemplate.execute(createSql);

        System.out.println("System has created 'person' table");
    }

    private void insertData() {

        String insertSql = "INSERT INTO person(name,age) values(?,?);";

        jdbcTemplate.execute(insertSql, (PreparedStatementCallback<Boolean>) ps -> {
            ps.setString(1, "Carlos");
            ps.setInt(2, 10);
            return ps.execute();
        });

        System.out.println("System has added a record in 'person' table");

        jdbcTemplate.execute(insertSql, (PreparedStatementCallback<Boolean>) ps -> {
            ps.setString(1, "Lizandro");
            ps.setInt(2, 15);
            return ps.execute();
        });

        System.out.println("System has added a record in 'person' table");
    }

    private void listData() {

        String selectSql = "SELECT * FROM person;";

        List<Person> personList = jdbcTemplate.query(selectSql, (rs, rowNum) -> {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setAge(rs.getInt("age"));
            return person;
        });

        System.out.println("System has to show some records from table 'person'");

        for(Person person: personList){
            System.out.printf("Record id: %d with name %s and age %d in 'person' table %n",person.getId(),person.getName(),person.getAge());

        }

    }
}
