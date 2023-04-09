package com.bongsoo.backend.model;

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
@Table(name = "server")
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "server_number")
    private Long serverNumber;

    @Column(name = "server_name", nullable = false)
    private String serverName;

    @OneToMany(mappedBy = "server", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Room> rooms;

    @Builder.Default
    @OneToMany(mappedBy = "serverNumber", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<JoinServer> joinServers = new HashSet<>();

}