package src.main.SkillFactory.FileNio2;
/*
Создайте текстовый файл с таким содержимым:
        1
        12
        123
        1234
        12345
        123456
        1234567
        12345678
        123456789
Теперь запишите содержимое этого файла в другой файл со строками, записанными в обратном порядке.*/
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FileTask {
    public static void main(String[] args) {
        try {

            List<String> stringList = Files.readAllLines(Paths.get("src/main/SkillFactory/FileNio2/text"));

            Collections.reverse(stringList);

            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/main/SkillFactory/FileNio2/text1"), Charset.defaultCharset())) {
                for (String str : stringList) {
                    writer.write(str);
                    writer.newLine();
                }
            }

            System.out.println("Запись завершена успешно.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
