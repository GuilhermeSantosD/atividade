package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContentManager cms = new ContentManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            switch (mainMenu(scanner)) {
                case 1:
                    if (Auth.authenticate(scanner)) {
                        boolean loggedIn = true;
                        while (loggedIn) {
                            switch (authenticatedMenu(scanner)) {
                                case 1:
                                    cms.createContent(scanner);
                                    break;
                                case 2:
                                    cms.listContents(false);
                                    break;
                                case 3:
                                    cms.updateContent(scanner);
                                    break;
                                case 4:
                                    cms.deleteContent(scanner);
                                    break;
                                case 5:
                                    System.out.println("Logout realizado com sucesso.");
                                    loggedIn = false;
                                    break;
                                default:
                                    System.out.println("Opção inválida.");
                            }
                        }
                    } else {
                        System.out.println("Usuário ou senha incorretos.");
                    }
                    break;
                case 2:
                    cms.listContents(true);
                    break;
                case 3:
                    System.out.println("Saindo do sistema.");
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    private static int mainMenu(Scanner scanner) {
        System.out.println("\nMenu Inicial:");
        System.out.println("1. Login");
        System.out.println("2. Listar Conteúdos (público)");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    private static int authenticatedMenu(Scanner scanner) {
        System.out.println(" \nMenu Após Login:");
        System.out.println("1. Criar Conteúdo");
        System.out.println("2. Listar Conteúdos");
        System.out.println("3. Atualizar Conteúdo");
        System.out.println("4. Excluir Conteúdo");
        System.out.println("5. Logout");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }
    }
