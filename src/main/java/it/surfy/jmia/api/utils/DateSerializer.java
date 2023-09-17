package it.surfy.jmia.api.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

public class DateSerializer implements JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {

        String date = jsonElement.getAsString();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        format.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Europe/Rome")));

        try {

            return format.parse(date);

        } catch (ParseException ex) {
            throw new JsonParseException(ex);
        }
    }

}
