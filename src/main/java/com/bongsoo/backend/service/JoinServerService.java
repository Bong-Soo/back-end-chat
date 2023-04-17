package com.bongsoo.backend.service;

import com.bongsoo.backend.dto.JoinServerDTO;
import com.bongsoo.backend.model.JoinServer;
import com.bongsoo.backend.repository.JoinServerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class JoinServerService {
    private final JoinServerRepository joinServerRepository;

    public List<JoinServerDTO> getServers(Long id){
        List<JoinServer> joinServers = joinServerRepository.findByMember_Id(id);                                        // id를 통해 JoinServer 검색
        if(joinServers.isEmpty()) throw new NoSuchElementException("No JoinServer found with Member_id :" + id);        // 예외처리

        List<JoinServerDTO> joinServerDTOS = new ArrayList<>();                                                         // DTO
        for (JoinServer joinServer : joinServers)                                                                       // DTO 에 담아서 전송
            joinServerDTOS.add(new JoinServerDTO(
                    joinServer.getServer().getId(),
                    joinServer.getServer().getName()
                    )
            );

        return joinServerDTOS;
    }
}
