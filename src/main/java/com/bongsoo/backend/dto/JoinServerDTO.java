package com.bongsoo.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JoinServerDTO {
    private Long serverNumber;
    private String serverName;

    public JoinServerDTO(Long serverNumber, String serverName) {
        this.serverNumber = serverNumber;
        this.serverName = serverName;
    }

    // Getters and setters
}