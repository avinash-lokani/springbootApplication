package com.springboot.assignment.springapplication.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name =  "users")
public @Data class User {
	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "enabled")
	private int enabled = 1;

	@OneToMany(mappedBy = "user",
			cascade = { CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Authority> authorities;

	public User() {
		
	}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
