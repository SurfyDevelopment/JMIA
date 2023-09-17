package it.surfy.jmia.api.mcita.proxy;

import it.surfy.jmia.api.mcita.endpoints.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface Proxy {


    @GET("server/list")
    Call<List<Server>> fetchServerList(@Query("page") Integer page);


    @GET("server/list")
    Call<List<Server>> fetchServerList(@Query("page") Integer page,
                                       @Query("name") String name,
                                       @Query("tagId") Integer tagId,
                                       @Query("versionId") Integer versionId,
                                       @Query("onlineMode") Boolean onlineMode,
                                       @Query("date") String date);


    @GET("server/info")
    Call<Server> fetchServerInfo(@Query("name") String urlName);


    @GET("vote/server")
    Call<List<Vote>> fetchServerDailyVotes(@Query("serverId") Integer serverId);


    @GET("vote/fetch")
    Call<List<Vote>> fetchServerVotes(@Query("apiKey") String apiKey);


    @GET("server/filters")
    Call<Filters> fetchFilters();


    @GET("stats/server")
    Call<Stats> fetchServerStats(@Query("serverId") int serverId);

}
