package com.gt.wms.httpServer.base;

/**
 * Created by rio on 2019/3/15.
 */

import com.google.gson.Gson;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rio on 2019/3/15.
 */
public class HttpServerHandler implements HttpHandler {

    public void handle(HttpExchange httpExchange) throws IOException {
        Map parameterMap = new HashMap();
        String requestType = httpExchange.getRequestMethod();
        switch (requestType) {
            case "GET":
                parameterMap = getGetParameter(httpExchange.getRequestURI().getRawQuery());
                break;
            case "POST":
                InputStream is = httpExchange.getRequestBody();
                List<String> list = httpExchange.getRequestHeaders().get("Content-Type");
                if (list.get(0).lastIndexOf("application/json") != -1) {
                    byte[] ba = new byte[is.available()];
                    is.read(ba);
                    Gson gson = new Gson();
                    parameterMap = gson.fromJson(new String(ba, "UTF-8"), Map.class);
                } else if (list.get(0).lastIndexOf("application/x-www-form-urlencoded") != -1) {
                    byte[] ba = new byte[is.available()];
                    is.read(ba);
                    parameterMap = getGetParameter(new String(ba, "UTF-8"));
                }

                break;
            default:
                break;
        }

        sendResponse(httpExchange, parameterMap);
    }

    private Map getGetParameter(String rawQuery) {
        Map<String, String> pm = new HashMap<String, String>();
        if (rawQuery != null && !"".endsWith(rawQuery)) {
            String[] entrys = rawQuery.split("&");
            for (String entry : entrys) {
                String[] en = entry.split("=");
                if (en.length > 1) {
                    pm.put(en[0], en[1]);
                } else {
                    pm.put(en[0], "");
                }

            }
        }

        return pm;
    }

    private void sendResponse(HttpExchange httpExchange, Map parameterMap) throws IOException {
        Headers header = httpExchange.getResponseHeaders();
        header.set("Content-Type", "application/Json;charset=utf-8");
        httpExchange.sendResponseHeaders(200, 0);
        OutputStream os = httpExchange.getResponseBody();

        byte[] ba = "{\"name\":\"LZX\"}".getBytes("utf-8");
        try {
            os.write(ba);
            os.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}