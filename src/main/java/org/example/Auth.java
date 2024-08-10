package org.example;

import java.util.Scanner;

public class Auth {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    public static boolean authenticate(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Usuário: ");
        String username = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            System.out.println("Login bem-sucedido!");
            return true;
        } else {
            System.out.println("Falha na autenticação.");
            return false;
        }
    }
}
