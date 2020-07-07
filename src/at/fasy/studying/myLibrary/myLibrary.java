package at.fasy.studying.myLibrary;
import java.util.Scanner;

public class myLibrary {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int amountOfBooks = 5;

        Book[] b = new Book[amountOfBooks];
        PrintTable t = new PrintTable();

        b[0] = new Book("Java in a Nutshell", "Benjamin J Evans, David Flanagan", "978-1449370824", 1, true, 3);
        b[1] = new Book("Beginning Programming with Java For Dummies", "Barry Burd ", "978-1119235538", 2, true, 2);
        b[2] = new Book("Web Design with HTML, CSS, JavaScript and jQuery Set", "Jon Duckett ", "978-1118907443", 3, true, 4);
        b[3] = new Book("Überleben unter Arschlöchern", "Robert I Sutton", "978-3492057400", 4, true, 2);
        b[4] = new Book("Database Systems: Design, Implementation, & Management", "Carlos Coronel, Steven Morris", "978-1337627900", 5, true, 1);

        String[] heading = {"TITLE", "AUTHOR", "ISBN", "INV. NR.", "AVAILABILITY", "STOCK"};

        t.printTable(b, heading);
        t.printMenu();
        int menuInput1 = 1;
        int menuInput2;

        while(menuInput1 != 0) {
            menuInput1 = in.nextInt();
            switch (menuInput1) {
                case 1:
                    System.out.println("Enter Inv. Number: ");
                    menuInput2 = in.nextInt();
                    if (b[menuInput2 - 1].lendBook()){
                        t.printTable(b, heading);
                    }
                    else{
                        t.printTable(b, heading);
                        System.out.println(b[menuInput2 - 1].getTitle());
                        System.out.println("Is not available");
                        System.out.println();
                    }
                    t.printMenu();
                    break;

                case 2:
                System.out.println("Enter Inv. Number: ");
                menuInput2 = in.nextInt();
                if(b[menuInput2 - 1].returnBook()){
                    t.printTable(b, heading);
                }
                else{
                    t.printTable(b, heading);
                    System.out.println(b[menuInput2 - 1].getTitle());
                    System.out.println("Cannot be returned because the stock is already full!");
                    System.out.println();
                }
                    t.printMenu();
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