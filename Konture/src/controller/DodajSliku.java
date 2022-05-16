package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import view.*;

public class DodajSliku implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser fc = new JFileChooser();

        int choice = fc.showOpenDialog(null);

        if (choice != JFileChooser.APPROVE_OPTION) return;

        File chosenFile = fc.getSelectedFile();

        try {
            GlavniProzor.getInstance().getDesno().dodajSliku(chosenFile);
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Slika nije ispravna", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
