package src.main.SkillFactory.Stream;

/*В текущем рабочем каталоге-файле есть список трат в строках, в формате «имя, сумма».
Шаблон balance.txt:
Дима, 510
Катя, 2800
Никита, 1500
Эмилия, 5000
Ярослав, 3000
Андрей
Что нужно сделать?

0. Скопировать текст из задания в файл balance.txt в текущий рабочий каталог.

1. Прочесть файл balance.txt в Map<String, Integer>.

2. Отсортировать строки файла в убывающем порядке.

3. Добавить в конце списка сумму всех трат: "Итого: n руб. (дата формирования файла в формате dd.MM.yyyy)",
пример: "Итого: 100 руб. (01.03.2021)".

4. Сохранить файл как balance_total_ddMMyy.txt, где ddMMyy — это день, число и год слитно.*/


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTask4 {
    public static void main(String[] args) {

        int resultSum;
        try {
            Map<String, Integer> resultMap = Files.readAllLines(Paths.get("src/main/SkillFactory/Stream/balance.txt"))
                    .stream()
                    .map(line -> line.split(", "))
                    .filter(line -> line.length == 2)
                    .collect(Collectors.toMap(
                            part -> part[0],
                            part -> Integer.parseInt(part[1]),
                            (existing, replacement) -> existing,
                            LinkedHashMap::new
                    ))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (existing, replacement) -> existing,
                            LinkedHashMap::new
                    ));
            resultMap.forEach((key, value) -> System.out.println(key + " потратил " + value));

            resultSum = resultMap
                    .values()
                    .stream()
                    .mapToInt(Integer::intValue)
                    .sum();

            LocalDate nowDate = LocalDate.now();
            String spent = "Итого: " + resultSum + " руб. (" + nowDate + ")";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");
            String formateDate = nowDate.format(formatter);

            System.out.println(spent);

            Files.createFile(Paths.get("src/main/SkillFactory/Stream/balance_total_" + formateDate + ".txt"));



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}