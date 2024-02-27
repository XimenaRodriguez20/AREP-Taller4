/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clase4.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *
 * @author ximena.rodriguez
 */
public class InvokeMain {

    public static void main(String... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> c = Class.forName(args[0]);
            Class[] argTypes = new Class[]{int.class, int.class};
            Method main = c.getDeclaredMethod("suma", argTypes);
            String[] mainArgs = Arrays.copyOfRange(args, 1, args.length);
            System.out.format("invoking %s.main()%n", c.getName());
            main.invoke(null,Integer.parseInt(mainArgs[0]) , Integer.parseInt(mainArgs[1]));
            // production code should handle these exceptions more gracefully
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        } catch (NoSuchMethodException x) {
            x.printStackTrace();
        }
    }
}