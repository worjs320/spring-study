package net.madvirus.spring4.chap11.guest;

import java.util.List;

public interface PersonDao {

	List<Person> select(int start, int size);

	public int counts();
	
	public int insert(Person person);
	
	public int delete(int id);
}
