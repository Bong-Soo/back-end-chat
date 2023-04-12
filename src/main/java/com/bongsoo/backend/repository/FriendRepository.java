package com.bongsoo.backend.repository;

import com.bongsoo.backend.model.Friend;
import com.bongsoo.backend.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Long> {
    List<Friend> findAllByMember1_Id(Long Id);

}
