/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Sheryl Philip
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao{

    Map<String, Dvd> dvdMap = new HashMap<>(); 
    private static final String DELIMITER ="::";
    public static final String DVD_FILE = "DvdLibrary.txt";
    
    /*
    This method will add new dvd data to to the file
    */
    @Override
    public Dvd addDvd(Dvd dvd) throws DVDLibraryExceptions {
        loadDvd();
        Dvd newDvd = dvdMap.put(dvd.getTitle(), dvd);
        writeDvd();
        return newDvd;
    }
    
    /*
    This method will remove one dvd detail as per title from the file
    */
    @Override
    public Dvd removeDvd(String title) throws DVDLibraryExceptions {
        loadDvd();
        Dvd removedDvd = dvdMap.remove(title);
        writeDvd();
        return removedDvd;
    }
    
    /*
    This method will edit the dvd details as per title in the file
    */
    @Override
    public Dvd editDvd(String title, Dvd dvd)throws DVDLibraryExceptions  {
       loadDvd();
       dvdMap.put(title,dvd);
       writeDvd();
       return dvd;
    }
    
    /*
    This method will get all the dvd details from the file
    */
    @Override
    public List<Dvd> listDvdCollection() throws DVDLibraryExceptions {
        loadDvd();
        return new ArrayList(dvdMap.values());
    }
    
    /*
    This method will get dvd detail from file as per title
    */
    @Override
    public Dvd displayDvd(String title)throws DVDLibraryExceptions  {
        loadDvd();
       Dvd dvd = dvdMap.get(title);
       return dvd;
    }
    
    /*
    this method will retriev dvd details as per the title
    */
    @Override
    public Dvd searchDvd(String title) throws DVDLibraryExceptions {
       loadDvd();
       Dvd dvd = dvdMap.get(title);
       return dvd;
    }
    
    /*
        This method will read each line from the file and split into DVD details
        DvdAsText- contains each line from file which is in the form        
        title::release date::MPAA rating::director name::studio::user rating
    
    */
    private Dvd unmarshallDvd(String DvdAsText){
        String[] dvdTokens = DvdAsText.split(DELIMITER);

        // Index 0 - title
        String title = dvdTokens[0];

        Dvd dvdFromFile = new Dvd(title);

        // Index 1 - release date
        dvdFromFile.setReleaseDate(dvdTokens[1]);

        // Index 2 - MPAA rating
        dvdFromFile.setMpaaRating(dvdTokens[2]);

        // Index 3 - director
        dvdFromFile.setDirectorName(dvdTokens[3]);

        // Index 4 - studio
        dvdFromFile.setStudio(dvdTokens[4]);

        // Index 5 - user rating
        dvdFromFile.setUserRating(dvdTokens[5]);

        // We have now created a dvd! Return it!
        return dvdFromFile;
    }
    
    /*
        This method will read data from the file
    */
    private void loadDvd() throws DVDLibraryExceptions {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryExceptions(
                    "-_- Could not load dvd data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentDvd holds the most recent Dvd unmarshalled
        Dvd currentDvd;
        // Go through DVD_FILE line by line, decoding each line into a 
        // Dvd object by calling the unmarshallDvd method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Dvd
            currentDvd = unmarshallDvd(currentLine);

            // We are going to use the student id as the map key for our student object.
            // Put currentStudent into the map using student id as the key
            dvdMap.put(currentDvd.getTitle(), currentDvd);
        }
        // close scanner
        scanner.close();
    }
    
    /*
    // This method will turn a Dvd object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        // title::release date::MPAA rating::director name::studio::user rating
    */
    private String marshallDvd(Dvd aDvd){
        

        // Start with the title, since that's supposed to be first.
        String dvdAsText = aDvd.getTitle() + DELIMITER;

        // add the rest of the properties in the correct order:

        // release date
        dvdAsText += aDvd.getReleaseDate() + DELIMITER;

        // MPAA rating
        dvdAsText += aDvd.getMpaaRating() + DELIMITER;

        // director name
        dvdAsText += aDvd.getDirectorName() + DELIMITER;

        // studio
        dvdAsText += aDvd.getStudio() + DELIMITER;

        // user rating - don't forget to skip the DELIMITER here.
        dvdAsText += aDvd.getUserRating();

        // We have now turned a Dvd to text! Return it!
        return dvdAsText;
    }

    /*
    this metod will write the data into file
    */
    private void writeDvd() throws DVDLibraryExceptions {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DVDLibraryExceptions(
                    "Could not save Dvd data.", e);
        }

        // Write out the Dvd objects to the DVD file.

        String dvdAsText;
        List<Dvd> dvdList = this.listDvdCollection();
        for (Dvd currentDvd : dvdList) {
            // turn a Dvd into a String
            dvdAsText = marshallDvd(currentDvd);
            // write the Student object to the file
            out.println(dvdAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
     
}
