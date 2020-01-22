package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Users {

    INCORRECT_USERNAME("test user", "qwerty");

    @Getter
    String username;
    @Getter
    String password;
}
