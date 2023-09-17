package it.surfy.jmia.api.mcita.endpoints;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Getter
public class Stats {

    @SerializedName("today_players")
    private List<Entry> dailyPlayers = Collections.emptyList();

    @SerializedName("month_players")
    private List<Entry> monthlyPlayers = Collections.emptyList();

    @SerializedName("month_votes")
    private List<Entry> monthlyVotes = Collections.emptyList();

    @SerializedName("year_players")
    private List<Entry> yearlyPlayers = Collections.emptyList();

    @SerializedName("year_votes")
    private List<Entry> yearlyVotes = Collections.emptyList();


    @Getter
    public static class Entry {

        @SerializedName("timestamp")
        private Date timestamp;

        @SerializedName("value")
        private long value;
    }
}
