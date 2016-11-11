/**
 * Created by ANGELUS on 11/11/16.
 * Clase encargada de generar las excepciones cuando ya no existe mas ingrediente activo
 */
public class ExcepcionLlenarBotella extends Exception {
    /**
     * Constructor de la excepcion recibe el mensaje a mostrar para la excepcion personlaizada
     * @param message String
     */
    public ExcepcionLlenarBotella(String message) {
        super(message);
    }
}
