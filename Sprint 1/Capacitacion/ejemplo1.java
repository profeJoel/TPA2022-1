import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ejemplo1 {
    public static void main(String[] args){
        File archivo = new File("ejemplo.txt");

        System.out.println("Nombre del Archivo : " + archivo.getName());
        System.out.println("Se puede leer? : " + archivo.canRead());
        System.out.println("Se puede escribir? : " + archivo.canWrite());
        System.out.println("Existe el archivo? : " + archivo.exists());
        System.out.println("tamaño del archivo : " + archivo.length());
        System.out.println("Ruta Absoluta : " + archivo.getAbsolutePath());

        /************************************/
        //Leer Archivo
        try{
            Scanner lector = new Scanner(archivo);

            //System.out.println("Texto Archivo:\n" + lector.nextLine());
            System.out.println("Texto Archivo:\n");

            while(lector.hasNextLine()){
                String linea = lector.nextLine();
                System.out.println(linea);
            }
            lector.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Ocurre un error con el archivo");
            e.printStackTrace();
        }



    }
}