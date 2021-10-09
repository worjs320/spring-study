package net.madvirus.spring4.chap14.main;

import net.madvirus.spring4.chap14.domain.Person;
import net.madvirus.spring4.chap14.domain.PersonRepository;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.text.ParseException;
import java.util.List;


public class MainForSelectPerson {

    public static void main(String[] args) throws ParseException {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/springconf.xml");

        PersonRepository personRepository = ctx.getBean(PersonRepository.class);
        Pageable pageable = PageRequest.of(1, 2, Sort.by(Sort.Order.asc("name"), Sort.Order.desc("id")));
        List<Person> personList = personRepository.findAll(pageable);
        for (Person person : personList) {
            System.out.println(person);
        }

        ctx.close();
    }
}
