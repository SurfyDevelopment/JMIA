package it.surfy.jmia.api.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Response;

public class ErrorUtils {

    public static String decodeError(Response<?> response, Gson gson) {

        ResponseBody body = response.errorBody();
        assert body != null;

        MediaType contentType = body.contentType();
        assert contentType != null;

        if (contentType.type().equals("application") && contentType.subtype().equals("json")) {

            try {

                JsonObject error = gson.fromJson(body.string(), JsonObject.class);
                return error.get("status_code").getAsInt() + " - " + error.get("error").getAsString();

            } catch (Exception ignored) {}
        }

        if (!response.message().trim().isEmpty()) {
            return response.code() + " - " + response.message();
        }
        else {
            return String.valueOf(response.code());
        }
    }
}
