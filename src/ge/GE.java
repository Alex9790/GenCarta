/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ge;
import Vista.Planillas;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Darkestt
 */
public class GE {

    /**
     * @param args the command line arguments
     * @throws javax.xml.bind.JAXBException
     */
    public static void main(String[] args) throws JAXBException {
        // TODO code application logic here
        UIManager.put("Synthetica.window.contentPane.opaque", Boolean.TRUE);
        try{
            UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlackMoonLookAndFeel");   
        }catch(UnsupportedLookAndFeelException ex){
            JOptionPane.showMessageDialog(null, "Error Look and Feel", 
                "Error:"+ ex.getMessage(),
                JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GE.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //llamando el frame de login
        Planillas P = new Planillas();
        P.setVisible(true);
        P.setLocationRelativeTo(null);
        
/*
        try {
            String name = "FORMATOS/CartaResidencia.docx";
            //abrir formato
            WordprocessingMLPackage template;
            template = WordprocessingMLPackage.load(new File("FORMATOS/CartaResidencia.docx"));
           
            //Modificar
            String XPATH_TO_SELECT_TEXT_NODES = "//w:t";
            
            List<Object> texts = template.getMainDocumentPart().getJAXBNodesViaXPath(XPATH_TO_SELECT_TEXT_NODES, true);

            for (Object obj : texts) {
                    Text text = (Text) ((JAXBElement) obj).getValue();
                    System.out.println("Antes: " + text.getValue());
                    //String textValue = text.getValue().replaceAll("Titulo", "HOLA");
                    //System.out.println("Despues: " + textValue);

                    //text.setValue(textValue);
            }
            
            //guardar archivo modificado
            //template.save(new File("FORMATOS/TemplateNew.docx"));
            
        } catch (Docx4JException | JAXBException ex) {
            Logger.getLogger(GE.class.getName()).log(Level.SEVERE, null, ex);
        }
*/        

/* 
        try {
            String name = "FORMATOS/CartaResidencia.docx";
            //abrir formato
            WordprocessingMLPackage template;
            template = WordprocessingMLPackage.load(new File(name));
            
            MainDocumentPart documentPart = template.getMainDocumentPart();

            HashMap<String, String> mappings = new HashMap<>();
            mappings.put("Nombre", "popo");
            mappings.put("Nacionalidad", "Venezolano");
            mappings.put("Cedula", "123.120.121");
            mappings.put("Dir", "por ahi");
            mappings.put("añoV", "105");
            mappings.put("Tel", "105.78.89");
            mappings.put("Razon", "porque si");
            mappings.put("dia", "10");
            mappings.put("mes", "octoberfest");
            mappings.put("año", "3100");
           
            documentPart.variableReplace(mappings);
            
            // Save it
            template.save(new File("FORMATOS/CartaResidenciaNew.docx"));
            System.out.println("Listo");
            
        } catch (Docx4JException ex) {
            Logger.getLogger(GE.class.getName()).log(Level.SEVERE, null, ex);
        }
*/        
        
    }
    
}
