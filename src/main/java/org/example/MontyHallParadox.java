package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHallParadox {
    public static void main(String[] args) {
        int iterationCount = 1000;

        Map<Integer, String> results = playMontyHall(iterationCount);

        int winCount = 0;
        int loseCount = 0;

        // Статистика игры
        for (String result : results.values()) {
            if (result.equals("win")) {
                winCount++;
            } else if (result.equals("lose")) {
                loseCount++;
            }
        }

        System.out.println("Победы: " + winCount);
        System.out.println("Поражения: " + loseCount);
    }

    private static Map<Integer, String> playMontyHall(int iterationCount) {
        Random random = new Random();
        Map<Integer, String> results = new HashMap<>();

        for (int i = 1; i <= iterationCount; i++) {
            int winningDoor = random.nextInt(3) + 1;
            int chosenDoor = random.nextInt(3) + 1;


            int openedDoor;
            do {
                openedDoor = random.nextInt(3) + 1;
            } while (openedDoor == winningDoor || openedDoor == chosenDoor);

            // Переключение на другую дверь
            int switchedDoor;
            do {
                switchedDoor = random.nextInt(3) + 1;
            } while (switchedDoor == chosenDoor || switchedDoor == openedDoor);

            // Проверка результата и сохранение
            if (switchedDoor == winningDoor) {
                results.put(i, "win");
            } else {
                results.put(i, "lose");
            }
        }

        return results;
    }
}
