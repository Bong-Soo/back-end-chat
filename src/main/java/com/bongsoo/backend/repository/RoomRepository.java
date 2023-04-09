package com.bongsoo.backend.repository;

import com.bongsoo.backend.model.Room;
import com.bongsoo.backend.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {
    // RoomId 메소드 추가
    List<Room> findByServer(Server server);
}
