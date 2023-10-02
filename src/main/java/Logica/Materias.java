package Logica;

public class Materias {
  int idMaterias;
  String nombreMateria;
  int codigoMateria;
  double notaFinal=0;


    public Materias(String nombreMateria, int codigoMateria, double notaFinal) {
        this.idMaterias = idMaterias;
        this.nombreMateria = nombreMateria;
        this.codigoMateria = codigoMateria;
        this.notaFinal = notaFinal;
    }

    public Materias() {

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

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
        return "Materias{" +
                "idMaterias=" + idMaterias +
                ", nombreMateria='" + nombreMateria + '\'' +
                ", codigoMateria=" + codigoMateria +
                ", notaFinal=" + notaFinal +
                '}';
    }
}
