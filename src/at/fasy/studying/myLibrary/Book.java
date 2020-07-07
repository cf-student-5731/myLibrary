package at.fasy.studying.myLibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Book {

    private final String title, author,isbn;
    private final int libNr, initialStock;
    private int stock;
    private boolean availability;

    public Book(String title, String author, String isbn, int libNr, boolean availability, int stock){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.libNr = libNr;
        this.availability = availability;
        this.stock = stock;
        this.initialStock = stock;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getIsbn(){
        return this.isbn;
    }

    public int getLibNr(){
        return this.libNr;
    }

    public int getStock(){
        return this.stock;
    }

    public String getAvailability(){
        if(this.availability){
            return "Available";
        }
        else{
            return "NOT Available";
        }
    }

    public boolean lendBook(){
        if(this.availability && this.stock > 0){
            this.stock--;
            if(this.stock == 0){
                this.availability = false;
            }
            return true;
        }
        else{
            return false;
        }

    }

    public boolean returnBook(){
        if(this.stock != this.initialStock){
            this.stock++;
            this.availability = true;
            return true;
        }
        else{
            return false;
        }


    }


    public Book[] addBook(Book[] b){
        Scanner in = new Scanner(System.in);
        String title, author,isbn;
        int libNr, stock;

        ArrayList<Book> bl = new ArrayList<Book>(Arrays.asList(b));

        System.out.print("Enter Title: ");
        title = in.nextLine();
        System.out.print("Enter Author: ");
        author = in.nextLine();
        System.out.print("Enter ISBN: ");
        isbn = in.nextLine();
        libNr = (b[b.length-1].getLibNr()+1);
        System.out.print("Enter Stock: ");
        stock = in.nextInt();

        bl.add(new Book(title, author, isbn, libNr, true, stock));

        return bl.toArray(b);
    }

    public Book[] deleteBook(Book[] b, int item){
        ArrayList<Book> bl = new ArrayList<Book>(Arrays.asList(b));
        int j = -1;
        for (Book i : b){
            j++;
            if (item == i.getLibNr()){
                item = j;
            }
        }
        bl.remove(item);
        b = Arrays.copyOf(b, b.length - 1);
        return bl.toArray(b);
    }
}
