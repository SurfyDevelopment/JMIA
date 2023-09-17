package it.surfy.jmia.api.mcita.endpoints.type;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class Tag {

    @SerializedName("id")
    private int id;

    @SerializedName("tag")
    private String tag;

    @SerializedName("description")
    private String description;
}
