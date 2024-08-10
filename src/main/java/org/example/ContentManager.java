package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContentManager {
    private List<Content> contents;

    public ContentManager() {
        contents = new ArrayList<>();
    }

    public void createContent(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Título do Conteúdo: ");
        String title = scanner.nextLine();
        System.out.print("Corpo do Conteúdo: ");
        String body = scanner.nextLine();
        contents.add(new Content(title, body));
        System.out.println("Conteúdo criado com sucesso.");
    }

    public void listContents(boolean publicView) {
        if (contents.isEmpty()) {
            System.out.println("Nenhum conteúdo disponível.");
            return;
        }

        System.out.println("\nLista de Conteúdos:");
        for (int i = 0; i < contents.size(); i++) {
            Content content = contents.get(i);
            System.out.println((i + 1) + ". " + content.getTitle());
            if (!publicView) {
                System.out.println("   Conteúdo: " + content.getBody());
            }
        }
    }

    public void updateContent(Scanner scanner) {
        listContents(false);
        System.out.print("Selecione o número do conteúdo a ser editado: ");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < contents.size()) {
            scanner.nextLine();  // Consumir nova linha
            System.out.print("Novo Título: ");
            String newTitle = scanner.nextLine();
            System.out.print("Novo Corpo: ");
            String newBody = scanner.nextLine();
            contents.get(index).setTitle(newTitle);
            contents.get(index).setBody(newBody);
            System.out.println("Conteúdo atualizado com sucesso.");
        } else {
            System.out.println("Conteúdo não encontrado.");
        }
    }

    public void deleteContent(Scanner scanner) {
        listContents(false);
        System.out.print("Selecione o número do conteúdo a ser deletado: ");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < contents.size()) {
            contents.remove(index);
            System.out.println("Conteúdo deletado com sucesso.");
        } else {
            System.out.println("Conteúdo não encontrado.");
        }
    }
}

class Content {
    private String title;
    private String body;

    public Content(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
