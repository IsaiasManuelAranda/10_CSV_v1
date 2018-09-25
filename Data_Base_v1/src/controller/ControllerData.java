
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.ModelData;
import view.ViewData;

public class ControllerData implements ActionListener {
    private final ModelData modelData;
    private final ViewData viewData;

    public ControllerData(ModelData modelData, ViewData viewData) {
        this.modelData = modelData;
        this.viewData = viewData;
        
        viewData.jb_guardar.addActionListener(this);
        viewData.jb_limpiar.addActionListener(this);
        
        initComponents();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewData.jb_guardar){
            makeCSV();
            clean();
        }
        else if (e.getSource() == viewData.jb_limpiar){
            clean();
        }
    }
    
    private void makeCSV() {
        modelData.setPath("C:\\Users\\VICTOR MANUEL ARANDA\\Documents\\archivos\\DataBase.csv");
        
        modelData.setName(viewData.jtf_nombre.getText());
        modelData.setEmail(viewData.jtf_email.getText());
        JOptionPane.showMessageDialog(null, "Tu nombre y tu email s ehan almacenado correctamente. ");
        modelData.resultCSV();
        modelData.setMessage(modelData.resultCSV());
        modelData.writeFile(modelData.getPath(), modelData.getMessage());
    }
    private void clean(){
        viewData.jtf_nombre.setText(null);
        viewData.jtf_email.setText(null);
    }
    
    private void initComponents() {
        viewData.setVisible(true);
        viewData.setLocationRelativeTo(null);
        viewData.setTitle("Base de Datos");
        
    }

}
