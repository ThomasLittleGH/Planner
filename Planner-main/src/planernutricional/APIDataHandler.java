package planernutricional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// Clase que recibe un nombre de alimento, fetchea la informacion del alimento y, dependiendo de las preferencias del usuario, llama a la clase LDH para almacenarlo
public class APIDataHandler {
    // Declaracion de variables
    List<String> nutrientIDs;
    LocalDataHandler LDH;
    String nutrientIDs_s = "",
            values = "";

    // Metodo que añade los id's de los nutrientes a ser considerados a un arreglo
    public void iniciar() {
        nutrientIDs = new ArrayList<>();
        nutrientIDs.add("Energy"); // calorias
        nutrientIDs.add("Protein"); // proteinas
        nutrientIDs.add("Carbohydrate, by difference"); // carbohidratos
        nutrientIDs.add("Sugars, total including NLEA"); // azucar
        nutrientIDs.add("Fatty acids, total saturated"); // Grasa
        nutrientIDs.add("Fiber, total dietary"); // fibra 
        nutrientIDs.add("Calcium, Ca"); // calcio
    }

    // Metodo que obtiene el documento JSON de el api
    public Alimentos getRequestFoodInfo(String food_id, boolean save_file) throws Exception {
        String url = "https://nutritionapiv2.herokuapp.com/test/q?name=" + food_id;
        
        // Se declaran las variables y se prepara la conexion
        StringBuffer response;
        URL urlForGetRequest = new URL(url);
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        conection.setRequestProperty("userId", "a1bcdef");
        
        // Si la canexion es exitosa se leen los datos
        if (conection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            System.out.println("CONNECTION OK");
            response = readApiGetData(conection);

            if (save_file) {
                LDH = new LocalDataHandler();
                LDH.createFile(food_id);
                LDH.writeFile(response.toString());
            }
            
            return jsonReaderFoodInfo(response.toString(), food_id, save_file);
        } else {
            return null;
        }
    }

    // Metodo que lee la informacion del api y la transforma en un string
    private StringBuffer readApiGetData(HttpURLConnection conection) throws IOException {
        StringBuffer response;
        String readLine;
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(conection.getInputStream()))) {
            response = new StringBuffer();
            System.out.println("Reading data back!");
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
        }
        return response;
    }

    // Metodo que interpreta el JSON ahora texto y le asigna los valores a un alimento
    public Alimentos jsonReaderFoodInfo(String json_String, String food_id, boolean save_file) {
        // Declaracion de variables
        JSONParser jsonParser = new JSONParser();
        Alimentos a = new Alimentos();
        
        iniciar();

        try {
            // Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(json_String);

            // Se obtiene el arreglo que contiene a los otros arreglos
            JSONObject data = (JSONObject) jsonObject.get("data");

            // Se obtienen los valores nutricionales generales
            JSONArray jsonArray = (JSONArray) data.get("generalItems");
            classifyDataFromJsonArrayToString(jsonArray);

            // Se obtienen los valores nutricionales de los minerales
            jsonArray = (JSONArray) data.get("mineralItems");
            classifyDataFromJsonArrayToString(jsonArray);

            // Se ordenan los valores en un orden especial para luego ser insertados al alimento
            String[] food_ids_arr = nutrientIDs_s.trim().split("~");
            String[] values_arr = values.trim().split(" ");
            ordenarValoresEnLista(food_ids_arr, values_arr);

            // Se asignan los valores obtenidos a un alimento y luego se retorna
            a.setId(food_id);
            a.setNombre(food_id);
            a.setCalorias(Float.parseFloat(nutrientIDs.get(0)));
            a.setProteinas(Float.parseFloat(nutrientIDs.get(1)));
            a.setCarbohidratos(Float.parseFloat(nutrientIDs.get(2)));
            a.setSugar(Float.parseFloat(nutrientIDs.get(3)));
            a.setFat(Float.parseFloat(nutrientIDs.get(4)));
            a.setFibra(Float.parseFloat(nutrientIDs.get(5)));
            a.setCalcio(Float.parseFloat(nutrientIDs.get(6)));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("");
        }
        return a;
    }

    // Metodo que ordena los valores de los datos nutricionales en un orden especifico
    private void ordenarValoresEnLista(String[] food_ids_arr, String[] values_arr) {
        for (int i = 0; i < food_ids_arr.length; i++) {
            if (food_ids_arr[i].equals(nutrientIDs.get(i))) {
                nutrientIDs.set(i, values_arr[i] + "_r");
            } else {
                for (int j = 0; j < nutrientIDs.size() - 1; j++) {
                    if (food_ids_arr[i].equals(nutrientIDs.get(j))) {
                        nutrientIDs.set(j, values_arr[i] + "_r");
                        break;
                    }
                }
            }
        }
        
        for (int i = 0; i < nutrientIDs.size(); i++) {
            if (nutrientIDs.get(i).contains("_")) {
                nutrientIDs.set(i, nutrientIDs.get(i).split("_")[0]);
            } else {
                nutrientIDs.set(i, "0.0");
            }
        }
    }

    // Metodo que clasifica los valores del arreglo JSON en texto para luego ser clasificados
    private void classifyDataFromJsonArrayToString(JSONArray jsonArray) {
        boolean flag = true;
        for (int i = 0; i < jsonArray.size(); i++) {
            String aux = (String) jsonArray.get(i).toString();
            String[] s = aux.split(",\"");
            for (String item : s) {
                if (item.contains("nutrientName")) {
                    flag = true;
                    String[] aux_array = null;
                    aux_array = item.split(":");
                    aux_array = aux_array[1].split("\"");
                    if (nutrientIDs.contains(aux_array[1])) {
                        nutrientIDs_s += aux_array[1] + "~";
                    } else {
                        flag = false;
                        continue;
                    }
                }
                if (item.contains("nutrientValue") && flag) {
                    String[] aux_array = item.split(":");
                    aux_array = aux_array[1].split("}");
                    values += " " + aux_array[0];
                }
            }
        }
    }
}
