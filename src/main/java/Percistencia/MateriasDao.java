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
                double notaFinal = rs.getDouble("notaFinal");

                list.add(new Materias(nombreMateria, codigoMateria, notaFinal));
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
                double notaFinal = rs.getDouble("notaFinal");

                materia = new Materias(nombreMateria, codigoMateria, notaFinal);
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

        Double city = student.getNotaFinal();

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
            String query = "INSERT INTO materias VALUES('" + id + "','" + name  + "','" + birthday + "','" + city + "')";

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
                Statement statement = connection.createStatement()
        ) {
            String query = "UPDATE materias SET nombreMateria = '" + materia.getNombreMateria() + "', codigoMateria = " + materia.getCodigoMateria() + ", notaFinal = " + materia.getNotaFinal() + " WHERE idMaterias = " + materia.getIdMaterias();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    @Override
    public void close() throws Exception {
        // Agrega la lógica para cerrar conexiones o recursos
    }
}
