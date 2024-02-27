/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.clase4.example;

import static java.lang.System.out;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/**
 *
 * @author ximena.rodriguez
 */
public class Clase4 {

    public static void main(String[] args) throws ClassNotFoundException {
        //Class c = String.class;
        //obtener un objeto que representa la clase
        Class c = Class.forName("com.mycompany.clase4.alumno");
        Field[] campos = c.getFields();
        printMembers(campos,"campos"); 
        
        //sacamos constructores
        Constructor[] constructores = c.getConstructors();
        printMembers(constructores,"constructores"); 
        
        //sacamos metodos
        Method [] metodos = c.getMethods();
        printMembers(metodos,"metodos"); 
    }
    
    public static void suma(int a,int b) {
        System.out.println("a+b"+ (a+b));
    }

    private static void printMembers(Member[] mbrs, String s) {
        
        //%s -> cadena, %n -> salto de linea
        // instanceof nos indica, si es una instancia concreta
        out.format("%s:%n", s);
        for (Member mbr : mbrs) {
            if (mbr instanceof Field) {
                out.format(" %s%n", ((Field) mbr).toGenericString());
            } else if (mbr instanceof Constructor) {
                out.format(" %s%n", ((Constructor) mbr).toGenericString());
            } else if (mbr instanceof Method) {
                out.format(" %s%n", ((Method) mbr).toGenericString());
            }
        }
        if (mbrs.length == 0) {
            out.format(" -- No %s --%n", s);
        }
        out.format("%n");
    }
    
    
}
