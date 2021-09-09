/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DVDLibraryExceptions;
import dao.DvdLibraryDao;
import dto.Dvd;
import java.util.List;
import ui.DvdLibraryView;

/**
 *
 * @author Sheryl Controller Class of DVD Library
 */
public class DVDController {

    private DvdLibraryView view;
    private DvdLibraryDao dao;

    /*
    DvD Controller which initialises the view & dao
     */
    public DVDController(DvdLibraryView view, DvdLibraryDao dao) {
        this.view = view;
        this.dao = dao;

    }

    /*
        Main method in controller to make choice as per the user selection
     */
    public void run() {
        int menuselection = 0;
        boolean continueFlag = true;
        try {
            do {

                menuselection = view.printMenuAndGetSelection();
                switch (menuselection) {
                    case 1:
                        createDvd();
                        break;
                    case 2:
                        removeDvd();
                        break;
                    case 3:
                        editDvdDetails();
                        break;
                    case 4:
                        displayAllDvd();
                        break;
                    case 5:
                        searchDvd();
                        break;
                    case 6:
                        exitCommand();
                        continueFlag = false;
                        break;
                    default:
                        defaultMessage();

                }

            } while (continueFlag);
        } catch (Exception e) {

        }
    }

    /*
        This method will make calls to view & dao in creating dvd details
     */
    private void createDvd() throws DVDLibraryExceptions {
        view.displayCreateDVDBanner();
        Dvd newdvd = view.getDvdInfo();
        dao.addDvd(newdvd);
        view.displayCreateSuccessBanner();
    }

    /*
    This method will make calls to view & dao in removing dvd from list
     */
    private void removeDvd() throws DVDLibraryExceptions {
        view.displayRemoveDvdBanner();
        String title = view.getTitle();
        Dvd removeDvd = dao.removeDvd(title);
        view.displayRemoveResult(removeDvd);
    }

    /*
    This method will make calls to view & dao in edit dvd details
     */
    private void editDvdDetails() throws DVDLibraryExceptions {
        view.displayEditDvdBanner();
        String title = view.getTitle();
        Dvd dvd = dao.searchDvd(title);
        if(dvd != null){
            dvd = view.editDvd(title, dvd);
            dvd = dao.editDvd(title, dvd);
        }
        
        view.displayEditResult(dvd);
    }

    /*
    This method will make calls to view & dao to display all dvds
     */
    private void displayAllDvd() throws DVDLibraryExceptions {
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = dao.listDvdCollection();
        view.displayDVDList(dvdList);

    }

    /*
    This method will make calls to view & dao to search dvd by title
     */
    private void searchDvd() throws DVDLibraryExceptions {
        String title = view.getTitle();
        Dvd dvd = dao.searchDvd(title);
        view.displayDVD(dvd);
    }

    /*
    This method will make calls to view to show exit command
     */
    private void exitCommand() {
        view.displayExitBanner();

    }

    /*
    This method will make calls to view to show default message
     */
    private void defaultMessage() {
        view.displayUnknownCommandBanner();
    }
}
