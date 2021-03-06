package at.fasy.studying.myLibrary;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InputOutput {

    public void fillRow (int offset, int length){
        for (int i=0; i<length-offset; i++)
            System.out.print(" ");
    }

    public void printColumn (int length){
        for (int i=0; i<length; i++)
            System.out.print("-");
    }


    public void printMenu(){
        System.out.println("Menu:");
        System.out.print("1...lend Book | ");
        System.out.print("2...return Book | ");
        System.out.print("3...add Book | ");
        System.out.print("4...delete Book | ");
        System.out.print("5...print Table | ");
        System.out.print("6...save to File | ");
        System.out.print("7...load from File | ");
        System.out.print("0...exit");
        System.out.println();
        System.out.print("Your choice: ");
    }

    public void printDashLine(int TitleMaxLength, int AuthorMaxLength, int AuthorIsbnMaxLength, int LibNrMaxLength, int LibAvailabilityMaxLength, int StockMaxLength) {

        System.out.println();
        System.out.print(" | ");
        printColumn(TitleMaxLength);
        System.out.print(" | ");
        printColumn(AuthorMaxLength);
        System.out.print(" | ");
        printColumn(AuthorIsbnMaxLength);
        System.out.print(" | ");
        printColumn(LibNrMaxLength);
        System.out.print(" | ");
        printColumn(LibAvailabilityMaxLength);
        System.out.print(" | ");
        printColumn(StockMaxLength);
        System.out.print(" | ");
    }



    public void printTable(Book[] b, String[] heading){
        GetLengths l = new GetLengths();
        int TitleMaxLength = l.getTitleLength(b);
        int AuthorMaxLength = l.getAuthorLength(b);
        int IsbnMaxLength = l.getIsbnLength(b);
        int LibNrMaxLength = l.getLibNrLength(b);
        int LibAvailabilityMaxLength = l.getAvailabilityLength(b);
        int StockMaxLength = l.getStockLength(b);

        if(TitleMaxLength < heading[0].length()){
            TitleMaxLength = heading[0].length();
        }

        if(AuthorMaxLength < heading[1].length()){
            AuthorMaxLength = heading[1].length();
        }

        if(IsbnMaxLength < heading[2].length()){
            IsbnMaxLength = heading[2].length();
        }

        if(LibNrMaxLength < heading[3].length()){
            LibNrMaxLength = heading[3].length();
        }

        if(LibAvailabilityMaxLength < heading[4].length()){
            LibAvailabilityMaxLength = heading[4].length();
        }

        if(StockMaxLength < heading[5].length()){
            StockMaxLength = heading[5].length();
        }

        printDashLine(TitleMaxLength, AuthorMaxLength, IsbnMaxLength, LibNrMaxLength, LibAvailabilityMaxLength, StockMaxLength);

        System.out.println();
        System.out.print(" | ");
        System.out.print(heading[0]);
        fillRow(heading[0].length(), TitleMaxLength);
        System.out.print(" | ");
        System.out.print(heading[1]);
        fillRow(heading[1].length(), AuthorMaxLength);
        System.out.print(" | ");
        System.out.print(heading[2]);
        fillRow(heading[2].length(), IsbnMaxLength);
        System.out.print(" | ");
        System.out.print(heading[3]);
        fillRow(heading[3].length(), (LibNrMaxLength));
        System.out.print(" | ");
        System.out.print(heading[4]);
        fillRow(heading[4].length(), LibAvailabilityMaxLength);
        System.out.print(" | ");
        System.out.print(heading[5]);
        fillRow(heading[5].length(), StockMaxLength);
        System.out.print(" | ");

        printDashLine(TitleMaxLength, AuthorMaxLength, IsbnMaxLength, LibNrMaxLength, LibAvailabilityMaxLength, StockMaxLength);

        for(Book j : b) {
            System.out.println();
            System.out.print(" | ");
            System.out.print(j.getTitle());
            fillRow(j.getTitle().length(), TitleMaxLength);
            System.out.print(" | ");
            System.out.print(j.getAuthor());
            fillRow(j.getAuthor().length(), AuthorMaxLength);
            System.out.print(" | ");
            System.out.print(j.getIsbn());
            fillRow(j.getIsbn().length(), IsbnMaxLength);
            System.out.print(" | ");
            System.out.print(j.getLibNr());
            fillRow(String.valueOf(j.getLibNr()).length(), LibNrMaxLength);
            System.out.print(" | ");
            System.out.print(j.getAvailability());
            fillRow(j.getAvailability().length(), LibAvailabilityMaxLength);
            System.out.print(" | ");
            System.out.print(j.getStock());
            fillRow(String.valueOf(j.getStock()).length(), StockMaxLength);
            System.out.print(" | ");
        }
        printDashLine(TitleMaxLength, AuthorMaxLength, IsbnMaxLength, LibNrMaxLength, LibAvailabilityMaxLength, StockMaxLength);

        System.out.println();
    }

    public static int readInt(){
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static String readString(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static void saveToFile(Book[] b) throws IOException {
        FileWriter writer = new FileWriter("./books.txt");
        for (Book i : b) {
            writer.write(i + "\r"+ "");
        }
        writer.close();
    }

    public static Book[] loadFromFile() throws IOException {
        FileReader fileReader = new FileReader("./books.txt");

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<Book> lines = new ArrayList<>();
        String line;

        while ((line = bufferedReader.readLine()) != null){
            String[] lineArray = line.split("#");
            String title = lineArray[0];
            String author = lineArray[1];
            String isbn = lineArray[2];
            boolean availability = true;
            int libNr = Integer.parseInt(lineArray[3]);
            if (lineArray[4].equals("false")){
                availability = false;
            }

            int stock = Integer.parseInt(lineArray[5]);
            int initialStock = Integer.parseInt(lineArray[6]);
            lines.add(new Book(title, author, isbn, libNr, availability, stock, initialStock));

        }
        bufferedReader.close();
        return lines.toArray(new Book[lines.size()]);
    }
}
