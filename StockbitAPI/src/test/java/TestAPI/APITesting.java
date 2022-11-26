package TestAPI;

import io.restassured.RestAssured;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


//Answer for Question 4
public class APITesting {

    @Test
    public void test_amountOfData(){
//When number of data : 20
        when().
            get("https://api.punkapi.com/v2/beers?page=2&per_page=20").
        then().
            assertThat().
            //Verify amount of data (20)
            body("id",hasSize(20));
        System.out.println("List of data with values 20");
        System.out.println((RestAssured.get("https://api.punkapi.com/v2/beers?page=2&per_page=20")).getBody().asString());
        System.out.println("Status Code : " + (RestAssured.get("https://api.punkapi.com/v2/beers?page=2&per_page=20")).getStatusCode());

//When number of data : 5
        when().
            get("https://api.punkapi.com/v2/beers?page=2&per_page=5").
        then().
            assertThat().
            //Verify amount of data (5)
            body("id",hasSize(5));
        System.out.println("List of data with values 5");
        System.out.println((RestAssured.get("https://api.punkapi.com/v2/beers?page=2&per_page=5")).getBody().asString());
        System.out.println("Status Code : " + (RestAssured.get("https://api.punkapi.com/v2/beers?page=2&per_page=5")).getStatusCode());

//When number of data : 1
        when().
            get("https://api.punkapi.com/v2/beers?page=2&per_page=1").
        then().
            assertThat().
            //Verify amount of data (1)
            body("id",hasSize(1));
        System.out.println("List of data with values 1");
        System.out.println((RestAssured.get("https://api.punkapi.com/v2/beers?page=2&per_page=1")).getBody().asString());
        System.out.println("Status Code : " + (RestAssured.get("https://api.punkapi.com/v2/beers?page=2&per_page=1")).getStatusCode());
    }
}
