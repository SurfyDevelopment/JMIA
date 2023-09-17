package it.surfy.jmia.api.mcita.endpoints.type;

import com.google.gson.annotations.SerializedName;
import it.surfy.jmia.api.mcita.endpoints.Server;
import lombok.Getter;

import java.util.List;

@Getter
public class StaffRole {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("color")
    private String color;

    @SerializedName("members")
    private List<StaffMember> members;


    @Getter
    public static class StaffMember {

        @SerializedName("id")
        private int id;

        @SerializedName("xenforo_id")
        private int forumId;

        @SerializedName("minecraft_username")
        private String username;

    }
}
