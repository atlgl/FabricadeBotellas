import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by ANGELUS on 09/11/16.
 * Clase encargada de llenar las botellas y verificar la cantidad de los ingredientes para llenar las botellas
 */
public class Maquina {

    private int numeroBotellas=0;
    private int cantidadIngredientes=0;
    private CargarIngredientes cargarIngredientes;
    private Scanner scan;

    /**
     * Variable que ejemplifica la bande transportadora de botellas
     */
    public LinkedList<Botella> bandaBotellas;
    /**
     * Hilo que detiene el programa por 5 segundos
     */
    public Thread tiempocreacion;

    /**
     * Constructor de la maquina se encarga de hechar a andar todas las funciones de la mquina
     */
    public Maquina(){
        bandaBotellas=new LinkedList<>();
        tiempocreacion=new Thread();
        cargarIngredientes=new CargarIngredientes("ingre.txt");
        scan=new Scanner(System.in);
        iniciar();
    }

    /**
     * Metodo encargado de iniciar la maquina leyendo el archivo de ingredientes
     */
    public void iniciar(){
        cantidadIngredientes=cargarIngredientes.leerIngrediente();
        if(cantidadIngredientes<0 || cantidadIngredientes==0)
            System.out.println("No hay suficientes Ingredientes Recargar ingredientes");
    }

    /**
     * Metodo encargado de llenar las botellas en caso de haber suficiente ingredientes para llenar
     * las botellas causara una excepcion del tipo cargar botella
     * @param numeroBotellas int
     * @throws ExcepcionLlenarBotella Exception
     */

    public void llenarBotellas(int numeroBotellas) throws ExcepcionLlenarBotella {
        int contador=1;
        System.out.println("Espere un momento Llenando Botellas...");
        do{

        int canntIngr=cantidadIngredientes-Botella.CANTIDAD_BOTELLA;

        if((cantidadIngredientes % Botella.CANTIDAD_BOTELLA==0) && cantidadIngredientes>0 && (cantidadIngredientes / Botella.CANTIDAD_BOTELLA>0)){
            Botella b=new Botella(Botella.CANTIDAD_BOTELLA);
            cantidadIngredientes=cantidadIngredientes-Botella.CANTIDAD_BOTELLA;
            bandaBotellas.add(b);

            try{
                tiempocreacion.sleep(500);
                System.out.println("Botella.........................."+contador);
                cargarIngredientes.guardaIngrediente(cantidadIngredientes);
                contador++;
            }catch (Exception ex){
                ex.printStackTrace();
            }
            numeroBotellas--;
        }else{
            System.out.println("Falta Ingredientes para llenar mas Botellas"+cantidadIngredientes);
            numeroBotellas=-1;
            cargarIngredientes.cerrarIngredientes();
            throw  new ExcepcionLlenarBotella("Falta Ingredientes para llenar botella");

        }
        }while (numeroBotellas>0);
        cargarIngredientes.cerrarIngredientes();

    }

    /**
     * Metodo encargado de mostrar el estado de la maquina e indicar el estado de la maquina
     */

    public void displayMaquina(){
        int numbotellas=0;
        do {

            System.out.println("----Display Estado de la maquina----------------------");
            System.out.println("----Para Salir presione -1");
            System.out.println("Cantidad actual de ingredientes:" + cantidadIngredientes);
            System.out.println("------------------------------------------------------");
            System.out.println("Cuantas botellas desea llenar:\n");
            numbotellas = leerInt();
            if(numbotellas!=-1) {
                try {
                    llenarBotellas(numbotellas);
                } catch (ExcepcionLlenarBotella ex) {
                    ex.printStackTrace();
                }
            }
        }while (numbotellas!=-1);
    }

    /**
     * Metodo encargado de leer un entero.
     * @return int
     */
    public int leerInt(){
        try{
            return scan.nextInt();
        }catch (Exception ex){
            ex.printStackTrace();
            return 1;
        }
    }

    /**
     * Metodo encargado de leer una cadena de texto n
     * @return String
     */
    public String leerString(){
        try{
            return scan.next();
        }catch (Exception ex){
            ex.printStackTrace();
            return "";
        }
    }
}
