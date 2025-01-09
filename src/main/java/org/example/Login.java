package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JTextField textField1; // Para el usuario
    private JPasswordField passwordField1; // Para la contraseña
    private JButton ingresarButton; // Botón de ingreso
    private JLabel loginLabel; // Mensaje de validación
    public JPanel Login; // Panel principal

    public Login() {
        // Agregar listener al botón de ingresar
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                String password = new String(passwordField1.getPassword());

                if (LoginValidation.validarUsuario(username, password)) {
                    loginLabel.setText("Acceso correcto");
                    JOptionPane.showMessageDialog(null, "Bienvenido, " + username);

                    // Crear y mostrar la ventana de Gestion Jugadores
                    new GestionJugadores(); // Esto abrirá la nueva ventana

                } else {
                    loginLabel.setText("Usuario o contraseña incorrectos");
                }
            }
        });
    }
}
