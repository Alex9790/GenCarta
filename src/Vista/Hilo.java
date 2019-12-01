/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import java.io.File;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBException;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

/**
 *
 * @author Darkestt
 */
public class Hilo extends Thread{
    
    HashMap<String, String> mappings;
    String Ubicacion;
    int Quien;
    
    public Hilo(HashMap<String, String> mappings, String Ubicacion, int Quien){
        this.mappings = mappings;
        this.Ubicacion = Ubicacion;
        this.Quien = Quien;
    }
    
    void Referencia (){
        try {
            String name = "FORMATOS/Referencia.docx";
            //abrir formato
            WordprocessingMLPackage template;
            template = WordprocessingMLPackage.load(new File(name));

            MainDocumentPart documentPart = template.getMainDocumentPart();           

            documentPart.variableReplace(mappings);

            // Save it
            int i = 1;
            boolean Guardar = true;
            File Referencia;
            while(Guardar){
                Referencia = new File( Ubicacion+"\\Referencia_"+i+".docx" );
                if(!Referencia.isFile()){
                    Guardar = false;
                    template.save( Referencia );
                    //System.out.println("Listo");
                    JOptionPane.showMessageDialog(null, "Referencia Generada Exitosamente.");
                }
                i++;
            }                              

        } catch (Docx4JException | JAXBException ex) {
            Logger.getLogger(Planillas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void ConstanciaTrabajo(){
        try {
                String name = "FORMATOS/ConstanciaTrabajo.docx";
                //abrir formato
                WordprocessingMLPackage template;
                template = WordprocessingMLPackage.load(new File(name));

                MainDocumentPart documentPart = template.getMainDocumentPart();                               

                documentPart.variableReplace(mappings);

                // Save it
                int i = 1;
                boolean Guardar = true;
                File Referencia;
                while(Guardar){
                    Referencia = new File( Ubicacion+"\\ConstanciaTrabajo_"+i+".docx" );
                    if(!Referencia.isFile()){
                        Guardar = false;
                        template.save( Referencia );
                        //System.out.println("Listo");
                        JOptionPane.showMessageDialog(null, "Constancia de Trabajo Generada Exitosamente.");
                    }
                    i++;
                }                              

            } catch (Docx4JException | JAXBException ex) {
                Logger.getLogger(Planillas.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    void CartaResidencia(){
        try {
                String name = "FORMATOS/CartaResidencia.docx";
                //abrir formato
                WordprocessingMLPackage template;
                template = WordprocessingMLPackage.load(new File(name));

                MainDocumentPart documentPart = template.getMainDocumentPart();               
                
                documentPart.variableReplace(mappings);

                // Save it
                int i = 1;
                boolean Guardar = true;
                File Referencia;
                while(Guardar){
                    Referencia = new File( Ubicacion+"\\CartaResidencia_"+i+".docx" );
                    if(!Referencia.isFile()){
                        Guardar = false;
                        template.save( Referencia );
                        //System.out.println("Listo");
                        JOptionPane.showMessageDialog(null, "Carta de Residencia Generada Exitosamente.");
                    }
                    i++;
                }                              

            } catch (Docx4JException | JAXBException ex) {
                Logger.getLogger(Planillas.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    void CertificacionNormal(){
        try {
            String name = "FORMATOS/CertificacionNormal.docx";
            //abrir formato
            WordprocessingMLPackage template;
            template = WordprocessingMLPackage.load(new File(name));

            MainDocumentPart documentPart = template.getMainDocumentPart();               

            documentPart.variableReplace(mappings);

            // Save it
            int i = 1;
            boolean Guardar = true;
            File Referencia;
            while(Guardar){
                Referencia = new File( Ubicacion+"\\CertificacionNormal_"+i+".docx" );
                if(!Referencia.isFile()){
                    Guardar = false;
                    template.save( Referencia );
                    //System.out.println("Listo");
                    JOptionPane.showMessageDialog(null, "Certificación Normal Generada Exitosamente.");
                }
                i++;
            }                              

        } catch (Docx4JException | JAXBException ex) {
            Logger.getLogger(Planillas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void CertificacionRemesas(){
        try {
            String name = "FORMATOS/CertificacionRemesas.docx";
            //abrir formato
            WordprocessingMLPackage template;
            template = WordprocessingMLPackage.load(new File(name));

            MainDocumentPart documentPart = template.getMainDocumentPart();               

            documentPart.variableReplace(mappings);

            // Save it
            int i = 1;
            boolean Guardar = true;
            File Referencia;
            while(Guardar){
                Referencia = new File( Ubicacion+"\\CertificacionRemesas_"+i+".docx" );
                if(!Referencia.isFile()){
                    Guardar = false;
                    template.save( Referencia );
                    //System.out.println("Listo");
                    JOptionPane.showMessageDialog(null, "Certificacion Remesas Generada Exitosamente.");
                }
                i++;
            }                              

        } catch (Docx4JException | JAXBException ex) {
            Logger.getLogger(Planillas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void AutorizacionNairuby (){
        try {
            String name = "FORMATOS/AutorizacionNairuby.docx";
            //abrir formato
            WordprocessingMLPackage template;
            template = WordprocessingMLPackage.load(new File(name));

            MainDocumentPart documentPart = template.getMainDocumentPart();           

            documentPart.variableReplace(mappings);

            // Save it
            int i = 1;
            boolean Guardar = true;
            File Referencia;
            while(Guardar){
                Referencia = new File( Ubicacion+"\\AutorizacionNairuby_"+i+".docx" );
                if(!Referencia.isFile()){
                    Guardar = false;
                    template.save( Referencia );
                    //System.out.println("Listo");
                    JOptionPane.showMessageDialog(null, "Autorizacion Nairuby Generada Exitosamente.");
                }
                i++;
            }                              

        } catch (Docx4JException | JAXBException ex) {
            Logger.getLogger(Planillas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void CartaBuenaConducta(){
        try {
                String name = "FORMATOS/CartaBuenaConducta.docx";
                //abrir formato
                WordprocessingMLPackage template;
                template = WordprocessingMLPackage.load(new File(name));

                MainDocumentPart documentPart = template.getMainDocumentPart();               
                
                documentPart.variableReplace(mappings);

                // Save it
                int i = 1;
                boolean Guardar = true;
                File Referencia;
                while(Guardar){
                    Referencia = new File( Ubicacion+"\\CartaBuenaConducta_"+i+".docx" );
                    if(!Referencia.isFile()){
                        Guardar = false;
                        template.save( Referencia );
                        //System.out.println("Listo");
                        JOptionPane.showMessageDialog(null, "Carta de Buena Conducta Generada Exitosamente.");
                    }
                    i++;
                }                              

            } catch (Docx4JException | JAXBException ex) {
                Logger.getLogger(Planillas.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    void FeDeVidaComunal(){
        try {
                String name = "FORMATOS/FeDeVidaComunal.docx";
                //abrir formato
                WordprocessingMLPackage template;
                template = WordprocessingMLPackage.load(new File(name));

                MainDocumentPart documentPart = template.getMainDocumentPart();               
                
                documentPart.variableReplace(mappings);

                // Save it
                int i = 1;
                boolean Guardar = true;
                File Referencia;
                while(Guardar){
                    Referencia = new File( Ubicacion+"\\FeDeVidaComunal_"+i+".docx" );
                    if(!Referencia.isFile()){
                        Guardar = false;
                        template.save( Referencia );
                        //System.out.println("Listo");
                        JOptionPane.showMessageDialog(null, "Carta de Fe De Vida Comunal Generada Exitosamente.");
                    }
                    i++;
                }                              

            } catch (Docx4JException | JAXBException ex) {
                Logger.getLogger(Planillas.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    void ReferenciaFamiliares(){
        try {
                String name = "FORMATOS/ReferenciasFamiliares.docx";
                //abrir formato
                WordprocessingMLPackage template;
                template = WordprocessingMLPackage.load(new File(name));

                MainDocumentPart documentPart = template.getMainDocumentPart();               
                
                documentPart.variableReplace(mappings);

                // Save it
                int i = 1;
                boolean Guardar = true;
                File Referencia;
                while(Guardar){
                    Referencia = new File( Ubicacion+"\\ReferenciasFamiliares_"+i+".docx" );
                    if(!Referencia.isFile()){
                        Guardar = false;
                        template.save( Referencia );
                        //System.out.println("Listo");
                        JOptionPane.showMessageDialog(null, "Referencia Familiar Generada Exitosamente.");
                    }
                    i++;
                }                              

            } catch (Docx4JException | JAXBException ex) {
                Logger.getLogger(Planillas.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    void Renuncia(){
        try {
                String name = "FORMATOS/Renuncia.docx";
                //abrir formato
                WordprocessingMLPackage template;
                template = WordprocessingMLPackage.load(new File(name));

                MainDocumentPart documentPart = template.getMainDocumentPart();               
                
                documentPart.variableReplace(mappings);

                // Save it
                int i = 1;
                boolean Guardar = true;
                File Referencia;
                while(Guardar){
                    Referencia = new File( Ubicacion+"\\Renuncia_"+i+".docx" );
                    if(!Referencia.isFile()){
                        Guardar = false;
                        template.save( Referencia );
                        //System.out.println("Listo");
                        JOptionPane.showMessageDialog(null, "Renuncia Generada Exitosamente.");
                    }
                    i++;
                }                              

            } catch (Docx4JException | JAXBException ex) {
                Logger.getLogger(Planillas.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @Override
    public void run()
    {
        Carga C = new Carga();
        C.setVisible(true);
        C.setLocationRelativeTo(null);
        
        switch(Quien){
            case 0: Referencia(); break;
            case 1: ConstanciaTrabajo(); break;
            case 2: CartaResidencia(); break;
            case 3: CertificacionNormal(); break;
            case 4: CertificacionRemesas(); break;
            case 5: AutorizacionNairuby(); break;
            case 6: CartaBuenaConducta(); break;
            case 7: FeDeVidaComunal(); break;
            case 8: ReferenciaFamiliares(); break;
            case 9: Renuncia(); break;
        }
               
        C.setVisible(false);
    }
    
}
