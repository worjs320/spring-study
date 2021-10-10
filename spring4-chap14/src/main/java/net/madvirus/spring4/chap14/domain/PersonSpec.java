package net.madvirus.spring4.chap14.domain;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.*;

public class PersonSpec {

    public static Specification<Person> nameEq(final String name) {
        return (root, query, cb) -> cb.equal(root.get(Person_.name), name);
    }

    public static Specification<Person> birthdayBtw(final Date date, final Date date2) {
        return (root, query, cb) -> cb.between(root.get(Person_.BIRTHDAY), date, date2);
    }

    public static Specification<Person> search(final Map<String, Object> searchParams) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            searchParams.forEach((key, value) -> {
                String likeValue = "%" + value + "%";
                switch (key) {
                    case "name":
                        predicates.add(cb.like(root.get(Person_.name), likeValue));
                        break;
					case "gender":
						predicates.add(cb.like(root.get(Person_.gender), likeValue));
						break;
					case "start_BIRTHDATE":
						predicates.add(cb.greaterThanOrEqualTo(root.get(Person_.BIRTHDAY), (Date) value));
						break;
					case "end_BIRTHDATE":
						predicates.add(cb.lessThanOrEqualTo(root.get(Person_.BIRTHDAY), (Date) value));
						break;
                }
            });
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
