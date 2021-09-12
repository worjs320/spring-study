package net.madvirus.spring4.chap13.store.service;

import net.madvirus.spring4.chap13.store.domain.*;
import org.springframework.transaction.annotation.Transactional;

public class PersonCallService {

	private PersonRepository personRepository;
	private CallHistoryRepository callHistoryRepository;

	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	public void setCallHistoryRepository(CallHistoryRepository callHistoryRepository) {
		this.callHistoryRepository = callHistoryRepository;
	}

	@Transactional
	public PersonCallResult call(PersonCallRequest personCallRequest) throws PersonNotFoundException {
		Person person = personRepository.findById(personCallRequest.getId());
		if (person == null)
			throw new PersonNotFoundException(personCallRequest.getId());

		CallHistory callHistory = new CallHistory(person.getId(), personCallRequest.getName());
		callHistoryRepository.save(callHistory);

		return new PersonCallResult(person, callHistory);
	}

}
