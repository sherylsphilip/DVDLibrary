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
 * @author prave
 */
public class DVDController {

    private DvdLibraryView view;
    private DvdLibraryDao dao;

    public DVDController(DvdLibraryView view, DvdLibraryDao dao) {
        this.view = view;
        this.dao = dao;

    }

    public void run() {
        int menuselection = 0;
        boolean continueFlag = true;
        try {
            do {

                menuselection = view.printMenuAndGetSelection();
                switch(menuselection){
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

    private void createDvd() throws DVDLibraryExceptions {
        view.displayCreateDVDBanner();
        Dvd newdvd = view.getDvdInfo();
        dao.addDvd(newdvd);
        view.displayCreateSuccessBanner();
    }

    private void removeDvd() throws DVDLibraryExceptions {
       view.displayRemoveDvdBanner();
       String title = view.getTitle();
       Dvd removeDvd = dao.removeDvd(title);
       view.displayRemoveResult(removeDvd);
    }

    //To check if any modifications
    private void editDvdDetails()throws DVDLibraryExceptions {
        String title = view.getTitle();
        Dvd editDvd = view.editDvd(title);
        dao.editDvd(title, editDvd);
    }

    private void displayAllDvd()throws DVDLibraryExceptions {
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = dao.listDvdCollection();
        view.displayDVDList(dvdList);
       
    }

    private void searchDvd() throws DVDLibraryExceptions{
        String title = view.getTitle();
        Dvd dvd = dao.searchDvd(title);
        view.displayDVD(dvd);
    }

    private void exitCommand() {
        view.displayExitBanner();
       
    }

    private void defaultMessage() {
        view.displayUnknownCommandBanner();
    }
}
