package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registro {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton enviarButton;
    private JButton loginButton;
    public JPanel Registro;

    public Registro() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
            }
        });
    }
    private void registrarUsuario() {
        String username = textField1.getText();
        String contrasena = textField2.getText();
        String nombre = textField3.getText();
        String apellido = textField4.getText();
        String edadTexto = textField5.getText();

        // Validación de campos vacíos
        if (username.isEmpty() || contrasena.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || edadTexto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            return;
        }

        int edad;

        // Inserción en la base de datos
        String sql = "INSERT INTO UsuarioNatacion (username, contrasena, nombre, apellido, edad) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, username);
            statement.setString(2, contrasena);
            statement.setString(3, nombre);
            statement.setString(4, apellido);
            statement.setInt(5, edad);

            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario: " + e.getMessage());
        }
    }
}
