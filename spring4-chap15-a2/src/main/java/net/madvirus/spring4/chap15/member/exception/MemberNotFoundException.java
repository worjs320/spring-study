package net.madvirus.spring4.chap15.member.exception;

public class MemberNotFoundException extends RuntimeException{
    public MemberNotFoundException(Long id) {
        super("Could not find member. member id:" + id);
    }
}
