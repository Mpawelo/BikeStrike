package bikestrike.util;

import java.util.regex.Pattern;

public class ValidationUtil {
    private static final Pattern EMAIL = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern NIP = Pattern.compile("^[0-9]{10}$");

    public static void requireEmail(String email) {
        if (!EMAIL.matcher(email).matches()) throw new IllegalArgumentException("Invalid email");
    }
    public static void requireNip(String nip) {
        if (!NIP.matcher(nip).matches()) throw new IllegalArgumentException("Invalid NIP");
    }
}