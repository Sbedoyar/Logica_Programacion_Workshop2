package com.packages.workshop2.inventory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * Administra el inventario de la tienda.
 * Maneja dos estanterías independientes: una para productos tipo A y otra para tipo B.
 */
public class InventoryService 
{
    private final int T = 100;

    private ProductStack shelfA;
    private ProductStack shelfB;

    private int inputCount;
    private int outputCount;

    private RecordProduct inputHistory[] = new RecordProduct[T];
    private RecordProduct outputHistory[] = new RecordProduct[T];

    public InventoryService()
    {
        shelfA = new ProductStack('A');
        shelfB = new ProductStack('B');
        inputCount = 0;
        outputCount = 0;
    }

    /*
     * Convierte el tipo de producto a mayúscula si el usuario ingresa a o b.
     */
    private char normalizeProductType(char productType)
    {
        if (productType == 'a') {
            productType = 'A';
        } else if (productType == 'b') {
            productType = 'B';
        }

        return productType;
    }

    /*
     * Retorna la estantería correspondiente al tipo de producto.
     */
    private ProductStack getShelfByType(char productType)
    {
        ProductStack shelf = null;
        productType = normalizeProductType(productType);

        if (productType == 'A') {
            shelf = shelfA;
        } else if (productType == 'B') {
            shelf = shelfB;
        }

        return shelf;
    }

    /*
     * Guarda el producto en el historial de ingresos.
     */
    private void saveInputProduct(RecordProduct product)
    {
        if (inputCount < T) {
            inputHistory[inputCount] = product;
            inputCount++;
        } else {
            System.out.println("El historial de ingresos está lleno.");
        }
    }

    /*
     * Guarda el producto en el historial de salidas.
     */
    private void saveOutputProduct(RecordProduct product)
    {
        if (outputCount < T) {
            outputHistory[outputCount] = product;
            outputCount++;
        } else {
            System.out.println("El historial de salidas está lleno.");
        }
    }

    /*
     * Sirve para validar si el cod del producto ya existe
     */
    public boolean productCodeExists(String code)
    {
        boolean exists = false;

        for (int i = 0; i < inputCount; i++) {
            if (inputHistory[i].code.equalsIgnoreCase(code)) {
                exists = true;
            }
        }

        return exists;
    }

    /*
     * Registra el ingreso de un producto al inventario.
     */
    public void registerProduct(String code, char productType, double price, LocalDate expirationDate)
    {
        ProductStack shelf = getShelfByType(productType);

        if (productCodeExists(code)) {
        System.out.println("Ya existe un producto registrado con el código " + code + ".");
        return;
        }

        if (shelf != null) {
            if (!shelf.isFull()) {
                RecordProduct product = new RecordProduct();

                product.code = code;
                product.type = normalizeProductType(productType);
                product.price = price;
                product.expirationDate = expirationDate;
                product.registerDateTime = LocalDateTime.now();
                product.exitDateTime = null;
                product.available = true;

                shelf.pushProduct(product);
                saveInputProduct(product);

                System.out.println("Producto registrado en la estantería tipo " + product.type + ".");
            } else {
                System.out.println("La estantería tipo " + normalizeProductType(productType) + " está llena.");
            }
        } else {
            System.out.println("Tipo de producto no válido. Debe ser A o B.");
        }
    }

    /*
     * Lista los productos disponibles de acuerdo con el tipo seleccionado.
     */
    public void listProductsByType(char productType)
    {
        ProductStack shelf = getShelfByType(productType);

        if (shelf != null) {
            shelf.displayProducts();
        } else {
            System.out.println("Tipo de producto no válido. Debe ser A o B.");
        }
    }

    /*
     * Muestra el producto con fecha más próxima a vencerse entre ambas estanterías.
     */
    public void showNearestExpirationProduct()
    {
        RecordProduct nearestProduct = null;

        for (int i = 0; i < shelfA.getTop(); i++) {
            RecordProduct product = shelfA.getProductByPosition(i);

            if (product != null) {
                if (nearestProduct == null || product.expirationDate.isBefore(nearestProduct.expirationDate)) {
                    nearestProduct = product;
                }
            }
        }

        for (int i = 0; i < shelfB.getTop(); i++) {
            RecordProduct product = shelfB.getProductByPosition(i);

            if (product != null) {
                if (nearestProduct == null || product.expirationDate.isBefore(nearestProduct.expirationDate)) {
                    nearestProduct = product;
                }
            }
        }

        if (nearestProduct != null) {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            System.out.println("Producto con fecha más próxima a vencerse:");
            System.out.println("Código: " + nearestProduct.code);
            System.out.println("Tipo: " + nearestProduct.type);
            System.out.println("Precio: " + nearestProduct.price);
            System.out.println("Fecha de vencimiento: " + nearestProduct.expirationDate.format(dateFormat));
            System.out.println("Fecha y hora de registro: " + nearestProduct.registerDateTime.format(dateTimeFormat));
        } else {
            System.out.println("No hay productos registrados en las estanterías.");
        }
    }

    /*
     * Retorna la cantidad de productos disponibles en la estantería seleccionada.
     */
    public int getAvailableProductsCount(char productType)
    {
        int count = -1;
        ProductStack shelf = getShelfByType(productType);

        if (shelf != null) {
            count = shelf.getTop();
        }

        return count;
    }

    /*
    * Alista productos para la venta.
    * Los productos alistados salen del inventario.
    */
    public void prepareProductsForSale(char productType, int amount)
    {
        ProductStack shelf = getShelfByType(productType);
        int preparedProducts = 0;

        if (amount <= 0) {
            amount = 1;
        }

        if (shelf != null) {
            if (!shelf.isEmpty()) {
                if (amount <= shelf.getTop()) {
                    while (preparedProducts < amount && !shelf.isEmpty()) {
                        RecordProduct product = shelf.popProduct();

                        if (product != null) {
                            product.exitDateTime = LocalDateTime.now();
                            product.available = false;

                            saveOutputProduct(product);
                            preparedProducts++;

                            System.out.println("Producto alistado para la venta: " + product.code);
                        }
                    }

                    System.out.println("Total productos alistados: " + preparedProducts);
                } else {
                    System.out.println("No se puede alistar esa cantidad.");
                    System.out.println("Productos disponibles en estantería tipo " + normalizeProductType(productType) + ": " + shelf.getTop());
                }
            } else {
                System.out.println("No hay productos disponibles en la estantería tipo " + normalizeProductType(productType) + ".");
            }
        } else {
            System.out.println("Tipo de producto no valido. Debe ser A o B.");
        }
    }
    /*
     * Verifica si una fecha y hora está dentro de un intervalo.
     */
    
    private boolean isDateTimeInInterval(LocalDateTime dateTime, LocalDateTime startDateTime, LocalDateTime endDateTime)
    {
        boolean inInterval = false;

        if (dateTime != null) {
            if ((dateTime.isEqual(startDateTime) || dateTime.isAfter(startDateTime)) &&
                (dateTime.isEqual(endDateTime) || dateTime.isBefore(endDateTime))) {
                inInterval = true;
            }
        }

        return inInterval;
    }

    /*
     * Cuenta cuántos productos ingresaron y cuántos salieron en un intervalo.
     */
    public void countProductsMovementInInterval(LocalDateTime startDateTime, LocalDateTime endDateTime)
    {
        int inputs = 0;
        int outputs = 0;

        if (startDateTime.isAfter(endDateTime)) {
            System.out.println("La fecha inicial no puede ser mayor que la fecha final.");
        } else {
            for (int i = 0; i < inputCount; i++) {
                if (isDateTimeInInterval(inputHistory[i].registerDateTime, startDateTime, endDateTime)) {
                    inputs++;
                }
            }

            for (int i = 0; i < outputCount; i++) {
                if (isDateTimeInInterval(outputHistory[i].exitDateTime, startDateTime, endDateTime)) {
                    outputs++;
                }
            }

            System.out.println("Productos ingresados en el intervalo: " + inputs);
            System.out.println("Productos salidos en el intervalo: " + outputs);
        }
    }

    
    /*
    * Organiza la estantería dejando en la parte superior
    * los productos con fecha de vencimiento más próxima.
    */
    public void moveNearExpirationProductsToTop(char productType)
    {
        ProductStack shelf = getShelfByType(productType);

        RecordProduct products[] = new RecordProduct[T];
        int productCount = 0;

        if (shelf != null) {
            if (!shelf.isEmpty()) {

                while (!shelf.isEmpty()) {
                    products[productCount] = shelf.popProduct();
                    productCount++;
                }

                /*
                * Ordenamiento manual por fecha de vencimiento.
                * No se usan funciones avanzadas de Java.
                */
                for (int i = 0; i < productCount - 1; i++) {
                    for (int j = i + 1; j < productCount; j++) {
                        if (products[j].expirationDate.isBefore(products[i].expirationDate)) {
                            RecordProduct aux = products[i];
                            products[i] = products[j];
                            products[j] = aux;
                        }
                    }
                }

                /*
                * Se insertan primero los de fecha más lejana,
                * para que los de fecha más próxima queden arriba.
                */
                for (int i = productCount - 1; i >= 0; i--) {
                    shelf.pushProduct(products[i]);
                }

                System.out.println("Productos organizados por fecha de vencimiento.");
                System.out.println("Los productos más próximos a vencer quedaron en la parte superior.");
            } else {
                System.out.println("No hay productos en la estantería tipo " + normalizeProductType(productType) + ".");
            }
        } else {
            System.out.println("Tipo de producto no valido. Debe ser A o B.");
        }
    }
}