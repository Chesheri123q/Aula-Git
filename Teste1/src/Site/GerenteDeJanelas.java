/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Site;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
/**
 *
 * @author Aluno
 */
public class GerenteDeJanelas {
    private static JDesktopPane jDesktopPane;
    
    public GerenteDeJanelas(JDesktopPane jDesktopPane){
    
    GerenteDeJanelas.jDesktopPane = jDesktopPane;
    
    }
   
    public void abrirJanelas(JInternalFrame jInternalFrame){
    if(jInternalFrame.isVisible()){
    jInternalFrame.toFront();
            jInternalFrame.requestFocus();
    
    } else {
    jDesktopPane.add(jInternalFrame);
    }
    }
}
