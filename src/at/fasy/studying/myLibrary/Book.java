package at.fasy.studying.myLibrary;

public class Book {

    private String title, author,isbn;
    private int libNr, stock, initialStock;
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

}
