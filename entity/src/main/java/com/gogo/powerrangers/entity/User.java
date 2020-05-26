package com.gogo.powerrangers.entity;

public class User {

    private final String name;
    private final String email;
    private final int age;
    private final Personality personality;
    private final String ranger;

    User(String name, String email, int age, Personality personality, String ranger) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.personality = personality;
        this.ranger = ranger;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public String getRanger() {
        return ranger;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public int getAge() {
        return age;
    }
    public Personality getPersonality() {
        return personality;
    }
}
