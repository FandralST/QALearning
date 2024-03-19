package tasks.task4;

import Core.APIcore.Specification.BaseSpecification;
import io.restassured.common.mapper.TypeRef;

import java.util.List;
import java.util.stream.Collectors;

import static Core.APIcore.Specification.BaseSpecification.getBaseSpec;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4_Steps {
    private final String path = "https://petstore.swagger.io/v2/";
    //TODO:переименовать post->createPet,getAfterPost-> findAllPets, delete->deletePet, getAfterDelete->checkIsDeleted
    public void post(String petName, Root pet) {
        BaseSpecification.installSpecification(getBaseSpec(path), BaseSpecification.responseSpecificationOK200().response());
        pet.setName(petName);
        pet.setStatus("available");
        SuccessReg successReg = given()
                .body(pet)
                .log().all()
                .when()
                .post("pet")
                .then().log().all()
                .extract().as(SuccessReg.class);
        pet.setId(successReg.getId());
        assertThat(pet.getName()).isEqualTo(successReg.getName());
    }

    public void findAllPets(Root pet){
        BaseSpecification.installSpecification(getBaseSpec(path), BaseSpecification.responseSpecificationOK200().response());
        List<Root> petList = given()
                .when()
                .log().all()
                .get("pet/findByStatus?status=available")
                .then()
                .extract().as(new TypeRef<List<Root>>(){});
        List <String> idS = petList.stream().map(x->x.getId().toString()).collect(Collectors.toList());
        assertThat(idS).contains(pet.getId().toString());
    }

    public void deletePet(Root pet){
        BaseSpecification.installSpecification(getBaseSpec(path), BaseSpecification.responseSpecificationOK404().response());
        given()
                .when()
                .delete(String.format(path,"pet/", pet.getId()))
                .then().log().all();
    }

    public void checkIsDeleted(Root pet){
        BaseSpecification.installSpecification(getBaseSpec(path), BaseSpecification.responseSpecificationOK200().response());
        List<Root> petList = given()
                .when()
                .log().all()
                .get("pet/findByStatus?status=available")
                .then()
                .extract().as(new TypeRef<List<Root>>(){});
        List <String> idS = petList.stream().map(x->x.getId().toString()).collect(Collectors.toList());
        assertThat(idS).doesNotContain(pet.getId().toString());
    }
}

