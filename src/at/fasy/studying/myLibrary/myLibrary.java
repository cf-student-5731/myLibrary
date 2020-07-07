package at.fasy.studying.myLibrary;
import java.util.Scanner;

public class myLibrary {

    static void fillRow (int offset, int length){
        for (int i=0; i<length-offset; i++)
            System.out.print(" ");
    }

    static void printColumn (int length){
        for (int i=0; i<length; i++)
            System.out.print("-");
    }

    static int getTitleLength(Book[] c){
        int length = 0;
        for(Book k : c){
            if (length < k.getTitle().length()){
                length = k.getTitle().length();
            }
        }
        return length;
    }

    static int getAuthorLength(Book[] c){
        int length = 0;
        for(Book k : c){
            if (length < k.getAuthor().length()){
                length = k.getAuthor().length();
            }
        }
        return length;
    }

    static int getIsbnLength(Book[] c){
        int length = 0;
        for(Book k : c){
            if (length < k.getIsbn().length()){
                length = k.getIsbn().length();
            }
        }
        return length;
    }

    static int getAvailabilityLength(Book[] c){
        int length = 0;
        for(Book k : c){
            if (length < k.getAvailability().length()){
                length = k.getAvailability().length();
            }
        }
        return length;
    }

    static int getLibNrLength(Book[] c){
        int length = 0;
        for(Book k : c){
            if (length < String.valueOf(k.getLibNr()).length()){
                length = String.valueOf(k.getLibNr()).length();
            }
        }
        return length;
    }

    static int getStockLength(Book[] c){
        int length = 0;
        for(Book k : c){
            if (length < String.valueOf(k.getStock()).length()){
                length = String.valueOf(k.getStock()).length();
            }
        }
        return length;
    }

    static void printTable(Book[] b, String[] heading){

        int TitleMaxLength = getTitleLength(b);
        int AuthorMaxLength = getAuthorLength(b);
        int IsbnMaxLength = getIsbnLength(b);
        int LibNrMaxLength = getLibNrLength(b);
        int LibAvailabilityMaxLength = getAvailabilityLength(b);
        int StockMaxLength = getStockLength(b);

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

    static void printMenu(){
        System.out.println("Menu:");
        System.out.print("1...lend Book | ");
        System.out.print("2...return Book | ");
//        System.out.print("3...add Book | ");
//        System.out.print("4...steal Book | ");
        System.out.print("0...exit");
        System.out.println();
        System.out.print("Your choice: ");
    }

    static void printDashLine(int TitleMaxLength, int AuthorMaxLength, int AuthorIsbnMaxLength, int LibNrMaxLength, int LibAvailabilityMaxLength, int StockMaxLength) {

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


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int amountOfBooks = 5;

        Book[] b = new Book[amountOfBooks];

        b[0] = new Book("Java in a Nutshell", "Benjamin J Evans, David Flanagan", "978-1449370824", 1, true, 3);
        b[1] = new Book("Beginning Programming with Java For Dummies", "Barry Burd ", "978-1119235538", 2, true, 2);
        b[2] = new Book("Web Design with HTML, CSS, JavaScript and jQuery Set", "Jon Duckett ", "978-1118907443", 3, true, 4);
        b[3] = new Book("Überleben unter Arschlöchern", "Robert I Sutton", "978-3492057400", 4, true, 2);
        b[4] = new Book("Database Systems: Design, Implementation, & Management", "Carlos Coronel, Steven Morris", "978-1337627900", 5, true, 1);

        String[] heading = {"TITLE", "AUTHOR", "ISBN", "INV. NR.", "AVAILABILITY", "STOCK"};

        printTable(b, heading);
        printMenu();
        int menuInput1 = 1;
        int menuInput2 = 0;

        while(menuInput1 != 0) {
            menuInput1 = in.nextInt();
            switch (menuInput1) {
                case 1:
                    System.out.println("Enter Inv. Number: ");
                    menuInput2 = in.nextInt();
                    if (b[menuInput2 - 1].lendBook()){
                        printTable(b, heading);
                    }
                    else{
                        printTable(b, heading);
                        System.out.println(b[menuInput2 - 1].getTitle());
                        System.out.println("Is not available");
                        System.out.println();
                    }
                    printMenu();
                    break;

                case 2:
                System.out.println("Enter Inv. Number: ");
                menuInput2 = in.nextInt();
                if(b[menuInput2 - 1].returnBook()){
                    printTable(b, heading);
                }
                else{
                    printTable(b, heading);
                    System.out.println(b[menuInput2 - 1].getTitle());
                    System.out.println("Cannot be returned because the stock is already full!");
                    System.out.println();
                }
                printMenu();
                break;
//            case 3:
//                break;
//            case 4:
//                break;
//            case 0:
//                break;
                default:
                    break;

            }
        }


    }
}