/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Reader;

import java.util.Scanner;

public class ReaderManager {
    private Scanner scanner;


    public ReaderManager() {
        scanner = new Scanner(System.in);

    }
    public Reader createReader() {
        Reader reader = new Reader();
        System.out.print("������� ��� ��������: ");
        reader.setFirstname(scanner.nextLine());
        System.out.print("������� ������� ��������: ");
        reader.setLastname(scanner.nextLine());
        System.out.print("������� ������� ��������: ");
        reader.setPhone(scanner.nextLine());

        return reader;
    }

    public void printListReader(Reader[] readers) {
        for (int i = 0; i < readers.length; i++) {
            System.out.printf("%d. %s %s. �������: %s%n"
                    , i + 1
                    , readers[i].getFirstname()
                    , readers[i].getLastname()
                    , readers[i].getPhone()
            );
        }

    }

}