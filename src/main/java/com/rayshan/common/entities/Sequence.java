package com.rayshan.common.entities;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "my_sequence")
public class Sequence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "seq_name")
    private String sequenceName;

    @Column(name = "next_val")
    private long nextValue;
}
