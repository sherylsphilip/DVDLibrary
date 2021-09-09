/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Dvd;
import java.util.List;

/**
 *
 * @author prave
 */
public interface DvdLibraryDao {
       
    Dvd addDvd(Dvd dvd)throws DVDLibraryExceptions;
    
    Dvd removeDvd(String title) throws DVDLibraryExceptions;
    
    Dvd editDvd(String title, Dvd dvd)throws DVDLibraryExceptions ;
    
    List<Dvd> listDvdCollection() throws DVDLibraryExceptions ;
    
    Dvd displayDvd(String title)throws DVDLibraryExceptions ;
    
    Dvd searchDvd(String title)throws DVDLibraryExceptions ;    
    
    
}
