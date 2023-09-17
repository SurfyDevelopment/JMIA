package it.surfy.jmia;

import it.surfy.jmia.api.mcita.endpoints.Filters;
import it.surfy.jmia.api.mcita.endpoints.Server;
import it.surfy.jmia.api.mcita.endpoints.Vote;
import it.surfy.jmia.api.mcita.proxy.Proxy;
import it.surfy.jmia.api.utils.Requests;
import it.surfy.jmia.api.utils.UncheckedOkHttpClient;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static it.surfy.jmia.api.utils.GsonUtils.gson;

public class JMIA {


    private final Proxy proxy;


    @Getter
    private static final JMIA instance = new JMIA();


    private JMIA() {
        proxy = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(UncheckedOkHttpClient.newInstance())
                .baseUrl("https://minecraft-italia.net/lista/api/")
                .build()
                .create(Proxy.class);
    }


    public List<Server> getServerList() throws IOException {
        return Requests.getServerList(proxy);
    }


    public List<Server> getServerList(@Nullable Integer page,
                                      @Nullable String name,
                                      @Nullable Integer tagId,
                                      @Nullable Integer versionId,
                                      @Nullable Boolean onlineMode,
                                      @Nullable String date) throws IOException {
        return Requests.getServerList(proxy, page, name, tagId, versionId, onlineMode, date);
    }


    public Server getServerByUrlName(String urlName) throws IOException {
        return Requests.getServerByUrlName(proxy, urlName);
    }


    public Server getServerById(int serverId) throws IOException {
        return Requests.getServerById(proxy, serverId);
    }


    public List<Vote> getServerDailyVotes(Server server) throws IOException {
        return Requests.getServerDailyVotes(proxy, server);
    }


    public URL getServerLogo(Server server) throws MalformedURLException {
        return Requests.getServerLogoURL(server);
    }


    /**
     * To see how to grab your API Key here is an example:
     * <br>
     * <img alt="APIKey Example" src="https://imgur.com/6D4g1yr.png">
     *
     */
    public List<Vote> getServerVotes(String apiKey) throws IOException {
        return Requests.getServerVotes(proxy, apiKey);
    }


    public Filters getFilters() throws IOException {
        return Requests.getFilters(proxy);
    }

}
