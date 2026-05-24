import com.packages.arrays.*;
import com.packages.linked_list.*;
import com.packages.queues.*;
import com.packages.recursivity.*;
import com.packages.stacks.*;
import com.packages.strings.*;
import com.packages.trees.*;

import com.packages.workshop2.admissions.*;
import com.packages.workshop2.inventory.*;

import java.util.Scanner;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main 
{
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
        String resp;
        do {
            System.out.println("Menú de opciones");
            System.out.println("0. Salir");
            System.out.println("1. Cadenas de caracteres");
            System.out.println("2. Vectores");
            System.out.println("3. Matrices");
            System.out.println("4. Registros");
            System.out.println("5. Lista Simplemente Ligada");
            System.out.println("6. Lista Simplemente Ligada Circular");
            System.out.println("7. Lista Doblemente Ligada");
            System.out.println("8. Pilas");
            System.out.println("9. Colas");
            System.out.println("10. Recursividad");
            System.out.println("11. Árboles binarios");
            System.out.println("12. Tarea 2 - Admisiones y Registro");
            System.out.println("13. Tarea 2 - Inventario de tienda");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    System.out.println("Hasta pronto");
                    break;
                case "1":
                    menuString();
                    break;
                case "2":
                    menuVector();
                    break;
                case "3":
                    menuMatrix();
                    break;
                case "4":
                    menuRecords();
                    break;
                case "5":
                    menuLSL();
                    break;
                case "6":
                    menuLSLC();
                    break;
                case "7":
                    menuLDL();
                    break;
                case "8":
                    menuStacks();
                    break;
                case "9":
                    menuQueues();
                    break;
                case "10":
                    menuRecursivity();
                    break;
                case "11":
                    menuTrees();
                    break;
                case "12":
                    menuAdmissions();
                    break;
                case "13":
                    menuInventory();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }

    public static void menuString()
    {
        String resp;
        StringChar str = new StringChar();
        do {
            System.out.println("Menú Cadenas de Caracteres");
            System.out.println("0. Regresar");
            System.out.println("1. Ingresar texto");
            System.out.println("2. Mostrar texto");
            System.out.println("3. Longitud texto");
            System.out.println("4. Texto mayúscula");
            System.out.println("5. Texto minúscula");
            System.out.println("6. Palíndromo");
            System.out.println("7. Ejemplos cadenas");
            System.out.println("8. Contar carácter del usuario");
            System.out.println("9. Convertir cadena a ASCII");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Ingrese un texto: ");
                    str.setText(input.nextLine());
                    break;
                case "2":
                    System.out.println("Texto ingresado: " + str.getText());
                    break;
                case "3":
                    System.out.println("Longitud texto: " + str.lengthString());
                    break;
                case "4":
                    System.out.println("Texto en mayúscula: " + str.upperString());
                    break;
                case "5":
                    System.out.println("Texto en minúscula: " + str.lowerString());
                    break;
                case "6":
                    str.palindrome();
                    break;
                case "7":
                    ExampleStrings es = new ExampleStrings();
                    break;
                case "8":
                    char charUser;
                    System.out.println("Carácter a contar: ");
                    charUser = input.next().charAt(0);
                    input.nextLine();
                    System.out.println("El carácter " + charUser + " se encuentra " + str.countChar(charUser));
                    break;
                case "9":
                    System.out.println("Cadena ASCII: " + str.stringASCII());
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }


    public static void menuVector()
    {
        String resp;
        int datum, pos;
        Vector v = new Vector();
        
        do {
            System.out.println("\n-------Menú Vectores------");
            System.out.println("0. Regresar");
            System.out.println("1. Agregar dato");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Buscar (secuencial)");
            System.out.println("5. Modificar");
            System.out.println("6. Eliminar");
            System.out.println("7. Insertar");
            System.out.println("8. Ordenar (burbuja)");
            System.out.println("9. Suma datos");
            System.out.println("10. Promedio datos");
            System.out.println("11. Mayor dato");
            System.out.println("12. Menor dato");
            System.out.println("13. Varianza");
            System.out.println("14. Desviación");
            System.out.println("15. Intercambio");
            System.out.println("16. Producto punto");
            System.out.println("17. Eliminar ocurrencias");
            System.out.println("18. Verificar orden ascendente");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Dato vector: ");
                    datum = input.nextInt();
                    input.nextLine();
                    if (v.getN() < v.getT()) {
                        v.addVector(datum);
                    } else {
                        System.out.println("Vector lleno");
                    }
                    // v.addVector(input.nextInt());
                    break;
                case "2":
                    System.out.println("Tamaño vector: " + v.getN());
                    break;
                case "3":
                    v.showVector();
                    break;
                case "4":
                    if (v.getN() > 0) {
                        System.out.print("Dato a buscar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        pos = v.searchSecuencial(datum);
                        if (pos == -1) {
                            System.out.println(datum + " no se encuentra en el vector");
                        } else {
                            System.out.println(datum + " encontrado en posición " + pos);
                        }
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "5":
                    if (v.getN() > 0) {
                        System.out.print("Dato a modificar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        pos = v.searchSecuencial(datum);
                        if (pos == -1) {
                            System.out.println(datum + " no se encuentra en el vector");
                        } else {
                            System.out.print("Nuevo dato: ");
                            datum = input.nextInt();
                            input.nextLine();
                            v.updateVector(datum, pos);
                            System.out.println("Dato actualizado correctamente");
                        }
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "6":
                    if (v.getN() > 0) {
                        System.out.print("Dato a eliminar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        pos = v.searchSecuencial(datum);
                        if (pos == -1) {
                            System.out.println(datum + " no se encuentra en el vector");
                        } else {
                            v.deleteVector(pos);
                            System.out.println("Dato eliminado correctamente");
                        }
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "7":
                    if (v.getN() < v.getT()) {
                        System.out.print("Dato referencia: ");
                        datum = input.nextInt();
                        input.nextLine();
                        pos = v.searchSecuencial(datum);
                        if (pos == -1) {
                            System.out.println(datum + " no se encuentra en el vector");
                        } else {
                            System.out.print("Dato a insertar: ");
                            datum = input.nextInt();
                            input.nextLine();
                            v.insertVector(pos, datum);
                            System.out.println("Dato insertado correctamente");
                        }
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "8":
                    if (v.getN() > 0) {
                        v.sortBubble();
                        System.out.println("Vector ordenado correctamente");
                    } else {
                        System.out.println("Vector vacío");
                    }
                case "9":
                    if (v.getN() > 0) {
                        System.out.println("Suma datos vector: " + v.sumVector());
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "10":
                    if (v.getN() > 0) {
                        System.out.println("Promedio datos vector: " + v.avgVector());
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "11":
                    if (v.getN() > 0) {
                        System.out.println("Mayor dato vector: " + v.maxVector());
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "12":
                    if (v.getN() > 0) {
                        System.out.println("Menor dato vector: " + v.minVector());
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "13":
                    if (v.getN() > 1) {
                        System.out.println("Varianza: " + v.variance());
                    } else {
                        System.out.println("No hay datos suficientes");
                    }
                    break;
                case "14":
                    if (v.getN() > 1) {
                        System.out.println("Desviación estándar: " + v.desviation());
                    } else {
                        System.out.println("No hay datos suficientes");
                    }
                    break;
                case "15":
                    if (v.getN() > 0) {
                        v.interchange();
                        System.out.println("Se intercambiaron los datos del vector");
                    } else {
                        System.out.println("No hay datos");
                    }
                    break;
                case "16":
                    int [] v1 = {2, 5 ,-6};
                    int [] v2 = {1, 8 , 4};
                    System.out.println("Producto punto: " + v.productPoint(v1, v2, 3));
                    break;
                case "17":
                    if (v.getN() > 0) {
                        v.deleteOcurrencies();
                        v.showVector();
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "18":
                    if (v.getN() > 0) {
                        if (v.sortAsc()) {
                            System.out.println("Vector ordenado ascendentemente");
                        } else {
                            System.out.println("El vector no está ordenado ascendentemente");
                        }
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }
    
    public static void menuMatrix()
    {
        String resp;
        int rows, cols;
        Matrix matrix = new Matrix();
        Matrix matrix2 = new Matrix();
        rows = 0;
        cols = 0;
        
        do {
            System.out.println("\n-------Menú Matrices------");
            System.out.println("0. Regresar");
            System.out.println("1. Crear matriz");
            System.out.println("2. Tamaño (orden)");
            System.out.println("3. Mostrar");
            System.out.println("4. Suma matrices");
            System.out.println("5. Diagonal principal");
            System.out.println("6. Diagonal secundaria");
            System.out.println("7. Triángulo arriba");
            System.out.println("8. Triángulo izquierdo");
            System.out.println("9. Triángulo derecho");
            System.out.println("10. Triangular inferior");
            System.out.println("11. Triangular inferior secundaria");
            System.out.println("12. Mayor dato por fila");
            System.out.println("13. Promedio por columna");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Número filas: ");
                    rows = input.nextInt();
                    input.nextLine();
                    System.out.print("Número columnas: ");
                    cols = input.nextInt();
                    input.nextLine();
                    if (rows > 0 && rows <= 50 && cols > 0 && cols <= 50) {
                        matrix.setM(rows);
                        matrix.setN(cols);
                        matrix.createMatrix();
                        System.out.println("Matriz creada correctamente");
                    } else {
                        System.out.println("Tamaño no válido para la matriz");
                    }
                    break;
                case "2":
                    System.out.println("Tamaño matriz: " + matrix.getM() + " x " + matrix.getN());
                    break;
                case "3":
                    matrix.showMatrix(matrix.getMat());
                    break;
                case "4":
                    matrix2.setM(rows);
                    matrix2.setN(cols);
                    matrix2.createMatrix();
                    matrix.sumMatrix(matrix.getMat(), matrix2.getMat());
                    matrix.showMatrix(matrix.getMat());
                    System.out.println();
                    matrix2.showMatrix(matrix2.getMat());
                    System.out.println();
                    matrix.showMatrix(matrix.getMatSum());
                    break;
                case "5":
                    if (matrix.getM() == matrix.getN() && matrix.getM() > 1) {
                        matrix.mainDiagonal();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "6":
                    if (matrix.getM() == matrix.getN() && matrix.getM() > 1) {
                        matrix.secondaryDiagonal();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "7":
                    if (matrix.getM() > 1 && matrix.getN() > 1) {
                        matrix.upTriangle();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "8":
                    if (matrix.getM() > 1 && matrix.getN() > 1) {
                        matrix.leftTriangle();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "9":
                    if (matrix.getM() > 1 && matrix.getN() > 1) {
                        matrix.rightTriangle();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "10":
                    if (matrix.getM() > 1 && matrix.getN() > 1) {
                        matrix.lowerTriangular();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "11":
                    if (matrix.getM() > 1 && matrix.getN() > 1) {
                        matrix.lowerTriangularSecondary();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "12":
                    if (matrix.getM() > 0 && matrix.getN() > 0) {
                        matrix.maxRow();
                    } else {
                        System.out.println("Debe crear la matriz");
                    }
                    break;
                case "13":
                    if (matrix.getM() > 0 && matrix.getN() > 0) {
                        matrix.averageColumn();
                    } else {
                        System.out.println("Debe crear la matriz");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }

    public static void menuRecords()
    {
        String name, resp;
        byte age;
        Persons per = new Persons();
        
        do {
            System.out.println("\n-------Menú Registros------");
            System.out.println("0. Regresar");
            System.out.println("1. Agregar dato");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Persona joven");
            System.out.println("5. Porcentaje mayores");
            // System.out.println("5. Promedio datos");
            // System.out.println("6. Mayor dato");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Nombre: ");
                    name = input.nextLine();
                    System.out.print("Edad: ");
                    age = input.nextByte();
                    input.nextLine();
                    if (per.getN() < per.getT()) {
                        per.createPerson(name, age);
                    } else {
                        System.out.println("Vector lleno");
                    }
                    break;
                case "2":
                    System.out.println("Tamaño vector: " + per.getN());
                    break;
                case "3":
                    per.showPerson();
                    break;
                case "4":
                    if (per.getN() > 0) {
                        per.youngPerson();
                    } else {
                        System.out.println("No hay personas registradas");
                    }
                    break;
                case "5":
                    if (per.getN() > 0) {
                        System.out.println("Porcentaje mayores de edad: " + per.percentageMax18());
                    } else {
                        System.out.println("No hay personas registradas");
                    }
                    break;
                
                // case "9":
                //     if (v.getN() > 0) {
                //         System.out.println("Suma datos vector: " + v.sumVector());
                //     } else {
                //         System.out.println("Vector vacío");
                //     }
                //     break;
                // case "10":
                //     if (v.getN() > 0) {
                //         System.out.println("Promedio datos vector: " + v.avgVector());
                //     } else {
                //         System.out.println("Vector vacío");
                //     }
                //     break;
                // case "11":
                //     if (v.getN() > 0) {
                //         System.out.println("Mayor dato vector: " + v.maxVector());
                //     } else {
                //         System.out.println("Vector vacío");
                //     }
                //     break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }


    public static void menuLSL()
    {
        int datum;
        String resp;
        LSL list = new LSL();
        Node r;
        do {
            System.out.println("\n-------Menú LSL------");
            System.out.println("0. Regresar");
            System.out.println("1. Agregar dato");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Suma");
            System.out.println("5. Promedio");
            System.out.println("6. Buscar");
            System.out.println("7. Modificar");
            System.out.println("8. Eliminar");
            System.out.println("9. Insertar (antes de referencia)");
            System.out.println("10. Mostrar LSL recursiva");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();
            
            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Nuevo dato: ");
                    datum = input.nextInt();
                    input.nextLine();
                    list.createBeginLSL(datum);
                    System.out.println("Dato agregado en la LSL");
                    break;
                case "2":
                    System.out.println("Tamaño lista: " + list.countNodesLSL() + " nodos");
                    break;
                case "3":
                    list.showLSL();
                    break;
                case "4":
                    System.out.println("Suma lista: " + list.sumNodesLSL());
                    break;
                case "5":
                    if (list.head != null) {
                        System.out.println(
                            "Promedio lista: " + 
                            list.sumNodesLSL() / list.countNodesLSL()
                        );
                    } else {
                        System.out.println("Lista vacía");
                    }
                    break;
                case "6":
                    if (list.head != null) {
                        System.out.print("Dato a buscar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        r = list.findLSL(datum);
                        if (r == null) {
                            System.out.println(datum + " no se encuentra en la LSL");
                        } else {
                            System.out.println(datum + " encontrado en dirección " + r);
                        }
                    } else {
                        System.out.println("No ha creado la LSL");
                    }
                    break;
                case "7":
                    if (list.head != null) {
                        System.out.print("Dato a modificar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        r = list.findLSL(datum);
                        if (r == null) {
                            System.out.println(datum + " no se encuentra en la LSL");
                        } else {
                            System.out.print("Nuevo dato: ");
                            datum = input.nextInt();
                            input.nextLine();
                            list.updateNode(r, datum);
                            System.out.println("Se actualizó el dato correctamente");
                            
                        }
                    } else {
                        System.out.println("No ha creado la LSL");
                    }
                    break;
                case "8":
                    if (list.head != null) {
                        System.out.print("Dato a eliminar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        list.deleteNodeLSL(datum);
                    } else {
                        System.out.println("No ha creado la LSL");
                    }
                    break;
                case "9":
                    if (list.head != null) {
                        System.out.print("Dato de referencia: ");
                        datum = input.nextInt();
                        input.nextLine();
                        Node dirRef = list.findReferenceLSL(datum);
                        if (dirRef != null) {
                            System.out.print("Dato a insertar: ");
                            datum = input.nextInt();
                            input.nextLine();
                            list.insertBeforeLSL(dirRef, datum);
                            System.out.println(datum + " se insertó correctamente");
                        }
                    } else {
                        System.out.println("No ha creado la LSL");
                    }
                    break;
                case "10":
                    list.displayLSLRecursivity(list.head);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }
    
    public static void menuLSLC()
    {
        int datum;
        String resp;
        LSLC list = new LSLC();
        Node r;
        do {
            System.out.println("\n-------Menú LSLC------");
            System.out.println("0. Regresar");
            System.out.println("1. Agregar dato");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Buscar");
            System.out.println("5. Modificar");
            System.out.println("6. Eliminar");
            System.out.println("7. Insertar (antes de referencia)");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();
            
            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Nuevo dato: ");
                    datum = input.nextInt();
                    input.nextLine();
                    
                    list.createEndLSLC(datum);
                    System.out.println("Dato agregado en la LSLC");
                    break;
                // case "2":
                //     System.out.println("Tamaño lista: " + list.countNodesLSL() + " nodos");
                //     break;
                case "3":
                    list.showLSLC();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }
    
    public static void menuLDL()
    {
        int datum;
        String resp;
        LDL ldl = new LDL();
        NodeLDL dir;
        do {
            System.out.println("\n-------Menú LDL------");
            System.out.println("0. Regresar");
            System.out.println("1. Agregar dato");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Buscar");
            System.out.println("5. Modificar");
            System.out.println("6. Eliminar");
            System.out.println("7. Insertar (después de referencia)");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();
            
            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Nuevo dato: ");
                    datum = input.nextInt();
                    input.nextLine();
                    ldl.createBeginLDL(datum);
                    System.out.println("Dato agregado en la LDL");
                    break;
                case "2":
                    System.out.println("Tamaño lista: " + ldl.getN() + " nodos");
                    break;
                case "3":
                    ldl.showLDL();
                    break;
                case "4":
                    if (ldl.head != null) {
                        System.out.print("Dato a buscar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        dir = ldl.findLDL(datum);
                        if (dir == null) {
                            System.out.println(datum + " no se encuentra en la LDL");
                        } else {
                            System.out.println(datum + " encontrado en dirección " + dir);
                        }
                    } else {
                        System.out.println("No ha creado la LDL");
                    }
                    break;
                case "5":
                    if (ldl.head != null) {
                        System.out.print("Dato a modificar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        dir = ldl.findLDL(datum);
                        if (dir != null) {
                            System.out.print("Nuevo dato: ");
                            datum = input.nextInt();
                            input.nextLine();
                            ldl.updateNodeLDL(dir, datum);
                            System.out.println("Dato actualizado correctamente");
                        } else {
                            System.out.println(datum + " no se encuentra en la LDL");
                        }
                    } else {
                        System.out.println("No ha creado la LDL");
                    }
                    break;
                case "6":
                    if (ldl.head != null) {
                        System.out.print("Dato a eliminar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        dir = ldl.findLDL(datum);
                        if (dir != null) {
                            ldl.deleteNodeLDL(dir);
                            System.out.println("Dato eliminado correctamente");
                        } else {
                            System.out.println(datum + " no se encuentra en la LDL");
                        }
                    } else {
                        System.out.println("No ha creado la LDL");
                    }
                    break;
                case "7":
                    if (ldl.head != null) {
                        System.out.print("Dato referencia: ");
                        datum = input.nextInt();
                        input.nextLine();
                        dir = ldl.findLDL(datum);
                        if (dir != null) {
                            System.out.print("Dato a insertar: ");
                            datum = input.nextInt();
                            input.nextLine();
                            ldl.insertAfterLDL(dir, datum);
                            System.out.println("Dato insertado correctamente");
                        } else {
                            System.out.println("El dato de referencia " + datum + " no se encuentra en la LDL");
                        }
                    } else {
                        System.out.println("No ha creado la LDL");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }

    public static void menuStacks()
    {
        int datum;
        String resp;
        Stack objStack = new Stack();
        do {
            System.out.println("\n-------Menú Pilas------");
            System.out.println("0. Regresar");
            System.out.println("1. Apilar");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Desapilar");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();
            
            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Dato a apilar: ");
                    datum = input.nextInt();
                    input.nextLine();
                    objStack.stacking(datum);
                    System.out.println("Dato almacenado en la Pila");
                    break;
                case "2":
                    System.out.println("Tamaño pila: " + objStack.getTop());
                    break;
                case "3":
                    if (objStack.getTop() > 0) {
                        objStack.showStack();
                    } else {
                        System.out.println("No ha creado la Pila");
                    }
                    break;
                case "4":
                    if (objStack.getTop() > 0) {
                        System.out.println(objStack.unStacking() + " se desapiló correctamente");
                    } else {
                        System.out.println("No ha creado la Pila");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }

    public static void menuQueues()
    {
        int datum;
        String resp;
        Queue objQueue = new Queue();
        do {
            System.out.println("\n-------Menú Colas------");
            System.out.println("0. Regresar");
            System.out.println("1. Encolar");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Desencolar");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();
            
            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Dato a encolar: ");
                    datum = input.nextInt();
                    input.nextLine();
                    objQueue.addQueue(datum);
                    System.out.println("Dato almacenado en la Cola");
                    break;
                case "2":
                    System.out.println("Tamaño Cola: " + objQueue.getEnd());
                    break;
                case "3":
                    if (objQueue.getEnd() > 0) {
                        objQueue.displayQueue();
                    } else {
                        System.out.println("No ha creado la Cola");
                    }
                    break;
                case "4":
                    if (objQueue.getEnd() > 0) {
                        System.out.println(objQueue.popQueue() + " se desencoló correctamente");
                    } else {
                        System.out.println("No ha creado la Cola");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }

    public static void menuRecursivity()
    {
        int datum;
        String resp;
        // Recursion rec = new Recursion();
        do {
            System.out.println("\n-------Menú Colas------");
            System.out.println("0. Regresar");
            System.out.println("1. Factorial");
            System.out.println("2. Imprimir primeros números naturales Desc");
            System.out.println("3. Imprimir primeros números naturales Asc");
            System.out.println("4. Fibonacci Iterativo");
            System.out.println("5. Fibonacci Recursivo");
            System.out.println("6. Suma cuadrados");
            System.out.println("4. Capital acumulado");
            System.out.println("5. Mostrar vector");
            System.out.println("6. Mostrar LSL");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();
            
            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Ingrese n: ");
                    datum = input.nextInt();
                    input.nextLine();
                    // System.out.println(datum + "! = " + rec.factorial(datum));
                    System.out.println(datum + "! = " + Recursion.factorial(datum));
                    break;
                case "2":
                    System.out.print("Ingrese n: ");
                    datum = input.nextInt();
                    input.nextLine();
                    Recursion.displayNaturalNumbersDesc(datum);
                    break;
                case "3":
                    System.out.print("Ingrese n: ");
                    datum = input.nextInt();
                    input.nextLine();
                    Recursion.displayNaturalNumbersAsc(datum, 1);
                    break;
                case "4":
                    System.out.print("Ingrese n: ");
                    datum = input.nextInt();
                    input.nextLine();
                    Recursion.FibonacciIterative(datum);
                    break;
                case "5":
                    System.out.print("Ingrese n: ");
                    datum = input.nextInt();
                    input.nextLine();
                    for (int j = 1; j <= datum; j++) {
                        System.out.println(Recursion.FibonacciRecursive(j));
                    }
                    break;
                case "6":
                    System.out.print("Ingrese n: ");
                    datum = input.nextInt();
                    input.nextLine();
                    System.out.println("Suma cuadrados: " + Recursion.sumSquare(datum));
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }
    
    public static void menuTrees()
    {
        int datum;
        String resp;
        Trees tree = new Trees();
        // NodeTree mem;
        do {
            System.out.println("\n-------Menú Árboles------");
            System.out.println("0. Regresar");
            System.out.println("1. Crear");
            System.out.println("2. Recorrido preorden");
            System.out.println("3. Recorrido inorden");
            System.out.println("4. Recorrido postorden");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();
            
            switch (resp) {
                case "0":
                    break;
                case "1":
                    // mem = new NodeTree();
                    // tree.setRoot(mem);
                    tree.setRoot(new NodeTree());
                    tree.addNode(tree.getRoot());
                    System.out.println("¡Árbol binario creado!");
                    break;
                case "2":
                    if (tree.getRoot() != null) {
                        tree.preorder(tree.getRoot());
                    } else {
                        System.out.println("Árbol vacío");
                    }
                    break;
                case "3":
                    if (tree.getRoot() != null) {
                        tree.inorder(tree.getRoot());
                    } else {
                        System.out.println("Árbol vacío");
                    }
                    break;
                case "4":
                    if (tree.getRoot() != null) {
                        tree.postorder(tree.getRoot());
                    } else {
                        System.out.println("Árbol vacío");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }
    public static void menuAdmissions()
    {
        String resp;
        String name;
        String answer;
        int fibonacciNumber;
        int suppliedFibonacciNumber;
        boolean specialAttention;

        AttentionQueue mainQueue = new AttentionQueue();
        AdmissionsService admissionsService = new AdmissionsService();

        do {
            System.out.println("\n-------Menú Tarea 2 - Admisiones y Registro------");
            System.out.println("0. Regresar");
            System.out.println("1. Registrar ingreso a la fila");
            System.out.println("2. Mostrar fila de personas en espera");
            System.out.println("3. Atender persona");
            System.out.println("4. Mostrar promedio de tiempo de atención de los funcionarios");
            System.out.println("5. Pasar usuarios a otra fila sin perder el orden");
            System.out.println("6. Contar personas atendidas en un intervalo");
            System.out.println("7. Mostrar historial de personas atendidas");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();
            System.out.println();

            switch (resp) {
                case "0":
                    break;

                case "1":
                    System.out.print("Nombre de la persona: ");
                    name = input.nextLine();

                    if (!name.equals("")) {
                        System.out.print("¿Tiene atención especial? S/N: ");
                        answer = input.nextLine();

                        specialAttention = answer.equalsIgnoreCase("S");

                        if (specialAttention) {
                            fibonacciNumber = admissionsService.assignFibonacciNumber();

                            mainQueue.registerPerson(name, true, fibonacciNumber);

                            System.out.println("Persona registrada con atención especial.");
                            System.out.println("Número fibonacci asignado: " + fibonacciNumber);
                            System.out.println("Debe suministrar este número al momento de ser atendida.");
                        } else {
                            mainQueue.registerPerson(name, false, 0);
                            System.out.println("Persona registrada en la fila.");
                        }
                    } else {
                        System.out.println("El nombre no puede estar vacío.");
                    }
                    break;

                case "2":
                    mainQueue.displayQueue();
                    break;

                case "3":
                    if (!mainQueue.isEmpty()) {
                        suppliedFibonacciNumber = 0;

                        if (mainQueue.firstPersonHasSpecialAttention()) {
                            System.out.print("La persona tiene atención especial. Ingrese el número fibonacci asignado: ");
                            suppliedFibonacciNumber = Integer.parseInt(input.nextLine());
                        }

                        RecordAttentionPerson attendedPerson = mainQueue.attendPerson(suppliedFibonacciNumber);

                        if (attendedPerson != null) {
                            System.out.println("La atención ha iniciado.");
                            System.out.println("Presione ENTER cuando el funcionario termine la atención...");
                            input.nextLine();

                            attendedPerson.attentionEndDateTime = LocalDateTime.now();

                            Duration attentionTime = Duration.between(
                                attendedPerson.attentionDateTime,
                                attendedPerson.attentionEndDateTime
                            );

                            long totalSeconds = attentionTime.getSeconds();
                            long minutes = totalSeconds / 60;
                            long seconds = totalSeconds % 60;

                            System.out.println("La atención finalizó.");
                            System.out.println("Tiempo de atención del funcionario: " + minutes + " minutos y " + seconds + " segundos.");

                            admissionsService.saveAttendedPerson(attendedPerson);
                        }
                    } else {
                        System.out.println("No hay personas en la fila.");
                    }
                    break;

                case "4":
                    admissionsService.showAverageAttentionTime();
                    break;

                case "5":
                    if (!mainQueue.isEmpty()) {
                        int previousQueueNumber = mainQueue.getQueueNumber();
                        int newQueueNumber = previousQueueNumber + 1;

                        AttentionQueue newQueue = new AttentionQueue(newQueueNumber);

                        mainQueue.moveToAnotherQueue(newQueue);
                        mainQueue = newQueue;

                        System.out.println("Se trasladó la fila #" + previousQueueNumber + " a la fila #" + newQueueNumber + " sin perder el orden.");
                        System.out.println("La fila #" + newQueueNumber + " ahora queda como fila activa.");

                        mainQueue.displayQueue();
                    } else {
                        System.out.println("No hay personas para trasladar.");
                    }
                    break;

                case "6":
                    try {
                        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                        System.out.println("Formato de fecha: dd/MM/yyyy");

                        System.out.print("Ingrese fecha inicial: ");
                        LocalDate startDate = LocalDate.parse(input.nextLine(), dateFormat);

                        System.out.print("Ingrese fecha final: ");
                        LocalDate endDate = LocalDate.parse(input.nextLine(), dateFormat);

                        LocalDateTime startDateTime = startDate.atStartOfDay();
                        LocalDateTime endDateTime = endDate.atTime(23, 59, 59);

                        admissionsService.countAttendedInInterval(startDateTime, endDateTime);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de fecha inválido.");
                    }
                    break;

                case "7":
                    admissionsService.displayAttendedPeople();
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }
    public static void menuInventory()
    {
        String resp;
        String code;
        String productTypeText;
        char productType;
        double price;
        int amount;

        InventoryService inventoryService = new InventoryService();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        do {
            System.out.println("\n-------Menu Tarea 2 - Inventario de tienda------");
            System.out.println("0. Regresar");
            System.out.println("1. Registrar ingreso de producto");
            System.out.println("2. Listar productos disponibles por tipo");
            System.out.println("3. Mostrar producto mas proximo a vencerse");
            System.out.println("4. Contar productos ingresados y salidos en un intervalo");
            System.out.println("5. Alistar productos para la venta");
            System.out.println("6. Ubicar productos proximos a vencer en la parte superior");
            System.out.print("Ingrese su opcion: ");
            resp = input.nextLine();

            System.out.println();

            switch (resp) {
                case "0":
                    break;

                case "1":

                    boolean validCode = false;
                    code = "";

                    do {
                        System.out.print("Codigo del producto: ");
                        code = input.nextLine();

                        if (code.equals("")) {
                            System.out.println("El codigo del producto es obligatorio.");
                        } else if (inventoryService.productCodeExists(code)) {
                            System.out.println("Ya existe un producto registrado con el codigo " + code + ".");
                            System.out.println("Ingrese un codigo diferente.");
                        } else {
                            validCode = true;
                        }

                    } while (!validCode);


                    boolean validProductType = false;
                    productType = ' ';

                    do {
                        System.out.print("Tipo de producto A/B: ");
                        productTypeText = input.nextLine();

                        if (!productTypeText.equals("")) {
                            productType = productTypeText.charAt(0);

                            if (productType == 'a') {
                                productType = 'A';
                            } else if (productType == 'b') {
                                productType = 'B';
                            }

                            if (productType == 'A' || productType == 'B') {
                                validProductType = true;
                            } else {
                                System.out.println("Tipo de producto no valido. Debe ingresar A o B.");
                            }
                        } else {
                            System.out.println("Debe ingresar un tipo de producto.");
                        }

                    } while (!validProductType);


                    boolean validPrice = false;
                    price = 0;

                    do {
                        try {
                            System.out.print("Precio del producto: ");
                            price = Double.parseDouble(input.nextLine());

                            if (price > 0) {
                                validPrice = true;
                            } else {
                                System.out.println("El precio debe ser mayor que cero.");
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("El precio debe ser numerico.");
                        }

                    } while (!validPrice);


                    boolean validExpirationDate = false;
                    LocalDate expirationDate = null;
                    LocalDate currentDate = LocalDate.now();

                    do {
                        try {
                            System.out.print("Fecha de vencimiento dd/MM/yyyy: ");
                            expirationDate = LocalDate.parse(input.nextLine(), dateFormat);

                            if (expirationDate.isBefore(currentDate)) {
                                System.out.println("La fecha de vencimiento no puede ser anterior a la fecha actual.");
                            } else {
                                validExpirationDate = true;
                            }

                        } catch (DateTimeParseException e) {
                            System.out.println("Formato de fecha invalido. Ejemplo correcto: 06/05/2026");
                        }

                    } while (!validExpirationDate);


                    inventoryService.registerProduct(code, productType, price, expirationDate);

                    break;

                case "2":
                    System.out.print("Ingrese tipo de producto A/B: ");
                    productTypeText = input.nextLine();

                    if (!productTypeText.equals("")) {
                        productType = productTypeText.charAt(0);
                        inventoryService.listProductsByType(productType);
                    } else {
                        System.out.println("Debe ingresar un tipo de producto.");
                    }
                    break;

                case "3":
                    inventoryService.showNearestExpirationProduct();
                    break;

                case "4":
                    try {
                        System.out.println("Formato de fecha: dd/MM/yyyy");

                        System.out.print("Ingrese fecha inicial: ");
                        LocalDate startDate = LocalDate.parse(input.nextLine(), dateFormat);

                        System.out.print("Ingrese fecha final: ");
                        LocalDate endDate = LocalDate.parse(input.nextLine(), dateFormat);

                        LocalDateTime startDateTime = startDate.atStartOfDay();
                        LocalDateTime endDateTime = endDate.atTime(23, 59, 59);

                        inventoryService.countProductsMovementInInterval(startDateTime, endDateTime);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de fecha invalido.");
                    }
                    break;
                case "5":
                    boolean validTypeForSale = false;
                    productType = ' ';

                    do {
                        System.out.print("Ingrese tipo de producto a alistar A/B: ");
                        productTypeText = input.nextLine();

                        if (!productTypeText.equals("")) {
                            productType = productTypeText.charAt(0);

                            if (productType == 'a') {
                                productType = 'A';
                            } else if (productType == 'b') {
                                productType = 'B';
                            }

                            if (productType == 'A' || productType == 'B') {
                                validTypeForSale = true;
                            } else {
                                System.out.println("Tipo de producto no valido. Debe ingresar A o B.");
                            }
                        } else {
                            System.out.println("Debe ingresar un tipo de producto.");
                        }

                    } while (!validTypeForSale);

                    int availableProducts = inventoryService.getAvailableProductsCount(productType);

                    if (availableProducts > 0) {
                        System.out.println("Productos disponibles en estantería tipo " + productType + ": " + availableProducts);

                        boolean validAmount = false;
                        amount = 1;

                        do {
                            try {
                                System.out.print("Cantidad de productos a alistar. Si desea alistar 1, ingrese 0: ");
                                amount = Integer.parseInt(input.nextLine());

                                if (amount <= 0) {
                                    amount = 1;
                                }

                                if (amount <= availableProducts) {
                                    validAmount = true;
                                } else {
                                    System.out.println("No se puede alistar esa cantidad.");
                                    System.out.println("Solo hay " + availableProducts + " productos disponibles.");
                                }

                            } catch (NumberFormatException e) {
                                System.out.println("La cantidad debe ser numerica.");
                            }

                        } while (!validAmount);

                        inventoryService.prepareProductsForSale(productType, amount);
                    } else {
                        System.out.println("No hay productos disponibles en la estantería tipo " + productType + ".");
                    }
                    break;

                case "6":
                    System.out.print("Ingrese tipo de producto A/B: ");
                    productTypeText = input.nextLine();

                    if (!productTypeText.equals("")) {
                        productType = productTypeText.charAt(0);

                        inventoryService.moveNearExpirationProductsToTop(productType);
                    } else {
                        System.out.println("Debe ingresar un tipo de producto.");
                    }
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (!resp.equals("0"));
    }
    
}
