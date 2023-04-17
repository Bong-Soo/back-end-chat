package com.bongsoo.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@RequiredArgsConstructor
@Service
public class MessageService {

    public void appendToChatLogFile(){//(String roomId, Message message)

        // 1. 프론트에서 Vue(Message) 구조에 추가하여 room 의 ID를 받아올 수 있도록 해야함
//        List<Room> rooms = roomRepository.findByRoomId(roomId); // roomId (방이름) 으로 id값 가져오기


        // 2. 프라이머리키로 검색하게 할 예정임으로 Optional 자료 구조로 받아 와서 가공할 수 있도록 해야함
//        List<Long> roomnumber = new ArrayList<>();
//        for(Room room : rooms){
//            System.out.println(room.getRoom_number()+"\n"+ room.getRoomId()+"\n"+room.getType());
//            roomnumber = Collections.singletonList(room.getRoom_number());
//        }


        try{
            // 3. 파일 읽어와서 list 로 만들기


            // 4. list 에 massage 추가
//            list.add(message.getSender()+":"+message.getMessage());       //새로운 메세지 추가

            File file = new File("../txt/"+"serverNumber"+"_"+"roomNumber"+".txt");     // 서버 넘버와 룸 넘버 같이 들어와야함
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    // ******  Vue(Message)에는 serverNumber(PK)와 roomNumber(PK)가 들어간 누가 적었고 어떤내용인지의 class 를 생성하여 규격을 맞춰야 한다  ******
}
