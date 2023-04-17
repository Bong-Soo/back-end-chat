package com.bongsoo.backend.service;

import com.bongsoo.backend.dto.RoomDTO;
import com.bongsoo.backend.model.Room;
import com.bongsoo.backend.model.Server;
import com.bongsoo.backend.repository.ServerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class ServerService {

    private final ServerRepository serverRepository;

    public List<RoomDTO> getRooms(Long server_id){
        Server server = serverRepository.findById(server_id)                                            // id로 검색하여 Server 가져오기
                .orElseThrow(() -> new NoSuchElementException("No server found with id " + server_id)); // 예외처리

        List<RoomDTO>roomDTOS = new ArrayList<>();                                                      // DTO
        for (Room room : server.getRooms())                                                             // DTO 에 담아서 전송
            roomDTOS.add(new RoomDTO(
                    room.getId(),
                    server_id,
                    room.getName(),
                    room.getType()
                    )
            );

        return roomDTOS;
    }
}
