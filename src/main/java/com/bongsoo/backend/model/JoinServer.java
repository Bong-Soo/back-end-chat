package com.bongsoo.backend.model;

import lombok.*;

import javax.persistence.*;

// lombok
@Getter
@Setter
@NoArgsConstructor  // 기본생성자
@AllArgsConstructor // 전채생성자
// JPA Table
@Entity
@Table(name = "join_server")
public class JoinServer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "server_id", nullable = false)
    private Server server;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
}