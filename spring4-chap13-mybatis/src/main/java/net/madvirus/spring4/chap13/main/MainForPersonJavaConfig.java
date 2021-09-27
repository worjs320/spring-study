package net.madvirus.spring4.chap13.main;

import net.madvirus.spring4.chap13.store.model.Person;
import net.madvirus.spring4.chap13.store.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainForPersonJavaConfig {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PersonJavaConfig.class);

		PersonService personService = ctx.getBean(PersonService.class);

		Person personInfo = new Person();
		personInfo.setName("test1");
		personInfo.setAge(123);
		personInfo.setGender("man");
		personService.insertPerson(personInfo);

		List<Person> personList =  personService.getPersonListAll();

		for (Person person:personList) {
			System.out.println(person.toString());
		}

		ctx.close();
	}

}
