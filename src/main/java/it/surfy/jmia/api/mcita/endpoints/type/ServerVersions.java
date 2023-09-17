package it.surfy.jmia.api.mcita.endpoints.type;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class ServerVersions {

    @SerializedName("min")
    private Version min;

    @SerializedName("max")
    private Version max;
}
