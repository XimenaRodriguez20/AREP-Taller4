package com.mycompany.clase4.example.runtime;


import static com.mycompany.clase4.example.runtime.HttpServer1.get;
import static com.mycompany.clase4.example.runtime.HttpServer1.post;

import java.io.IOException;
import java.net.URISyntaxException;

public class App {
    public static void main(String[] args) throws IOException, URISyntaxException {

        get("/hola", (req) -> {
            return "Hola Mundo " + req;
        });

        post("/recibido", (req) -> {
            return "No esta implementado el post" ;
        });
        // start the server
        if (!HttpServer1.running) HttpServer1.getInstance().start(args);
    }
}