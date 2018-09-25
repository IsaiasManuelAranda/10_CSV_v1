
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class ModelData {
    public String name;
    public String email;
    public String result;
    public String path;
    public String message;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String resultCSV(){
        this.result = this.name + "," + this.email;
        return result;
    }
    public void writeFile(String path, String message){
        try{
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, true);
            try (PrintWriter printWriter = new PrintWriter(fileWriter)){
                printWriter.println(message);
                printWriter.close();
            }
        }catch(FileNotFoundException err){
            JOptionPane.showMessageDialog(null, "File not found: " + err.getMessage());
        }catch(IOException err){
            JOptionPane.showMessageDialog(null, "Fallo de entrada o salida: " + err.getMessage());
        }
    }
}
