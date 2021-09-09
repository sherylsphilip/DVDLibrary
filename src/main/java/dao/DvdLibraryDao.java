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
       
    Dvd addDvd(Dvd dvd);
    
    Dvd removeDvd(String title);
    
    Dvd editDvd(String title);
    
    List<Dvd> listDvdCollection();
    
    Dvd displayDvd(String title);
    
    Dvd searchDvd(String title);    
    
    
}
