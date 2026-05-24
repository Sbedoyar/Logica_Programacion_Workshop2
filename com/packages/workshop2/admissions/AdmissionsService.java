package com.packages.workshop2.admissions;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * Administra operaciones generales del punto de admisiones:
 * historial de personas atendidas, promedio de espera e intervalos de atención.
 */
public class AdmissionsService 
{
    private final int T = 100;
    private int attendedCount;
    private int fibonacciPosition;
    private RecordAttentionPerson attendedPeople[] = new RecordAttentionPerson[T];

    public AdmissionsService()
    {
        attendedCount = 0;
        // Se inicia en la posición 3 para evitar asignar dos veces el número 1.
        fibonacciPosition = 3;
    }

    public int getAttendedCount()
    {
        return attendedCount;
    }

    public boolean isHistoryFull()
    {
        return attendedCount == T;
    }

    /*
     * Calcula un número de la serie Fibonacci.
     * Se usa para asignar un número a las personas con atención especial.
     */
    private int calculateFibonacci(int position)
    {
        int first = 1;
        int second = 1;
        int fibonacci = 1;

        if (position <= 2) {
            fibonacci = 1;
        } else {
            for (int i = 3; i <= position; i++) {
                fibonacci = first + second;
                first = second;
                second = fibonacci;
            }
        }

        return fibonacci;
    }

    /*
     * Asigna el siguiente número Fibonacci disponible.
     */
    public int assignFibonacciNumber()
    {
        int fibonacciNumber = calculateFibonacci(fibonacciPosition);
        fibonacciPosition++;

        return fibonacciNumber;
    }

    /*
     * Guarda en el historial una persona que ya fue atendida.
     */
    public void saveAttendedPerson(RecordAttentionPerson person)
    {
        if (person != null && person.attended) {
            if (!isHistoryFull()) {
                attendedPeople[attendedCount] = person;
                attendedCount++;
            } else {
                System.out.println("El historial de personas atendidas está lleno.");
            }
        }
    }

    /*
     * Muestra las personas que ya fueron atendidas.
     */
    public void displayAttendedPeople()
    {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        if (attendedCount > 0) {
            System.out.println("Personas atendidas:");
            System.out.println("Nombre\t\tLlegada\t\t\tAtencion");

            for (int i = 0; i < attendedCount; i++) {
                System.out.println(
                    attendedPeople[i].name + "\t\t" +
                    attendedPeople[i].arrivalDateTime.format(format) + "\t" +
                    attendedPeople[i].attentionDateTime.format(format)
                );
            }

            System.out.println("Total personas atendidas: " + attendedCount);
        } else {
            System.out.println("No hay personas atendidas registradas.");
        }
    }
    /*
     * Calcula el promedio de tiempo de atención de los funcionarios.
     */
    public void showAverageAttentionTime()
    {
        long totalSeconds = 0;
        int validRecords = 0;

        if (attendedCount > 0) {
            for (int i = 0; i < attendedCount; i++) {
                if (attendedPeople[i].attentionDateTime != null && attendedPeople[i].attentionEndDateTime != null) {
                    Duration attentionTime = Duration.between(
                        attendedPeople[i].attentionDateTime,
                        attendedPeople[i].attentionEndDateTime
                    );

                    totalSeconds = totalSeconds + attentionTime.getSeconds();
                    validRecords++;
                }
            }

            if (validRecords > 0) {
                long averageSeconds = totalSeconds / validRecords;
                long minutes = averageSeconds / 60;
                long seconds = averageSeconds % 60;

                System.out.println("Promedio de tiempo de atención de los funcionarios: " + minutes + " minutos y " + seconds + " segundos.");
            } else {
                System.out.println("No hay datos suficientes para calcular el promedio.");
            }
        } else {
            System.out.println("No hay personas atendidas para calcular el promedio.");
        }
    }

    /*
     * Cuenta cuántas personas fueron atendidas dentro de un intervalo de tiempo.
     */
    public int countAttendedInInterval(LocalDateTime startDateTime, LocalDateTime endDateTime)
    {
        int count = 0;

        if (startDateTime.isAfter(endDateTime)) {
            System.out.println("La fecha inicial no puede ser mayor que la fecha final.");
        } else {
            for (int i = 0; i < attendedCount; i++) {
                LocalDateTime attentionDateTime = attendedPeople[i].attentionDateTime;

                if (attentionDateTime != null) {
                    if ((attentionDateTime.isEqual(startDateTime) || attentionDateTime.isAfter(startDateTime)) &&
                        (attentionDateTime.isEqual(endDateTime) || attentionDateTime.isBefore(endDateTime))) {
                        count++;
                    }
                }
            }

            System.out.println("Personas atendidas en el intervalo: " + count);
        }

        return count;
    }
}