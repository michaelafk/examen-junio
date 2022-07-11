/*
CLASE RangoIncorrecto REPRESENTA UNA EXCEPCIÓN NO PREDEFINIDA QUE SERÁ INVOCADA
CUANDO EL RANGO DE IMPORTES DADO SEA INCORRECTO
 */
package examen_final_junio_2022.PROBLEMA2;

public class RangoIncorrecto extends Exception{
 public RangoIncorrecto (String mensaje) {
        super(mensaje);
    }    
}
