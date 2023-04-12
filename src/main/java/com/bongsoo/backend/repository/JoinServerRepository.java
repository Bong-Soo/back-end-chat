package com.bongsoo.backend.repository;

import com.bongsoo.backend.model.JoinServer;
import com.bongsoo.backend.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoinServerRepository extends JpaRepository<JoinServer, Long> {
    List<JoinServer> findByServerMemberId_Id(Long memberId);
}
