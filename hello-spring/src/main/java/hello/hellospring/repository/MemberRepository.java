package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원을 저장하고, 저장한 회원 반환
    Optional<Member> findById(Long id); // ID로 회원을 찾고 Optional 반환(없으면 Null을 반환하는 경우)
    Optional<Member> findByName(String name); //
    List<Member> findAll();
}
