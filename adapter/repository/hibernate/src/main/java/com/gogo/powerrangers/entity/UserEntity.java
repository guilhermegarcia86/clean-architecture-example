package com.gogo.powerrangers.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserEntity {
	
	@Id
	private String id;
    private String name;
    private String email;
    private int age;
    private String personality;
    private String ranger;
    
    public static User toUser(UserEntity entity) {
        var user = User.builder().name(entity.getName()).age(entity.getAge())
                .email(entity.getEmail()).personality(entity.getPersonality()).build();

        return user;
    }
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPersonality() {
		return personality;
	}
	public void setPersonality(String personality) {
		this.personality = personality;
	}
	public String getRanger() {
		return ranger;
	}
	public void setRanger(String ranger) {
		this.ranger = ranger;
	}

}
