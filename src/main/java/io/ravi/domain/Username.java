package io.ravi.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
public class Username {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min = 6, max = 100)
    @Column(unique = true, nullable = false, length = 100)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
