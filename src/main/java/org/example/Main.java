package org.example;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Main {
    public static void main(String[] args) throws SQLException{

        String url="jdbc:mysql://localhost:3306/operadores";
        String user="root";
        String password="12345";

        String query = "SELECT * FROM clientes";

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