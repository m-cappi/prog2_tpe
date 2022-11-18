package TPE_LinkedList.Academia;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Universitaria {
    protected String nombre;
    protected String apellido;
    protected int dni;
    protected int edad;
    protected List<String> intereses;

    public Estudiante(String nombre, String apellido, int dni, int edad, List<String> intereses){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.intereses = intereses;
    }

    @Override
    public int getCantidadEstudiantes() {
        return 1;
    }
    //setters getters;

}
