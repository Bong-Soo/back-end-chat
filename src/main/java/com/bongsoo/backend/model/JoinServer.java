package com.bongsoo.backend.model;

import lombok.Data;

import javax.persistence.*;

// lombok 기능
@Data               // Getter Setter 및 여러 기능
// Table 설정
@Entity
@Table(name = "join_server")
public class JoinServer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "server_number", nullable = false)
    private Server serverNumber;

    @ManyToOne
    @JoinColumn(name = "server_member_id", nullable = false)
    private Member serverMemberId;
}