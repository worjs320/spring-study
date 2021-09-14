package net.madvirus.spring4.chap13.main;

import net.madvirus.spring4.chap13.store.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainByJavaConfigAnnotationMappingPerson {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfigAnnotationMappingPerson.class);

		PersonCallService personCallService = ctx.getBean(PersonCallService.class);
		PersonCallRequest personCallRequest = new PersonCallRequest();
		personCallRequest.setId(1);
		personCallRequest.setName("jgkim");

		PersonCallResult personCallResult = personCallService.call(personCallRequest);
		System.out.println(personCallResult.getPerson());

		ctx.close();
	}

}
