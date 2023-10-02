package Logica;

import java.time.LocalDate;
import java.util.Date;

public class Actividades {
    private int idActividades;
    private String actividadesNombre;
    private TipoActividad tipoActividad;
    private Date fechaEntrega;
    private int ponderado;
    private int materiasId; // Esto corresponde a la relación con Materias

    public Actividades() {

    }

    public enum TipoActividad {

        Talleres,
        Proyecto,
        Evalucion,
        Otros;

    }

    public Actividades(String trabajo, String taller, LocalDate localDate, int i, int i1) {
        // Constructor vacío
    }

    public Actividades(int idActividades, String actividadesNombre, TipoActividad tipoActividad, Date fechaEntrega, int ponderado, int materiasId) {
        this.idActividades = idActividades;
        this.actividadesNombre = actividadesNombre;
        this.tipoActividad = tipoActividad;
        this.fechaEntrega = fechaEntrega;
        this.ponderado = ponderado;
        this.materiasId = materiasId;
    }

    public int getIdActividades() {
        return idActividades;
    }

    public void setIdActividades(int idActividades) {
        this.idActividades = idActividades;
    }

    public String getActividadesNombre() {
        return actividadesNombre;
    }

    public void setActividadesNombre(String actividadesNombre) {
        this.actividadesNombre = actividadesNombre;
    }

    public TipoActividad getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(TipoActividad tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getPonderado() {
        return ponderado;
    }

    public void setPonderado(int ponderado) {
        this.ponderado = ponderado;
    }

    public int getMateriasId() {
        return materiasId;
    }

    public void setMateriasId(int materiasId) {
        this.materiasId = materiasId;
    }
}

