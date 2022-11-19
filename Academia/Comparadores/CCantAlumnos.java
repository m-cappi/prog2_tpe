package TPE_LinkedList.Academia.Comparadores;

import TPE_LinkedList.Academia.Universitaria;

import java.util.Comparator;

public class CCantAlumnos implements Comparator<Universitaria> {
    @Override
    public int compare(Universitaria o1, Universitaria o2) {
        return o1.getCantidadEstudiantes() - o2.getCantidadEstudiantes();
    }

}
