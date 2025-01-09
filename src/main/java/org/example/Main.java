package org.example;
import javax.swing.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Main {
    public static void main(String[] args) throws SQLException{

            JFrame frame = new JFrame("Registro");
            // Establecer el contenido del JFrame como el panel del formulario de Registro
            frame.setContentPane(new Registro().Registro);
            // Configurar operación de cierre
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Ajustar el tamaño automáticamente al contenido
            frame.pack();
            // Hacer visible la ventana
            frame.setVisible(true);


        String url="jdbc:mysql://localhost:3306/Natacion";
        String user="root";
        String password="12345";

        String query = "SELECT * FROM UsuarioNatacion";

        try (Connection con=DriverManager.getConnection(url,user,password)){
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            System.out.println("Conectado");
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String nombre=resultSet.getNString("nombre");
                String apellido=resultSet.getNString("apellido");
                String correo=resultSet.getNString("correo");

                System.out.println("id: " + id + " nombre: " + nombre + " apellido: " + apellido + " correo: " + correo);
            }
        }
        catch (Exception e){
            Exception e1 = e;
            e.printStackTrace();
        }
    }


    }
