package com.bongsoo.backend.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bongsoo.backend.dto.JoinServerDTO;
import com.bongsoo.backend.model.JoinServer;
import com.bongsoo.backend.repository.JoinServerRepository;
import com.bongsoo.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class IndexController {

    private final JoinServerRepository joinServerRepository;

    private final MemberRepository memberRepository;

    @GetMapping("/get_servers")
    public List<JoinServerDTO> getServers(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long Id = (Long) session.getAttribute("Id");

        List<JoinServer> joinServers = joinServerRepository.findByServerMemberId_Id(1L);

        List<JoinServerDTO> joinServerDTOS = new ArrayList<>();
        for (JoinServer joinServer : joinServers) {
            System.out.println("Server Number: " + joinServer.getServerNumber().getServerNumber());
            System.out.println("Server Name: " + joinServer.getServerNumber().getServerName());
            joinServerDTOS.add(new JoinServerDTO(joinServer.getServerNumber().getServerNumber(), joinServer.getServerNumber().getServerName()));
        }
        return joinServerDTOS;
    }

//    @GetMapping("/get_friends")
//    public List<> getFriends(){
//
//    }
}
