package com.clin.springbootdemo.dao;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginLog implements Serializable {
    private int loginLogId;
    private int userId;
    private String ip;
    private Date loginDate;
}
