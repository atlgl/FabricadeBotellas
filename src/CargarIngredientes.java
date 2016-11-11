import sun.tools.java.Environment;

import java.awt.*;
import java.io.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by ANGELUS on 09/11/16.
 * Clase encargada de cargar los ingredientes del archivo de texto
 */
public class CargarIngredientes {
    private String filepath="";
    private File file;
    private FileReader fileReader;
    private FileWriter fileWriter;

    /**
     * Devuelve la direccion y nombre del fichero
     * @return String
     */
    public String getFilepath() {
        return filepath;
    }

    /**
     * Agrega una direccion y nombre del fichero
     * @param filepath String
     */
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }


    /**
     * Constructor que permite establecer el nombre y direccion del archivo
     * @param filepath String
     */
    public CargarIngredientes(String filepath) {
        try {
            this.filepath = filepath;
            file = new File(filepath);
            //System.out.println(file.getCanonicalPath());
            //file.exists();
            fileReader = new FileReader(file);
            //fileWriter = new FileWriter(file);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    /**
     * Metodo que lee el ultimo ingrediente del archivo de ingredientes
     * @return int
     */
    public int leerIngrediente(){
        try {
            BufferedReader scanner=new BufferedReader(fileReader);

            Object[] dato= scanner.lines().toArray();

            String[] linea= ((String)dato[dato.length-1]).split(",");
            linea=linea[0].split(":");

        scanner.close();

         return  Integer.parseInt(linea[1]);

        } catch (IOException e) {
            e.printStackTrace();

            return 0;
        }

    }

    /**
     * Metodo que permite guardar el sobrante del ingrediente en tiempo de ejecucion
     * @param ingrediente int
     */

    public void guardaIngrediente(int ingrediente){
        try {
            if (fileWriter==null)
            {
                fileWriter=new FileWriter(file,true);
            }
            fileWriter.write("\ningrediente:"+ingrediente+",fecha:"+(new Date().toString()));

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    /**
     * Cierra el archivo de ingredientes paraque ya no se pueda leer o escribir sobre el.
     */

    public void cerrarIngredientes(){

        try {
            if(fileWriter!=null)
                fileWriter.close();
            fileWriter=null;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
