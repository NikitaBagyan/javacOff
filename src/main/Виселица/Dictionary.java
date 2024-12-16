package src.main.Виселица;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

 class Dictionary {

    protected static String randomWord() {

        List<String> wordList = new ArrayList<>();
        String outputWord = "";

        try {
            File file = new File("Виселица/Resources");
            Scanner scanner = new Scanner(file); // Создаем сканнер для нашего файла

            while (scanner.hasNext()){//Читаем из файла пока в нем есть слова
                String word = scanner.next();
                wordList.add(word);
            }

            scanner.close();//не забываем закрыть поток чтения

        } catch (FileNotFoundException e) {//Бросаем исключения в случае неверного пути файла
            System.out.println("Файл не найден" + e);
        }

        Random random = new Random(); //Создаем объект класса random

        outputWord = wordList.get(random.nextInt(wordList.size() - 1)); //Берем рандомное слово из массива

        return outputWord;
    }
}
