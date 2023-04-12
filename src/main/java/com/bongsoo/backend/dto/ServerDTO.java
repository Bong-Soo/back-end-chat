package com.bongsoo.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ServerDTO {

    private Long id;
    private String name;
    private Set<RoomDTO> rooms;
    //private Set<JoinServerDTO> joinServers;
}