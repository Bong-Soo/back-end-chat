package com.bongsoo.backend.model;

import com.bongsoo.backend.type.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// lombok 기능
@Data               // Getter Setter 및 여러 기능
@Builder
@NoArgsConstructor
@AllArgsConstructor
// Table 설정
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_number")
    private Long roomNumber;

    @ManyToOne
    @JoinColumn(name = "server_number", nullable = false)
    private Server server;

    @Column(name = "room_name", nullable = false)
    private String roomName;

    @Column(name = "room_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @Builder.Default
    @OneToMany(mappedBy = "roomNumber", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<JoinRoom> joinRooms = new HashSet<>();

}
