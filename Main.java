package TPE_LinkedList;

import TPE_LinkedList.Academia.Comparadores.CCantAlumnos;
import TPE_LinkedList.Academia.Comunidad;
import TPE_LinkedList.Academia.Estudiante;
import TPE_LinkedList.Academia.Universitaria;
import TPE_LinkedList.Comparator.StringReverse;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[]args){

       CustomLinkedList<Integer> integerCustomLinkedList = new CustomLinkedList<>(Integer::compareTo);
       integerCustomLinkedList.addElement(10);
       integerCustomLinkedList.addElement(21);
       integerCustomLinkedList.addElement(1);
       integerCustomLinkedList.addElement(5);
       integerCustomLinkedList.addElement(11);
        integerCustomLinkedList.forEach(System.out::println);
        integerCustomLinkedList.deleteBy(0);
        integerCustomLinkedList.forEach(System.out::println);
        integerCustomLinkedList.deleteBy(new Integer(5));
        integerCustomLinkedList.forEach(System.out::println);
        integerCustomLinkedList.deleteBy(new Integer(11));
        integerCustomLinkedList.forEach(System.out::println);
        CustomLinkedList<String> stringCustomLinkedList = new CustomLinkedList<>(String::compareTo);
        stringCustomLinkedList.addElement("Facil");
        stringCustomLinkedList.addElement("Es");
        stringCustomLinkedList.addElement("Parcial");
        stringCustomLinkedList.addElement("Prog 2");
        stringCustomLinkedList.forEach(System.out::println);
        System.out.println(stringCustomLinkedList.getIndexBy("Recuperatorio"));
        System.out.println(stringCustomLinkedList.getIndexBy("Parcial"));
        stringCustomLinkedList.setComparator(new StringReverse());
        stringCustomLinkedList.forEach(System.out::println);

        Comunidad unicen = new Comunidad(new CCantAlumnos(), "Unicen");
        Comunidad exactas = new Comunidad(new CCantAlumnos(), "Exactas");
        Comunidad humanas = new Comunidad(new CCantAlumnos(), "Humanas");
        Comunidad historia = new Comunidad(new CCantAlumnos(), "Historia");


        //Declaracion Listas de estudiantes e intereses
        ArrayList<String> flopezIntereses= new ArrayList<>();
        flopezIntereses.add("redes");
        flopezIntereses.add("php");
        flopezIntereses.add("java");
        flopezIntereses.add("python");
        Estudiante flopez = new Estudiante("Federico", "Lopez",35999888, 31,flopezIntereses);
        ArrayList<String> jgarciaIntereses= new ArrayList<>();
        flopezIntereses.add("programacion");
        flopezIntereses.add("php");
        flopezIntereses.add("java");
        Estudiante jgarcia = new Estudiante("Juana", "Garcia",27123455, 21,jgarciaIntereses);
        ArrayList<String> jDoeIntereses = new ArrayList<>();
        jDoeIntereses.add("intercambio");
        Estudiante jDoe = new Estudiante("John", "Doe", 1200000, 34, jDoeIntereses);
        ArrayList<String> mdiazIntereses = new ArrayList<>();
        mdiazIntereses.add("psicologia");
        mdiazIntereses.add("freud");
        Estudiante mDiaz = new Estudiante("Mora", "Diaz", 37124425, 35, mdiazIntereses);
        ArrayList<String> frivasIntereses = new ArrayList<>();
        frivasIntereses.add("historia");
        frivasIntereses.add("antigua");
        Estudiante fRivas = new Estudiante("Flora", "Rivas", 34555111, 33, frivasIntereses);
        ArrayList<String> mgomezIntereses = new ArrayList<>();
        mgomezIntereses.add("romanos");
        mgomezIntereses.add("egipcios");
        mgomezIntereses.add("griegos");
        Estudiante mGomez = new Estudiante("Martin", "Gomez", 34111222, 36, mgomezIntereses);
        ArrayList<String> rbazanIntereses = new ArrayList<>();
        rbazanIntereses.add("argentina");
        Estudiante rBazan = new Estudiante("Roman","Bazan",32555111, 47, rbazanIntereses);
        unicen.addUniversitaria(exactas);
        unicen.addUniversitaria(humanas);
        unicen.addUniversitaria(jDoe);
        exactas.addUniversitaria(flopez);
        exactas.addUniversitaria(jgarcia);
        humanas.addUniversitaria(historia);
        humanas.addUniversitaria(mDiaz);
        historia.addUniversitaria(fRivas);
        historia.addUniversitaria(mGomez);
        historia.addUniversitaria(rBazan);


        Comunidad olimpiadasMatematicas = new Comunidad(new CCantAlumnos(), "Olimpiadas Matematicas");
        Comunidad matea2 = new Comunidad(new CCantAlumnos(), "Matea2");
        Comunidad losFibo = new Comunidad(new CCantAlumnos(), "LosFibo");

        ArrayList<String> jjuarezIntereses = new ArrayList<>();
        mdiazIntereses.add("sucesiones");
        mdiazIntereses.add("algebra");
        Estudiante jJuarez = new Estudiante("Juan", "Juarez", 33222444, 35, jjuarezIntereses);
        ArrayList<String> jcesarIntereses = new ArrayList<>();
        mdiazIntereses.add("sucesiones");
        mdiazIntereses.add("algebra");
        Estudiante jCesar = new Estudiante("Julio", "Cesar", 33222111, 35, jcesarIntereses);
        ArrayList<String> brivasIntereses = new ArrayList<>();
        mdiazIntereses.add("matematicas");
        Estudiante bRivas = new Estudiante("Bernardino", "Rivas", 30987654, 22, brivasIntereses);
        ArrayList<String> jpasoIntereses = new ArrayList<>();
        mdiazIntereses.add("problemas");
        Estudiante jPaso = new Estudiante("Jose", "Paso", 33322112, 38, jpasoIntereses);
        ArrayList<String> inewtonIntereses = new ArrayList<>();
        mdiazIntereses.add("sucesiones");
        Estudiante iNewton = new Estudiante("Isaac", "Newton", 12343565, 379, inewtonIntereses);
        matea2.addUniversitaria(jJuarez);
        matea2.addUniversitaria(jCesar);
        losFibo.addUniversitaria(bRivas);
        losFibo.addUniversitaria(jPaso);
        losFibo.addUniversitaria(iNewton);
        olimpiadasMatematicas.addUniversitaria(matea2);
        olimpiadasMatematicas.addUniversitaria(losFibo);
    }

}
