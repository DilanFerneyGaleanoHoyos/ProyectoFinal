import Logica.Actividades;
import Percistencia.ActividadesDao;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletActivities", value = "/servlet-activities")
public class ServletActivities extends HttpServlet {

    private ActividadesDao actividadesDAO;

    @Override
    public void init() throws ServletException {
        actividadesDAO = new ActividadesDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        Gson gson = new Gson();

        List<Actividades> actividades = actividadesDAO.findAll();

        PrintWriter out = response.getWriter();
        out.println(gson.toJson(actividades));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Aquí puedes agregar código para manejar las solicitudes POST, como agregar nuevas actividades a la base de datos.
    }
}
