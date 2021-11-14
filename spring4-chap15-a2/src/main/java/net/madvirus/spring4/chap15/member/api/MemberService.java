package net.madvirus.spring4.chap15.member.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.madvirus.spring4.chap15.member.domain.Member;
import net.madvirus.spring4.chap15.member.domain.MemberRepository;
import net.madvirus.spring4.chap15.member.exception.MemberNotFoundException;
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
        return memberRepository.findById(id).orElseThrow(() -> {
            throw new MemberNotFoundException(id);
        });
    }

    @ApiOperation(value = "Save member", response = Member.class, responseContainer = "Object")
    @PostMapping("/members")
    public Member insertMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    @ApiOperation(value = "Update member's name, email", response = Member.class, responseContainer = "Object")
    @PutMapping("/members/{id}")
    public Member updateMember(@RequestBody Member member, @PathVariable Long id) {
        return memberRepository.findById(id)
                .map(orgMember -> {
                    orgMember.setName(member.getName());
                    orgMember.setEmail(member.getEmail());
                    return memberRepository.save(orgMember);
                })
                .orElseGet(() -> {
                    throw new MemberNotFoundException(id);
                });
    }

    @ApiOperation(value = "Delete member")
    @DeleteMapping("/members/{id}")
    public Member deleteMember(@PathVariable Long id) {
        return memberRepository.deleteById(id);
    }
}
