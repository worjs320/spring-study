package net.madvirus.spring4.chap13.store.model;

import org.apache.ibatis.type.Alias;

@Alias("Person")
public class Person {
	private String name;

	private String phoneNumber;

	private Integer age;

	private String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Person() {
	}

	public Person(String name, String phoneNumber, Integer age, String gender) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", age=" + age +
				", gender='" + gender + '\'' +
				'}';
	}
}
