/*
 * Copyright (c) 2023 https://minecraft-italia.net/ | Surfy
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package it.surfy.jmia.api.mcita.endpoints;

import com.google.gson.annotations.SerializedName;
import it.surfy.jmia.api.mcita.endpoints.type.Link;
import it.surfy.jmia.api.mcita.endpoints.type.ServerVersions;
import it.surfy.jmia.api.mcita.endpoints.type.Tag;
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
