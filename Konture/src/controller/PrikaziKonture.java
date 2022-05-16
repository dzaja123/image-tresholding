package controller;

import view.GlavniProzor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrikaziKonture implements ActionListener {

    JTextField textThreshold;

    public PrikaziKonture(JTextField textThreshold) {
        this.textThreshold = textThreshold;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            GlavniProzor.getInstance().getDesno().prikaziKonture(textThreshold.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Threshold nije ispravan ili slika nije ucitana", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
