package utils;

import lombok.Getter;

@Getter
public enum User {
    STANDARD_USER("standard_user", Config.getProperty(Properties.STANDARD_USER_PASSWORD));

    private final String login;
    private final String password;

    User(String login, String password) {
        this.login = login;
        this.password = password;
    }

}
