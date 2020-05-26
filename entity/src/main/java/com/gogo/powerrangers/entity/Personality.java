package com.gogo.powerrangers.entity;

import java.util.Arrays;

public enum Personality {

    LIDERANCA("Liderança"), ENTUSIASMO("Entusiasmo"), TRANQUILIDADE("Tranquilidade"), INTELIGENCIA("Inteligência"),
    RIQUEZA("Riqueza"), PERSISTENCIA("Persistência"), FORCA("Força");

    private String personality;

    Personality(String personality) {
        this.personality = personality;
    }

    public static Personality of(String value) {

        return Arrays.stream(values()).filter(type -> type.personality.equalsIgnoreCase(value)).findFirst().get();
    }

    public String getPersonality() {
        return personality;
    }
}
