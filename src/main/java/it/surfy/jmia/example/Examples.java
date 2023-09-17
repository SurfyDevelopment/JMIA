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
package it.surfy.jmia.example;

import it.surfy.jmia.JMIA;
import it.surfy.jmia.api.mcita.endpoints.Server;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Examples
{

    public static void main(String[] args) {

        serverTop();
        serverInfos();

    }


    public static void serverTop()
    {
        JMIA jmia = JMIA.getInstance();

        System.out.println("Top 10 Servers (Per Voti)");

        try
        {
            List<Server> servers = jmia.getServerList()
                    .stream()
                    .limit(10)
                    .collect(Collectors.toList());

            int pos = 1;

            for(Server server : servers)
            {
                System.out.println(pos++ + "°  |  " + server.getName() + "  |  " + server.getVotes());
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }


    public static void serverInfos()
    {

        JMIA jmia = JMIA.getInstance();

        try
        {
            Server byPosition = jmia.getServerByPosition(1);
            System.out.println("JMIA: Il server in prima posizione attualmente è: " + byPosition.getName() + "!");

            Server byUrlName = jmia.getServerByUrlName("metamc");
            System.out.println("JMIA: Il server " + byUrlName.getName() +
                    " ha ricevuto " + byUrlName.getVotes() + " voti fin'ora!");

            Server byId = jmia.getServerById(37);
            System.out.println("JMIA: Il server " + byId.getName() + " supporta le versioni di gioco dalla " +
                    byId.getVersions().getMin().getName() + " alla " + byId.getVersions().getMax().getName());

        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
