package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member= new Member("jackson",30);

        //when
        Member savedMember = memberRepository.save(member);

        //then
        assertThat(member).isEqualTo(savedMember);
    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("joy", 10);
        Member member2 = new Member("sad", 10);
        //when
        memberRepository.save(member1);
        memberRepository.save(member2);
        //then
        List<Member> list = memberRepository.findAll();

        assertThat(list.size()).isEqualTo(2);
    }

}