package com.gogo.powerrangers.entity;

public final class UserBuilder {

    private String name;
    private String email;
    private int age;
    private Personality personality;
    private String ranger;

    UserBuilder() {
    }

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder age(int age) {
        this.age = age;
        return this;
    }

    public UserBuilder personality(String personality) {
        this.personality = Personality.of(personality);
        this.ranger = this.discoverRanger(this.personality);
        return this;
    }

    public User build() {
        return new User(this.name, this.email, this.age, this.personality, this.ranger);
    }

    private String discoverRanger(Personality personality) {
        switch (personality) {
            case LIDERANCA:
                return "Vermelho";

            case ENTUSIASMO:
                return "Preto";

            case TRANQUILIDADE:
                return "Amarelo";

            case INTELIGENCIA:
                return "Azul";

            case RIQUEZA:
                return "Rosa";

            case PERSISTENCIA:
                return "Verde";

            case FORCA:
                return "Branco";

            default:
                return "";
        }
    }
}
