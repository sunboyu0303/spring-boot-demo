package com.bj.springboot.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by sunboyu on 2017/8/6.
 */
@Data
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = -3054930106825707933L;

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "user_name")
    private String username;

    @Column
    private String password;
}
