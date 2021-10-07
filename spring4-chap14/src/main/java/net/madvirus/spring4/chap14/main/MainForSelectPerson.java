package net.madvirus.spring4.chap14.main;

import net.madvirus.spring4.chap14.domain.Person;
import net.madvirus.spring4.chap14.domain.PersonRepository;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.domain.Sort;

import java.text.ParseException;
import java.util.List;


public class MainForSelectPerson {

    public static void main(String[] args) throws ParseException {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/springconf.xml");

        PersonRepository personRepository = ctx.getBean(PersonRepository.class);
        List<Person> personList = personRepository.findAll(Sort.by(Sort.Order.asc("name"), Sort.Order.desc("id")));
        for (Person person:personList) {
            System.out.println(person);
        }

        ctx.close();
    }
}
