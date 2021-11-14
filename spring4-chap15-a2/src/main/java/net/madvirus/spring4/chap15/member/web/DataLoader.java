package net.madvirus.spring4.chap15.member.web;

import net.madvirus.spring4.chap15.member.exception.MemberNotFoundException;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import net.madvirus.spring4.chap15.member.domain.Member;
import net.madvirus.spring4.chap15.member.domain.MemberRepository;

public class DataLoader {

	@Autowired
	private MemberRepository memberRepository;

	@Transactional
	public Member loadMember(Long memberId) {
		Member member = memberRepository.findById(memberId).orElseThrow(() -> {
			throw new MemberNotFoundException(memberId);
		});
		if (member == null)
			return null;
		Hibernate.initialize(member.getLocker());
		return member;
	}
}
