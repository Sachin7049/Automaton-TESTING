package API_TESTING;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SimpleAPITest {

    public static void main(String[] args) {

        // Base URI
        RestAssured.baseURI = "https://pre-stage-api.parkengage.com";

        // Request body (same as cURL)
        String requestBody = "{"
                + "\"facility_id\":300,"
                + "\"license_plate\":\"H92348\","
                + "\"phone\":\"3489564865\","
                + "\"email\":\"tested1@yopmail.com\","
                + "\"length\":\"2.00\","
                + "\"discount_amount\":\"10.00\","
                + "\"promocode\":\"PER_100\","
                + "\"total\":0,"
                + "\"walletPay\":\"\","
                + "\"nonce\":\"\","
                + "\"paymentMethods\":\"\","
                + "\"check_warning\":0,"
                + "\"paymentMethodInfo\":{},"
                + "\"first_name\":\"tested\","
                + "\"last_name\":\"user\","
                + "\"start_date\":\"2025-12-29 03:42:47\","
                + "\"is_overnight_enabled\":0,"
                + "\"is_fast_track_enabled\":0,"
                + "\"device_type\":\"web\""
                + "}";

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("X-ClientSecret", "LCZDjiPsVpMmYJb2XAOihxFTj")
                .header("Origin", "https://pre-stage-transient.parkengage.com")
                .header("Referer", "https://pre-stage-transient.parkengage.com/")
                .body(requestBody)
                .when()
                .post("/pave-make-web-ungated-checkin-payment");

        // 🔹 Always print full response first (DEBUG RULE)
        System.out.println("Full Response:");
        System.out.println(response.asString());

        // Status validation
        System.out.println("Status Code: " + response.getStatusCode());


    }
}
