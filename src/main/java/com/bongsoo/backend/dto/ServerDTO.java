package com.bongsoo.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ServerDTO {

    private Long server_number;
    private String server_name;
    //private Set<RoomDTO> rooms;
    //private Set<JoinServerDTO> joinServers;

}