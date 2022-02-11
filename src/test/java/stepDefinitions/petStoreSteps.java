package stepDefinitions;


import apiConfigs.EndPoints;
import apiConfigs.model.requests.AddPetRequest;
import apiConfigs.model.requests.UpdatePetRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

    public class petStoreSteps {

        private static Response response;


        @Given("the Petstore is available")
        public void the_petstore_is_available() {
            response = EndPoints.availablePetstore();
            Assertions.assertEquals(200, response.getStatusCode(), "Unexpected Status Code, expected value was: 200");
        }

        @When("the user gets the {string} pets")
        public void the_user_gets_all_the_pets(String status) {
            response = EndPoints.getPets(status);
        }

        @Then("the user should get the pets with the {string} status")
        public void the_user_should_get_all_the_pets_with_the_status(String status) {
            Assertions.assertTrue(response.asString().contains(status), "Unexpected Pet Status, expected value was: "+status);
            Assertions.assertEquals(200, response.getStatusCode(), "Unexpected Status Code, expected value was: 200");
        }

        @Then("the the user shouldn't get the pets with the {string} status")
        public void the_the_user_shouldn_t_get_the_pets_with_the_status(String status) {
            Assertions.assertFalse(response.asString().contains(status), "Unexpected Pet Status found: "+status);
        }

        @When("the user adds a pet with the {string} status, id {long} and name {string}")
        public void the_user_adds_a_pet_with_the_status(String status, long id, String name) {
            AddPetRequest addPetRequest = new AddPetRequest(id, null, name, null, null, status);
            response = EndPoints.addPet(addPetRequest);
        }

        @Then("the name of the pet with id {long} should be {string}")
        public void the_name_of_the_pet_with_id_should_be(long id, String name) {
            Assertions.assertEquals(200, response.getStatusCode(), "Unexpected Status Code, expected value was: 200");
            Assertions.assertTrue(response.asString().contains(name), "Unexpected pet name, expected value was: "+name);
            Assertions.assertTrue(response.asString().contains(String.valueOf(id)), "Unexpected pet id, expected value was: "+id);
        }

        @Given("the pet with id {string} is in the Petstore")
        public void the_user_s_pet_is_in_the_petsore(String id) {
            response = EndPoints.isPetInPetstore(id);
        }

        @When("the user updates the status of the pet with id {long} to {string}")
        public void the_user_updates_the_pet_s_information(long id, String status) {
            UpdatePetRequest updatePetRequest = new UpdatePetRequest(id, null, "Paquito", null, null, status);
            response = EndPoints.updatePet(updatePetRequest);
        }

        @Then("the status of the pet with id {long} should be {string}")
        public void the_status_of_the_pet_with_id_should_be(long id, String status) {
            Assertions.assertEquals(200, response.getStatusCode(), "Unexpected Status Code, expected value was: 200");
            Assertions.assertTrue(response.asString().contains(status), "Unexpected pet status, expected value was: "+status);
            Assertions.assertTrue(response.asString().contains(String.valueOf(id)), "Unexpected pet id, expected value was: "+id);
        }

        @When("the user deletes the pet with id {string}")
        public void the_user_deletes_this_pet(String id) {
            response = EndPoints.removePet(id);
            if (response.asString().contains("name")) {
                response = EndPoints.removePet(id);
            }
        }

        @Then("the pet should be removed from the Petstore")
        public void the_pet_should_be_removed_from_the_petstore() {
            Assertions.assertEquals(200, response.getStatusCode(), "Unexpected Status Code, expected value was: 200");
            Assertions.assertTrue(response.asString().contains("unknown"), "The pet wasn't removed");
        }
    }