package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTodosFoundEpic() {
        SimpleTask simpleTask = new SimpleTask(1, "Спеть песню");
        String[] subtasks = {"Кукуруза", "Пшено", "Огурцы"};
        Epic epic = new Epic(3, subtasks);
        Meeting meeting = new Meeting(4, "Музыка", "Балалайка", "10.10.2025 15:00");


        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("Огурцы");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTodosFoundSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Спеть песню");
        String[] subtasks = {"Кукуруза", "Пшено", "Огурцы"};
        Epic epic = new Epic(3, subtasks);
        Meeting meeting = new Meeting(4, "Музыка", "Балалайка", "10.10.2025 15:00");


        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Спеть песню");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTodosFoundMeeting() {
        SimpleTask simpleTask = new SimpleTask(1, "Спеть песню");
        String[] subtasks = {"Кукуруза", "Пшено", "Огурцы"};
        Epic epic = new Epic(3, subtasks);
        Meeting meeting = new Meeting(4, "Музыка", "Балалайка", "10.10.2025 15:00");


        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Балалайка");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTodosNotFound() {
        SimpleTask simpleTask = new SimpleTask(1, "Спеть песню");
        String[] subtasks = {"Кукуруза", "Пшено", "Огурцы"};
        Epic epic = new Epic(3, subtasks);
        Meeting meeting = new Meeting(4, "Музыка", "Балалайка", "10.10.2025 15:00");


        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Ножницы");

        Assertions.assertArrayEquals(expected, actual);
    }
}
