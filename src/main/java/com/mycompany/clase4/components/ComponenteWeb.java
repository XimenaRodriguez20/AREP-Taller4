/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clase4.components;

import com.mycompany.clase4.example.runtime.Component;
import com.mycompany.clase4.example.runtime.GetMapping;

/**
 *
 * @author ximena.rodriguez
 */
@Component
public class ComponenteWeb {
    
    @GetMapping("/prueba")
    public static String hello(){
        System.out.println( "palabra que sale");
        return "hello";
    }
    @GetMapping("/hola")
    public static String prueba2(){
        System.out.println( "palabra que sale");
        return "como estas";
    }
    
}
