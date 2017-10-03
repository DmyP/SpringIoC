package ua.rd;

public class AuthorizedUser {
    private AuthorizedUser() {
    }

    public static Long id = 1L;

    public static Long getId() {
        return id;
    }

    public static void setId(Long id) {
        AuthorizedUser.id = id;
    }
}
