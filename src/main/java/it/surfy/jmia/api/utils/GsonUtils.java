package it.surfy.jmia.api.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

public class GsonUtils {

    public static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(Date.class, new DateSerializer())
            .disableHtmlEscaping()
            .setPrettyPrinting()
            .create();
}
