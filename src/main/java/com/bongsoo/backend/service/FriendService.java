package com.bongsoo.backend.service;

import com.bongsoo.backend.dto.FriendDTO;
import com.bongsoo.backend.model.Friend;
import com.bongsoo.backend.repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class FriendService {
    private final FriendRepository friendRepository;

    public List<FriendDTO> getFriends(Long id){
        List<Friend> friends = friendRepository.findAllByMember1_Id(id);                                    // 사용자의 친구들 검색
        if(friends.isEmpty()) throw new NoSuchElementException("No friend found with member1 id " + id);    // 예외처리


        List<FriendDTO> friendDTOS = new ArrayList<>();                                                     // DTO List
        for(Friend friend : friends)                                                                        // DTO 에 담아서 전송
            friendDTOS.add(new FriendDTO(
                    friend.getMember2().getName()
                    )
            );

        return friendDTOS;
    }
}
