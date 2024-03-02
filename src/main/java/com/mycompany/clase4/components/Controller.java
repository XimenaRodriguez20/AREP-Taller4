/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clase4.components;

import com.mycompany.clase4.example.runtime.Component;
import com.mycompany.clase4.example.runtime.GetMapping;
import com.mycompany.clase4.example.runtime.HttpServer;
import com.mycompany.clase4.example.runtime.MySpringBoot;

import java.net.URI;

/**
 *
 * @author ximena.rodriguez
 */
@Component
public class Controller {

    @GetMapping("/Movies")
    public static String pelicula(){
        System.out.println( "palabra que sale");
        return "como estas";
    }
    @GetMapping("/action")
    public static String css(URI value){
        HttpServer.callService(value);
        System.out.println(HttpServer.callService(value));
        return "hello";
    }

    @GetMapping("/spring")
    public static String springResponse(String value){
        return "HTTP/1.1 200 OK\r\n" //encabezado necesario
                + "Content-Type:text/html\r\n"
                + "\r\n"+
                "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Spring Method Test</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1 style=\"font-weight: bold; font-size: 36px; text-align: center; margin-top: 20%;\">El método de Spring <strong>funciona</strong> segun la url:" + value + "</h1>\n" +
                "</body>\n" +
                "</html>";
    }
}
