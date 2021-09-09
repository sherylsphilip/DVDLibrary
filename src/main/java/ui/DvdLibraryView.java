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
 * @author Sheryl
 */
public class DvdLibraryView {

    private UserIO io;

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    /*
   
    This function will print the menu and takes the user selection
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

    /*
    this method will get the user details for creating new dvd
     */
    public Dvd getDvdInfo() {
        String title = io.readString("Please enter the title of the DVD:");
        String released = io.readString("Please enter the released date:");
        String mpaa = io.readString("Please entern the MPAA's rating:");
        String director = io.readString("Please enter the Director");
        String studio = io.readString("Please enter the studio");
        String user = io.readString("Please enter the user's rating");
        Dvd currentDVD = new Dvd(title, released, mpaa, director, studio, user);
        return currentDVD;
    }

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully created.  Please hit enter to continue");
    }

    /*
    this method will display all dvds in the list
     */
    public void displayDVDList(List<Dvd> dvdList) {
        for (Dvd currentDVD : dvdList) {
            this.displayDVD(currentDVD);
        }
        io.readString("Please hit enter to continue.");
    }

    /*
    this method will display all dvd banner
     */
    public void displayDisplayAllBanner() {
        io.print("=== Display All DVD ===");
    }

    /*
    this method will display dvd banner
     */
    public void displayDisplayDVDBanner() {
        io.print("=== Display DVD ===");
    }

    /*
    this method will get title from the user
     */
    public String getTitle() {
        return io.readString("Please enter the title of the DVD.");
    }

    /*
    this method will display individual dvd details
     */
    public void displayDVD(Dvd dvd) {
        if (dvd != null) {
            String dvdInfo = String.format("Title : %s - Director: %s"
                    + "\nStudio: %s - Release Date: %s\n"
                    + "MPAA Rating: %s, User Rating: %s",
                    dvd.getTitle(),
                    dvd.getDirectorName(),
                    dvd.getStudio(),
                    dvd.getReleaseDate(),
                    dvd.getMpaaRating(),
                    dvd.getUserRating());

            io.print(dvdInfo);
        } else {
            io.print("No such DVD.");
        }
        io.print("---------------------------");
    }

    /*
    displaying dvd removal banner
     */
    public void displayRemoveDvdBanner() {
        io.print("=== Remove DVD ===");
    }

    /*
    this method shows that dvd removal success message
     */
    public void displayRemoveResult(Dvd dvdRecord) {
        if (dvdRecord != null) {
            io.print("DVD successfully removed.");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    /*
    this method displays good bye message
     */
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    /*
    this method will display unknown error message when user enters other than 1 to 6
     */
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    /*
    this method will display the error message
     */
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    /*
    This method will ask get details from the user to edit dvd details
     */
    public Dvd editDvd(String title) {
        Dvd dvd = new Dvd(title);
        dvd.setReleaseDate(io.readString("Please enter the released date to be edited:"));
        dvd.setMpaaRating(io.readString("Please entern the MPAA's rating  to be edited:"));
        dvd.setDirectorName(io.readString("Please enter the Director  to be edited:"));
        dvd.setStudio(io.readString("Please enter the studio  to be edited"));
        dvd.setUserRating(io.readString("Please enter the user's rating to be edited:"));
        return dvd;
    }
}
