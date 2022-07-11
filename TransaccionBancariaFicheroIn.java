/*
CLASE que aglutina las declaraciones y funcionalidades que posiblitan la lectura
de objetos TransaccionBancaria desde un fichero
 */
package examen_final_junio_2022.PROBLEMA2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class TransaccionBancariaFicheroIn {
    //Declaración de atributos
    private ObjectInputStream fichero=null;
    
    //MÉTODOS
    //MÉTODO CONSTRUCTOR
    public TransaccionBancariaFicheroIn(String nombreFichero) {
        try {
            fichero=new ObjectInputStream(new FileInputStream(nombreFichero));
        }catch (FileNotFoundException error) {
            System.out.println("ERROR: FICHERO INEXISTENTE");
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
    
    //MÉTODOS FUCNIONALES
    //MÉTODO lectura POSIBILTA LA LECTURA DE UN OBJETO TransaccionBancaria DESDE
    //EL FICHERO
    public TransaccionBancaria lectura() {
        //Declaración de atributos
        TransaccionBancaria transaccion= new TransaccionBancaria();
        
        //ACCIONES
        try {
            transaccion=(TransaccionBancaria) fichero.readObject();
        }catch (ClassNotFoundException error) {
            System.out.println("ERROR: "+error.toString());
            return null;
        }catch (IOException error) {
            System.out.println("ERROR: ERROR EN LA LECTURA DESDE EL FICHERO");
            return null;
        }
        return transaccion;
    }
    
    
    //MÉTODO listadoTransacciones LLEVA A CABO EL LISTADO DE LOS OBJETOS
    //TransaccionBancaria CONTENIDOS EN EL FICHERO CUYO PARÁMETRO importe
    //ESTÉ EN EL RANGO DE LOS IMPORTES minimo Y maximo DADOS POR PARÁMETRO
    public void listadoTransacciones(double minimo, double maximo) {
        //ATRIBUTOS        
        TransaccionBancaria transaccion= new TransaccionBancaria();
        
        //ACCIONES
        try {
            if (minimo>maximo) {
                throw new RangoIncorrecto("IMPORTES DADOS INCORRECTOS");
            }   
            else {
                //lectura primer objeto TransaccionBancaria desde el fichero
                transaccion=(TransaccionBancaria) fichero.readObject();
                //bucle lectura y tratamiento
                while (!transaccion.esCentinela()) {
                    //verificación si el objeto TransaccionBancaria leído verifica el
                    //criterio de rango minimo y máximo
                    if ((transaccion.getImporte()>=minimo)&&(transaccion.getImporte()<=maximo)) {
                        //visualización objeto Transaccionbancaria leído
                        System.out.println(transaccion.toString());  
                    }
                    //lectura siguiente objeto TransaccionBancaria
                    transaccion=(TransaccionBancaria) fichero.readObject();
                }
            }
        }catch (RangoIncorrecto error) {}
         catch (ClassNotFoundException error) {
            System.out.println("ERROR: "+error.toString());
         }
         catch (IOException error) {
            System.out.println("ERROR: ERROR EN LA LECTURA DESDE EL FICHERO");
        }
    }
    
    //MÉTODO cierre LLEVA A CABO EL CIERRE DEL ENLACE CON EL FICHERO FÍSICO
    public void cierre() {
        try {
            if (fichero!=null) {
                fichero.close();
            }
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
    
}
