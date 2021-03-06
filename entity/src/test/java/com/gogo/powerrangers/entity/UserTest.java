package com.gogo.powerrangers.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.gogo.powerrangers.entity.Personality;
import com.gogo.powerrangers.entity.User;


public class UserTest {

    @Test
    void testCreateUserSuccess() {
        var user = User.builder().name("Guilherme").age(19).email("guilherme.garcia@gmail.com").personality("Inteligência").build();

        assertEquals("Guilherme", user.getName());
        assertEquals(Personality.INTELIGENCIA, user.getPersonality());

    }

}
