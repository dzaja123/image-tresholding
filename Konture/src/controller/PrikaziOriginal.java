package controller;

import view.GlavniProzor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrikaziOriginal implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        GlavniProzor.getInstance().getDesno().prikaziOriginal();
    }
}
