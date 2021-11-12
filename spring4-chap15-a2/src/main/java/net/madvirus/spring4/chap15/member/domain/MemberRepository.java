package net.madvirus.spring4.chap15.member.domain;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface MemberRepository extends Repository<Member, Long> {
	List<Member> findAll();

	Member findById(Long id);

	Member findByUserId(String userId);

	Member findByEmail(String email);

	Member save(Member m);

}
