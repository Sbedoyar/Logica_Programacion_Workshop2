package com.packages.workshop2.inventory;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
Representa el registro de un producto que ingresa al inventario.
Cada producto pertenece al tipo A o B y se organiza en su respectiva estantería.
*/
public class RecordProduct 
{
    public String code;
    public char type;
    public double price;
    public LocalDate expirationDate;
    public LocalDateTime registerDateTime;
    public LocalDateTime exitDateTime;
    public boolean available;

    /*
    Inicializa el producto con valores por defecto.
    La fecha y hora de registro se toma automáticamente del sistema.
    */
    public RecordProduct()
    {
        code = "";
        type = ' ';
        price = 0;
        expirationDate = null;
        registerDateTime = LocalDateTime.now();
        exitDateTime = null;
        available = true;
    }
}