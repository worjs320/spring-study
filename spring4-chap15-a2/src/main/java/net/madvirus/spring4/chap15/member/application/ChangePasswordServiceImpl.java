package net.madvirus.spring4.chap15.member.application;

import net.madvirus.spring4.chap15.member.domain.Member;
import net.madvirus.spring4.chap15.member.domain.MemberRepository;

import net.madvirus.spring4.chap15.member.exception.MemberNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ChangePasswordServiceImpl implements ChangePasswordService {

	@Autowired
	private MemberRepository memberRepository;

	@Transactional
	@Override
	public void changePassword(ChangePasswordRequest req) {
		Member member = memberRepository.findById(req.getMemberId()).orElseThrow(() -> {
			throw new MemberNotFoundException(req.getMemberId());
		});
		member.changePassword(req.getCurrentPassword(), req.getNewPassword());
	}

	public void changePassword(Long memberId, NewChangePasswordRequest req) {
		Member member = memberRepository.findById(memberId).orElseThrow(() -> {
			throw new MemberNotFoundException(memberId);
		});
		member.changePassword(req.getCurrentPassword(), req.getNewPassword());
		memberRepository.save(member);
	}
}
