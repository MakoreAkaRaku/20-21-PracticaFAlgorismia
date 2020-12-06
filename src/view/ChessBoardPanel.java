/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 * Classe que crea el panell del tauler per al joc Wuzi Chess
 *
 * @author Bernat
 */
public class ChessBoardPanel extends JPanel {

    private static final int MAXX = 600, MAXY = 600;
    private int Item_Width;
    private int Item_Heigth;
    private Casella caselles[][];
    private int size;
    private static Color WHITE = new Color(231,208,167);
    private static Color BLACK = new Color(167,126,92);

    /**
     * Costructor del Tauler del joc Reserva espai per a totes les caselles
     *
     * @param n Tamany del tauler n x n
     */
    public ChessBoardPanel(int n) {
        this.size = n;
        this.init();
    }

    /**
     * Inicialitza un tauler buid
     */
    private void init() {
        Casella cas[][] = new Casella[this.size][this.size];
        Item_Width = MAXX / this.size;
        Item_Heigth = MAXY / this.size;
        this.setSize(MAXX, MAXY);
        boolean oddRow;
        int y = 0;
        for (int i = 0; i < this.size; i++) {
            //pintam la fila i 
            oddRow = (i % 2 != 0);
            int x = 0;
            for (int j = 0; j < this.size; j++) {// pintam la element j de la fila i
                Rectangle2D.Float r = new Rectangle2D.Float(x, y, Item_Width, Item_Heigth);
                Color CFons;

                if (oddRow) {
                    CFons = (j % 2 == 0) ? WHITE : BLACK;
                } else {
                    CFons = (j % 2 != 0) ? WHITE : BLACK;
                }
                cas[i][j] = new Casella(r, CFons);
                x += Item_Width;
            }
            y += Item_Heigth;
        }
        this.caselles = cas;
    }

    /**
     * Mètode que pinta el tauler del joc
     *
     * @param g Objecte per a pintar els components del tauler
     */
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);
        int y = 0;
        for (int i = 0; i < size; i++) {
            //pintam la fila i
            int x = 0;
            for (int j = 0; j < size; j++) {
                caselles[i][j].paint(g);

                Image img_pesa = caselles[i][j].getImg_pesa();

                int margen = 10;
                if (img_pesa != null) {
                    g2d.drawImage(img_pesa, x + margen/2, y + margen/2, this.Item_Width - margen, this.Item_Heigth -margen , caselles[i][j].getColorFons(), this);
                }

                // switch boolean
                x += Item_Width;
            }
            y += Item_Heigth;
        }
    }

    /**
     * Canvia el tamany del tauler
     *
     * @param size
     */
    public void changeSize(int size) {
        this.size = size;
        this.init();
        this.repaint();
    }

    /**
     * Coloca una pesa a la fila i columna especificada. Després repinta el
     * tauler.
     *
     * @param col
     * @param fila
     * @param drawable
     */
    public void colocarPesa(int col, int fila, CellDrawable drawable) {
        Casella c = caselles[col][fila];
            caselles[col][fila].setImage(drawable.getPieceImage());
        this.removeAll();
        this.updateUI();
        this.repaint();
    }

    public void resetBoard() {
        this.init();
    }
}
