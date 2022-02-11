package apiConfigs;

import apiConfigs.model.requests.AddPetRequest;
import apiConfigs.model.requests.UpdatePetRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import javafx.util.Pair;

public class EndPoints {

    private static final Pair<String, String> header = new Pair("Content-Type", "application/json");

    private static RequestSpecification getRequest() {
        RestAssured.baseURI = PetPaths.BASE_URL;
        return RestAssured.given();
    }

    public static Response getPets(String status) {
        RequestSpecification request = getRequest();
        Response response = request.get(PetPaths.getPetsByStatus(status));
        return response;
    }

    public static Response addPet(AddPetRequest addPetRequest) {
        RequestSpecification request = getRequest();
        request.header(header.getKey(), header.getValue())
                .body(addPetRequest);
        Response response = request.post(PetPaths.addPet());
        return response;
    }

    public static Response removePet(String id) {
        RequestSpecification request = getRequest();
        request.header(header.getKey(), header.getValue());
        Response response = request.delete(PetPaths.removePet(id));
        return response;
    }

    public static Response updatePet(UpdatePetRequest updatePetRequest) {
        RequestSpecification request = getRequest();
        request.header(header.getKey(), header.getValue())
                .body(updatePetRequest);
        Response response = request.put(PetPaths.updatePet());
        return response;
    }

    public static Response availablePetstore() {
        RequestSpecification request = getRequest();
        Response response = request.get(PetPaths.availablePetstore());
        return response;
    }

    public static Response isPetInPetstore(String id) {
        RequestSpecification request = getRequest();
        Response response = request.get(PetPaths.isPetInStore(id));
        return response;
    }
}