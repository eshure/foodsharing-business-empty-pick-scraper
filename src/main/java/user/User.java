package user;

public abstract class User {
    private final String email;
    private final String password;

    User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String email()  {
        return email;
    }

    public String password() {
        return password;
    }

    @Override
    public String toString() {
        return email + " " + password;
    }
}
