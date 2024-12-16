package src.main.Week1.InterfaceTask;

public class Document implements Translatable{
    @Override
    public void translate(String input) {

        if (input.equals("document")){
            System.out.println("Документ");
        }
    }
}
