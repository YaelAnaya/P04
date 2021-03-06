/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package yael.ao.p04;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme;
import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import yael.ao.uabc.Main;

/**
 *
 * @author yaela
 */
public class Quiz extends javax.swing.JDialog {

    private SinglyLinkedList<State> options;
    private State stateToAsk;
    private int playerScore;
    private boolean gameFinished;
    private final Color GREEN = Color.decode("#14AE5C");
    private final Color RED = Color.decode("#AE1414");
    private final Color DEFAULT_COLOR = Color.decode("#2C2C2C");

    public Quiz(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        options = new SinglyLinkedList<>();
        startGame();
    }

    public void makeOptions() {
        Random random = new Random();
        //Obtenemos tres estados de manera aleatoria.
        while (options.getSize() < 3) {

            int randomIndex = random.nextInt(StatesView.getStates().getSize());
            if (!options.contains(StatesView.getStates().get(randomIndex))) {
                options.addLast(StatesView.getStates().get(randomIndex));
            }
        }

    }

    public void makeQuestion() {
        var random = new Random();
        int randomIndex = random.nextInt(options.getSize());
        stateToAsk = options.get(randomIndex);
        stateNameLabel.setText(stateToAsk.getName());
    }

    public void checkAnswer(JLabel optionLabel) {
        if (!gameFinished) {
            if (stateToAsk.getCoatOfArms().equals(optionLabel.getIcon())) {
                scoreLabel.setText("PUNTOS: " + Integer.toString(++playerScore));
                titlePanel.setBackground(GREEN);
            } else {
                titlePanel.setBackground(RED);
            }
            gameFinished = true;
            options.clear();
        }

    }

    public void startGame() {
        makeOptions();
        makeQuestion();
        titlePanel.setBackground(DEFAULT_COLOR);
        option1.setIcon(options.get(0).getCoatOfArms());
        option2.setIcon(options.get(1).getCoatOfArms());
        option3.setIcon(options.get(2).getCoatOfArms());
        gameFinished = false;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playButton = new yael.ao.p04.CButton();
        option3 = new javax.swing.JLabel();
        option2 = new javax.swing.JLabel();
        option1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        scoreLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        titlePanel = new yael.ao.p04.RoundedPanel();
        stateNameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        playButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/PlayButton.png"))); // NOI18N
        playButton.setBaseImage(new javax.swing.ImageIcon(getClass().getResource("/icons/PlayButton.png")));
        playButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        playButton.setHoverImage(new javax.swing.ImageIcon(getClass().getResource("/icons/PlayButton_1.png")));
        playButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playButtonMouseClicked(evt);
            }
        });

        option3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        option3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coatOfArms/Estado_de_Mexico.png"))); // NOI18N
        option3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        option3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                option3MouseClicked(evt);
            }
        });

        option2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        option2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coatOfArms/Chiapas.png"))); // NOI18N
        option2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        option2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                option2MouseClicked(evt);
            }
        });

        option1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        option1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coatOfArms/Baja_California.png"))); // NOI18N
        option1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        option1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                option1MouseClicked(evt);
            }
        });

        scoreLabel.setFont(new java.awt.Font("Mulish Black", 0, 20)); // NOI18N
        scoreLabel.setForeground(new java.awt.Color(65, 65, 65));
        scoreLabel.setText("PUNTOS:");
        scoreLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(scoreLabel);

        titlePanel.setBackground(new java.awt.Color(44, 44, 44));
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(titlePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(option1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(option2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(option3, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addComponent(playButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(option2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(option3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(option1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void option1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option1MouseClicked
        checkAnswer(option1);
    }//GEN-LAST:event_option1MouseClicked

    private void playButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playButtonMouseClicked
        startGame();
    }//GEN-LAST:event_playButtonMouseClicked

    private void option2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option2MouseClicked
        checkAnswer(option2);
    }//GEN-LAST:event_option2MouseClicked

    private void option3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option3MouseClicked
        checkAnswer(option3);
    }//GEN-LAST:event_option3MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatGitHubIJTheme());
            UIManager.put("Button.arc", 20);
            UIManager.put("TextComponent.arc", 15);
            UIManager.put("Component.focusWidth", 0);

        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, null, ex);
        }

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            Quiz dialog = new Quiz(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel option1;
    private javax.swing.JLabel option2;
    private javax.swing.JLabel option3;
    private yael.ao.p04.CButton playButton;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel stateNameLabel;
    private yael.ao.p04.RoundedPanel titlePanel;
    // End of variables declaration//GEN-END:variables
}
