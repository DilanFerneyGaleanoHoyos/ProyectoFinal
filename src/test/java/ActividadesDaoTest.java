import Logica.Actividades;
import Percistencia.ActividadesDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActividadesDaoTest {
    private ActividadesDao actividadesDao;

    @BeforeEach
    public void setUp() {
        // Puedes inicializar cualquier configuración necesaria antes de cada prueba aquí.
        actividadesDao = new ActividadesDao();
    }

    @Test
    public void testAddActividad() {
        // Crea un objeto Actividades para la prueba
        Actividades actividad = new Actividades();
        actividad.setActividadesNombre("Evalua");
        actividad.setTipoActividad(Actividades.TipoActividad.Otros); // Cambia al valor que necesites
        actividad.setFechaEntrega(new Date());
        actividad.setPonderado(12);
        actividad.setMateriasId(2); // Cambia al valor correcto

        // Llama al método add y verifica si se ha agregado con éxito
        boolean added = actividadesDao.add(actividad);

        // Comprueba si la actividad se ha agregado correctamente
        assertTrue(added);
    }

    @Test
    public void testUpdateActividad() {
        // Crear un objeto Actividades con los datos de prueba
        Actividades actividadToUpdate = new Actividades();
        actividadToUpdate.setIdActividades(1);  // ID existente en tu base de datos
        actividadToUpdate.setActividadesNombre("Nueva Actividad");
        actividadToUpdate.setTipoActividad(Actividades.TipoActividad.Talleres);  // O el tipo de actividad que desees
        actividadToUpdate.setFechaEntrega(new Date());  // Fecha de entrega válida
        actividadToUpdate.setPonderado(20);  // Ponderado válido
        actividadToUpdate.setMateriasId(2);  // ID de la materia existente

        // Intentar actualizar la actividad y verificar si fue exitosa
        boolean updateResult = actividadesDao.update(actividadToUpdate);

        assertTrue(updateResult);
    }
}
