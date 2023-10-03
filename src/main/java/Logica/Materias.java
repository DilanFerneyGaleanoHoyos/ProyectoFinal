package Logica;

public class Materias {
  int idMaterias;
  String nombreMateria;
  int codigoMateria;



    public Materias(String nombreMateria, int codigoMateria) {
        this.idMaterias = idMaterias;
        this.nombreMateria = nombreMateria;
        this.codigoMateria = codigoMateria;

    }

    public Materias() {

    }
    public Materias(int idMaterias, String nombreMateria, int codigoMateria) {
        this.idMaterias = idMaterias;
        this.nombreMateria = nombreMateria;
        this.codigoMateria = codigoMateria;
    }

    public int getIdMaterias() {
        return idMaterias;
    }

    public void setIdMaterias(int idMaterias) {
        this.idMaterias = idMaterias;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(int codigoMateria) {
        this.codigoMateria = codigoMateria;
    }



    @Override
    public String toString() {
        return "Materias{" +
                "idMaterias=" + idMaterias +
                ", nombreMateria='" + nombreMateria + '\'' +
                ", codigoMateria=" + codigoMateria +
                '}';
    }
}
