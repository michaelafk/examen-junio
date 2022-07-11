/*
CLASE Palabra
*/

package examen_final_junio_2022.PROBLEMA3;

public class Palabra  implements java.io.Serializable {
    //DECLARACIÓN DE ATRIBUTOS
    private static final int MAXIMO = 20;
    private static char caracter=' ';
    private static final char FINAL_SECUENCIA='.';
    private static final char ESPACIO=' ';
    private char caracteres []=new char[MAXIMO];
    private int numCaracteres;

    //MÉTODOS
    //CONSTRUCTOR
    public Palabra() {
     numCaracteres=0;
    }

    //MÉTODOS FUNCIONALES
    //MÉTODO copiar posibilita copiar un objeto Palabra en otro objeto Palabra
    public static void copiar(Palabra a, Palabra b) {
        for (int indice=0;indice<a.numCaracteres;indice++) {
            b.caracteres[indice]=a.caracteres[indice];
        }
        b.numCaracteres=a.numCaracteres;
    }

    //MÉTODO adicionCaracter posibilita la adición del caracter dado por parámetro
    //en el atributo caracteres del objeto Palabra
    public void adicionCaracter(char caracter) {
       caracteres[numCaracteres]=caracter;
       numCaracteres++;
    }
    //Método que devuelve el número de caracteres de un objeto Palabra
    public static int getMaximoNumerocaracteres() {
       return MAXIMO;
    }

}



