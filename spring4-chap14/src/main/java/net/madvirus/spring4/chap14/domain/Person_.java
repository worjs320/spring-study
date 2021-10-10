package net.madvirus.spring4.chap14.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Person.class)
public class Person_ {
	public static volatile SingularAttribute<Person, Long> id;
	public static volatile SingularAttribute<Person, String> phone;
	public static volatile SingularAttribute<Person, String> name;
	public static volatile SingularAttribute<Person, String> gender;
	public static volatile SingularAttribute<Person, String> email;
	public static volatile SingularAttribute<Person, Team> team;
	public static volatile SingularAttribute<Person, Date> BIRTHDAY;
}
