/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.parcial.parcial2;

import java.awt.Color;
import javax.swing.*;
import java.util.ArrayList;

/**
 * @author monje
 */
public class Main extends javax.swing.JFrame {


    // Declaración de una variable "turno" que indica de quién es el turno ("X" o "O").
    String turno = "X";

    // ArrayList "lbls" que almacena las etiquetas del juego.
    ArrayList<JLabel> lbls = new ArrayList<>();

    // Constructor de la clase Main.
    public Main() {
        initComponents();
        start(); // Llama al método "start" al inicializar la aplicación.
    }

    // Método "start" que inicia el juego.
    private void start() {
        cls(); // Llama al método "cls" para limpiar la interfaz del juego.
        changeTurno(); // Llama al método "changeTurno" para establecer el turno inicial.
        positionLbl(); // Llama al método "positionLbl" para asignar las etiquetas del juego a la lista "lbls".
    }

    // Método "positionLbl" que agrega las etiquetas del juego a la lista "lbls".
    void positionLbl() {
        lbls.add(lb1);
        lbls.add(lb2);
        lbls.add(lb3);
        lbls.add(lb4);
        lbls.add(lb5);
        lbls.add(lb6);
        lbls.add(lb7);
        lbls.add(lb8);
        lbls.add(lb9);
    }

    // Método "pressedLabel" que se llama cuando se presiona una etiqueta del juego.
    public void pressedLabel(int position) {
        if (lbls.get(position).getText().isEmpty()) {
            lbls.get(position).setText(turno); // Establece el turno actual en la etiqueta si la casilla está vacía.
            changeTurno(); // Cambia el turno al siguiente jugador.
        }

        lbls.get(position).setText(turno); // Establece el turno actual en la etiqueta si la casilla no está vacía.
        checkWinner(); // Comprueba si hay un ganador después de cada movimiento.
    }


    // Función 'changeTurno' que cambia el turno del jugador actual.
    public void changeTurno() {
        if (turno.equals("X")) {
            // Si el turno actual es "X", cambiamos el turno a "O".
            turno = "O";
        } else {
            // Si el turno actual no es "X" (asumiendo que es "O"), cambiamos el turno a "X".
            turno = "X";
        }
    }

    // Función 'changeLblPlayer' que actualiza la etiqueta que muestra al jugador actual.
    public void changeLblPlayer() {
        if (lbl_player.getText().equals("X")) {
            // Si la etiqueta muestra "X", la actualizamos para mostrar "O".
            lbl_player.setText("O");
        } else {
            // Si la etiqueta no muestra "X" (asumiendo que muestra "O"), la actualizamos para mostrar "X".
            lbl_player.setText("X");
        }
    }



    // Matriz 'win' que almacena las combinaciones ganadoras en el juego de totito
    int win[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};

    // Función 'winnerpts' que toma como entrada el jugador ("X" o "O") que ganó y devuelve su puntaje actualizado.
    int winnerpts(String player) {
        if (player.equals("X")) {
            // Si el jugador es "X", se obtiene el puntaje actual de "X" desde la etiqueta 'lbXwin',
            // se le suma 1 y se devuelve el puntaje actualizado.
            return Integer.parseInt(lbXwin.getText()) + 1;
        } else {
            // Si el jugador no es "X" (asumiendo que es "O"), se obtiene el puntaje actual de "O" desde la etiqueta 'lbWinO',
            // se le suma 1 y se devuelve el puntaje actualizado.
            return Integer.parseInt(lbWinO.getText()) + 1;
        }
    }


    public void checkWinner() {
        for (int i = 0; i < 8; i++) {
            if (lbls.get(win[i][0]).getText().equals(lbls.get(win[i][1]).getText())
                    && lbls.get(win[i][1]).getText().equals(lbls.get(win[i][2]).getText())
                    && !lbls.get(win[i][0]).getText().isEmpty()) {

                // Marcamos las casillas ganadoras en verde
                lbls.get(win[i][0]).setBackground(Color.GREEN);
                lbls.get(win[i][1]).setBackground(Color.GREEN);
                lbls.get(win[i][2]).setBackground(Color.GREEN);

                // Mostramos un mensaje con el ganador
                JOptionPane.showMessageDialog(null, "Ganador '" + lbls.get(win[i][0]).getText()+"'");

                // Actualizamos los puntajes según el ganador
                if (lbls.get(win[i][0]).getText().equals("X")) {
                    lbXwin.setText(String.valueOf(winnerpts(lbls.get(win[i][0]).getText())));
                } else {
                    lbWinO.setText(String.valueOf(winnerpts(lbls.get(win[i][0]).getText())));
                }

                // Llamamos al método cls() para reiniciar el juego
                cls();

                // Cambiamos el turno
                changeTurno();
            } else if (!lb1.getText().isEmpty() && !lb2.getText().isEmpty() && !lb3.getText().isEmpty()
                    && !lb4.getText().isEmpty() && !lb5.getText().isEmpty() && !lb6.getText().isEmpty()
                    && !lb7.getText().isEmpty() && !lb8.getText().isEmpty() && !lb9.getText().isEmpty()) {
                // En caso de empate, mostramos un mensaje y reiniciamos el juego
                JOptionPane.showMessageDialog(null, "Empate");
                cls();
                changeTurno();
            }
        }
    }



    void cls() {
        // Limpiamos los textos de las etiquetas
        lb1.setText("");
        lb2.setText("");
        lb3.setText("");
        lb4.setText("");
        lb5.setText("");
        lb6.setText("");
        lb7.setText("");
        lb8.setText("");
        lb9.setText("");

        // Cambiamos el fondo de las etiquetas a blanco
        for (int i = 0; i < lbls.size(); i++) {
            lbls.get(i).setBackground(Color.WHITE);
        }

        // Establecemos el texto en lbl_player como "X"
        lbl_player.setText("X");

        // Establecemos el turno como "X"
        turno = "X";
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lb7 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb9 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbXwin = new javax.swing.JLabel();
        lbWinO = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbl_player = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        lb7.setBackground(new java.awt.Color(255, 255, 255));
        lb7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lb7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb7.setText("jLabel1");
        lb7.setOpaque(true);
        lb7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb7MousePressed(evt);
            }
        });

        lb4.setBackground(new java.awt.Color(255, 255, 255));
        lb4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lb4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb4.setText("jLabel1");
        lb4.setOpaque(true);
        lb4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb4MousePressed(evt);
            }
        });

        lb5.setBackground(new java.awt.Color(255, 255, 255));
        lb5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lb5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb5.setText("jLabel1");
        lb5.setOpaque(true);
        lb5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb5MousePressed(evt);
            }
        });

        lb1.setBackground(new java.awt.Color(255, 255, 255));
        lb1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1.setText("jLabel1");
        lb1.setOpaque(true);
        lb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb1MousePressed(evt);
            }
        });

        lb3.setBackground(new java.awt.Color(255, 255, 255));
        lb3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lb3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb3.setText("jLabel1");
        lb3.setOpaque(true);
        lb3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb3MousePressed(evt);
            }
        });

        lb9.setBackground(new java.awt.Color(255, 255, 255));
        lb9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lb9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb9.setText("jLabel1");
        lb9.setOpaque(true);
        lb9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb9MousePressed(evt);
            }
        });

        lb6.setBackground(new java.awt.Color(255, 255, 255));
        lb6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lb6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb6.setText("jLabel1");
        lb6.setOpaque(true);
        lb6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb6MousePressed(evt);
            }
        });

        lb2.setBackground(new java.awt.Color(255, 255, 255));
        lb2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lb2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb2.setText("jLabel1");
        lb2.setOpaque(true);
        lb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb2MousePressed(evt);
            }
        });

        lb8.setBackground(new java.awt.Color(255, 255, 255));
        lb8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lb8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb8.setText("jLabel1");
        lb8.setOpaque(true);
        lb8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb8MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(lb7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lb8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lb9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lb3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(lb4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lb5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lb6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lb3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lb4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lb5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lb6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lb7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lb9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lb8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setText("Reiniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Puntajes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("X :");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("O:");

        lbXwin.setText("0");

        lbWinO.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbXwin))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbWinO)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(lbXwin))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(lbWinO))
                                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Turno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        lbl_player.setFont(new java.awt.Font("Hack Nerd Font", 0, 36)); // NOI18N
        lbl_player.setText("X O");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addComponent(lbl_player)
                                .addGap(17, 17, 17))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_player)
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(40, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lb7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb7MousePressed
        changeLblPlayer();
        pressedLabel(6);
    }//GEN-LAST:event_lb7MousePressed

    private void lb4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb4MousePressed
        changeLblPlayer();
        pressedLabel(3);
    }//GEN-LAST:event_lb4MousePressed

    private void lb5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb5MousePressed
        changeLblPlayer();
        pressedLabel(4);
    }//GEN-LAST:event_lb5MousePressed

    private void lb1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb1MousePressed
        changeLblPlayer();
        pressedLabel(0);
    }//GEN-LAST:event_lb1MousePressed

    private void lb3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb3MousePressed
        changeLblPlayer();
        pressedLabel(2);
    }//GEN-LAST:event_lb3MousePressed

    private void lb9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb9MousePressed
        changeLblPlayer();
        pressedLabel(8);
    }//GEN-LAST:event_lb9MousePressed

    private void lb6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb6MousePressed
        changeLblPlayer();
        pressedLabel(5);
    }//GEN-LAST:event_lb6MousePressed

    private void lb2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb2MousePressed
        changeLblPlayer();
        pressedLabel(1);
    }//GEN-LAST:event_lb2MousePressed

    private void lb8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb8MousePressed
        changeLblPlayer();
        pressedLabel(7);
    }//GEN-LAST:event_lb8MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cls();
        changeTurno();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    private javax.swing.JLabel lb8;
    private javax.swing.JLabel lb9;
    private javax.swing.JLabel lbWinO;
    private javax.swing.JLabel lbXwin;
    private javax.swing.JLabel lbl_player;
    // End of variables declaration//GEN-END:variables
}
