package com.bongsoo.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor  // 기본생성자
@AllArgsConstructor // 전채생성자
@Table(name = "friends")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member1_id", nullable = false)
    private Member member1;

    @ManyToOne
    @JoinColumn(name = "member2_id", nullable = false)
    private Member member2;

}