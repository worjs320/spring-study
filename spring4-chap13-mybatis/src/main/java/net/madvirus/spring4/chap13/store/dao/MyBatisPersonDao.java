package net.madvirus.spring4.chap13.store.dao;

import net.madvirus.spring4.chap13.store.model.Person;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisPersonDao {

	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<Person> findAll() {
		List<Person> person = sqlSession.selectList("net.madvirus.spring4.chap13.store.dao.PersonDao.select_person_all");
		return person;
	}

}
