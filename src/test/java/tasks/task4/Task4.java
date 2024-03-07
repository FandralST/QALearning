package tasks.task4;

import Core.APIcore.Specification.BaseSpecification;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static Core.APIcore.Specification.BaseSpecification.getBaseSpec;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class Task4 {

    private final String path = "https://petstore.swagger.io/v2/";


    @Test
    void postTask4() {
        //post
        BaseSpecification.installSpecification(getBaseSpec(path), BaseSpecification.responseSpecificationOK200().response());
        String name = "WeeWee";
        Root pet = new Root();
        pet.setName(name);
        SuccessReg successReg = given()
                .body(pet)
                .log().all()
                .when()
                .post("pet")
                .then().log().all()
                .extract().as(SuccessReg.class);
        assertThat(name).isEqualTo(successReg.getName());


        //get after post
        List<Root> petList = given()
                .when()
                .log().all()
                .get("pet/findByStatus?status=available")
                .then()
                .extract().as(new TypeRef<List<Root>>(){});

        System.out.println(successReg.getId());
        //System.out.println(petList.get(0).getId());
        List <String> ids = petList.stream().map(x->x.getId().toString()).collect(Collectors.toList());
        for (int i=0; i<ids.size(); i++){
            assertThat(successReg.getId().toString()).contains(ids.get(i));
        }

        /*List <String> names = petList.stream().map(Root::getName).collect(Collectors.toList());
        for (int i=0; i<names.size(); i++){
            assertThat(names.get(i).contains(pet.getName()));
            System.out.println(names.get(i));
        }*/
        //System.out.println(pet.getName());


    }

}
