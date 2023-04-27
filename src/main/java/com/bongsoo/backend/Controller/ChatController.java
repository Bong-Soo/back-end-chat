package com.bongsoo.backend.Controller;

import com.bongsoo.backend.dto.RoomDTO;
import com.bongsoo.backend.model.Server;
import com.bongsoo.backend.service.RoomService;
import com.bongsoo.backend.service.ServerService;
import lombok.RequiredArgsConstructor;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {
    private final RoomService roomService;

    @PostMapping("/get_rooms")
    public List<RoomDTO> test(){
        return roomService.findAllRoom();
    }

    @PostMapping("/history/{roomId}")
    public List<String> roomDetail(Model model, @PathVariable String roomId){  //@PathVariable("변수명") String roomId 즉, /room/enter/{roomId} 에서 {} 안에있는 값을 가져온다.
        model.addAttribute("roomId",roomId);
        List<String> chatlist = roomService.findRoomChat(Long.valueOf(roomId));
        return chatlist;
    }

}
