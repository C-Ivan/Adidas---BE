package apiConfigs;

public class PetPaths {

    private static final String PETSTORE = "/pet";
    public static final String BASE_URL = "https://petstore.swagger.io/v2";

    public static String getPetsByStatus(String status) {
        return PETSTORE + "/findByStatus?status=" + status + "";
    }

    public static String addPet() {
        return PETSTORE;
    }

    public static String removePet(String id) {
        return PETSTORE + "/" + id + "";
    }

    public static String availablePetstore() {
        return "/swagger.json";
    }

    public static String updatePet() {
        return PETSTORE;
    }

    public static String isPetInStore(String id) {
        return PETSTORE + "/" + id + "";
    }

    public static String checkUpdatedInformation(int id) {
        return PETSTORE + "/" + id + "";
    }
}