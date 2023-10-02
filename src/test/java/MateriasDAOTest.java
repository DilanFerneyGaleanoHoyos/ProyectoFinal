import Logica.Materias;
import Percistencia.ActividadesDao;
import Percistencia.MateriasDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MateriasDAOTest {

    private MateriasDao materiasDAO = new MateriasDao();
    private ActividadesDao actividadesDao = new ActividadesDao();

    @Test
    void findAll() {
        materiasDAO = new MateriasDao();
        assertNotNull(materiasDAO.findAll());
        materiasDAO.findAll().forEach(System.out::println);
    }

    @Test
    void findById() {
        MateriasDao MateriasDao = new MateriasDao();
        Materias materia = materiasDAO.findById(1);

        assertEquals("Pogramacion", materia.getNombreMateria());
        assertEquals(1, materia.getCodigoMateria());
        assertEquals(67890, materia.getNotaFinal());
    }

    @Test
    void add() {
        materiasDAO = new MateriasDao();
        assertTrue(materiasDAO.add(new Materias("Programacion", 2289, 0.0)));
    }



    @Test
    void delete() {
        // Implementa la prueba para eliminar una materia si es necesario.
    }

    @Test
    public void testUpdateMateria() {

        Materias materiaToUpdate = new Materias();
        materiaToUpdate.setIdMaterias(2); // Reemplaza con el ID de la materia que deseas actualizar
        materiaToUpdate.setNombreMateria("Fisica");
        materiaToUpdate.setCodigoMateria(12345);
        materiaToUpdate.setNotaFinal(7.0);

        // Llama al método update
        materiasDAO.update(materiaToUpdate);

        // Verifica si la actualización fue exitosa
        Materias updatedMateria = materiasDAO.findById(materiaToUpdate.getIdMaterias());
        assertNotNull(updatedMateria); // Asegurarse de que se haya encontrado la materia
        assertEquals(materiaToUpdate.getNombreMateria(), updatedMateria.getNombreMateria());
        assertEquals(materiaToUpdate.getCodigoMateria(), updatedMateria.getCodigoMateria());
        assertEquals(materiaToUpdate.getNotaFinal(), updatedMateria.getNotaFinal());
    }

}
