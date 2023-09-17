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
