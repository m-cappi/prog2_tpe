package TPE_LinkedList.Academia;

import TPE_LinkedList.CustomLinkedList;
import TPE_LinkedList.Node;
import java.util.Comparator;
import java.util.List;

public class Comunidad extends Universitaria {
    CustomLinkedList<Universitaria> listaUniversitaria;
    private String nombre;

    public Comunidad(Comparator<Universitaria> comparadorUniversitario) {
        this.listaUniversitaria = new CustomLinkedList<>(comparadorUniversitario);
    }

    public Comunidad(Comparator<Universitaria> comparadorUniversitario, String nombre) {
        this(comparadorUniversitario);
        this.nombre = nombre;
    }

    public void addListaUniversitaria(List<Universitaria> listaFactultades) {
        for (Universitaria facu : listaFactultades) {
            addUniversitaria(facu);
        }
    }

    public void addUniversitaria(Universitaria universitaria) {
        listaUniversitaria.addElement(universitaria);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getCantidadEstudiantes() {
        int res = 0;
        for (Node<Universitaria> univ : listaUniversitaria)
            res += univ.getData().getCantidadEstudiantes();
        return res;
    }
}
