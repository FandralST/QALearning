package Core.APIcore.Specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseSpecification {

    public static RequestSpecification getBaseSpec(String url){
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType("application/json")
                .build();
    }
}
