package com.bongsoo.backend.repository;
import com.bongsoo.backend.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // MemberId 메소드 추가
    Optional<Member> findByMemberId(String id);
}
