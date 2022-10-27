/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptv21library;

import entity.Author;
import entity.Book;
import entity.History;
import entity.Reader;
import manager.BookManager;
import manager.ReaderManager;
import manager.HistoryManager;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    private final Scanner scanner;
    private Book[] books;
    private Reader[] readers;
    private History[] histories;
    private final BookManager bookManager;
    private final ReaderManager readerManager;
    private final HistoryManager historyManager;
    private Reader Reader;

    public App() {
        scanner = new Scanner(System.in);
        books = new Book[0];
        readers = new Reader[0];
        histories = new History[0];
        bookManager = new BookManager();
        readerManager = new ReaderManager();
        historyManager = new HistoryManager();
    }

    public void run(){
        boolean repeat = true;
        do{
            System.out.println("������: ");
            System.out.println("0. ��������� ���������");
            System.out.println("1. �������� �����");
            System.out.println("2. �������� ��������");
            System.out.println("3. ������ �����");
            System.out.println("4. ������� �����");
            System.out.println("5. ������ �������� ����");
            System.out.println("6. ������ ����");
            System.out.println("7. ������ ���������");
            System.out.println("8. ������������� �����");
            System.out.println("9. ������������ ��������");
            System.out.print("�������� ������: ");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    System.out.println("1. �������� �����");
                    addBook(bookManager.createBookWithAuthot());

                    break;
                case 2:
                    System.out.println("2. �������� ��������");
                    addReader(readerManager.createReader());
                    break;
                case 3:
                    System.out.println("3. ������ �����");
                    addHistory(historyManager.takeOnBook(books, readers));
                    break;
                case 4:
                    System.out.println("4. ������� �����");
                    histories = historyManager.returnBook(histories);
                    break;
                case 5:
                    System.out.println("5. ������ �������� ����");
                    historyManager.printReadingBooks(histories);
                    break;
                case 6:
                    System.out.println("6. ������ ����");
                    bookManager.printListBooks(books);
                    break;
                case 7:
                    System.out.println("7. ������ ���������");
                    readerManager.printListReaders(readers);
                    break;
                case 8:
                    this.books = bookManager.changeBook(books);
                    break;
                case 9:
                    System.out.println("8. �������������� ��������");
                    this.readers = readerManager.changeReader(readers);
                    break;
                default:
                    System.out.println("�������� ������ �� ������!");;
            }
        }while(repeat);
        System.out.println("�������� ���������, ����!");
    }

    private void addBook(Book book) {
        this.books = Arrays.copyOf(this.books, this.books.length+1);
        this.books[this.books.length - 1] = book;
    }
    private void addReader(Reader reader) {
        this.readers = Arrays.copyOf(this.readers, this.readers.length+1);
        this.readers[this.readers.length - 1] = reader;
    }
    private void addHistory(History histories) {
        this.histories = Arrays.copyOf(this.histories, this.histories.length+1);
        this.histories[this.histories.length - 1] = histories;
    }
}