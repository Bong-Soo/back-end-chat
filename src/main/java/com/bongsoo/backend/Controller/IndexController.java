package com.bongsoo.backend.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import com.bongsoo.backend.dto.FriendDTO;
import com.bongsoo.backend.dto.JoinServerDTO;
import com.bongsoo.backend.dto.RoomDTO;
import com.bongsoo.backend.model.Friend;
import com.bongsoo.backend.model.JoinServer;
import com.bongsoo.backend.model.Room;
import com.bongsoo.backend.model.Server;
import com.bongsoo.backend.repository.FriendRepository;
import com.bongsoo.backend.repository.JoinServerRepository;
import com.bongsoo.backend.repository.ServerRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class IndexController {

    private final JoinServerRepository joinServerRepository;
    private final FriendRepository friendRepository;
    private final ServerRepository serverRepository;
    public HttpSession session;
    @GetMapping("/get_servers")
    public List<JoinServerDTO> getServers(HttpServletRequest request) {
        session = request.getSession();
        Long Id = (Long) session.getAttribute("Id");

        List<JoinServer> joinServers;
        try {
            joinServers = joinServerRepository.findByMember_Id(Id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        List<JoinServerDTO> joinServerDTOS = new ArrayList<>();
        for (JoinServer joinServer : joinServers)
            joinServerDTOS.add(new JoinServerDTO(joinServer.getServer().getId(), joinServer.getServer().getName()));

        return joinServerDTOS;
    }

    @GetMapping("/get_friends")
    public List<FriendDTO> getFriends(HttpServletRequest request){
        session = request.getSession();
        Long Id = (Long) session.getAttribute("Id");

        List<Friend> fields;
        try {
            fields = friendRepository.findAllByMember1_Id(Id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


        List<FriendDTO> friendDTOS = new ArrayList<>();

        for(Friend friend : fields)
            friendDTOS.add(new FriendDTO(friend.getMember2().getName()));

        return friendDTOS;
    }

    @Transactional
    @GetMapping("/get_rooms/{serverNumber}")
    public List<RoomDTO> getRooms(@PathVariable String serverNumber){

        Server server = serverRepository.findById(Long.parseLong(serverNumber))
                .orElseThrow(() -> new NoSuchElementException("No server found with id " + serverNumber));

        List<RoomDTO>roomDTOS = new ArrayList<>();
        for (Room room : server.getRooms())
            roomDTOS.add(new RoomDTO(room.getId(),
                    Long.parseLong(serverNumber),
                    room.getName(),
                    room.getType()));

        return roomDTOS;
    }
}
