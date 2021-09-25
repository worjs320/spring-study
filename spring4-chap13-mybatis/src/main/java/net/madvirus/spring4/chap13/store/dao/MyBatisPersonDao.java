package net.madvirus.spring4.chap13.store.dao;

import net.madvirus.spring4.chap13.store.model.Person;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisPersonDao extends SqlSessionDaoSupport {
    @Autowired
    public void sqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public List<Person> findAll() {
        List<Person> person = getSqlSession().selectList("net.madvirus.spring4.chap13.store.dao.PersonDao.select_person_all");
        return person;
    }
}
