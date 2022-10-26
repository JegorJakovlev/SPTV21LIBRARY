/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Author;
import entity.Book;

import java.util.Scanner;

public class BookManager {
    private Scanner scanner;

    public BookManager() {
        scanner = new Scanner(System.in);
    }

    public Book createBookWithAuthot() {
        System.out.print("������� �������� �����: ");
        String bookName = scanner.nextLine();
        System.out.print("������� ��� ������� �����: ");
        String publishedYear = scanner.nextLine();
        System.out.print("������� ���������� ����������� �����: ");
        String quantity = scanner.nextLine();

        Book book = createBook(bookName, new Integer(quantity), Integer.parseInt(publishedYear));
        System.out.print("������� ���������� ������� �����:");
        int countAuthorsInBook = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < countAuthorsInBook; i++) {
            System.out.print("������� ��� ������ " + (i + 1) + ": ");
            String firstname = scanner.nextLine();
            System.out.print("������� ������� ������ " + (i + 1) + ": ");
            String lastname = scanner.nextLine();
            System.out.print("������� ��� �������� ������ " + (i + 1) + ": ");
            String birthday = scanner.nextLine();
            book.addAuthor(createAuthor(firstname, lastname, new Integer(birthday)));
        }
        return book;
    }

    public void printListBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.print(i + 1 + ". " + books[i].getBookName() + ". ");
            for (int j = 0; j < books[i].getAuthors().length; j++) {
                System.out.printf("%s %s %d. ",
                        books[i].getAuthors()[j].getFirstname(),
                        books[i].getAuthors()[j].getLastname(),
                        books[i].getAuthors()[j].getBirthday());
            }
            System.out.println();
        }
    }

    public Book[] changeBook(Book[] books) {
        System.out.println("������ ����: ");
        for (int i = 0; i < books.length; i++) {
            System.out.print(i + 1 + ". " + books[i].getBookName() + ". ");
            for (int j = 0; j < books[i].getAuthors().length; j++) {
                System.out.printf("%s %s %d",
                        books[i].getAuthors()[j].getFirstname(),
                        books[i].getAuthors()[j].getLastname(),
                        books[i].getAuthors()[j].getBirthday());
            }
            System.out.println();
        }
        System.out.print("�������� ����� ����� ��� ��������������: ");
        int numBookForEdit = scanner.nextInt();
        scanner.nextLine();
        System.out.print("�������� �����: ");
        System.out.println(books[numBookForEdit - 1].getBookName());
        System.out.print("�������� �������� �����? (y/n)");
        String edit = scanner.nextLine();
        if (edit.equals("y")) {
            System.out.print("������� ����� �������� �����: ");
            books[numBookForEdit - 1].setBookName(scanner.nextLine());
        }
        System.out.print("��� ������� �����: ");
        System.out.println(books[numBookForEdit - 1].getPublishedYear());
        System.out.print("�������� ��� ������� �����? (y/n)");
        edit = scanner.nextLine();
        if (edit.equals("y")) {
            System.out.print("������� ����� �������� �����: ");
            books[numBookForEdit - 1].setPublishedYear(scanner.nextInt());
            scanner.nextLine();
        }
        System.out.print("���������� ����������� �����: ");
        System.out.println(books[numBookForEdit - 1].getQuantity());
        System.out.print("�������� ���������� ����������� �����? (y/n)");
        edit = scanner.nextLine();
        if (edit.equals("y")) {
            System.out.print("������� ������ ���������� �����: ");
            books[numBookForEdit - 1].setQuantity(scanner.nextInt());
            scanner.nextLine();
        }
        System.out.println("������� � ����� " + books[numBookForEdit - 1].getAuthors().length);
        System.out.println("�������� ���������� �������? (y/n)");
        edit = scanner.nextLine();
        if (edit.equals("y")) {
            System.out.print("������� ����� ���������� �������: ");
            int newCountAuthorsInBook = scanner.nextInt();
            scanner.nextLine();
            if (newCountAuthorsInBook < books[numBookForEdit - 1].getAuthors().length) {
                int deltaAuthors = books[numBookForEdit - 1].getAuthors().length - newCountAuthorsInBook;
                for (int n = 0; n < deltaAuthors; n++) {
                    books[numBookForEdit - 1] = deleteAuthorBook(books[numBookForEdit - 1]);
                }
            } else {
                for (int i = 0; i < newCountAuthorsInBook; i++) {
                    if (i >= books[numBookForEdit - 1].getAuthors().length) {
                        Author newAuthor = new Author();
                        System.out.print("������� ��� ������ " + (i + 1) + ": ");
                        newAuthor.setFirstname(scanner.nextLine());
                        System.out.print("������� ������� ������ " + (i + 1) + ": ");
                        newAuthor.setLastname(scanner.nextLine());
                        System.out.print("������� ��� �������� ������ " + (i + 1) + ": ");
                        newAuthor.setBirthday(scanner.nextInt());
                        scanner.nextLine();
                        books[numBookForEdit - 1].addAuthor(newAuthor);
                    } else if (i < books[numBookForEdit - 1].getAuthors().length) {
                        System.out.println(i + 1 + "-� �����: "
                                + books[numBookForEdit - 1].getAuthors()[i].getFirstname() + " " +
                                books[numBookForEdit - 1].getAuthors()[i].getLastname());
                        System.out.print("�������� ��� ������? (y/n)");
                        edit = scanner.nextLine();
                        if (edit.equals("y")) {
                            System.out.print("������� ������ ��� ������: ");
                            books[numBookForEdit - 1].getAuthors()[i].setFirstname(scanner.nextLine());
                        }
                        System.out.print("�������� ������� ������? (y/n)");
                        edit = scanner.nextLine();
                        if (edit.equals("y")) {
                            System.out.print("������� ������ ������� ������: ");
                            books[numBookForEdit - 1].getAuthors()[i].setLastname(scanner.nextLine());
                        }
                        System.out.print("�������� ��� �������� ������? (y/n)");
                        edit = scanner.nextLine();
                        if (edit.equals("y")) {
                            System.out.print("������� ������ ��� �������� ������: ");
                            books[numBookForEdit - 1].getAuthors()[i].setBirthday(scanner.nextInt());
                            scanner.nextLine();
                        }
                    }
                }
            }
        }
        return books;
    }

    public Book createBook(String bookName, int quantity, int publishedYear) {
        Book book = new Book();
        book.setBookName(bookName);
        book.setPublishedYear(publishedYear);
        book.setQuantity(quantity);
        return book;

    }

    public Author createAuthor(String firstname, String lastname, int birthday) {
        Author author = new Author();
        author.setBirthday(birthday);
        author.setFirstname(firstname);
        author.setLastname(lastname);
        return author;
    }

    private Book deleteAuthorBook(Book book) {
        for (int i = 0; i < book.getAuthors().length; i++) {
            System.out.println(
                    i+1+". "+book.getAuthors()[i].getFirstname()+" "+
                            book.getAuthors()[i].getLastname());
        }
        System.out.println("������ ������ �������? ");
        int numDeleteAuthor = scanner.nextInt();
        scanner.nextLine();
        book.removeAuthor(numDeleteAuthor);
        return book;
    }
}