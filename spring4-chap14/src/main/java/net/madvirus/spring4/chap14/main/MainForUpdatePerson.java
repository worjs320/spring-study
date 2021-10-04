package net.madvirus.spring4.chap14.main;

import net.madvirus.spring4.chap14.domain.Person;
import net.madvirus.spring4.chap14.domain.PersonRepository;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainForUpdatePerson {

    public static void main(String[] args) throws ParseException {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/springconf.xml");

        PersonRepository personRepository = ctx.getBean(PersonRepository.class);
        Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse("2000-03-20");
        personRepository.updatePersonsName("ModifyBarak3", "Barak3");
        ctx.close();
    }
}
