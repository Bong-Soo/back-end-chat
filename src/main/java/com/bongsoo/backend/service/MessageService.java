package com.bongsoo.backend.service;

import com.bongsoo.backend.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MessageService {

    public void appendToChatLogFile(Long roomId, MessageDTO message){

        // 1. 프론트에서 Vue(Message) 구조에 추가하여 room 의 ID를 받아올 수 있도록 해야함 (해결 파라미터로 받아옴)

        // 2. 프라이머리키로 검색하게 할 예정임으로 Optional 자료 구조로 받아 와서 가공할 수 있도록 해야함 (받아왔기 때문에 필요없음)
        List<String> chatHistory;
        try{
            // 3. 파일 읽어와서 list 로 만들기
            chatHistory = Files.readAllLines(Paths.get("./src/main/java/com/bongsoo/backend/text/test.txt"), StandardCharsets.UTF_8);

            if(chatHistory.isEmpty()) chatHistory = new ArrayList<>();

            // 4. list 에 massage 추가
            chatHistory.add(message.getDateTime()+":"+message.getUser_id()+":"+message.getContent());       //새로운 메세지 추가

            Files.write(Paths.get("./src/main/java/com/bongsoo/backend/text/"+"serverNumber"+"_"+"roomNumber"+".txt"),
                    chatHistory, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        }catch (NoSuchFileException e){            // 예외 처리 되는지 확인해야함
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    // ******  Vue(Message)에는 serverNumber(PK)와 roomNumber(PK)가 들어간 경우가 적었고 어떤내용인지의 class 를 생성하여 규격을 맞춰야 한다  ******
}
