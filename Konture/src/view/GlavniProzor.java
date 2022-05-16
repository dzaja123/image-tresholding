package view;

import javax.swing.*;
import java.awt.*;

public class GlavniProzor extends JFrame {

    private static GlavniProzor instance = null;

    Menu levo;
    Slika desno;

    private GlavniProzor() {
        setTitle("Detekcija kontura");

        levo = new Menu();
        desno = new Slika();

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, levo, desno);
        split.setDividerLocation(240);

        add(split, BorderLayout.CENTER);
        setSize(1200,750);
        setLocationRelativeTo(null);
        setVisible(true);

        // ovo sluzi da se zavrsi program kada se zatvori glavni prozor
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public Slika getDesno() {
        return desno;
    }

    public static GlavniProzor getInstance() {
        if (instance == null)
            instance = new GlavniProzor();

        return instance;
    }

}
