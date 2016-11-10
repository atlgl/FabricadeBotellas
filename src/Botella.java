/**
 * Created by ANGELUS on 09/11/16.
 */
public class Botella {
    public static final int CANTIDAD_BOTELLA=100;

    private int contenido_neto=0;

    public Botella(int contenido_neto) {
        this.contenido_neto = contenido_neto;
    }

    public int getContenido_neto() {
        return contenido_neto;
    }

    public void setContenido_neto(int contenido_neto) {
        this.contenido_neto = contenido_neto;
    }


}
