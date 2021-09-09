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
 * @author prave
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao{

    Map<String, Dvd> dvdMap = new HashMap<>(); 
    private static final String DELIMITER ="::";
    
    @Override
    public Dvd addDvd(Dvd dvd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dvd removeDvd(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dvd editDvd(String title, Dvd dvd) {
       //read from file
       dvdMap.put(title,dvd);
       //write to file
       return dvd;
    }

    @Override
    public List<Dvd> listDvdCollection() {
        //call from file
        return new ArrayList(dvdMap.values());
    }

    @Override
    public Dvd displayDvd(String title) {
        //call from file
       Dvd dvd = dvdMap.get(title);
       return dvd;
    }

    @Override
    public Dvd searchDvd(String title) {
        //call from file
       Dvd dvd = dvdMap.get(title);
       return dvd;
    }
    /*
    loader()
    write
    marshalling
    unmarshalling
 */       
     
}
