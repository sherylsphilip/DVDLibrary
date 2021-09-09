/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dto.Dvd;
import java.util.List;

/**
 *
 * @author prave
 */
public class DvdLibraryView {
     private UserIO io;

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }
/*
    Allow the user to add a DVD to the collection
Allow the user to remove a DVD from the collection
Allow the user to edit the information for an existing DVD in the collection
Allow the user to list the DVDs in the collection
Allow the user to display the information for a particular DVD
Allow the user to search for a DVD by title
    */
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add DVD");
        io.print("2. Remove DVD");
        io.print("3. Edit DVD");
        io.print("4. Show All DVDs");
        io.print("5. Search DVD");
        io.print("6. QUIT");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public Dvd getDvdInfo() 
    {
    String title = io.readString("Please enter the title of the DVD:");
    String released = io.readString("Please enter the released date:");
    String mpaa = io.readString("Please entern the MPAA's rating:");
    String director = io.readString("Please enter the Director");
    String studio = io.readString("Please enter the studio");
    String user = io.readString("Please enter the user's rating");
    Dvd currentDVD = new Dvd(title, released, mpaa, director, studio, user);
    return currentDVD;
}

    /*
    Title
Release date
MPAA rating
Director's name
Studio
User rating 
    */


    public void displayCreateDVDBanner() {
    io.print("=== Create DVD ===");
}
    public void displayCreateSuccessBanner() {
    io.readString(
            "DVD successfully created.  Please hit enter to continue");
}

    public void displayDVDList(List<Dvd> dvdList) {
    for (Dvd currentDVD : dvdList) {
        this.displayDVD(currentDVD);
    }
    io.readString("Please hit enter to continue.");
}
    public void displayDisplayAllBanner() {
    io.print("=== Display All DVD ===");
}
    public void displayDisplayDVDBanner () {
    io.print("=== Display DVD ===");
}

public String getTitle() {
    return io.readString("Please enter the title of the DVD.");
}

public void displayDVD(Dvd dvd) {
    if (dvd != null) {
        String dvdInfo = String.format("%s\n%s\n%s, %s\n%s   -   n%s",
              dvd.getTitle(),
              dvd.getDirectorName(),
              dvd.getStudio(),
              dvd.getReleaseDate().toString(),
              dvd.getMpaaRating(),
              dvd.getUserRating());

        io.print(dvdInfo);
    } else {
        io.print("No such DVD.");
    }
    io.readString("Please hit enter to continue.");
}

public void displayRemoveDvdBanner () {
    io.print("=== Remove DVD ===");
}

public void displayRemoveResult(Dvd dvdRecord) {
    if(dvdRecord != null){
      io.print("DVD successfully removed.");
    }else{
      io.print("No such DVD.");
    }
    io.readString("Please hit enter to continue.");
}
public void displayExitBanner() {
    io.print("Good Bye!!!");
}

public void displayUnknownCommandBanner() {
    io.print("Unknown Command!!!");
}
public void displayErrorMessage(String errorMsg) {
    io.print("=== ERROR ===");
    io.print(errorMsg);
}




    /*
    Allow the user to add a DVD to the collection
Allow the user to remove a DVD from the collection
Allow the user to edit the information for an existing DVD in the collection
Allow the user to list the DVDs in the collection
Allow the user to display the information for a particular DVD
Allow the user to search for a DVD by title
    */

    public Dvd editDvd(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
