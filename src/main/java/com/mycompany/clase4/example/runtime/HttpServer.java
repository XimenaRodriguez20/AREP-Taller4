/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clase4.example.runtime;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 *
 * @author ximena.rodriguez
 */
public class HttpServer {

    //almaceno los componentes
    static HashMap<String, Method> componentes = new HashMap<String, Method>();

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        //1.Cargar los componentes anotados con @Component
        //Para el primer prototipo lo leere de la linea de comandos
        //para la entrega final lo deben leer en disco
        Class c = Class.forName(args[0]);

        if (c.isAnnotationPresent(Component.class)) {

            //2.Almacenar todos los metodos en una estructura llave valor Hashmap
            // la llave sera el path del webService y el valor son metodos
            //todos los metodos que se van a ejecutar seran estaticos
            for (Method m: c.getDeclaredMethods()){
                if(m.isAnnotationPresent(GetMapping.class)){
                    componentes.put(m.getAnnotation(GetMapping.class).value(),m);
                }
            }
            
        }
        //3.Si llega una ruta que esta enlazada aun componente 
        //Ejecute el componente no olvide los encabezados
        // Implemente pasar parametros
        //String pathDelGet ="/components/prueba";
        String pathDelGet ="/components/hola";

        Method m = componentes.get(pathDelGet.substring(11));
        System.out.println("que esta haciendo el pathGet: " + m);

        if(m != null){
            System.out.println("funciona" + m.invoke(null));
        }

    }
}
