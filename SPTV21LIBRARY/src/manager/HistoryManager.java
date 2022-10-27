/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Author;
import entity.Book;
import entity.History;
import entity.Reader;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class HistoryManager {
private final Scanner scanner;

    public HistoryManager() {
        scanner = new Scanner(System.in);
    }
    
    public History takeOnBook(Book[] books, Reader[] readers){
        System.out.println("������ ���������: ");
        for (int i = 0; i < readers.length; i++) {
            System.out.println(i+1+". "+readers[i].getFirstname()+" "+readers[i].getLastname());
        }
        System.out.print("������ ��������: ");
        int numberReader = scanner.nextInt(); scanner.nextLine();
        System.out.println("������ ����: ");
        for (int i = 0; i < books.length; i++) {
            System.out.print(i+1+". "+books[i].getBookName()+". ");
            for (Author author : books[i].getAuthors()) {
                System.out.printf("%s %s %d", author.getFirstname(), author.getLastname(), author.getBirthday());
            }
            System.out.println();
        }
        System.out.print("������ ����� �����: ");
        int numberBook = scanner.nextInt();scanner.nextLine();
        History history = new History();
        history.setBook(books[numberBook - 1]);
        history.setReader(readers[numberReader-1]);
        history.setTakeOnBook(new GregorianCalendar().getTime());
        return history;
    }
    
    public void printReadingBooks(History[] histories){
        for (int i = 0; i < histories.length; i++) {
            if(histories[i].getReturnBook() == null){
                System.out.print(i+1+". "+histories[i].getBook().getBookName()+". ");
                for (Author author : histories[i].getBook().getAuthors()) {
                    System.out.printf("%s %s %d", author.getFirstname(), author.getLastname(), author.getBirthday());
                }
                System.out.println();
            }
        }
    }

    public History[] returnBook(History[] histories) {
        //������� ����� ������� � ������������ ������
        //�������� ������� ���� � ���� returnBook
        System.out.println("������ �������� ����: ");
        this.printReadingBooks(histories);
        System.out.print("�������� �� ������ ����� ������������ �����: ");
        int numberReturnBook = scanner.nextInt();scanner.nextLine();
        histories[numberReturnBook - 1].setReturnBook(new GregorianCalendar().getTime());
        return histories;
    }
}