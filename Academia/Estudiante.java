package TPE_LinkedList.Academia;

import java.util.ArrayList;

public class Estudiante extends Universitaria {
    protected String nombre;
    protected String apellido;
    protected int dni;
    protected int edad;
    protected ArrayList<String> intereses;

    public Estudiante(){
        this.intereses = new ArrayList<>();
    }
    public Estudiante(String nombre, String apellido, int dni, int edad, ArrayList<String> intereses){
        this();
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        addListaIntereses(intereses);
    }

    private void addListaIntereses(ArrayList<String> intereses) {
        for(String interes : intereses)
            addInteres(interes);
    }

    @Override
    public int getCantidadEstudiantes() {
        return 1;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<String> getIntereses() {
        ArrayList<String> res = new ArrayList<>(intereses);
        return res;
    }

   public void addInteres(String interes){
        intereses.add(interes);
   }
}
