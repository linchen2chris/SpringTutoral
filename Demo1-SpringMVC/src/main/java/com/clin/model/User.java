package com.clin.model;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private int userId;
    private String userName;
    private String password;
    private int credit;
    private String lastIp;
    private Date lastVisit;
}
