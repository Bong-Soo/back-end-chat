package com.bongsoo.backend.dto;
import com.bongsoo.backend.model.Room;
import com.bongsoo.backend.model.Server;
import com.bongsoo.backend.type.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {

    private Long roomNumber;
    private Long serverNumber;
    private String roomName;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    public Room toEntity(){
        return Room.builder()
                .roomNumber(this.roomNumber)
                .server(Server.builder().serverNumber(this.serverNumber).build())
                .roomName(this.roomName)
                .roomType(this.roomType)
                .build();
    }
}
