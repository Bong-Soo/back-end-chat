package com.bongsoo.backend.model;

import com.bongsoo.backend.type.RoomType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// lombok 기능
@Getter
@Setter // Getter Setter 및 여러 기능
@Builder
@NoArgsConstructor
@AllArgsConstructor
// Table 설정
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "server_id", nullable = false)
    private Server server;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomType type;

    @Builder.Default
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<JoinRoom> joinRooms = new HashSet<>();

}
