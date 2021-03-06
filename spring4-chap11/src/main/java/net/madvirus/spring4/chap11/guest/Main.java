package net.madvirus.spring4.chap11.guest;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
//		useJdbc();
//		useJdbcTemplate();
//		useJdbcTemplate2();
//		useNamedJdbcTemplate();
		useSimpleInsert();
	}

	private static void useJdbcTemplate() {
		String configLocation = "classpath:applicationContext.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(
				configLocation);

//		MessageDao messageDao = ctx.getBean("jdbcTemplateMessageDao", MessageDao.class);
//		runMessageDao(messageDao);
		PersonDao personDao = ctx.getBean("jdbcTemplatePersonDao", PersonDao.class);
		runPersonDao(personDao);
		ctx.close();
	}

	
	private static void useJdbcTemplate2() {
		String configLocation = "classpath:applicationContext.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(
				configLocation);

		PersonDao personDao = ctx.getBean("jdbcTemplatePersonDao2", PersonDao.class);
		runPersonDao(personDao);
		ctx.close();
	}
	
	private static void useNamedJdbcTemplate() {
		String configLocation = "classpath:applicationContext.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(
				configLocation);

//		MessageDao messageDao = ctx.getBean("namedTemlateDao", MessageDao.class);
//		runMessageDao(messageDao);
		PersonDao personDao = ctx.getBean("namedTemplatePersonDao", PersonDao.class);
		runPersonDao(personDao);
		ctx.close();
		ctx.close();
	}

	private static void useJdbc() {
		String configLocation = "classpath:applicationContext.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);

//		MessageDao messageDao = ctx.getBean("jdbcMessageDao", MessageDao.class);
//		runMessageDao(messageDao);
		PersonDao personDao = ctx.getBean("jdbcPersonDao", PersonDao.class);
		runPersonDao(personDao);
		ctx.close();
	}

	private static void useSimpleInsert() {
		String configLocation = "classpath:applicationContext.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(
				configLocation);

//		MessageDao messageDao = ctx.getBean("simpleInsertMessageDao", MessageDao.class);
//		runMessageDao(messageDao);
		PersonDao personDao = ctx.getBean("simpleInsertPersonDao", PersonDao.class);
		runPersonDao(personDao);
		ctx.close();
	}

	private static void runMessageDao(MessageDao messageDao) {
		Message message = new Message();
		message.setMessage("?????????");
		message.setCreationTime(new Date());
		message.setName("Barak");
		int id = messageDao.insert(message);
		System.out.printf("Message[%d]??? ?????????????????????.\n", id);

		int count = messageDao.counts();
		System.out.printf("?????? ??????: %d\n", count);
		List<Message> messages = messageDao.select(0, 10);
		System.out.printf("????????? ????????? ??????: %d\n", messages.size());
	}

	private static void runPersonDao(PersonDao personDao) {
		Person person = new Person();
		person.setName("useSimpleInsert");
		person.setGender("w");
		person.setAge(22);
		person.setBirth(new Date());
		int id = personDao.insert(person);
		System.out.printf("Person[%d]??? ?????????????????????.\n", id);

		int count = personDao.counts();
		System.out.printf("?????? ??????: %d\n", count);
		List<Person> persons = personDao.select(0, 10);
		System.out.printf("????????? ????????? ??????: %d\n", persons.size());

		for (Person p : persons) {
			System.out.println(p.getNum()+" || "+p.getName());
		}
	}

}
