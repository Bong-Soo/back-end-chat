package com.bongsoo.backend.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bongsoo.backend.dto.FriendDTO;
import com.bongsoo.backend.dto.JoinServerDTO;
import com.bongsoo.backend.dto.RoomDTO;

import com.bongsoo.backend.service.FriendService;
import com.bongsoo.backend.service.JoinServerService;
import com.bongsoo.backend.service.ServerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class MainController {

    // Service
    private final ServerService serverService;
    private final FriendService friendService;
    private final JoinServerService joinServerService;
    public HttpSession session;
    @GetMapping("/get_servers")
    public List<JoinServerDTO> getServers(HttpServletRequest request) {
        session = request.getSession();
        return joinServerService.getServers((Long) session.getAttribute("Id"));
    }

    @GetMapping("/get_friends")
    public List<FriendDTO> getFriends(HttpServletRequest request){
        session = request.getSession();
        return friendService.getFriends((Long) session.getAttribute("Id"));
    }

    @GetMapping("/get_rooms/{server_id}")
    public List<RoomDTO> getRooms(@PathVariable String server_id){
        return serverService.getRooms(Long.parseLong(server_id));
    }
}
