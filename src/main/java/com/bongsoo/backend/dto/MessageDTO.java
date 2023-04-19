package com.bongsoo.backend.dto;

import com.bongsoo.backend.type.ContentType;
import com.bongsoo.backend.type.MessageType;
import lombok.Data;

import java.time.LocalDateTime;

@Data               // Getter Setter 및 여러 기능

public class MessageDTO {
    private Long room_id;
    private String avatar;
    private String user_id;
    private LocalDateTime dateTime;
    private ContentType content_type;
    private MessageType message_type;
    private String content;

}
