package Percistencia;

import Logica.Actividades;
import Logica.Actividades.TipoActividad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public  class ActividadesDao implements InterfaceDAO<Actividades> {
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://127.0.0.1:3306/mydb?allowPublicKeyRetrieval=true&useSSL=false";
    private final String USER = "Dilan";
    private final String PASSWORD = "123";

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

    public boolean add(Actividades actividades) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Actividades (actividadesNombre, tipoActividad, fechaEntrega, ponderado, Materias_idMaterias) VALUES (?, ?, ?, ?, ?)")
        ) {
            statement.setString(1, actividades.getActividadesNombre());
            statement.setString(2, actividades.getTipoActividad().name());
            statement.setDate(3, new java.sql.Date(actividades.getFechaEntrega().getTime()));
            statement.setInt(4, actividades.getPonderado());
            statement.setInt(5, actividades.getMateriasId());

            int rows = statement.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(Integer id) {
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

    public Actividades update(Actividades actividades) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("UPDATE Actividades SET actividadesNombre = ?, tipoActividad = ?, fechaEntrega = ?, ponderado = ?, Materias_idMaterias = ? WHERE idActividades = ?")
        ) {
            statement.setString(1, actividades.getActividadesNombre());
            statement.setString(2, actividades.getTipoActividad().name());
            statement.setDate(3, new java.sql.Date(actividades.getFechaEntrega().getTime()));
            statement.setInt(4, actividades.getPonderado());
            statement.setInt(5, actividades.getMateriasId());
            statement.setInt(6, actividades.getIdActividades());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                return actividades;
            } else {
                return null; // O devuelve un valor apropiado en caso de fallo
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // O devuelve un valor apropiado en caso de excepción
        }
    }


    @Override
    public void close() throws Exception {

    }
}
