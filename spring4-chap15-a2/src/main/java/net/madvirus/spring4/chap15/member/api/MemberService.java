package net.madvirus.spring4.chap15.member.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.madvirus.spring4.chap15.member.domain.Member;
import net.madvirus.spring4.chap15.member.domain.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Member")
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @ApiOperation(value = "Get all member list", response = Member.class, responseContainer = "List")
    @GetMapping("/members")
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @ApiOperation(value = "Get member object by member id", response = Member.class, responseContainer = "Object")
    @GetMapping("/members/{id}")
    public Member findMember(@PathVariable Long id) {
        return memberRepository.findById(id);
    }
}
