package com.springboot.assignment.springapplication.entity;

import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public @Data class Authority {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "authority")
	private String role = "ROLE_USER";
	public Authority() {
		
	}

	@ManyToOne(cascade = {CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "username")
	private User user;


	public Authority(User user, String role) {
		this.user = user;
		this.role = role;
	}
}
