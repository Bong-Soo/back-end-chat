package com.bongsoo.backend.repository;

import com.bongsoo.backend.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Server,Long> {
}
