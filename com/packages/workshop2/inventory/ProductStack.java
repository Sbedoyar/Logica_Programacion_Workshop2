package com.packages.workshop2.inventory;

import java.time.format.DateTimeFormatter;

/*
 * Maneja una estantería de productos usando estructura de pila.
 * Cada estantería almacena productos de un solo tipo: A o B.
 */
public class ProductStack 
{
    private final int T = 100;
    private int top;
    private char productType;
    private RecordProduct stack[] = new RecordProduct[T];

    public ProductStack(char productType)
    {
        top = 0;
        this.productType = productType;
    }

    public int getTop()
    {
        return top;
    }

    public char getProductType()
    {
        return productType;
    }

    public boolean isEmpty()
    {
        return top == 0;
    }

    public boolean isFull()
    {
        return top == T;
    }

    /*
     * Agrega un producto en la parte superior de la estantería.
     */
    public void pushProduct(RecordProduct product)
    {
        if (!isFull()) {
            stack[top] = product;
            top++;
        } else {
            System.out.println("La estantería de productos tipo " + productType + " está llena.");
        }
    }

    /*
     * Retira el producto ubicado en la parte superior de la estantería.
     */
    public RecordProduct popProduct()
    {
        RecordProduct product = null;

        if (!isEmpty()) {
            top--;
            product = stack[top];
            stack[top] = null;
        } else {
            System.out.println("No hay productos en la estantería tipo " + productType + ".");
        }

        return product;
    }

    /*
     * Permite consultar un producto de la estantería por su posición.
     */
    public RecordProduct getProductByPosition(int position)
    {
        RecordProduct product = null;

        if (position >= 0 && position < top) {
            product = stack[position];
        }

        return product;
    }

    /*
     * Lista los productos disponibles en la estantería.
     */
    public void displayProducts()
    {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        if (!isEmpty()) {
            System.out.println("Productos disponibles en estantería tipo " + productType + ":");
            System.out.println("Código\tTipo\tPrecio\tVencimiento\tRegistro");

            for (int i = top - 1; i >= 0; i--) {
                System.out.println(
                    stack[i].code + "\t" +
                    stack[i].type + "\t" +
                    stack[i].price + "\t" +
                    stack[i].expirationDate.format(dateFormat) + "\t" +
                    stack[i].registerDateTime.format(dateTimeFormat)
                );
            }

            System.out.println("Total productos en estantería tipo " + productType + ": " + top);
        } else {
            System.out.println("No hay productos disponibles en la estantería tipo " + productType + ".");
        }
    }
}