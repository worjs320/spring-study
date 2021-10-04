package net.madvirus.spring4.chap14.main;

import net.madvirus.spring4.chap14.domain.*;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainForSavePerson {

    public static void main(String[] args) throws ParseException {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/springconf.xml");

        PersonRepository personRepository = ctx.getBean(PersonRepository.class);
        Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse("2000-03-20");
        Person person = new Person(null, "Barak3", "123", "123", birthDate);
        personRepository.save(person);
        ctx.close();
    }
}
