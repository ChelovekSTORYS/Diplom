import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTests {
    Todos sut;
    String task = "B";

    @BeforeEach
    public void init() {
        sut = new Todos();
    }

    @Test
    public void testAddTask() {
        Todos expected = new Todos();
        expected.listTask.add(task);

        sut.addTask(task);

        Assertions.assertEquals(expected.listTask, sut.listTask);
    }

    @Test
    public void testRemoveTask() {
        Todos expected = new Todos();
        expected.listTask.add(task);

        sut.addTask(task);
        sut.addTask("A");
        sut.removeTask("A");

        Assertions.assertEquals(expected.listTask, sut.listTask);
    }

    @Test
    public void testGetAllTask() {
        Todos list = new Todos();
        list.listTask.add(task);
        list.listTask.add("A");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list.listTask) {
            stringBuilder.append(s).append(" ");
        }
        String expected = stringBuilder.toString();

        sut.addTask(task);
        sut.addTask("A");
        String result = sut.getAllTasks();

        Assertions.assertEquals(expected, result);
    }
}
