package com.example.session13_demo.repository.impl;

import com.example.session13_demo.model.Person;
import com.example.session13_demo.repository.IPersonRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // tiem sang cho khac
@RequiredArgsConstructor
public class PersonRepositoryImpl implements IPersonRepository {

    private final SessionFactory sessionFactory;

    @Override
    public List<Person> getAll() {
        // mở phiên thao tác với DB
        Session session = sessionFactory.openSession();

        //cú pháp về HQL : hibernate  QL
        List<Person> list = session.createQuery("select p from Person p", Person.class).list();

        session.close();
        return list;
    }

    @Override
    public void save(Person person) {
        Session session = sessionFactory.openSession();
        session.save(person);
        session.close();
        // tim hieu getCurrentSession
    }
}
