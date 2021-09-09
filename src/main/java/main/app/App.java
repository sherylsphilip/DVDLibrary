/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.app;

import controller.DVDController;
import dao.DvdLibraryDao;
import dao.DvdLibraryDaoFileImpl;
import ui.DvdLibraryView;
import ui.UserIO;
import ui.UserIOImpl;

/**
 *
 * @author prave
 */
public class App {

    /*
    Main method where the App Starts
    Main function calls the controller.
    Controller has a constructor which initialises view and dao object
     */
    public static void main(String[] args) {

        UserIO io = new UserIOImpl();
        DvdLibraryView view = new DvdLibraryView(io);
        DvdLibraryDao dao = new DvdLibraryDaoFileImpl();

        DVDController dvdController = new DVDController(view, dao);
        dvdController.run();
    }
}
