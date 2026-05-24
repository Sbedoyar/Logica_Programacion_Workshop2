package com.packages.strings;

public class ExampleStrings 
{
    public ExampleStrings()
    {
        String object = new String("Invocando al constructor de la clase String");
        System.out.println("Cadena: " + object);
        String cad1 = object.concat(". Cadena concatenada");
        System.out.println("Cadena concatenada con concat: " + cad1);
        
        int a, b, c;
        a = 5;
        b = 2;
        c = 0;
        boolean x = !(a > b) && a > c;
        System.out.println("x: " + x);
        
        String c1, c2;
        c1 = "hola";
        c2 = "Hola";
        // if (c1 == c2) {
        if (c1.equalsIgnoreCase(c2)) {
            System.out.println("Cadenas iguales");
        } else {
            System.out.println("Cadenas diferentes");
        }
        
        String aa = String.valueOf(b);
        System.out.println("valueOf: " + aa);
        
        // object = "Invocando al constructor de la clase String"
        int pos = object.indexOf("al", 0);
        System.out.println("Posición de al: " + pos);
        pos = object.indexOf("cando", 0);
        System.out.println("Posición de cando: " + pos);
        pos = object.indexOf("zzz", 0);
        System.out.println("Posición de zzz: " + pos);
        char z = object.charAt(0);
        System.out.println("z: " + z);
        z = object.charAt(14);
        System.out.println("z: " + z);
        char w = '5';
        System.out.println("ASCII(5): " + (int) w);
        System.out.println("Char(65): " + (char) 65);

        String subString = object.substring(13, 24);
        System.out.println("Subcadena: " + subString);
            
    }
}
