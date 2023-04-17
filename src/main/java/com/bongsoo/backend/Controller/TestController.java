package com.bongsoo.backend.Controller;

import com.bongsoo.backend.dto.RoomDTO;
import com.bongsoo.backend.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class TestController {
    private final RoomService roomService;

    @GetMapping("/test")
    public List<RoomDTO> test(){
        return roomService.findAllRoom();
    }
    @PostMapping("/test")
    public String test_2(){
        return "post test";
    }

}
