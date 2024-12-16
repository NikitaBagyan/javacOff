package src.main.Week3.project;

import src.main.Week3.project.UI.*;

public class Main {
    public static void main(String[] args) {
        // Инициализация менеджеров
        AudienceManager audienceManager = new AudienceManagerImpl();
        GroupManager groupManager = new GroupManagerImpl();
        ScheduleManager scheduleManager = new ScheduleManagerImpl();

        // Создание пользовательского интерфейса
        UI userInterface = new UI (audienceManager, groupManager, scheduleManager);

        // Запуск пользовательского интерфейса
        userInterface.start();
    }
}

