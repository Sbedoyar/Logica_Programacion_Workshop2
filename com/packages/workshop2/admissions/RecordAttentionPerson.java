package com.packages.workshop2.admissions;

import java.time.LocalDateTime;

/*Representa el registro de una persona que ingresa a la fila
de atención del departamento de Admisiones y Registro.*/
public class RecordAttentionPerson 
{
    public String name;
    public LocalDateTime arrivalDateTime;
    public LocalDateTime attentionDateTime;
    public LocalDateTime attentionEndDateTime;
    public boolean attended;
    public boolean specialAttention;
    public int fibonacciNumber;

    /*Inicializa una persona con los valores por defecto solicitados:
    no atendida y con fecha/hora de llegada tomada del sistema.*/
    public RecordAttentionPerson()
    {
        name = "";
        arrivalDateTime = LocalDateTime.now();
        attentionDateTime = null;
        attentionEndDateTime = null;
        attended = false;
        specialAttention = false;
        fibonacciNumber = 0;
    }
}