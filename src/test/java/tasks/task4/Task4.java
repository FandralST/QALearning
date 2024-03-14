package tasks.task4;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class Task4 {
    Task4_Steps task4_steps = new Task4_Steps();
    private final String path = "https://petstore.swagger.io/v2/";
    Root pet = new Root();
    String petName = "Doom";

    //TODO: переместить path в steps, убрать как параметр из методов
    //TODO: создать preconditions с beforeEach, где будут инициализироваться pet и petName

    @Test
    void Task4() {
        task4_steps.post(path,petName, pet);
        task4_steps.getAfterPost(path, pet);
        task4_steps.delete(path,pet);
        task4_steps.getAfterDelete(path, pet);
    }
}
