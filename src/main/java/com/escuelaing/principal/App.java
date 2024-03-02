package com.escuelaing.principal;


import com.escuelaing.components.MySpringBoot;

import static com.escuelaing.principal.HttpServer.get;
import static com.escuelaing.principal.HttpServer.post;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;

public class App {
    public static void main(String[] args) throws IOException, URISyntaxException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {

        get("/hola", (req) -> {
            return "Hola Mundo " + req;
        });

        post("/recibido", (req) -> {
            return "No esta implementado el post" ;
        });
        // start the server
        if (!MySpringBoot.running) MySpringBoot.getInstance().main(args);
        if (!HttpServer.running) HttpServer.getInstance().start(args);

    }
}