package planernutricional;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Clase que maneja la informacion almacenada local
public class LocalDataHandler {
    // Declaracion de variables
    String URL;
    
    // Metodo que crea los archivos dentro de la carpeta food_data
    public Boolean createFile(String fid) {
        this.URL = "food_data\\" + fid.replace("%20", " ") + ".json";
        try {
            // Se crea el directorio
            File dir = new File("food_data\\");
            dir.mkdir();
            
            // Se intenta crear el archivo y se retorna si fue posible o no
            File myObj = new File(URL);
            return myObj.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Metodo que escrible el string dado en el archivo creado
    public void writeFile(String s) {
        try {
            FileWriter myWriter = new FileWriter(URL);
            myWriter.write(s);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metodo que lee el archivo y regresa su contenido
    public String readFile() {
        String s = "";
        try {
            File myObj = new File(URL);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                s+=data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return s;
    }
}
