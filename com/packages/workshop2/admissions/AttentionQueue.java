package com.packages.workshop2.admissions;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*Maneja la fila de atención de personas del departamento de Admisiones.
Esta clase adapta la estructura de cola vista en clase, pero usando
un arreglo de objetos RecordAttentionPerson.*/

public class AttentionQueue 
{
    private final int T = 100;
    private int end;
    private int queueNumber;
    private RecordAttentionPerson queue[] = new RecordAttentionPerson[T];

    public AttentionQueue()
    {
        end = 0;
        queueNumber = 1;
    }

    public AttentionQueue(int queueNumber)
    {
        end = 0;
        this.queueNumber = queueNumber;
    }

    public int getQueueNumber()
    {
        return queueNumber;
    }

    public int getEnd() 
    {
        return end;
    }

    public int getT() 
    {
        return T;
    }

    public boolean isEmpty()
    {
        return end == 0;
    }

    public boolean isFull()
    {
        return end == T;
    }

    /*
    Indica si la primera persona de la fila tiene atención especial.
    */
    public boolean firstPersonHasSpecialAttention()
    {
        boolean specialAttention = false;

        if (!isEmpty()) {
            specialAttention = queue[0].specialAttention;
        }

        return specialAttention;
    }

    /*
    Agrega una persona al final de la fila.
    Este método se usa para las personas con atención normal.
    */
    public void addQueue(RecordAttentionPerson person)
    {
        if (!isFull()) {
            queue[end] = person;
            end++;
        } else {
            System.out.println("La fila está llena.");
        }
    }

    /*
    Agrega una persona al inicio de la fila.
    Este método se usa cuando la persona tiene atención especial.
    */
    public void addSpecialQueue(RecordAttentionPerson person)
    {
        if (!isFull()) {
            for (int i = end; i > 0; i--) {
                queue[i] = queue[i - 1];
            }

            queue[0] = person;
            end++;
        } else {
            System.out.println("La fila está llena.");
        }
    }

    /*
    Registra una persona en la fila.
    La fecha y hora de llegada se toman automáticamente del sistema.
    */
    public void registerPerson(String name, boolean specialAttention, int fibonacciNumber)
    {
        RecordAttentionPerson person = new RecordAttentionPerson();

        person.name = name;
        person.arrivalDateTime = LocalDateTime.now();
        person.attentionDateTime = null;
        person.attended = false;
        person.specialAttention = specialAttention;
        person.fibonacciNumber = fibonacciNumber;

        if (specialAttention) {
            addSpecialQueue(person);
        } else {
            addQueue(person);
        }
    }

    /*
    Retira la primera persona de la fila.
    Mantiene el orden de las demás personas.
    */
    public RecordAttentionPerson popQueue()
    {
        RecordAttentionPerson saved = null;

        if (!isEmpty()) {
            saved = queue[0];

            for (int i = 0; i < end - 1; i++) {
                queue[i] = queue[i + 1];
            }

            end--;
            queue[end] = null;
        } else {
            System.out.println("No hay personas en la fila.");
        }

        return saved;
    }

    /*
    Atiende a la primera persona de la fila.
    Si tiene atención especial, valida el número fibonacci suministrado.
    */
    public RecordAttentionPerson attendPerson(int suppliedFibonacciNumber)
    {
        RecordAttentionPerson person = null;

        if (!isEmpty()) {
            if (queue[0].specialAttention && queue[0].fibonacciNumber != suppliedFibonacciNumber) {
                System.out.println("El número fibonacci no coincide. No se puede atender la persona.");
            } else {
                person = popQueue();

                person.attentionDateTime = LocalDateTime.now();
                person.attended = true;

                Duration waitingTime = Duration.between(person.arrivalDateTime, person.attentionDateTime);

                long totalSeconds = waitingTime.getSeconds();
                long minutes = totalSeconds / 60;
                long seconds = totalSeconds % 60;

                System.out.println("Persona atendida: " + person.name);
                System.out.println("Tiempo en fila: " + minutes + " minutos y " + seconds + " segundos.");
            }
        } else {
            System.out.println("No hay personas en la fila.");
        }

        return person;
    }

    /*
    Muestra las personas que están esperando atención.
    */
    public void displayQueue()
    {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        if (!isEmpty()) {
            System.out.println("Personas en espera - Fila #" + queueNumber + ":");
            System.out.println("Nombre\t\tLlegada\t\t\tAtencion especial\tFibonacci");

            for (int i = 0; i < end; i++) {
                System.out.println(
                    queue[i].name + "\t\t" +
                    queue[i].arrivalDateTime.format(format) + "\t" +
                    queue[i].specialAttention + "\t\t\t" +
                    queue[i].fibonacciNumber
                );
            }

            System.out.println("Total personas en espera: " + end);
        } else {
            System.out.println("No hay personas en la fila #" + queueNumber + ".");
        }
    }

    /*
    Traslada las personas a otra fila sin perder el orden que traían.
    */
    public void moveToAnotherQueue(AttentionQueue anotherQueue)
    {
        while (!isEmpty()) {
            RecordAttentionPerson person = popQueue();
            anotherQueue.addQueue(person);
        }
    }
}