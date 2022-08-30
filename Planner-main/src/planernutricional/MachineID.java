package planernutricional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MachineID {

    private final String OS = System.getProperty("os.name").toLowerCase();
    public String ID;

    public void identificarOS() throws IOException, InterruptedException {
        String command = null;
        System.out.println("OS: " + OS);
        
        if (OS.contains("win")) {
            command = "wmic csproduct get UUID";
            StringBuffer output = executeCommand(command);
            ID = output.toString().substring(output.indexOf("\n"), output.length()).trim();
            return;
        }
        
        if (OS.contains("mac")) {
            command = "system_profiler SPHardwareDataType | awk '/UUID/ { print $3; }'";
            StringBuffer output = executeCommand(command);
            ID = output.toString().substring(output.indexOf("UUID: "), output.length()).replace("UUID: ", "").trim();
            return;
        }
        
        JOptionPane.showMessageDialog(null, "NO SUPPORT FOR SYSTEMS OTHER THAN WINDOWS AND MAC OS, SORRY!");
        System.exit(0);
    }

    private StringBuffer executeCommand(String command) {
        try {
            StringBuffer output = new StringBuffer();
            Process SerNumProcess = Runtime.getRuntime().exec(command);
            BufferedReader sNumReader = new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
            
            String line = "";
            
            while ((line = sNumReader.readLine()) != null) {
                output.append(line + "\n");
            }
            
            SerNumProcess.waitFor();
            
            sNumReader.close();
            
            return output;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Boolean checkSameOS(String id) {
        return ID.equals(id);
    }
}
