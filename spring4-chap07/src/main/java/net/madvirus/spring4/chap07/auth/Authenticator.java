package net.madvirus.spring4.chap07.auth;

import net.madvirus.spring4.chap07.member.MemberInfo;
import net.madvirus.spring4.chap07.member.MemberService;

public class Authenticator {

	private MemberService memberService;

	public Authenticator(MemberService memberService) {
		this.memberService = memberService;
	}

	public Auth authenticate(String email, String password, String name) {
		MemberInfo mi = memberService.getMemberInfoByEmail(email);
		if (mi == null)
			throw new AuthenticationException();
		if (!mi.matchPassword(password))
			throw new AuthenticationException();
		if (!mi.matchName(name))
			throw new AuthenticationException();

		return new Auth(mi.getId(), mi.getName());
	}
}
