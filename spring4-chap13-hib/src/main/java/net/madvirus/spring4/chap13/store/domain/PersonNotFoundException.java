package net.madvirus.spring4.chap13.store.domain;

public class PersonNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Integer id;

	public PersonNotFoundException(Integer id) {
		super("not found person: id=" + id);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

}
