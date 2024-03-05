package com.example.study4webflux.learn;

/**
 * 설명:
 *
 * @author Aldo / kwon.sy@dreamus.io
 * @since 2024/03/05
 */
public record User(String username, String firstname, String lastname) {

    public static final User SKYLER = new User("swhite", "Skyler", "White");
    public static final User JESSE = new User("jpinkman", "Jesse", "Pinkman");
    public static final User WALTER = new User("wwhite", "Walter", "White");
    public static final User SAUL = new User("sgoodman", "Saul", "Goodman");

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (!username.equals(user.username)) {
            return false;
        }
        if (!firstname.equals(user.firstname)) {
            return false;
        }
        return lastname.equals(user.lastname);

    }

    @Override
    public String toString() {
        return "Person{" + "username='" + username + '\'' + ", firstname='" + firstname + '\'' + ", lastname='" + lastname + '\'' + '}';
    }
}
