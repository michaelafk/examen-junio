/*
CLASE PalabraFrecuencia
 */
package examen_final_junio_2022.PROBLEMA3;


public class PalabraFrecuencia {
    //ATRIBUTOS
    private Palabra palabra;
    private int frecuencia;
    private static final int DIMENSION=44; //20 caracteres*2 bytes + 4 bytes
    
    //MÉTODOS
    //CONTRUCTORES
    public PalabraFrecuencia() {}
    
    public PalabraFrecuencia(Palabra dato) {
        Palabra.copiar(dato,palabra);
        frecuencia=1;
    }
    
    //MÉTODOS FUNCIONALES
    public Palabra getPalabra() {
        return palabra;
    }
    
    //MÉOTDOS GET'S Y SET'S
    public void setPalabra(Palabra dato) {
        Palabra.copiar(dato,palabra);
    }
    
    public int getFrecuencia() {
        return frecuencia;
    }
    
    public void setFrecuencia(int dato) {
        frecuencia=dato;
    }
    
    public static int getDimension() {
        return DIMENSION;
    }

    //método copiar posibilita la copia de un objeto PalabraFrecuencia en otro
    public static void copiar(PalabraFrecuencia a, PalabraFrecuencia b) {
        b.setPalabra(a.getPalabra());
        b.setFrecuencia(a.getFrecuencia());
    }
    
}
