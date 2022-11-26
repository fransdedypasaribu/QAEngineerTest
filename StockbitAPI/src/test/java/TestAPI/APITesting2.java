package TestAPI;

import io.restassured.RestAssured;
import org.junit.Test;
import io.restassured.response.Response;

import java.util.List;

//Answer for Question 5
public class APITesting2 {

    @Test
    public void test_JsonSchemaAPI(){

        Response response = RestAssured.get("https://api.punkapi.com/v2/beers");

        List<String> jsonMapStringObjectResponse = response.jsonPath().get("name");
        for (int i=0; i<jsonMapStringObjectResponse.size(); i++){
//Print all returned names
            System.out.println(jsonMapStringObjectResponse.get(i));
        }
// Total names (data)
        System.out.println("Total names :" + jsonMapStringObjectResponse.size());
    }
}
