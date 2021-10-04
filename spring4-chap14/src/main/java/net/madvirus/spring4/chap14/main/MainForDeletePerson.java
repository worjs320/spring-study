package net.madvirus.spring4.chap14.main;

import net.madvirus.spring4.chap14.domain.PersonRepository;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForDeletePerson {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/springconf.xml");

        PersonRepository personRepository = ctx.getBean(PersonRepository.class);
        personRepository.deleteByName("Barak3");
        ctx.close();
    }
}
