/**
 * Created by ANGELUS on 09/11/16.
 * Clase botella permite representar a una botella con un contenido de 100 mililitros
 */
public class Botella {
    /**
     * Constante del valor de la botella
     */
    public static final int CANTIDAD_BOTELLA=100;

    private int contenido_neto=0;

    /**
     * Ccnstructor de una botella se puede pase automaticamente el valor para llenar la botella
     * @param contenido_neto int
     */
    public Botella(int contenido_neto) {
        this.contenido_neto = contenido_neto;
    }

    /**
     * Devuelve el valor del contenido de la botella
     * @return String
     */
    public int getContenido_neto() {
        return contenido_neto;
    }

    /**
     * Agrega el contenido neto de la botella
     * @param contenido_neto
     */
    public void setContenido_neto(int contenido_neto) {
        this.contenido_neto = contenido_neto;
    }


}
