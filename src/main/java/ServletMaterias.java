import Logica.Materias;
import Percistencia.MateriasDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletMaterias", value = "/add-materia")
public class ServletMaterias extends HttpServlet {
    private MateriasDao materiasDao;

    public void init() {
        materiasDao = new MateriasDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Aquí puedes utilizar el MateriasDao para realizar operaciones basadas en la solicitud POST.
        // Por ejemplo, agregar una nueva materia a la base de datos.

        String nombreMateria = request.getParameter("nombreMateria");
        int codigoMateria = Integer.parseInt(request.getParameter("codigoMateria"));
        double notaFinal = Double.parseDouble(request.getParameter("notaFinal"));

        Materias nuevaMateria = new Materias(nombreMateria, codigoMateria, notaFinal);
        boolean exito = materiasDao.add(nuevaMateria);

        if (exito) {
            // La inserción en la base de datos fue exitosa.
            // Puedes redirigir a la página de éxito o mostrar un mensaje de éxito.
            response.sendRedirect("materias.jsp"); // Redirige a una página de éxito
        } else {
            // Ocurrió un error al insertar la materia.
            // Puedes redirigir a la página de error o mostrar un mensaje de error.
            response.sendRedirect("error.html"); // Redirige a una página de error
        }
    }



    public void destroy() {
        // Aquí puedes cerrar cualquier recurso abierto, como conexiones de base de datos.
    }
}
