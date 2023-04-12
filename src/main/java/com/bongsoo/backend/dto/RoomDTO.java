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

    private Long id;
    private Long serverId;
    private String name;
    @Enumerated(EnumType.STRING)
    private RoomType type;

    public Room toEntity(){
        return Room.builder()
                .id(this.id)
                .server(Server.builder().id(this.serverId).build())
                .name(this.name)
                .type(this.type)
                .build();
    }
}
