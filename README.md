<img align="right" src="https://i.imgur.com/hRKebb4.png" height="150" width="150">

# JMIA (Java Minecraft-Italia API)
JMIA è una libreria Java per semplificare l'integrazione con le [API](https://minecraft-italia.net/lista/docs/) di [Minecraft-Italia.net](https://minecraft-italia.net/).
La libreria fornisce una serie di funzioni e classi per accedere alle funzionalità offerte dalle API in modo efficiente e intuitivo.

## Requisiti
- Java 8 o versione successiva

## Installazione

Puoi aggiungere questa libreria al tuo progetto Java utilizzando **Gradle** o **Maven**. Aggiungi la seguente dipendenza al tuo file `pom.xml`/`build.gradle`:

**Gradle**
```gradle
repositories {
    maven { 
        url 'https://jitpack.io' 
    }
}

dependencies {
    implementation 'com.github.SurfyDevelopment:JMIA:1.0.0'
}
```

**Maven**
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.SurfyDevelopment</groupId>
    <artifactId>JMIA</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Utilizzo

Innanzitutto, bisogna registrare l'istanza di JMIA nel proprio metodo/classe.
```java

JMIA jmia = JMIA.getInstance();

```

Ecco alcuni esempi di come puoi utilizzare questa libreria:

**Top 10 Servers (Per Voti)**
```java
import it.surfy.jmia.JMIA;
import it.surfy.jmia.api.mcita.endpoints.Server;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Top10ServerExample
{

    public static void main(String[] args)
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
}
```

**Informazioni Server specifico (Acquisibile in diversi modi)**
```java

import it.surfy.jmia.JMIA;
import it.surfy.jmia.api.mcita.endpoints.Server;

import java.io.IOException;

public class Top10ServerExample
{

    public static void main(String[] args)
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
```

## Contributi

Siamo aperti a contributi da parte della comunità. Se desideri contribuire a questa libreria, sentiti libero di inviare una pull request.

## Segnalazione di Problemi

Se riscontri bug o hai domande sulla libreria, per favore apri una nuova issue nel repository del progetto.

## Licenza

Questo progetto è concesso in licenza sotto la Licenza MIT. Consulta il file `LICENSE` per ulteriori informazioni.