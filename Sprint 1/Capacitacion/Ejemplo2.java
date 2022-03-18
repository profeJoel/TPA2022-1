import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejemplo2{
    public static void main(String[] args){
        /**Creación de un archivo por código Java */
        try{
            File nuevoArchivo = new File("cancionero.txt");
            if(nuevoArchivo.createNewFile()){
                System.out.println("Archivo Creado: " + nuevoArchivo.getName());
            } else {
                System.out.println("El archivo descrito ya existe!");
            }

        }catch(IOException e){
            System.out.println("Ocurrió un error en la creación del archivo");
            e.printStackTrace();
        }


        /*** Escribir en el archivo que hemos creado en JAVA */
        try{
            FileWriter escritor = new FileWriter("cancionero.txt");
            escritor.write("Last Stand - Sabbaton\n");
            escritor.write("Que pasa - Marcineke\n");
            escritor.write("Peace Sells - Megadeth\n");

            escritor.close();
            System.out.println("La escritura del archivo fue realizada con éxito!!!");
        }catch(IOException e){
            System.out.println("Ocurrió un error en la escritura del archivo");
            e.printStackTrace();

        }

        //Leer Archivo
        try{
            File archivo = new File("cancionero.txt");
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

        try{
            FileWriter escritor = new FileWriter("cancionero.txt", true);
            escritor.append("Noa Noa - Juan Gabriel\n");

            escritor.close();
            System.out.println("La escritura del archivo fue realizada con éxito!!!");
        }catch(IOException e){
            System.out.println("Ocurrió un error en la escritura del archivo");
            e.printStackTrace();

        }



    }
}