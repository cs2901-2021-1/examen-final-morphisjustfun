package cs.lab;

import java.util.Scanner;
import java.util.logging.Logger;

import cs.lab.utils.Reverse;

public class Authentication {
    static final Logger logger = Logger.getLogger(Authentication.class.getName());

    public static Boolean LogIn() {
        String username;
        String password;
        logger.warning("Enter username:");
        Scanner scanner = new Scanner(System.in);
        username = scanner.nextLine();
        logger.warning("Enter password:");
        password = scanner.nextLine();
        scanner.close();
        if (password.equals(Reverse.reverse(username))) {
            logger.warning("Login successful");
            return true;
        }
        logger.warning("Bad login");
        return false;
    }

    public static void LogOut() {
        logger.warning("Exiting application");
        LogIn();
    }

    private Authentication(){
        // default one
    }

}
