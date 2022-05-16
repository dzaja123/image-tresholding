package view;

import controller.DodajSliku;
import controller.PrikaziKonture;
import controller.PrikaziOriginal;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    public Menu() {

        BoxLayout bl = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(bl);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel l1 = new JLabel("Dodaj novu sliku:");
        l1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        add(l1);
        add(new JLabel(" "));

        JButton dugmeDodaj = new JButton("Dodaj");
        dugmeDodaj.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        dugmeDodaj.addActionListener(new DodajSliku());
        add(dugmeDodaj);

        add(new JLabel(" "));
        add(new JLabel(" "));

        JLabel l2 = new JLabel("Unesi threshold (int od 0 do 255):");
        l2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        add(l2);
        add(new JLabel(" "));
        JTextField textThreshold = new JTextField();
        textThreshold.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        textThreshold.setMaximumSize(new Dimension(240,30));
        add(textThreshold);

        add(new JLabel(" "));
        add(new JLabel(" "));

        JLabel l3 = new JLabel("Prikazi konture:");
        l3.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        add(l3);
        add(new JLabel(" "));

        JButton dugmeKonture = new JButton("Konture");
        dugmeKonture.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        dugmeKonture.addActionListener(new PrikaziKonture(textThreshold));
        add(dugmeKonture);

        add(new JLabel(" "));
        add(new JLabel(" "));

        JLabel l4 = new JLabel("Prikazi original:");
        l4.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        add(l4);
        add(new JLabel(" "));

        JButton dugmeOriginal = new JButton("Original");
        dugmeOriginal.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        dugmeOriginal.addActionListener(new PrikaziOriginal());
        add(dugmeOriginal);
    }

}
