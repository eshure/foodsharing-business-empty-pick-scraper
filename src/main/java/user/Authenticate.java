package user;

public abstract class Authenticate {
    private final String email;
    private final String password;

    Authenticate(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String email()  {
        return email;
    }

    public String password() {
        return password;
    }
}
