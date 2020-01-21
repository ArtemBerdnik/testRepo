package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CaptionsForSectionsInHomePage {
    CONTACT_US("Need to perfect your Webdriver Cucumber skills? BDD also referred to as ‘Behaviour Driven Development’ is a great way to test and simulate different user scenarios, for example what happens if you try to use the following contact us form (Click the button to access the challenge) to simulate user(s) inputting different types of data or how about attempting to simulate a user submitting information to the form using an email address in the incorrect ‘Mandatory’ format?"),
    LOGIN_PORTAL("Are you really an actually user of webdriveruniversity.com? Do you really have a valid username and password? Cucumber enables us to validate multiple sets of username(s) and password(s) with ease by using scenarios outlines and examples! Give the challenge a try!");

    @Getter
    String name;

}
