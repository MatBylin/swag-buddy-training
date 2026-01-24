package utils;

import lombok.Getter;

@Getter
public enum User {
    STANDARD_USER("standard_user", Config.getProperty(Properties.GENERIC_USER_PASSWORD)),
    DO_NOT_EXIST_USER("do_not_exist", Config.getProperty(Properties.GENERIC_USER_PASSWORD));

    private final String login;
    private final String password;

    User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
