package com.bongsoo.backend.Controller;

import com.bongsoo.backend.dto.RoomDTO;
import com.bongsoo.backend.service.RoomService;
import com.bongsoo.backend.service.ServerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
public class RoomController {
    private final RoomService roomService;
    private final ServerService serverService;

    @GetMapping("/room")        // 처음 채팅 화면(개발필요)
    public String chatRoom(Model model){
        return "";
    }

    @GetMapping("/rooms")       // 어떤 서버의 모든방 출력(개발필요)
    @ResponseBody
    public List<RoomDTO> room() {
        System.out.println(roomService.findAllRoom());  // 확인용 코드
        return roomService.findAllRoom();
    }
    @PostMapping("/room")       // 방 생성
    @ResponseBody
    public RoomDTO createRoom(@RequestParam RoomDTO roomDTO){
        return roomService.createRoom(roomDTO);
    }

    @GetMapping("/room/enter/{roomNumber}")     // 방 입장(개발필요)
    public String roomDetail(Model model,@PathVariable String roomNumber){  //@PathVariable("변수명") String roomId 즉, /room/enter/{roomId} 에서 {} 안에있는 값을 가져온다.
        model.addAttribute("roomId",roomNumber);
        List<String> chatlist = roomService.findRoomChat(Long.parseLong(roomNumber));       // 채팅기록 확인할 수 있도록 하는 메소드로 변경
        return "";
    }

}
