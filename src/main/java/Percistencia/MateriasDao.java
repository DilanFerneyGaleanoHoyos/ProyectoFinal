package Percistencia;

import Logica.Materias;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MateriasDao implements InterfaceDAO<Materias> {
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://127.0.0.1:3306/mydb?allowPublicKeyRetrieval=true&useSSL=false"; // Cambia "db_uptc" por "mydb"
    private final String USER = "root";
    private final String PASSWORD = "";

    @Override
    public List<Materias> findAll() { // Corregido el tipo de retorno a List<Materias>
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM Materias"; // Corregido el nombre de la tabla
            ResultSet rs = statement.executeQuery(query);
            List<Materias> list = new ArrayList<>();

            while (rs.next()) {
                Integer idMaterias = rs.getInt("idMaterias"); // Corregido el índice a los nombres de las columnas
                String nombreMateria = rs.getString("nombreMateria");
                int codigoMateria = rs.getInt("codigoMateria");


                list.add(new Materias(nombreMateria, codigoMateria));
            }

            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Materias findById(Integer idFind) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM Materias WHERE idMaterias='" + idFind + "'";
            ResultSet rs = statement.executeQuery(query);
            Materias materia = null;

            while (rs.next()) {
                Integer idMaterias = rs.getInt("idMaterias");
                String nombreMateria = rs.getString("nombreMateria");
                int codigoMateria = rs.getInt("codigoMateria");
                materia = new Materias(nombreMateria, codigoMateria);
            }

            return materia;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean add(Materias student) {

        String id = "0";

        String name = student.getNombreMateria();



        int birthday = student.getCodigoMateria();

        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try(
                Connection connection = DriverManager.getConnection(URL, USER,PASSWORD);
                Statement statement = connection.createStatement();
        ){
            String query = "INSERT INTO materias VALUES('" + id + "','" + name  + "','" + birthday +  "')";

            int rows = statement.executeUpdate( query );

            return rows > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean delete(Integer id) {
        // Agrega la lógica para eliminar un registro en la base de datos
        return false;
    }

    @Override

    public boolean update(Materias materia) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE materias SET nombreMateria = ?, codigoMateria = ? WHERE idMaterias = ?")
        ) {
            preparedStatement.setString(1, materia.getNombreMateria());
            preparedStatement.setInt(2, materia.getCodigoMateria());
            preparedStatement.setInt(3, materia.getIdMaterias());

            int rowsUpdated = preparedStatement.executeUpdate();

            return rowsUpdated > 0; // Devuelve true si se actualizó al menos una fila, de lo contrario, devuelve false.
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }




    @Override
    public void close() throws Exception {
        // Agrega la lógica para cerrar conexiones o recursos
    }
}
