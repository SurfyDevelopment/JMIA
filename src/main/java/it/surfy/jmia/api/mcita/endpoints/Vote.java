package it.surfy.jmia.api.mcita.endpoints;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.Date;

@Getter
public class Vote {

    @SerializedName("id")
    private long voteId;

    @SerializedName("server_id")
    private long serverId;

    @SerializedName("timestamp")
    private Date timestamp;

    @SerializedName("username")
    private String username;
}
