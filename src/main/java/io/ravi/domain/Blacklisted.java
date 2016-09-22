package io.ravi.domain;

import javax.persistence.*;

@Entity
public class Blacklisted {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;



}
