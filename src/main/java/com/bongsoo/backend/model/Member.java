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
@Builder            // MemberDTO 에서 사용
@NoArgsConstructor  // 기본생성자
@AllArgsConstructor // 전채생성자
// Table 설정
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "pw")
    private String pw;

    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<JoinServer> joinServers = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<JoinRoom> joinRooms = new HashSet<>();


    @OneToMany(mappedBy = "member1", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Friend> member1;

    @OneToMany(mappedBy = "member2", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Friend> member2;

}
