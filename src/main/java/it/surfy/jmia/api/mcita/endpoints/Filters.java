package it.surfy.jmia.api.mcita.endpoints;

import com.google.gson.annotations.SerializedName;
import it.surfy.jmia.api.mcita.endpoints.type.Tag;
import it.surfy.jmia.api.mcita.endpoints.type.Version;
import lombok.Getter;

import java.util.List;

@Getter
public class Filters {


    @SerializedName("tags")
    private List<Tag> tags;


    @SerializedName("versions")
    private List<Version> versions;

}
