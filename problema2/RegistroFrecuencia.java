/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_final_junio_2022.PROBLEMA3;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RegistroFrecuencia {
    //declaración objeto RandomAccessFile para posibilitar la lectura/escritura
    //de objetos PalabraFrecuencia desde/en fichero
    private RandomAccessFile fichero=null;

    //MÉTODOS
    
    //MÉTODO CONSTRUCTOR
    public RegistroFrecuencia(String nombreFichero){ 
        try {
            //instanciación objeto RandomAccessFile para establecer el enlace con
            //el fichero a nivel de lectura/escritura
            fichero = new RandomAccessFile(nombreFichero,"rw");
        }catch (FileNotFoundException error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
    
    //MÉTODOS FUNCIONALES

    //método lectura que posibilita la lectura de un objeto PalabraFrecuencia desde el
    //fichero
    public PalabraFrecuencia lectura() {
        //DECLARACIONES
        //declaración objeto PalabraFrecuencia
        PalabraFrecuencia objeto=new PalabraFrecuencia();
        
        //ACCIONES
        try {
            //lectura atributo Palabra
            objeto.setPalabra(lecturaPalabra());
            //lectura atributo frecuencia
            objeto.setFrecuencia(fichero.readInt());
        }catch (EOFException error) {
            return null;
        }
        catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
        return objeto;
    }
    
    //método que lleva a cabo la lectura, caracter a caracter, de los caracteres
    //correspondientes a una palabra teniendo en cuenta la dimensión correspondiente
    private Palabra lecturaPalabra() {
        Palabra palabra=new Palabra();
        try {
            for (int indice=0;indice<Palabra.getMaximoNumerocaracteres();indice++) {
                palabra.adicionCaracter(fichero.readChar());
            }            
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }

        return palabra;
    }

    //método que3 devuelve el objeto Palabra que más apariciones tiene de los
    //objetos PalabraFrecuencia contenidos en el fichero    
    public Palabra palabraMasRepetida() {
        //declaración objeto PalabraFrecuencia
        PalabraFrecuencia objeto=new PalabraFrecuencia();
        //declaración objeto PalabraFrecuencia masRepetida
        PalabraFrecuencia masRepetida=new PalabraFrecuencia();               
        //ACCIONES
        try {
            //posicionamiento puntero al comienzo del fichero
            fichero.seek(0);      
            //lectura primer objeto FrecuenciaPalabra
            objeto=lectura();
            //copiar el objeto PalabraFrecuencia leído en el objeto masrepetida
            PalabraFrecuencia.copiar(objeto, masRepetida);
            //bucle de lectura y tratamiento
            for (int indice=1;indice<fichero.length()/PalabraFrecuencia.getDimension();indice++) {
                //lectura siguiente objeto PalabraFrecuencia desde el fichero
                objeto=lectura();
                //verificar si el objeto leído tiene una frecuencia más elevada que 
                //masrepetida
                if (objeto.getFrecuencia()>masRepetida.getFrecuencia()) {
                    //copiar el objeto PalabraFrecuencia leído en el objeto masrepetida
                    PalabraFrecuencia.copiar(objeto, masRepetida);
                }  
            }
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
        //devolución atributo Palabra del objeto masRepetida
        return masRepetida.getPalabra();
    }
    
    
    //método que3 devuelve el objeto Palabra que menos apariciones tiene de los
    //objetos PalabraFrecuencia contenidos en el fichero
    public Palabra palabraMenosRepetida() {
        //declaración objeto PalabraFrecuencia
        PalabraFrecuencia objeto=new PalabraFrecuencia();
        //declaración objeto PalabraFrecuencia menosRepetida
        PalabraFrecuencia menosRepetida=new PalabraFrecuencia();               
        //ACCIONES
        try {
            //posicionamiento puntero al comienzo del fichero
            fichero.seek(0);      
            //lectura primer objeto FrecuenciaPalabra
            objeto=lectura();
            //copiar el objeto PalabraFrecuencia leído en el objeto menosRepetida
            PalabraFrecuencia.copiar(objeto, menosRepetida);
            //bucle de lectura y tratamiento
            for (int indice=1;indice<fichero.length()/PalabraFrecuencia.getDimension();indice++) {
                //lectura siguiente objeto PalabraFrecuencia desde el fichero
                objeto=lectura();
                //verificar si el objeto leído tiene una frecuencia menor que 
                //menosRepetida
                if (objeto.getFrecuencia()<menosRepetida.getFrecuencia()) {
                    //copiar el objeto PalabraFrecuencia leído en el objeto menosRepetida
                    PalabraFrecuencia.copiar(objeto, menosRepetida);
                }  
            }
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
        //devolución atributo Palabra del objeto menosRepetida
        return menosRepetida.getPalabra();
    }

    
    //cierre del enlace con el fichero
    public void cierre() throws Exception {
        try {
            if (fichero!=null) {
                fichero.close();                  
            }          
        }catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
    
}
