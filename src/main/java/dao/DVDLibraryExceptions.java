/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Sheryl Philip
 */
public class DVDLibraryExceptions extends Exception {
    
    DVDLibraryExceptions(String message){
        super(message);
    }
    
    DVDLibraryExceptions(String message, Throwable cause){
        super(message, cause);
    }
}
