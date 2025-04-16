package controller;

import dao.PatronDao;
import entity.Patrons;

import java.util.List;

public class PatronController {
    private final PatronDao dao=new PatronDao();
    public boolean addPatron(String name) {
        Patrons patron=new Patrons(name);
        return dao.addPatron(patron);
    }

    public Patrons getPatronById(int patronId){
        return dao.getPatronByID(patronId);
    }

    public List<Patrons> getAllPatrons(){
        return  dao.getAllPatrons();
    }
}
