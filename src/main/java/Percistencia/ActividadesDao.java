package Percistencia;

import Logica.Actividades;
import Logica.Actividades.TipoActividad;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public  class ActividadesDao implements InterfaceDAO<Actividades> {
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://127.0.0.1:3306/mydb?allowPublicKeyRetrieval=true&useSSL=false";
    private final String USER = "root";
    private final String PASSWORD = "";

    public List<Actividades> findAll() {
        List<Actividades> actividadesList = new ArrayList<>();
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Actividades");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int idActividades = resultSet.getInt("idActividades");
                String actividadesNombre = resultSet.getString("actividadesNombre");
                TipoActividad tipoActividad = TipoActividad.valueOf(resultSet.getString("tipoActividad"));
                Date fechaEntrega = resultSet.getDate("fechaEntrega");
                int ponderado = resultSet.getInt("ponderado");
                int materiasId = resultSet.getInt("Materias_idMaterias");

                Actividades actividades = new Actividades(idActividades, actividadesNombre, tipoActividad, fechaEntrega, ponderado, materiasId);
                actividadesList.add(actividades);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return actividadesList;
    }

    @Override
    public Actividades findById(Integer id) {
        return null;
    }

    public Actividades findById(int id) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Actividades WHERE idActividades = ?");
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int idActividades = resultSet.getInt("idActividades");
                String actividadesNombre = resultSet.getString("actividadesNombre");
                TipoActividad tipoActividad = TipoActividad.valueOf(resultSet.getString("tipoActividad"));
                Date fechaEntrega = resultSet.getDate("fechaEntrega");
                int ponderado = resultSet.getInt("ponderado");
                int materiasId = resultSet.getInt("Materias_idMaterias");

                return new Actividades(idActividades, actividadesNombre, tipoActividad, fechaEntrega, ponderado, materiasId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean add(Actividades student) {

        String id = "0";

        String name = student.getActividadesNombre();

        TipoActividad city = student.getTipoActividad();

        Date fechaEntrega = student.getFechaEntrega();
        java.sql.Date Fecha = (fechaEntrega != null) ? new java.sql.Date(fechaEntrega.getTime()) : null;

        int ponderado =student.getPonderado();
       int Materias_idMaterias = student.getMateriasId();
        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try(
                Connection connection = DriverManager.getConnection(URL, USER,PASSWORD);
                Statement statement = connection.createStatement();
        ){
            String query = "INSERT INTO actividades VALUES('" + id + "','" + name  + "','" + city + "','" + Fecha +  "','" + ponderado + "','" + Materias_idMaterias +"')";

            int rows = statement.executeUpdate( query );

            return rows > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public boolean delete(Integer id) {
        return false;
    }


    @Override
    public boolean update(Actividades materia) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                // Usar PreparedStatement para la consulta SQL
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE actividades SET actividadesNombre = ?, tipoActividad = ?, fechaEntrega = ?, Ponderado = ?, Materias_idMaterias = ? WHERE idActividades = ?")
        ) {
            // Configurar los parámetros en el PreparedStatement
            preparedStatement.setString(1, materia.getActividadesNombre());
            preparedStatement.setInt(2, materia.getIdActividades());
            preparedStatement.setDate(3, new java.sql.Date(materia.getFechaEntrega().getTime()));
            preparedStatement.setInt(4, materia.getPonderado());
            preparedStatement.setInt(5, materia.getMateriasId());
            preparedStatement.setInt(6, materia.getIdActividades());

            // Ejecutar la actualización
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0; // Retorna verdadero si al menos una fila se vio afectada
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    public boolean delete(int id) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Actividades WHERE idActividades = ?")
        ) {
            statement.setInt(1, id);

            int rows = statement.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }





    @Override
    public void close() throws Exception {

    }
}
