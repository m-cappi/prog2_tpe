package TPE_LinkedList;

public class Main {

    public static void main(String[]args){
        CustomLinkedList<String> cappiLinkedList = new CustomLinkedList<>();
        cappiLinkedList.addElement("pete");
        cappiLinkedList.addElement("pito");
        //cappiLinkedList.addElementAt("AAA", 1);
        System.out.println(cappiLinkedList.getFirst().toString());
        System.out.println(cappiLinkedList.getLast().toString());
        System.out.println(cappiLinkedList.getLength());

    }

}
