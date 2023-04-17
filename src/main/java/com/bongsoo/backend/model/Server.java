package com.bongsoo.backend.model;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


// lombok
@Getter
@Setter
@Builder
@NoArgsConstructor  // 기본생성자
@AllArgsConstructor // 전채생성자
// JPA Table
@Entity
@Table(name = "server")
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "server", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Room> rooms;

    @Builder.Default
    @OneToMany(mappedBy = "server", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<JoinServer> joinServers = new HashSet<>();

}