package net.madvirus.spring4.chap14.domain;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;

public class PersonSpec {

	public static Specification<Person> nameEq(final String name) {
		return new Specification<Person>() {
			@Override
			public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get(Person_.name), name);
			}
		};
	}

	public static Specification<Person> birthdayBtw(final Date date, final Date date2) {
		return new Specification<Person>() {
			@Override
			public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.between(root.get(Person_.BIRTHDAY), date, date2);
			}
		};
	}
}
