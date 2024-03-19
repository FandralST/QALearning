package tasks.task4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class Task4 {
    Task4_Steps task4_steps = new Task4_Steps();
    Root pet;
    String petName;



    @BeforeEach
    void precondition(){
        pet = new Root();
        petName = "Doom";
    }


    //TODO: переместить path в steps, убрать как параметр из методов
    //TODO: создать preconditions с beforeEach, где будут инициализироваться pet и petName

    @Test
    void Task4() {
        task4_steps.post(petName, pet);
        task4_steps.findAllPets(pet);
        task4_steps.deletePet(pet);
        task4_steps.checkIsDeleted(pet);
    }
}
