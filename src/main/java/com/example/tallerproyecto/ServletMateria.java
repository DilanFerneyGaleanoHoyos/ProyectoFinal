package com.example.tallerproyecto;

import Logica.Materias;
import Percistencia.MateriasDao;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletMateria", urlPatterns = {"/ServletMateria"})
public class ServletMateria extends HttpServlet {

    private MateriasDao materiasDao;

    public void init() {
        materiasDao = new MateriasDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");

        PrintWriter out = response.getWriter();

        List<Materias> materiasList = materiasDao.findAll();

        Gson gson = new Gson();

        out.print(gson.toJson(materiasList));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        boolean add = Boolean.parseBoolean(request.getParameter("add"));

        if (add) {
            String nombreMateria = request.getParameter("nombreMateria");
            int codigoMateria = Integer.parseInt(request.getParameter("codigoMateria"));

            Materias materia = new Materias(nombreMateria, codigoMateria);

            try (PrintWriter out = response.getWriter()) {
                if (materiasDao.add(materia)) {
                    out.print("{\"state\":true}");
                } else {
                    out.print("{\"state\":false}");
                }
            }
        } else {
            boolean update = Boolean.parseBoolean(request.getParameter("update"));
            boolean delete = Boolean.parseBoolean(request.getParameter("delete"));

            if (update) {
                int idMaterias = Integer.parseInt(request.getParameter("idMaterias"));
                String nombreMateria = request.getParameter("ServletMateria");
                int codigoMateria = Integer.parseInt(request.getParameter("codigoMateria"));

                Materias materia = new Materias(idMaterias, nombreMateria, codigoMateria);

                try (PrintWriter out = response.getWriter()) {
                    if (materiasDao.update(materia)) {
                        out.print("{\"state\":true}");
                    } else {
                        out.print("{\"state\":false}");
                    }
                }
            } else if (delete) {
                String idMaterias = request.getParameter("idMaterias");

                try (PrintWriter out = response.getWriter()) {
                    if (materiasDao.delete(Integer.parseInt(idMaterias))) {
                        out.print("{\"state\":true}");
                    } else {
                        out.print("{\"state\":false}");
                    }
                }
            }
        }
    }
}
