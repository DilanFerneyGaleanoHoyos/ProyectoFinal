import Logica.Materias;
import Percistencia.MateriasDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MateriasDAOTest {

    private MateriasDao materiasDAO = new MateriasDao();

    @Test
    void findAll() {
        materiasDAO = new MateriasDao();
        assertNotNull(materiasDAO.findAll());
        materiasDAO.findAll().forEach(System.out::println);
    }

    @Test
    void findById() {
        MateriasDao MateriasDao = new MateriasDao();
        Materias materia = materiasDAO.findById(0);

        assertEquals("null", materia.getNombreMateria());
        assertEquals(0, materia.getCodigoMateria());
        assertEquals(0, materia.getNotaFinal());
    }

    @Test
    void add() {
        materiasDAO = new MateriasDao();
        assertTrue(materiasDAO.add(new Materias("Pogramacion", 67890, 0.0)));
    }

    @Test
    void delete() {
        // Implementa la prueba para eliminar una materia si es necesario.
    }

    @Test
    void update() {
        // Implementa la prueba para actualizar una materia si es necesario.
    }
}
