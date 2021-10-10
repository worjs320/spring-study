package net.madvirus.spring4.chap14.main;

import net.madvirus.spring4.chap14.domain.Person;
import net.madvirus.spring4.chap14.domain.PersonRepository;
import net.madvirus.spring4.chap14.domain.PersonSpec;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class MainForSelectPerson {

    public static void main(String[] args) throws ParseException {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/springconf.xml");

        PersonRepository personRepository = ctx.getBean(PersonRepository.class);
//        Pageable pageable = PageRequest.of(1, 2, Sort.by(Sort.Order.asc("name"), Sort.Order.desc("id")));
        List<Person> personListByName = personRepository.findAll(PersonSpec.nameEq("2"));
        List<Person> personListByBirthdate = personRepository.findAll(PersonSpec.birthdayBtw(getDate("2000-03-01"), getDate("2000-03-20")));
        for (Person person : personListByName) {
            System.out.println(person);
        }

        for (Person person : personListByBirthdate) {
            System.out.println(person);
        }

        ctx.close();
    }

    public static Date getDate(String date) throws ParseException {
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
        return transFormat.parse(date);
    }
}
