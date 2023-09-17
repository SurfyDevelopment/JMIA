package it.surfy.jmia.api.mcita.endpoints;

import com.google.gson.annotations.SerializedName;
import it.surfy.jmia.api.mcita.endpoints.type.*;
import lombok.Getter;

import java.util.List;

@Getter
public class Server {


    @SerializedName("id")
    private int id;


    @SerializedName("name")
    private String name;


    @SerializedName("url_name")
    private String urlName;


    @SerializedName("java_address")
    private String javaAddress;


    @SerializedName("java_port")
    private int javaPort;


    @SerializedName("bedrock_address")
    private String bedrockAddress;


    @SerializedName("bedrock_port")
    private int bedrockPort;


    @SerializedName("online_mode")
    private boolean onlineMode;


    @SerializedName("applied_tags")
    private List<Tag> appliedTags;


    @SerializedName("versions")
    private ServerVersions versions;


    @SerializedName("position")
    private int position;


    @SerializedName("votes")
    private int votes;


    @SerializedName("online_players")
    private int onlinePlayers;


    @SerializedName("status")
    private Status status;


    @SerializedName("icon_id")
    private String iconId;


    @SerializedName("banner_id")
    private String bannerId;


    @SerializedName("description")
    private String description;


    @SerializedName("external_links")
    private List<Link> links;



    /**
     * Without an admin API Key this will always return {@link Status#OK} as no other server will be obtainable through public api.
     */
    @Getter
    public enum Status {
        OK, HIDDEN, BUILDING, TO_BE_APPROVED, REJECTED, SUSPENDED, REMOVED
    }

}
