package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;




@FixMethodOrder(MethodSorters.NAME_ASCENDING)    //This sets the order of our request so that we can run them and be synchro


public class HardCodedExamples {


     String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
     String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUwNDg4MjIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTA5MjAyMiwidXNlcklkIjoiNTI4NSJ9.OmL11P2Lma-ycLjKELqHZIOzCgxL0G1Gqe_jzDMlS84";

     static String employee_id;


     @Test
     public void bgetCreateEmployee() {
          RequestSpecification preparedRequest = given().
                  header("Content-Type", "application/json").
                  header("Authorization", token).
                  queryParam("employee_id", employee_id);


          //:::::::hitting the endpoint:::::::
          Response response = preparedRequest.when().get("/getOneEmployee.php");
          response.prettyPrint();


          //:::::::verify the response:::::::
          response.then().assertThat().statusCode(200);


          String tempEmpId = response.jsonPath().getString("employee.employee_id");
          // we have 2 employee id (1 is global , 1 is local )
          Assert.assertEquals(employee_id, tempEmpId);


     }


     @Test
     public void acreateEmployee() {
          //:::::::prepare the request:::::::
          RequestSpecification preparedRequest = given().header("Content-Type", "application/json")
                  .header("Authorization", token).body("{\n" +
                          "    \"emp_firstname\": \"Mohamed\",\n" +
                          "    \"emp_lastname\": \"Boulksout\",\n" +
                          "    \"emp_middle_name\": \"ALLH\",\n" +
                          "    \"emp_gender\": \"M\",\n" +
                          "    \"emp_birthday\": \"1994-11-10\",\n" +
                          "    \"emp_status\": \"Confirmed\",\n" +
                          "    \"emp_job_title\": \"QA AE\"    \n" +
                          "}");


          //:::::::hitting the endpoint/send the request:::::::
          Response response = preparedRequest.when().post("/createEmployee.php");

          //:::::::it will print the output in the console:::::::
          response.prettyPrint();

          //:::::::verifying the assertions/get response:::::::
          response.then().assertThat().statusCode(201);


          //:::::::we are capturing employee id from the response:::::::
          employee_id = response.jsonPath().getString("Employee.employee_id");
          System.out.println(employee_id);


          //:::::::verifying the firstname and lastname in the response body:::::::
          response.then().assertThat()
                  .body("Employee.emp_firstname", equalTo("Mohamed"));

          response.then().assertThat()
                  .body("Employee.emp_lastname", equalTo("Boulksout"));

          System.out.println("My test case is passed");
     }


     //in HW, create a method to get all employee status and job title
     @Test
     public void cupdateEmployee() {
          RequestSpecification preparedRequest = given().
                  header("Content-Type","application/json").
                  header("Authorization", token).body("{\n" +
                          "    \"employee_id\": \"\"+employee_id+\"\",\n" +
                          "    \"emp_firstname\": \"Mohamed\",\n" +
                          "    \"emp_lastname\": \"Moha\",\n" +
                          "    \"emp_middle_name\": \"MAM\",\n" +
                          "    \"emp_gender\": \"M\",\n" +
                          "    \"emp_birthday\": \"1993-02-02\",\n" +
                          "    \"emp_status\": \"Confirmed\",\n" +
                          "    \"emp_job_title\": \"Manual tester\"\n" +
                          "}");


          //hitting the endpoint
          Response response = preparedRequest.when().put("/updateEmployee.php");
          response.then().assertThat().statusCode(200);
          //for verification
          response.then().assertThat().body("Message", equalTo("Employee record Updated"));


     }




     @Test
     public void dgetUpdatedEmployee(){
          RequestSpecification preparedRequest = given().
                  header("Content-Type","application/json").
                  header("Authorization", token).
                  queryParam("employee_id",employee_id);

          Response response = preparedRequest.when().get("/getOneEmployee.php");
          response.prettyPrint();
          response.then().assertThat().statusCode(200);
          //if you want to verify the body of the response.
          //you can do that using hamcrest matchers

     }

}