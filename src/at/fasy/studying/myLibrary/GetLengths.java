package at.fasy.studying.myLibrary;

public class GetLengths {

    public int getTitleLength(Book[] c){
        int length = 0;
        for(Book k : c){
            if (length < k.getTitle().length()){
                length = k.getTitle().length();
            }
        }
        return length;
    }

    public int getAuthorLength(Book[] c){
        int length = 0;
        for(Book k : c){
            if (length < k.getAuthor().length()){
                length = k.getAuthor().length();
            }
        }
        return length;
    }

    public int getIsbnLength(Book[] c){
        int length = 0;
        for(Book k : c){
            if (length < k.getIsbn().length()){
                length = k.getIsbn().length();
            }
        }
        return length;
    }

    public int getAvailabilityLength(Book[] c){
        int length = 0;
        for(Book k : c){
            if (length < k.getAvailability().length()){
                length = k.getAvailability().length();
            }
        }
        return length;
    }

    public int getLibNrLength(Book[] c){
        int length = 0;
        for(Book k : c){
            if (length < String.valueOf(k.getLibNr()).length()){
                length = String.valueOf(k.getLibNr()).length();
            }
        }
        return length;
    }

    public int getStockLength(Book[] c){
        int length = 0;
        for(Book k : c){
            if (length < String.valueOf(k.getStock()).length()){
                length = String.valueOf(k.getStock()).length();
            }
        }
        return length;
    }

}
