package com.gogo.powerrangers.presenter;

import com.gogo.powerrangers.entity.User;
import lombok.Data;

@Data
public class UserPresenter {

    private String name;
    private String email;
    private int age;
    private String personality;
    private String ranger;

    public static UserPresenter mapToUserModel(User user) {

        var userModel = new UserPresenter();
        userModel.name = user.getName();
        userModel.email = user.getEmail();
        userModel.age = user.getAge();
        userModel.personality = user.getPersonality().getPersonality();
        userModel.ranger = user.getRanger();

        return userModel;
    }

    public static User mapToUser(UserPresenter userPresenter) {
        //@formatter:off
        return User.builder().name(userPresenter.getName())
                             .age(userPresenter.getAge())
                             .email(userPresenter.getEmail())
                             .personality(userPresenter.getPersonality())
                             .build();
        //@formatter:on
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", personality='" + personality + '\'' +
                ", ranger='" + ranger + '\'' +
                '}';
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
