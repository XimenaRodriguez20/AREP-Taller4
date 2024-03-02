package com.mycompany.clase4.example.runtime;


import static com.mycompany.clase4.example.runtime.HttpServer.get;
import static com.mycompany.clase4.example.runtime.HttpServer.post;

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