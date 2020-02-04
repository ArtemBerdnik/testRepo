package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Users {

    INCORRECT_USER("test user", "qwerty", "Lol", "Tvar", "aaa"),
    CORRECT_USER("correct user", "test1!", "Ty", "Kto", "test@test.com");

    @Getter
    String username;
    @Getter
    String password;
    @Getter
    String firstName;
    @Getter
    String lastName;
    @Getter
    String email;
}
