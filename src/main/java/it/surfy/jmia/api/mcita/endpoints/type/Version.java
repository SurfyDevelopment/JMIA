package it.surfy.jmia.api.mcita.endpoints.type;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class Version {

    @SerializedName("id")
    private int id;

    @SerializedName("protocol_id")
    private int protocolId;

    @SerializedName("name")
    private String name;
}
