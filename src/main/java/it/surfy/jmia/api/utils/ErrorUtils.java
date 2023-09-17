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
