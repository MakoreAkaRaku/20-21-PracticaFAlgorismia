/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import model.chesspieces.ChessPiece;
import model.users.Arbiter;
import model.users.Player;
import model.users.User;
import repository.UsersRepository;

/**
 * Classe que representa la finestra per a gestionar els usuaris de l'aplicació.
 * 
 * @author Bernat Galmés Rubert
 */
public class UsersWindow extends JFrame {
    private final UsersWindow uW = this;
    private UsersRepository users;

    private ChessBoardWindow chessWindow;
    
    /**
     * Creates new form UsersWindow
     *
     * @param users Repository to query app users.
     */
    public UsersWindow(UsersRepository users) {
        this.users = users;

        initComponents();

        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        jTable1.getColumn("botó").setCellRenderer(buttonRenderer);
        jTable1.addMouseListener(new JTableUsersButtonMouseListener(jTable1));
        chessWindow = new ChessBoardWindow(9);
        chessWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public javax.swing.table.TableModel getTableData() {
        return new JTableUsersModel();
    }

    /**
     * Classe que representa la visualització dels usuaris en forma de taula.
     */
    private class JTableUsersModel extends AbstractTableModel {

        private static final long serialVersionUID = 1L;
        private final String[] COLUMN_NAMES = new String[]{"ID", "Nom", "Mail", "Tipus usuari", "botó"};
        private final Class<?>[] COLUMN_TYPES = new Class<?>[]{String.class, String.class, String.class, String.class, JButton.class};

        @Override
        public int getColumnCount() {
            return COLUMN_NAMES.length;
        }

        @Override
        public int getRowCount() {
            return users.findAll().size();
        }

        @Override
        public String getColumnName(int columnIndex) {
            return COLUMN_NAMES[columnIndex];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return COLUMN_TYPES[columnIndex];
        }

        @Override
        public Object getValueAt(final int rowIndex, final int columnIndex) {
            User user = users.findAll().get(rowIndex);
            String userType;
            Object o = null;
            switch (columnIndex){
                case 0:
                    o = user.getId();
                    break;
                case 1:
                    o = user.getName() + " " +  user.getSurname();
                    break;
                case 2:
                    o = user.getEmail();
                    break;
                case 3:
                    o = user.getType();
                    break;
                case 4:
                    userType = user.getType();
                    if (userType == "Player"){
                        o = new JButton("Mes info");
                    }else if( userType == "Arbiter"){
                        o = new JButton("Resum");
                    }
                    break;
            }
            return o;
        }
        
    }

    /**
     * Classe que implementa l'escoltador del mouse quan es clica 
     * al botó d'un usuari concret de la taula.
     * 
     */
    private class JTableUsersButtonMouseListener extends MouseAdapter {
        private final JTable table;
        public JTableUsersButtonMouseListener(JTable table) {
            this.table = table;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // get the coloum of the button
            int row = e.getY() / table.getRowHeight(); //get the row of the button
            /*Checking the row or column is valid or not*/
            if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
                Object value = table.getValueAt(row, column);
                if (value instanceof JButton) {
                    /*perform a click event*/
                    User u = users.findAll().get(row);
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            switch (u.getType()){
                                case "Player":
                                    ChessPiece[][] cp;
                                    Player p = (Player) u;
                                    chessWindow.reset();
                                    chessWindow.putTextAreaText(u.toString());
                                    if (p.getPlayedMatches().size() > 0){
                                        cp =p.getPlayedMatches().get(0).getState().getBoardPieces();
                                        chessWindow.colocaPeces(cp);
                                    }
                                    chessWindow.setVisible(true);
                                    break;
                                case "Arbiter":
                                    Arbiter a = (Arbiter) u;
                                    JOptionPane.showMessageDialog(uW, a, "Resum de "+a.getName(),JOptionPane.PLAIN_MESSAGE);
                                    break;
                            }
                        }
                    });
                }
            }
        }
    }

    private static class JTableButtonRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JButton button = (JButton) value;
            return button;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Projecte Algoritmia");

        jTable1.setModel(getTableData());
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Cambria Math", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ESCACS UIB");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton1.setText("Veure resum usuaris");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel2.add(jButton1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(jPanel3, java.awt.BorderLayout.LINE_START);
        getContentPane().add(jPanel4, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        float[] accesosperclasse = users.meanAccessByClass();
        String text = "> Nombre mitj accessos arbitres: " + accesosperclasse[0];
        text += "\n> Nombre mitj accessos socis: " + accesosperclasse[1];
        text += "\n> Nombre mitj accessos jugadors: " + accesosperclasse[2];
        text += "\n> Usuari amb mes accessos: " + users.findUserWithMaxAccess();
        text += "\n> Usuari amb mes partides guanyades: " + users.findUserWithMaxWins();
        text += "\n> Usuaris que no han accedit mai: " + String.join(",", users.findUsersWithNoAccess());
        JOptionPane.showMessageDialog(this, text, "RESUM DADES USUARIS",JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jButton1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
