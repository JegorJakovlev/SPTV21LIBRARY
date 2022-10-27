/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Reader;

import java.util.Scanner;

public class ReaderManager {
    private final Scanner scanner;


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

    public void printListReaders(Reader[] readers) {
        for (int i = 0; i < readers.length; i++) {
            System.out.printf("%d. %s %s. �������: %s%n"
                    , i + 1
                    , readers[i].getFirstname()
                    , readers[i].getLastname()
                    , readers[i].getPhone()
            );
        }

    }



public Reader[] changeReader(Reader[] readers) {
    System.out.println("������ ���������");
    this.printListReaders(readers);
    System.out.print("�������� ����� ��������");
    int numberReader = scanner.nextInt();scanner.nextLine();
    System.out.println("���: "+readers[numberReader-1].getFirstname());
    System.out.print("��������? (y/n): ");
    String letter = scanner.nextLine();
    if(letter.equals("y")){
        System.out.println("������� ����� ���: ");
        readers[numberReader - 1].setFirstname(scanner.nextLine());

    }
    System.out.println("�������: "+readers[numberReader-1].getFirstname());
    System.out.print("��������? (y/n): ");
    letter = scanner.nextLine();
    if(letter.equals("y")){
        System.out.println("������� ����� ���: ");
        readers[numberReader - 1].setLastname(scanner.nextLine());
    }
    System.out.println("�������: "+readers[numberReader-1].getFirstname());
    System.out.print("��������? (y/n): ");
    letter = scanner.nextLine();
    if(letter.equals("y")){
        System.out.println("������� �������: ");
        readers[numberReader - 1].setPhone(scanner.nextLine());
    }
    return readers;
  }
}

