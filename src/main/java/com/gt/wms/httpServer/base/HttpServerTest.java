package com.gt.wms.httpServer.base;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by rio on 2019/3/15.
 */
public class HttpServerTest {

    public static void main(String[] args) throws IOException {
        HttpServerProvider hsp = HttpServerProvider.provider();
        HttpServer hs = hsp.createHttpServer(new InetSocketAddress(80), 100);
        hs.createContext("/gisCore", new HttpServerHandler());
        hs.setExecutor(null);
        hs.start();
    }
}
