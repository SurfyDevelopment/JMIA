package it.surfy.jmia.api.mcita.endpoints.type;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class Link {

    @SerializedName("type")
    private Type type;

    @SerializedName("value")
    private String value;


    @Getter
    public enum Type {
        WEBSITE, FACEBOOK, TWITTER, TELEGRAM, INSTAGRAM, TIKTOK, DISCORD, SHOP
    }
}
