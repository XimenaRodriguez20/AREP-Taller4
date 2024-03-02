package com.mycompany.clase4.example.runtime;

/**
 *
 * @author ximena.rodriguez
 */

import java.net.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class HttpServer {

    private static HashMap<String, Function> service = new HashMap<>();
    public static boolean running = false;
    private static HttpServer instance = null;

    private HttpServer() {}

    public static HttpServer getInstance() {
        if (instance == null) {
            instance = new HttpServer();
        }
        return instance;
    }

    public static void start(String[] args) throws IOException, URISyntaxException {
        ServerSocket serverSocket = null;

        HashMap<String,String> cacheMovies = new HashMap<String,String>();

        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        HttpServer.running = true;
        while (running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            String inputLine, outputLine;

            boolean firstLine = true;
            String uriStr ="";
            String metodo ="";

            while ((inputLine = in.readLine()) != null) {
                if(firstLine){
                    metodo = inputLine.split(" ")[0];
                    System.out.println("metodo"+ metodo);
                    uriStr = inputLine.split(" ")[1];
                    System.out.println("uriStr"+ uriStr);
                    firstLine = false;
                }
                System.out.println("Received: " + inputLine);
                if (!in.ready()) {
                    break;
                }
            }

            URI requestUri = new URI(uriStr);
            OutputStream outputStream = clientSocket.getOutputStream();

            //En esta parte validamos cuando se haga una busqueda, de acuerdo al nombre que nos provee el usuario
            if (uriStr.startsWith("/Movies")){
                //En caso de que ya se halla realizado una busqueda previa sobre esta pelicula no habra necesidad
                //de consultar la api externa  directamente retornaremos lo que se tiene en esta api fachada
                if(cacheMovies.containsKey(uriStr.split("=")[1])){
                    outputLine = cacheMovies.get(uriStr.split("=")[1]);
                    outputStream.write(outputLine.getBytes());
                    //Sino se tiene una busqueda previa esta información como es nueva se hace la busqueda en la api externa
                    //y se guarda en nuestra api fachada
                }else {
                    HttpConection httpApiExternal = new HttpConection();
                    outputLine = httpApiExternal.ResponseRequest(uriStr.split("=")[1]);
                    cacheMovies.put(uriStr.split("=")[1], outputLine);
                }
                // sino escribe el path correto no va ha mostrar la pagina donde se puede consultar las peliculas
            }else {
                try {
                    if (uriStr.startsWith("/action")){
                        outputLine = callService(new URI(uriStr));
                    } else if (uriStr.startsWith("/spring")){
                        outputLine = MySpringBoot.Recibe(new URI(uriStr));
                    } else {
                        outputLine = httpResponse(new URI(uriStr),outputStream);
                    }
                } catch (Exception e) {
                    outputLine = httpError();
                }
            }

            try {
                clientSocket.getOutputStream().write(outputLine.getBytes());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }

    public static String callService(URI requestUri) {

        System.out.println("como esta al inicio" + requestUri);
        String calledServiceUri = requestUri.getPath().substring(7);
        System.out.println("que parte de la uri estoy tomando: "+ calledServiceUri);
        String output = "HTTP/1.1 200 OK\r\n"
                + "Content-Type:text/html\r\n"
                + "\r\n";

        if (service.containsKey(calledServiceUri)) {
            output += service.get(calledServiceUri).handle(requestUri.getQuery());
        }
        return output;
    }

    public static void get(String path, Function s) throws IOException, URISyntaxException {
        service.put(path, s);
    }
    public static void post(String path, Function s) throws IOException, URISyntaxException {
        service.put(path, s);
    }

    public static String httpError() {
        return "HTTP/1.1 400 Not Found\r\n"
                + "Content-Type:text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>Error Not found</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <h1>Error</h1>\n"
                + "    </body>\n";

    }
    public static String httpResponse(URI requestUri, OutputStream outputStream) throws IOException {

        Path file = Paths.get("target/classes/public" + requestUri.getPath());
        File fileSrc = new File(requestUri.getPath());
        String fileType = Files.probeContentType(fileSrc.toPath());
        System.out.println("que dato estas enviaando" + requestUri.getPath());
        String outputline = "HTTP/1.1 200 OK\r\n" //encabezado necesario
                + "Content-Type:" + fileType + "\r\n"
                + "\r\n"; //retorno de carro y salto de linea


        if (fileType.startsWith("image")){
            byte[] Arraybytes = Files.readAllBytes(file);
            outputStream.write(outputline.getBytes());
            outputStream.write(Arraybytes);
        }else{
            Charset charset = Charset.forName("UTF-8");
            BufferedReader reader = Files.newBufferedReader(file, charset);
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.print(line);
                outputline = outputline + line;
            }
        }

        return outputline;


    }

}
