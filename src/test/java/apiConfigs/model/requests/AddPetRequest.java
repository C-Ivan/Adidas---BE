package apiConfigs.model.requests;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class AddPetRequest {

    public Long id;
    public Category category;
    public String name;
    public List<String> photoUrls;
    public List<Tag> tags;
    public String status;

    public AddPetRequest(Long id, Category category, String name, List<String> photoUrls, List<Tag> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

}