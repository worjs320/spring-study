package net.madvirus.spring4.chap13.store.domain;


public interface PersonRepository {

	Person findById(Integer id);

}
