package at.fasy.studying.myLibrary;

import java.util.ArrayList;
import java.util.Arrays;

public class Book {

    private final String title, author,isbn;
    private final int libNr, initialStock;
    private boolean availability;
    private int stock;


    @Override
    public String toString() {
        return  title + "#" +
                author + "#" +
                isbn + "#" +
                libNr + "#" +
                availability + "#" +
                stock + "#" +
                initialStock;
    }

    public Book(String title, String author, String isbn, int libNr, boolean availability, int stock, int initialStock){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.libNr = libNr;
        this.availability = availability;
        this.stock = stock;
        this.initialStock = initialStock;
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


    public static Book[] addBook(Book[] b, int libNr){
        String title, author,isbn;
        int stock, initialStock;

        ArrayList<Book> bl = new ArrayList<>(Arrays.asList(b));

        System.out.print("Enter Title: ");
        title = InputOutput.readString();
        System.out.print("Enter Author: ");
        author = InputOutput.readString();
        System.out.print("Enter ISBN: ");
        isbn = InputOutput.readString();
        System.out.print("Enter Stock: ");
        stock = InputOutput.readInt();
        System.out.print("Enter max amount of this Book: ");
        initialStock = InputOutput.readInt();

        while(stock <1 ){
            System.out.print("Enter a value higher than 0: ");
            stock = InputOutput.readInt();
        }


        while(initialStock < stock) {
            System.out.print("Enter a value higher than " + (stock-1) + " :");
            initialStock = InputOutput.readInt();
        }

        bl.add(new Book(title, author, isbn, libNr, true, stock, initialStock));
        return bl.toArray(b);
    }

    public static Book[] deleteBook(Book[] b, int item){
        ArrayList<Book> bl = new ArrayList<>(Arrays.asList(b));
        int j = -1;
        for (Book i : b){
            j++;
            if (item == i.getLibNr()){
                item = j;
            }
        }
        bl.remove(item);
        return bl.toArray(new Book[bl.size()]);
    }
}
