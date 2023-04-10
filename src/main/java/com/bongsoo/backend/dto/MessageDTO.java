package com.bongsoo.backend.dto;

import com.bongsoo.backend.type.ContentType;
import lombok.Data;

import java.time.LocalDateTime;

@Data               // Getter Setter 및 여러 기능

public class MessageDTO {
    private String avatar;
    private String user_name;
    private LocalDateTime cur_data;
    private ContentType content_type;
    private String content;

}
