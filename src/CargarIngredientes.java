import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by ANGELUS on 09/11/16.
 */
public class CargarIngredientes {
    private String filepath="";
    private File file;
    private FileReader fileReader;
    private FileWriter fileWriter;



    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public CargarIngredientes(String filepath) {
        try {
            this.filepath = filepath;
            file = new File(filepath);
            fileReader = new FileReader(file);
            fileWriter = new FileWriter(file);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public int leerIngrediente(){
        Scanner scanner=new Scanner(fileReader);

        String[] linea=scanner.next().split(":");
        //int dato=0;
        //if (linea[0].equals("ingredientes"))
         //   dato=Integer.parseInt(linea[1]);
        scanner.close();

        return  Integer.parseInt(linea[1]);

    }

    public void guardaIngrediente(int ingrediente){
        try {
            fileWriter.write(ingrediente);
            fileWriter.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }



}
