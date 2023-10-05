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
package it.surfy.jmia;

import it.surfy.jmia.api.mcita.endpoints.Filters;
import it.surfy.jmia.api.mcita.endpoints.Server;
import it.surfy.jmia.api.mcita.endpoints.Stats;
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


    public Server getServerByPosition(int position) throws IOException {
        return Requests.getServerList(proxy).get(position - 1);
    }


    public List<Vote> getServerDailyVotes(Server server) throws IOException {
        return Requests.getServerDailyVotes(proxy, server);
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

    public Stats getServerStats(int serverId) throws IOException {
        return Requests.getServerStats(proxy, serverId);
    }


    public URL getServerLogo(Server server) throws MalformedURLException {
        return Requests.getServerLogoURL(server);
    }


    public Filters getFilters() throws IOException {
        return Requests.getFilters(proxy);
    }

}
