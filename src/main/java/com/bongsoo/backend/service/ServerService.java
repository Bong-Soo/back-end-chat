package com.bongsoo.backend.service;

import com.bongsoo.backend.model.Server;
import com.bongsoo.backend.repository.ServerRepository;
import org.springframework.stereotype.Service;

@Service
public class ServerService {

    private final ServerRepository serverRepository;

    public ServerService(ServerRepository serverRepository){
        this.serverRepository = serverRepository;
    }

    public Server findById(long id){
        return serverRepository.findById(id).orElse(null);
    }
}
