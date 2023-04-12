package com.bongsoo.backend.repository;

import com.bongsoo.backend.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServerRepository extends JpaRepository<Server,Long> {

}
