import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by ANGELUS on 09/11/16.
 */
public class Maquina {

    private int numeroBotellas=0;
    private int cantidadIngredientes=0;
    private CargarIngredientes cargarIngredientes;
    private Scanner scan;


    public LinkedList<Botella> bandaBotellas;
    public Thread tiempocreacion;

    public Maquina(){
        bandaBotellas=new LinkedList<>();
        tiempocreacion=new Thread();
        cargarIngredientes=new CargarIngredientes("Ingredientes.txt");
        scan=new Scanner(System.in);
        iniciar();
    }

    public void iniciar(){
        cantidadIngredientes=cargarIngredientes.leerIngrediente();
    }

    public void llenarBotellas(int numeroBotellas) throws ExcepcionLlenarBotella {
        int contador=1;
        do{


        int canntIngr=cantidadIngredientes-Botella.CANTIDAD_BOTELLA;

        if((cantidadIngredientes % Botella.CANTIDAD_BOTELLA==0) && cantidadIngredientes>0 && (cantidadIngredientes / Botella.CANTIDAD_BOTELLA>0)){
            Botella b=new Botella(Botella.CANTIDAD_BOTELLA);
            cantidadIngredientes=cantidadIngredientes-Botella.CANTIDAD_BOTELLA;
            bandaBotellas.add(b);
            contador++;
            try{
                tiempocreacion.sleep(5000);
                System.out.println("Botella.........................."+contador);
            }catch (Exception ex){
                ex.printStackTrace();
            }
            numeroBotellas--;
        }else{
            System.out.println("Falta Ingredientes para llenar mas Botellas"+cantidadIngredientes);
            numeroBotellas=-1;
            throw  new ExcepcionLlenarBotella("Falta Ingredientes para llenar botella");

        }
        }while (numeroBotellas>0);


    }

    public void displayMaquina(){

        System.out.println("----Display Estado de la maquina----------------------");
        System.out.println("Cantidad actual de ingredientes:"+cantidadIngredientes);
        System.out.println("------------------------------------------------------");
        System.out.println("Cuantas botellas desea llenar:\n");
        int numbotellas=leerInt();
        try {
            llenarBotellas(numbotellas);
        }catch (ExcepcionLlenarBotella ex){
            ex.printStackTrace();
        }
    }

    public int leerInt(){
        try{
            return scan.nextInt();
        }catch (Exception ex){
            ex.printStackTrace();
            return 1;
        }
    }

    public String leerString(){
        try{
            return scan.next();
        }catch (Exception ex){
            ex.printStackTrace();
            return "";
        }
    }
}
