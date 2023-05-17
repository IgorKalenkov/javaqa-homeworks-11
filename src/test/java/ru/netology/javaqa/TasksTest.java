package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldMatchesSimpleTaskTrue() {
        SimpleTask task = new SimpleTask(1, "Зарядка");

        boolean expected = true;
        boolean actual = task.matches("Зарядка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesSimpleTaskFalse() {
        SimpleTask task = new SimpleTask(1, "Пробежка");

        boolean expected = false;
        boolean actual = task.matches("Зарядка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesEpicTrue() {
        String[] subtasks = {"Булка", "Гречка", "Сахар"};

        Epic task = new Epic(2, subtasks);

        boolean expected = true;
        boolean actual = task.matches("Сахар");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldMatchesEpicFalse() {
        String[] subtasks = {"Булка", "Гречка", "Сахар"};

        Epic task = new Epic(2, subtasks);

        boolean expected = false;
        boolean actual = task.matches("Зарядка");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldMatchesMeetingTrue() {
        Meeting task = new Meeting(1, "Путешествия", "Австралия", "10.10.2025 15:00");

        boolean expected = true;
        boolean actual = task.matches("Австралия");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesMeetingFalse() {
        Meeting task = new Meeting(1, "Путешествия", "Австралия", "10.10.2025 15:00");

        boolean expected = false;
        boolean actual = task.matches("Швейцария");
        Assertions.assertEquals(expected, actual);
    }
}
