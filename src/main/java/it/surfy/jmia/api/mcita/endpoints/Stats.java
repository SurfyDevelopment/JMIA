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
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class Stats {

    @SerializedName("today_players")
    private List<Entry> dailyPlayers;

    @SerializedName("month_players")
    private List<Entry> monthlyPlayers;

    @SerializedName("month_votes")
    private List<Entry> monthlyVotes;

    @SerializedName("year_players")
    private List<Entry> yearlyPlayers;

    @SerializedName("year_votes")
    private List<Entry> yearlyVotes;


    @Getter
    public static class Entry {

        @SerializedName("timestamp")
        private Date timestamp;

        @SerializedName("value")
        private long value;
    }
}
