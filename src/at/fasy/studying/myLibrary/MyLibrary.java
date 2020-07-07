package at.fasy.studying.myLibrary;

public class MyLibrary {

    public static void main(String[] args) {

        int amountOfBooks = 5;

        Book[] b = new Book[amountOfBooks];
        InputOutput t = new InputOutput();

        b[0] = new Book("Java in a Nutshell", "Benjamin J Evans, David Flanagan", "978-1449370824", 1, true, 3);
        b[1] = new Book("Beginning Programming with Java For Dummies", "Barry Burd ", "978-1119235538", 2, true, 2);
        b[2] = new Book("Web Design with HTML, CSS, JavaScript and jQuery Set", "Jon Duckett ", "978-1118907443", 3, true, 4);
        b[3] = new Book("Überleben unter Arschlöchern", "Robert I Sutton", "978-3492057400", 4, true, 2);
        b[4] = new Book("Database Systems: Design, Implementation, & Management", "Carlos Coronel, Steven Morris", "978-1337627900", 5, true, 1);

        String[] heading = {"TITLE", "AUTHOR", "ISBN", "INV. NR.", "AVAILABILITY", "STOCK"};

        t.printTable(b, heading);
        t.printMenu();
        int menuInput1, menuInput2, j;
        int maxLibNr = b.length;
        boolean exit = false;
        boolean found;


        while(!exit) {
            found = false;
            try{
                menuInput1 = InputOutput.readInt();
            }
            catch (Exception e){
                menuInput1 = 99;
            }

            switch (menuInput1) {
                case 1:
                    System.out.print("Enter Inv. Number: ");
                    try {
                        menuInput2 = InputOutput.readInt();
                        j = -1;
                        for (Book i : b) {
                            j++;
                            if (menuInput2 == i.getLibNr()) {
                                menuInput2 = j;
                            }
                        }
                        if (b[menuInput2].lendBook()) {
                            t.printTable(b, heading);
                        } else {
                            t.printTable(b, heading);
                            System.out.println(b[menuInput2].getTitle());
                            System.out.println("Is not available");
                            System.out.println();
                        }
                    }
                    catch(Exception e){
                        System.out.println("Invalid Inv. Nr.");
                    }
                    t.printMenu();
                    break;

                case 2:
                    System.out.print("Enter Inv. Number: ");
                    try {
                        menuInput2 = InputOutput.readInt();
                        j = -1;
                        for (Book i : b) {
                            j++;
                            if (menuInput2 == i.getLibNr()) {
                                menuInput2 = j;
                                found = true;
                            }
                        }
                        if(found) {
                            if (b[menuInput2].returnBook()) {
                                t.printTable(b, heading);
                            } else {
                                System.out.println(b[menuInput2].getTitle());
                                System.out.println("Cannot be returned because the stock is already full!");
                                System.out.println();
                            }
                        }
                        else{
                            System.out.println("Invalid Inv. Nr.");
                            t.printMenu();
                            break;
                        }
                    }
                    catch(Exception e){
                        System.out.println("Invalid Inv. Nr.");
                    }
                    t.printMenu();
                    break;

                case 3:
                    try {
                        maxLibNr++;
                        b = Book.addBook(b, maxLibNr);
                        t.printTable(b, heading);
                    }
                    catch(Exception e){
                        System.out.println("Invalid Input!");
                    }
                    t.printMenu();
                    break;
                case 4:
                    System.out.print("Enter Inv. Number: ");
                    try{
                        menuInput2 = InputOutput.readInt();
                        b = Book.deleteBook(b, menuInput2);
                        t.printTable(b, heading);
                    }
                    catch(Exception e){
                        System.out.println("Invalid Inv. Nr.");
                    }
                    t.printMenu();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Bye!");
                    break;

                case 5:
                    t.printTable(b, heading);
                    t.printMenu();
                    break;

                default:
                    System.out.println("Invalid Input!");
                    t.printMenu();
                    break;
            }
        }
    }
}