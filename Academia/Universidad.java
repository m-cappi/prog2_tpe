package TPE_LinkedList.Academia;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    List<Facultad> facultades;

    public Universidad(List<Facultad> listaFactultades) {
        this.facultades = new ArrayList<>();
        addListaFacultades(listaFactultades);
    }

    public void addListaFacultades(List<Facultad> listaFactultades) {
        for (Facultad facu : listaFactultades) {
            addFacultad(facu);
        }
    }

    public void addFacultad(Facultad facultad) {
        facultades.add(facultad);
    }

    public List<Facultad> getFacultades() {
        return new ArrayList<>(facultades);
    }
}
