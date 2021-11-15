package net.madvirus.spring4.chap15.member.application;

public interface ChangePasswordService {
	void changePassword(ChangePasswordRequest req);
	void changePassword(Long memberId, NewChangePasswordRequest req);
}
