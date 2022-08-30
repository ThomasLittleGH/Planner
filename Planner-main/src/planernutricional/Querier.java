/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planernutricional;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Querier{  
    ConectarBD conBD = new ConectarBD();
    Connection conn = conBD.conexion();
    MachineID identificante = new MachineID();
    
    // –––––––––––––––––––––  MISC  ––––––––––––––––––––
    
    private void println(String toPrint){
        System.out.println(toPrint);
    }
    
    // ––––––––––––––––––––– INSERT ––––––––––––––––––––  
    
    public void insertUser(String nombre_usuario, float masa) {
        insertUser(nombre_usuario.trim(),  masa, 7, 0, 0, 0, 0, 0, 0, 0);
    }

    public void insertUser(String nombre_usuario, float... arguments) {
        try {
            identificante.identificarOS();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        // INSERT INTO user VALUES (DEFAULT, nombre, masa, periodo, calorias, proteinas, carbohidratos, vit_a, vit_c, vit_k, fibra, calcio)
        String values = str(nombre_usuario) + ", " + str(identificante.ID) + ", " + str("rice noodles bread lettuce avocado tomato potato onion apple peach beef chicken ham cow%20milk white%20yogurt buttery%20cheese egg honey butter lentils tea coffee") + ", ";
        
        for(int i = 0; i < arguments.length; i++) {
            values += ((i == 0) ? "" : ", ") + arguments[i];
        }
        
        String query = "INSERT INTO user (nombre, machine_id, selected_food_ids, masa, periodo, calorias, proteinas, carbohidratos, sugar, fat, fibra, calcio) VALUES (" + values + ")";
                
        executePreparedStatement(query);
        
        // Recreo el arreglo para poder que el sistema tome en cuenta los cambios
        conBD.crearArrayUsuarios();
    }
    
    public void insertMetasNutricionales(float masa) {
        insertMetasNutricionales(conBD.arregloUsuarios.get(conBD.arregloUsuarios.size() - 1).getId(), (float)2100, (float)(masa * 0.8), (float)135, (float)25, (float)25, (float)25, (float)1000);
    }
    
    public void insertMetasNutricionales(int id, float... arguments){
        // Metodo que inserta los valores de las metas nutricionales a la base de datos
        String values = id + ", ";
        
        for(int i = 0; i < arguments.length; i++) {
            values += ((i == 0) ? "" : ", ") + arguments[i];
        }
        
        String query = "INSERT INTO nutritionvalues (id, calorias, proteinas, carbohidratos, sugar, fat, fibra, calcio) VALUES (" + values + ")";
                
        executePreparedStatement(query);
        
        // Recreo el arreglo para poder que el sistema tome en cuenta los cambios
        conBD.crearArrayDatosNutricionales();
    }
    
    
    // ––––––––––––––––––––––––––––––––––––––––––––––––––
    
    public void executePreparedStatement(String query) {
        try {
            PreparedStatement prepStatement = conn.prepareStatement(query);
            println("Executing: " + query);
            prepStatement.executeUpdate(); 
        } catch(Exception e) {
            println("Error executing query: " + e.toString());
        }
    }
        
    public static String str(String s) {
        return "'" + s + "'";
    }
    
            
    enum Syntax {
        DEFAULT("DEFAULT"),
        AND(" AND "),
        OR(" OR "),
        COUNTALL("COUNT(*)"),
        NULL("NULL");
        
        private final String str;
        
        Syntax(String s) {
            this.str = s;
        }
        
        public String str() {
            return str;
        }
    }
    
    // shhhhh
    public String arrayToStr(String[] arr) {
        String s = "";
        
        for(int i = 0; i < arr.length; i++) {
            s += arr[i];
            s += i == arr.length-1 ? "" : ", ";
        }
        
        return s;
    }
}