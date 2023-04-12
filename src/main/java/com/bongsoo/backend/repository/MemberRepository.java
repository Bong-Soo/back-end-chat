package com.bongsoo.backend.repository;
import com.bongsoo.backend.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import java.util.Optional;
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // MemberId 메소드 추가

    Optional<Member> findByMemberId(String id);
}
