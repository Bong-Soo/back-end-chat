package com.bongsoo.backend.service;
import com.bongsoo.backend.dto.MessageDTO;
import com.bongsoo.backend.dto.RoomDTO;
import com.bongsoo.backend.model.Room;
import com.bongsoo.backend.model.Server;
import com.bongsoo.backend.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    @Transactional
    public List<RoomDTO> findAllRoom(){         // 1. ServerDTO 를 사용하여 순환참조 발생 방지 구현    2. DB 연관관계로 생성된 list<Room> 사용
        // Select * from room  -> (we will change) Select * from room where serverNumber = ""
        List<Room> rooms = new ArrayList<>(roomRepository.findByServer(Server.builder().serverNumber(1L).build()));
        List<RoomDTO> roomDTOS = new ArrayList<>();

        for(Room room : rooms){
            roomDTOS.add(RoomDTO.builder()
                    .roomNumber(room.getRoomNumber())
                    .serverNumber(room.getServer().getServerNumber())
                    .roomName(room.getRoomName())
                    .roomType(room.getRoomType())
                    .build());
        }

        return roomDTOS;
    }
    public RoomDTO createRoom(RoomDTO roomDTO) {    // 방 생성 함수, 생성시 채팅 txt 도 같이 생성
        roomRepository.save(roomDTO.toEntity());
        try{
            File file = new File("../txt/"+roomDTO.getServerNumber()+"_"+roomDTO.getRoomNumber()+".txt");
            if(!file.exists()){
                file.createNewFile();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return new RoomDTO();
    }

    public List<String> findRoomChat(Long roomNumber){
        Optional<Room> rooms = roomRepository.findById(roomNumber);
        Room room;
        if(rooms.isPresent()) {
            room = rooms.get();
            File roomChat = new File("../txt/" + room.getServer().getServerNumber() + "_" + room.getRoomNumber() + ".txt");

            List<MessageDTO> messageList = new ArrayList<>();
            try {
                if (roomChat.exists()) {
                    BufferedReader br = new BufferedReader(new FileReader(roomChat));
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] tokens = line.split(":", 2);
                        messageList.add(new MessageDTO());
                    }
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            int start = Math.max(messageList.size() - 20, 0);
            int end = messageList.size();

            for (int i = start; i < end; i++) {
                //System.out.println(memberList.get(i)+" : "+messageList.get(i));
                System.out.println("20개 출력 : " + messageList.get(i));
            }
        }
        return new ArrayList<>();
    }

}
