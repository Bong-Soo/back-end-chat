package com.bongsoo.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "follow")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "following", nullable = false)
    private Member follower;

    @ManyToOne
    @JoinColumn(name = "followers", nullable = false)
    private Member followee;

}