package src.main.SkillFactory;

//Создайте объект класса ZonedDateTime c временем и датой текущего момента и с временной зоной города Москва.

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static java.time.LocalTime.now;

public class Time {
    public static void main(String[] args) {


      ZonedDateTime moscowTime =  ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/Moscow"));
      System.out.println(moscowTime);
    }
}