package src.main.Week1;

//Создайте класс Customer со свойствами имя и ID и коллекцией покупок. Реализуйте методы для добавления новой покупки и получения списка покупок. Покажите использование коллекции для хранения покупателей и их информации.

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name = "Игорян";
    static int id = 1;
    static List<String> purshases = new ArrayList<>();


    protected void purshaseAdd(String product) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Покупку номер " + id + " совершил " + name);
        purshases.add(stringBuilder.toString());
    }
    protected void purshaseGet(){

        for (String str : purshases) {
            System.out.println(str);
        }
    }


    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.purshaseAdd("Каша");
        customer.purshaseGet();
    }
}
