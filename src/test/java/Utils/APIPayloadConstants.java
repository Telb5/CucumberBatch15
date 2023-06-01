package Utils;


import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonFormat;
import org.json.JSONObject;

public class APIPayloadConstants {

    //We will pass the body/payload in multiple formats, for this we have created this class.
    public static String createEmployeePayLoad(){
        String createEmployeePayLoad = "{\n" +
                "    \"emp_firstname\": \"Mohamed\",\n" +
                "    \"emp_lastname\": \"Boulksout\",\n" +
                "    \"emp_middle_name\": \"ALLH\",\n" +
                "    \"emp_gender\": \"M\",\n" +
                "    \"emp_birthday\": \"1994-11-10\",\n" +
                "    \"emp_status\": \"Confirmed\",\n" +
                "    \"emp_job_title\": \"QA AE\"    \n" +
                "}";

        return createEmployeePayLoad;
    }



    public static String createEmployeePayloadJson()
        {
            JSONObject obj = new JSONObject();
            obj.put("emp_firstname","Mohamed");
            obj.put("emp_lastname","Boulksout");
            obj.put("emp_middle_name","ALLH");
            obj.put("emp_gender","M");
            obj.put("emp_birthday","1994-11-10");
            obj.put("emp_status","Confirmed");
            obj.put("emp_job_title","QA AE");
            return obj.toString();
        }

    public static String createEmployeePayloadDynamic
            (String emp_firstname, String emp_lastname,
             String emp_middle_name, String emp_gender, String emp_birthday,
             String emp_status, String emp_job_title){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);

        return obj.toString();
    }

    public static String updateEmployeePayloadJson(){
        JSONObject obj = new JSONObject();
        obj.put("employee_id","57561A");
        obj.put("emp_firstname","natalia");
        obj.put("emp_lastname","glusco");
        obj.put("emp_middle_name","ms");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2001-04-22");
        obj.put("emp_status","Probation");
        obj.put("emp_job_title","Manager");
        return obj.toString();
    }
}
