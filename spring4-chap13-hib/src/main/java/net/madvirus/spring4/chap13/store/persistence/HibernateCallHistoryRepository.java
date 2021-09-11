package net.madvirus.spring4.chap13.store.persistence;

import net.madvirus.spring4.chap13.store.domain.CallHistory;
import net.madvirus.spring4.chap13.store.domain.CallHistoryRepository;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateCallHistoryRepository implements CallHistoryRepository {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(CallHistory callHistory) {
		sessionFactory.getCurrentSession().save(callHistory);
	}

}
