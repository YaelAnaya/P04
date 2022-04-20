/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package yael.ao.p04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author yaela
 */
public class StatesView extends javax.swing.JPanel {

    private static SinglyLinkedList<State> states;
    public int currentStateIndex;

    public StatesView() {
        initComponents();
        this.states = new SinglyLinkedList<>();
        this.currentStateIndex = 0;
    }

    public static SinglyLinkedList<State> getStates() {
        return states;
    }

    public int getCurrentStateIndex() {
        return currentStateIndex;
    }
    

    public void showCurrentSate() {
        var currentSate = states.get(this.currentStateIndex);
        coatOfArmsLabel.setIcon(currentSate.getCoatOfArms());
        coatOfArmsLabel.setToolTipText(currentSate.toString());
        stateNameLabel.setText(currentSate.getName());
        
    }

    /**
     * Este metodo avanza al siguiente estado de la lista.
     *
     */
    public void nextState() {
        if (this.currentStateIndex < StatesView.states.getSize() - 1) {
            this.currentStateIndex ++;
            showCurrentSate();
        }
    }

    /**
     * Este metodo lee un archivo de texto que contiene la informacion
     * correspondiente a los atributos de los estados (esta informacion se
     * encuentra separada por comas), se guarda el estado en la lista con la
     * informacion leida y una vez terminada la lectura, se ordenan los
     * elementos en orden ascendete.
     *
     */
    public void fillList() {

        //Se lee el archivo
        FileReader file = null;
        try {
            file = new FileReader("src/main/resources/estados.txt", StandardCharsets.UTF_8);
        } catch (IOException ex) {
            Logger.getLogger(StatesView.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Se lee la primera linea del archivo
        var buffer = new BufferedReader(file);
        //Se lee la primera linea del archivo
        String line;
        try {
            while ((line = buffer.readLine()) != null) {
                //Se guarda la informacion que esta separada por comas en un arreglo.
                String[] tokens = line.split(",");
                //Se crea un objeto State y se guarda en la lista States.
                State state = new State(tokens[0], tokens[1], Integer.parseInt(tokens[2]),
                        Integer.parseInt(tokens[3]), 
                        new ImageIcon(getClass().getResource(tokens[4])));
                states.addLast(state);
            }
             states.sort();
        } catch (IOException ex) {
            Logger.getLogger(StatesView.class.getName()).log(Level.SEVERE, null, ex);
        }

       
    }

    /**
     * Este metodo mezcla los estados dentro de la lista y reinicia el indice
     * que indica el estado actual al inicio de la Lista.
     *
     */
    public void shuffleList() {
        states.shuffle();
        this.currentStateIndex = 0;

    }
    /**
     * Este metodo ordena los estados dentro de la lista y reinicia el indice
     * que indica el estado actual al inicio de la Lista.
     *
     */
    public void resetList() {
        states.sort();
        this.currentStateIndex = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        titlePanel = new yael.ao.p04.RoundedPanel();
        stateNameLabel = new javax.swing.JLabel();
        coatOfArmsLabel = new yael.ao.p04.CJLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setFocusable(false);

        titlePanel.setBackground(new java.awt.Color(0, 193, 236));
        titlePanel.setRadius(40);

        stateNameLabel.setFont(new java.awt.Font("Mulish Black", 0, 22)); // NOI18N
        stateNameLabel.setForeground(new java.awt.Color(247, 248, 250));
        stateNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stateNameLabel.setText("AGUASCALIENTES");
        stateNameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stateNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stateNameLabel)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        coatOfArmsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        coatOfArmsLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coatOfArms/aguascalientes.png"))); // NOI18N
        coatOfArmsLabel.setFont(new java.awt.Font("Mulish", 0, 12)); // NOI18N
        coatOfArmsLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(coatOfArmsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(coatOfArmsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private yael.ao.p04.CJLabel coatOfArmsLabel;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel stateNameLabel;
    private yael.ao.p04.RoundedPanel titlePanel;
    // End of variables declaration//GEN-END:variables
}
