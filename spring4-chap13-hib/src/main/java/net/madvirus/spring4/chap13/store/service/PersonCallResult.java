package net.madvirus.spring4.chap13.store.service;

import net.madvirus.spring4.chap13.store.domain.CallHistory;
import net.madvirus.spring4.chap13.store.domain.Person;

public class PersonCallResult {
	private Person person;
	private CallHistory callHistory;

	public PersonCallResult(Person person, CallHistory callHistory) {
		this.person = person;
		this.callHistory = callHistory;
	}

	public Person getPerson() {
		return person;
	}

	public CallHistory getCallHistory() {
		return callHistory;
	}

}
