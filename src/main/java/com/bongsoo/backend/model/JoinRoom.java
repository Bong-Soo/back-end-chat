package com.bongsoo.backend.model;

import lombok.Data;

import javax.persistence.*;

// lombok 기능
@Data               // Getter Setter 및 여러 기능
// Table 설정
@Entity
@Table(name = "join_room")
public class JoinRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_number", nullable = false)
    private Room roomNumber;

    @ManyToOne
    @JoinColumn(name = "room_member_id", nullable = false)
    private Member roomMemberId;

}