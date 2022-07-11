/*
CLASE TransaccionBancaria
 */
package examen_final_junio_2022.PROBLEMA2;

public class TransaccionBancaria implements java.io.Serializable {
    //Declaración de atributos
    private double importe;
    //objeto centinela
    private static final TransaccionBancaria CENTINELA=new TransaccionBancaria(-1);
    
    //MÉTODOS
    //CONSTRUCTORES
    public TransaccionBancaria() {}
    
    public TransaccionBancaria(double dato) {
        importe=dato;
    }
    
    //MÉTODOS FUNCIONALES
    //método toString convierte un objeto TransaccionBancaria en String
    @Override
    public String toString() {
        return "Importe Transaccion: "+importe;
    }
    
    //MÉTODOS Get's y Set's   
    public double getImporte() {
        return importe;
    }
    
    public void setImporte(double dato) {
        importe=dato;
    }
    
    
    //método esCentinela lleva a cabo la verificación de si un objeto TransaccionBancaria
    //es el objeto CENTINELA
    public boolean esCentinela() {
        return importe==CENTINELA.getImporte();
    }   
    
}
