package fcantenn.config;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodePassword {
    public static void main(String[] args) {
        String raw_password = "111111";
        String password;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        password = passwordEncoder.encode(raw_password);
        System.out.println(password);
    }
}
