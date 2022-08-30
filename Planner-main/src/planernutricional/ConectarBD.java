package planernutricional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

// Clase que permite realizar la coneccin a la base de datos
public class ConectarBD {
    // Declaracion de variables
    Connection conectar = null;
    public List<Usuarios> arregloUsuarios = new ArrayList<>();
    public List<Alimentos> arregloAlimentos = new ArrayList<>();
    public List<MetasNutricional> arregloMetasNutricionales = new ArrayList<>();
    MachineID identificante;

            // Metodo que establece la conexion con la base de datos
    public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // El orden de objeto es: drive + servidor + puerto + Bd + user + clave
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:8889/bd_nutricion", "admin", "12345");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return conectar;
    }

// Metodo que crea un arreglo con los usuarios en la base de datos que compartan el ID unico con la maquina del usuario
    public void crearArrayUsuarios() {
        identificarID();
        arregloUsuarios.clear();
        try {
            // Obtengo los datos del usuario con la base de datos
            Statement st = conectar.createStatement(); //obj para realiza la conexion
            ResultSet rs = st.executeQuery("SELECT * from user");
            while (rs.next()) {
                Usuarios usuario = new Usuarios();
                usuario.setId(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setMachine_id(rs.getString(3));
                usuario.setSelected_food_ids(rs.getString(4));
                usuario.setMasa(rs.getFloat(5));
                usuario.setPeriodo(rs.getInt(6));
                usuario.setCalorias(rs.getFloat(7));
                usuario.setProteinas(rs.getFloat(8));
                usuario.setCarbohidratos(rs.getFloat(9));
                usuario.setSugar(rs.getFloat(10));
                usuario.setGrasa(rs.getFloat(11));
                usuario.setFibra(rs.getFloat(12));
                usuario.setCalcio(rs.getFloat(13));
                
                if (identificante.checkSameOS(usuario.getMachine_id())) {
                    arregloUsuarios.add(usuario);
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Metodo que crea un arreglo con la informacion de los alimentos
    public void crearArrayAlimentos(int currentID) {
        arregloAlimentos.clear();
        try {
            // Se busca el usuario actual para luego fetchear los datos de solo ese usuario
            for (Usuarios u : arregloUsuarios) {
                if (u.getId() == currentID) {
                    System.out.println("User: " + u.getNombre());
                    // Reviso si existen los valores de los alimentos de manera local, si no, son recuperados de una API y luego se almacenan localmente
                    for (String food_id : u.getSelected_food_ids().trim().split(" ")) {
                        LocalDataHandler LDH = new LocalDataHandler();
                        APIDataHandler ADH = new APIDataHandler();
                        System.out.println("Adding food id: " + food_id);
                        if (LDH.createFile(food_id.replace("%20", " "))) {
                            arregloAlimentos.add(ADH.getRequestFoodInfo(food_id, true));
                        } else {
                            arregloAlimentos.add(ADH.jsonReaderFoodInfo(LDH.readFile(), food_id, false));
                        }
                    }
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Metodo que crea un arreglo que contiene las metas de cada usuario con la informacion almacenada en la base de datos.
    public void crearArrayDatosNutricionales() {
        arregloMetasNutricionales.clear();
        try {
            Statement st = conectar.createStatement(); //obj para realiza la conexion
            ResultSet rs = st.executeQuery("SELECT * from nutritionvalues");
            while (rs.next()) {
                MetasNutricional metaNutricion = new MetasNutricional();
                metaNutricion.setId(rs.getInt(1));
                metaNutricion.setCalorias(rs.getFloat(2));
                metaNutricion.setProteinas(rs.getFloat(3));
                metaNutricion.setCarbohidratos(rs.getFloat(4));
                metaNutricion.setSugar(rs.getFloat(5));
                metaNutricion.setFat(rs.getFloat(6));
                metaNutricion.setFibra(rs.getFloat(7));
                metaNutricion.setCalcio(rs.getFloat(8));
                arregloMetasNutricionales.add(metaNutricion);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR- No se pueden crear los botones");
        }
    }

    // Metodo que instancia el identificante e identifica el OS
    public void identificarID() {
        identificante = new MachineID();
        try {
            identificante.identificarOS();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
