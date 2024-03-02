/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.escuelaing.components;

import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author ximena.rodriguez
 */
public class MySpringBoot {

    //almaceno los componentes
    static HashMap<String, Method> componentes = new HashMap<String, Method>();
    private static MySpringBoot instance = null;

    public static boolean running = false;
    public static MySpringBoot getInstance() {
        if (instance == null) {
            instance = new MySpringBoot();
        }
        return instance;
    }

    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, URISyntaxException {

        //1.Cargar los componentes anotados con @Component
        //Para el primer prototipo lo leere de la linea de comandos
        //para la entrega final lo deben leer en disco
        running = true;
        if (args.length == 0 ){
            Reflections reflections = new Reflections("com.escuelaing");
            Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Component.class);

            for (Class<?> c : classes) {
                System.out.println("clase a ejecutar ----" + c);
                DatosComponents(c);
            }
            //3.Si llega una ruta que esta enlazada aun componente
            //Ejecute el componente no olvide los encabezados
            // Implemente pasar parametros
            //String pathDelGet ="/components/prueba";
            String pathDelGet = "/components/hola";
            System.out.println("-----"+ pathDelGet);

            Method m = componentes.get(pathDelGet.substring(11));
            System.out.println("que esta haciendo el pathGet: " + m);

            if (m != null) {
                System.out.println("funciona" + m.invoke(null));
            }
        } else if (args.length > 0) {
            Class c = Class.forName(args[0]);
            DatosComponents(c);

            String pathDelGet = args[1];
            URI param = new URI(args[2]);
            System.out.println("-----"+ pathDelGet);
            System.out.println("+++++++"+ param);
            System.out.println("hash"+ componentes.toString());
            Method m = componentes.get(pathDelGet);
            System.out.println("que esta haciendo el pathGet: " + m);

            if (m != null) {
                System.out.println("funciona" + m.invoke(null, param));

        }
    }


    }

    public static void DatosComponents(Class c){
        if (c.isAnnotationPresent(Component.class)) {

            //2.Almacenar todos los metodos en una estructura llave valor Hashmap
            // la llave sera el path del webService y el valor son metodos
            //todos los metodos que se van a ejecutar seran estaticos
            for (Method m : c.getDeclaredMethods()) {
                if (m.isAnnotationPresent(GetMapping.class)) {
                    System.out.println("que estas acciendo---" + m.getAnnotation(GetMapping.class).value());
                    componentes.put(m.getAnnotation(GetMapping.class).value(), m);
                }
            }

        }
    }


    public static String Recibe(URI url) throws InvocationTargetException, IllegalAccessException {
        String path = url.getPath();

        Method m = null;
        for (String metodo: componentes.keySet()) {
            if (path.startsWith(metodo)) {
                m = componentes.get(metodo);
            }
        }
        System.out.println("que esta haciendo el pathGet: " + m);
        String respuesta = null;

        if (m != null) {
            respuesta = (String) m.invoke(null, path.substring(7));
            System.out.println("funciona" + respuesta);
        }
        return respuesta;
    }
        
}


