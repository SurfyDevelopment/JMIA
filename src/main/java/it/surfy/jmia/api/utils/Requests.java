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
package it.surfy.jmia.api.utils;

import it.surfy.jmia.api.mcita.endpoints.Filters;
import it.surfy.jmia.api.mcita.endpoints.Server;
import it.surfy.jmia.api.mcita.endpoints.Stats;
import it.surfy.jmia.api.mcita.endpoints.Vote;
import it.surfy.jmia.api.mcita.proxy.Proxy;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static it.surfy.jmia.api.utils.GsonUtils.gson;

public class Requests {


    public static List<Server> getServerList(Proxy proxy) throws IOException {

        List<Server> servers = new ArrayList<>();
        int currentPage = 0;

        while (true) {

            Response<List<Server>> response = proxy.fetchServerList(currentPage++)
                    .execute();

            if (!response.isSuccessful()) {
                throw new RuntimeException("JMIA returned an error: " + ErrorUtils.decodeError(response, gson));
            }

            List<Server> page = response.body();
            assert page != null;

            if (page.isEmpty()) break;

            servers.addAll(page);
        }

        servers.sort(Comparator.comparingInt(Server::getPosition));

        return servers;
    }


    public static List<Server> getServerList(Proxy proxy,
                                      @Nullable Integer page,
                                      @Nullable String name,
                                      @Nullable Integer tagId,
                                      @Nullable Integer versionId,
                                      @Nullable Boolean onlineMode,
                                      @Nullable String date) throws IOException {

        Response<List<Server>> response = proxy
                .fetchServerList(page, name, tagId, versionId, onlineMode, date)
                .execute();

        if (!response.isSuccessful()) {
            throw new RuntimeException("JMIA returned an error: " + ErrorUtils.decodeError(response, gson));
        }

        List<Server> list = response.body();
        assert list != null;

        List<Server> servers = new ArrayList<>(list);

        if(servers.isEmpty()) return Collections.emptyList();

        servers.sort(Comparator.comparingInt(Server::getPosition));

        return servers;
    }


    public static Server getServerByUrlName(Proxy proxy, String urlName) throws IOException {

        Response<Server> response = proxy.fetchServerInfo(urlName).execute();

        if (!response.isSuccessful()) {
            throw new RuntimeException("JMIA returned an error: " + ErrorUtils.decodeError(response, gson));
        }

        return response.body();
    }


    public static Server getServerById(Proxy proxy, int serverId) throws IOException {


        Server server = getServerList(proxy).stream()
                .filter(srv -> srv.getId() == serverId)
                .findFirst()
                .orElse(null);

        if (server == null) {
            throw new NullPointerException("JMIA couldn't find a valid server with ID: " + serverId);
        }


        Response<Server> response = proxy.fetchServerInfo(server.getUrlName()).execute();

        if (!response.isSuccessful()) {
            throw new RuntimeException("JMIA returned an error: " + ErrorUtils.decodeError(response, gson));
        }

        return response.body();
    }


    public static List<Vote> getServerDailyVotes(Proxy proxy, Server server) throws IOException {

        Response<List<Vote>> response = proxy.fetchServerDailyVotes(server.getId()).execute();

        if (!response.isSuccessful()) {
            throw new RuntimeException("JMIA returned an error: " + ErrorUtils.decodeError(response, gson));
        }

        return response.body();
    }


    public static List<Vote> getServerVotes(Proxy proxy, String apiKey) throws IOException {

        Response<List<Vote>> response = proxy.fetchServerVotes(apiKey).execute();

        if (!response.isSuccessful()) {
            throw new RuntimeException("JMIA returned an error: " + ErrorUtils.decodeError(response, gson));
        }

        return response.body();
    }


    public static Stats getServerStats(Proxy proxy, int serverId) throws IOException {

        Response<Stats> response = proxy.fetchServerStats(serverId).execute();

        if (!response.isSuccessful()) {
            throw new RuntimeException("JMIA returned an error: " + ErrorUtils.decodeError(response, gson));
        }

        return response.body();
    }


    public static Filters getFilters(Proxy proxy) throws IOException {

        Response<Filters> response = proxy.fetchFilters().execute();

        if (!response.isSuccessful()) {
            throw new RuntimeException("JMIA returned an error: " + ErrorUtils.decodeError(response, gson));
        }

        return response.body();
    }


    public static URL getServerLogoURL(Server server) throws MalformedURLException {
        return new URL("https://minecraft-italia.net/lista/api/blob/get?id=" + server.getIconId());
    }

}
