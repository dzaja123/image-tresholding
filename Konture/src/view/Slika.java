package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Slika extends JPanel {

    BufferedImage aktivnaSlika, original, konture;

    // proverava da li je uneta slika crno bela
    public boolean proveriSliku(BufferedImage slika) {

        int w = slika.getWidth();
        int h = slika.getHeight();

        int p, r, g, b;

        for (int i = 0; i < w; i++)
            for (int j = 0; j < h; j++) {
                // vrednost jednog pixela
                p = slika.getRGB(i, j);
                // prvih 8 bitova je crvena
                r = (p >> 16) & 0xff;
                // sledecih 8 bitova je zelena
                g = (p >> 8) & 0xff;
                // poslednjih 8 bitova je plava
                b = (p) & 0xff;

                // provera da li je R=G=B, ako nije onda nije crno bela slika
                if (r != g || g != b )
                    return false;
            }

        return true;
    }

    public void dodajSliku(File novaSlika) throws Exception {

        if (!proveriSliku(ImageIO.read(novaSlika)))
            throw new Exception("Slika nije validna");

        original = ImageIO.read(novaSlika);
        aktivnaSlika = original;
        // repaint sluzi da se osvezi prikaz, tj da se prikaze nova slika ako se nesto menjalo
        repaint();
    }

    public void prikaziOriginal() {
        aktivnaSlika = original;
        repaint();
    }

    public BufferedImage nadjiKonture(BufferedImage original, int treshold) {

        konture = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_RGB);

        Color belaBoja = new Color(255, 255, 255);
        int bela = belaBoja.getRGB();
        Color crnaBoja = new Color(0, 0, 0);
        int crna = crnaBoja.getRGB();

        // svaki piksel postavljamo ili na crni ili na beli, zavisi da li je ispod ili iznad thresholda
        for (int i = 0; i < konture.getWidth(); i++)
            for (int j = 0; j < konture.getHeight(); j++) {
                int rgb = original.getRGB(i, j);
                // posto je slika crno bela dovoljno nam je da uzmemo samo jedan kanal (svi su isti)
                int gs = rgb & 0xff;

                if (gs > treshold)
                    konture.setRGB(i, j, bela);
                else
                    konture.setRGB(i, j, crna);
            }
        return konture;
    }

    public void prikaziKonture(String thresholdStr) throws Exception {
        // ovde moze doci do exceptiona, ako je napisano nesto sto nije int u polju za threshold
        // (cathuje se u klasi PrikaziKonture)
        int threshold = Integer.parseInt(thresholdStr);
        konture = nadjiKonture(original, threshold);
        aktivnaSlika = konture;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension d = this.getSize();
        g.drawImage(aktivnaSlika, 0, 0, d.width, d.height, this);
    }
}
