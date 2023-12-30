/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luissdev.gestiondeusuarios.dao;

//import java.lang.System.Logger;
//import java.lang.System.Logger.Level;
//import java.lang.System.Logger;
import com.luissdev.gestiondeusuarios.models.Usuarios;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


/**
 *
 * @author luissdev
 */
public class UsuarioDao {
    
    public Connection conexion() throws SQLException{
        
        String db = "db_gestion_usuarios";
        String user = "root";
        String password = "";
        String host = "localhost";
        String port = "3306";
        String driver = "com.mysql.cj.jdbc.Driver";
        
        String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=false";

        Connection connection = null;
        
        
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(urlConnection, user, password);
            System.out.println("Connected to DB");
        } catch (Exception ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,null, ex);
            System.out.println("Failed connect to DB");
            Logger.getLogger(UsuarioDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            System.out.println("Finishing connection");
            connection.close();
        }
        
        return connection;
    }
   
    
    public void agregarUsuario(Usuarios usuario) throws SQLException{

        try {
            Connection connection = conexion();
            String sql = "INSERT INTO usuarios (nombre,apellidos,direccion,telefono) VALUES ("+"\""+usuario.getNombre()+"\",\""+usuario.getApellidos()+"\",\""+usuario.getDireccion()+"\",\""+usuario.getTelefono()+"\");";
            System.out.println(sql);
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (Exception ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,null, ex);
            System.out.println("Failed connect to DB");
            Logger.getLogger(UsuarioDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            System.out.println("Finishing connection");
        }   
    }
    
    public List<Usuarios> listarUsuarios() throws SQLException{
        
        List<Usuarios> listado = new ArrayList<>();
        
        try {
            Connection connection = conexion();
            
            String sql = "SELECT * FROM usuarios;";
            System.out.println(sql);
            Statement statement = connection.createStatement();
            // Cambia el comando para que retorne las filas
            ResultSet resultado =  statement.executeQuery(sql);
            while(resultado.next()) {
                Usuarios usuarioRegistrado = new Usuarios();
                usuarioRegistrado.setId(resultado.getString("id"));
                usuarioRegistrado.setNombre(resultado.getString("nombre"));
                usuarioRegistrado.setApellidos(resultado.getString("apellidos"));
                usuarioRegistrado.setDireccion(resultado.getString("direccion"));
                usuarioRegistrado.setTelefono(resultado.getString("telefono"));
                listado.add(usuarioRegistrado);
            }
             
        } catch (Exception ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,null, ex);
            System.out.println("Failed connect to DB");
            Logger.getLogger(UsuarioDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return listado;
    }
    
    public void editUsuario(Usuarios usuario) throws SQLException{
        
        try {
            Connection connection = conexion();
            String sql = " UPDATE usuarios SET nombre =\""+usuario.getNombre()+"\", apellidos = \""+usuario.getApellidos()+"\", direccion = \""+usuario.getDireccion()+"\", telefono=\""+usuario.getTelefono()+"\"  WHERE id = "+usuario.getId()+";";
            System.out.println(sql);
            Statement statement = connection.createStatement();
            statement.execute(sql);
             
        } catch (Exception ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,null, ex);
            System.out.println("Failed connect to DB");
            Logger.getLogger(UsuarioDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public void deleteUsuario(String id) throws SQLException{
        
        try {
            Connection connection = conexion();
            String sql = "DELETE FROM usuarios WHERE id="+id+";";
            System.out.println(sql);
            Statement statement = connection.createStatement();
            // Cambia el comando para que retorne las filas
            statement.execute(sql);
             
        } catch (Exception ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,null, ex);
            System.out.println("Failed connect to DB");
            Logger.getLogger(UsuarioDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }


}
