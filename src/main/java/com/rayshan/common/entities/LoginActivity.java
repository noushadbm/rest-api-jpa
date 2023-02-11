package com.rayshan.common.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="login_activity")
public class LoginActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private String status;
}
