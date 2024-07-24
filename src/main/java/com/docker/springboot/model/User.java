package com.docker.springboot.model;

import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
	private String userId;
	private String name;
    private String phone;
    private String email;

}
