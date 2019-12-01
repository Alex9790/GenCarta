/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Darkestt
 */
public class Planillas extends javax.swing.JFrame {
    Hilo H;
    private final String[] Meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    
    //idices para saber los 6 meses de certificado remesas
    int[] indices = new int[6];
    /**
     * Creates new form Planillas
     */ 
    @SuppressWarnings("empty-statement")
    public Planillas() {
        super("Generador de Cartas");
        initComponents();
        
        boolean SeleccionarUbicacion = false;
        
        File Dir = new File( "FORMATOS/Ubicacion.txt" );
        if (!Dir.isFile()) {  //si no existe el archivo     
            SeleccionarUbicacion = true;
                                    
        } else {
            
            BufferedReader entrada;
            try {
                entrada = new BufferedReader( new FileReader( Dir ) );
                String linea;
                linea = entrada.readLine();
                Dir = new File( linea );
                 if (!Dir.isDirectory()) {  //si no existe la carpeta q dice el archivo
                     SeleccionarUbicacion = true;
                 }else{
                     UbicacionLabel.setText(linea);
                 }
            }catch (IOException e) {};             
        }
        
        if(SeleccionarUbicacion){
            JOptionPane.showMessageDialog(null, "Selecciona la ubicación de las cartas generadas");
            
            JFileChooser Chooser = new JFileChooser();
            Chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if(Chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                UbicacionLabel.setText(Chooser.getSelectedFile().toString());
            }

            File f;
            f = new File("FORMATOS/Ubicacion.txt");
            //Escritura
            try{
                FileWriter w = new FileWriter(f);
                try (BufferedWriter bw = new BufferedWriter(w); PrintWriter wr = new PrintWriter(bw)) {
                    wr.write(UbicacionLabel.getText());//escribimos en el archivo
                }
            }catch(IOException e){};
        }
        
        Limpiar();
        //inicializando el Sexo
        //HombreRadioButton.setSelected(true);
        //TraHombreRadioButton.setSelected(true);
           
    }

    public final void Limpiar (){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //get current date time with Calendar()
        Calendar cal = Calendar.getInstance();
        
        //Limpiar Referencias
        Nombre1TextField.setText("");
        Cedula1FormattedTextField.setText("");
        Dir1TextField.setText("");
        Tel1TextField.setText("");
        Nombre2TextField.setText("");
        Cedula2FormattedTextField.setText("");
        SexoButtonGroup.clearSelection();
        CiudadTextField.setText("Caracas");
        //FechaDateChooser.setDate(null); 
        AñosConocidosSpinner.setValue(0);        
        FechaDateChooser.setDate(cal.getTime());
        HombreRadioButton.setSelected(true);
                
        //Limpiar Contancia de Trabajo
        TraNombreTextField.setText("");
        TraRifTextField.setText("");
        TraTelefonoTextField.setText("");
        TraDireccionTextField.setText("");
        TraNombreResTextField.setText("");
        TraCargoResTextField.setText("");
        TraNombreEmpTextField.setText("");
        TraCedulaEmpFormattedTextField.setText("");
        SexoButtonGroup2.clearSelection();
        TraFechaEmpDateChooser.setDate(null);
        TraCargoEmpTextField.setText("");
        TraSueldoEmpTextField.setText("");
        TraSueldoEmpSpinner.setValue(0);        
        TraCiudadTextField.setText("Caracas");
        TraFechaActualDateChooser.setDate(cal.getTime());
        TraHombreRadioButton.setSelected(true);
        
        //Limpiar Carta de Residencia
        ResNombreTextField.setText("");
        ResCedulaFormattedTextField.setText("");
        ResNacTextField.setText("VENEZOLANA");
        ResDirTextField.setText("");
        ResAñosSpinner.setValue(0);
        ResTelTextField.setText("");
        ResFechaActualDateChooser.setDate(cal.getTime());
        ResRazonTextArea.setText("");
        
        //Limpiar Autorizacion Nairuby 
        ANNombreTextField.setText("");
        ANCedulaFormattedTextField.setText("");
        SexoButtonGroup3.clearSelection();
        ANFechaActualDateChooser.setDate(cal.getTime());
        ANHombreRadioButton.setSelected(true);
        ANRazonTextArea.setText("");
        
        //Limpiar Carta de Buena Conducta
        BCNombreTextField.setText("");
        BCCedulaFormattedTextField.setText("");
        BCNacTextField.setText("VENEZOLANA");
        BCDirTextField.setText("");
        BCAñosSpinner.setValue(0);
        BCTelTextField.setText("");        
        BCFechaActualDateChooser.setDate(cal.getTime());
        BCProfesionTextField.setText("");
        BCRazonTextArea.setText("");
        
        //Limpiar Carta Fe De Vida
        FDVNombresTextField.setText("");
        FDVApellidosTextField.setText("");
        FDVCedulaFormattedTextField.setText("");
        FDVEdoCivilTextField.setText("");
        FDVEFTextField.setText("");
        FDVMunicipioTextField.setText("");
        FDVCiudadTextField.setText("");
        FDVParroquiaTextField.setText("");
        FDVCalleTextField.setText("");
        FDVNumCasaSpinner.setValue(0);
        FDVAñosSpinner.setValue(0);
        FDVFechaActualDateChooser.setDate(cal.getTime());
        
        //Limpiar Referencias Familiares
        RFNombreTextField.setText("");
        RFCedulaFormattedTextField.setText("");
        RFTelTextField.setText("");
        RFNombre2TextField.setText("");
        RFCedula2FormattedTextField.setText("");
        SexoButtonGroup3.clearSelection();
        RFRelFamiliaTextField.setText("");
        //FechaDateChooser.setDate(null);        
        RFFechaDateChooser.setDate(cal.getTime());
        RFHombreRadioButton.setSelected(true);
        
        //Limpiar Renuncia
        ReNombreTextField.setText("");
        ReCedulaFormattedTextField.setText("");
        ReNombreEmpresaTextField.setText("");
        ReCargoTextField.setText("");
        ReRazonTextArea.setText("");
        ReFechaActualDateChooser.setDate(cal.getTime());        
    }
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SexoButtonGroup = new javax.swing.ButtonGroup();
        SexoButtonGroup1 = new javax.swing.ButtonGroup();
        SexoButtonGroup2 = new javax.swing.ButtonGroup();
        SexoButtonGroup3 = new javax.swing.ButtonGroup();
        GenCartasLabel = new javax.swing.JLabel();
        TabPane = new javax.swing.JTabbedPane();
        ReferenciaScrollPane = new javax.swing.JScrollPane();
        ReferenciaPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Nombre1Label = new javax.swing.JLabel();
        Cedula1Label = new javax.swing.JLabel();
        Dir1Label = new javax.swing.JLabel();
        Tel1Label = new javax.swing.JLabel();
        Nombre1TextField = new javax.swing.JTextField();
        Cedula1FormattedTextField = new javax.swing.JFormattedTextField();
        Dir1TextField = new javax.swing.JTextField();
        Tel1TextField = new javax.swing.JTextField();
        Nombre2Label = new javax.swing.JLabel();
        Cedula2Label = new javax.swing.JLabel();
        SexoLabel = new javax.swing.JLabel();
        Nombre2TextField = new javax.swing.JTextField();
        Cedula2FormattedTextField = new javax.swing.JFormattedTextField();
        HombreRadioButton = new javax.swing.JRadioButton();
        MujerRadioButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        CiudadLabel = new javax.swing.JLabel();
        FechaLabel = new javax.swing.JLabel();
        AñosConocidosLabel = new javax.swing.JLabel();
        CiudadTextField = new javax.swing.JTextField();
        AñosConocidosSpinner = new javax.swing.JSpinner();
        LimpiarButton = new javax.swing.JButton();
        GenReferenciaButton = new javax.swing.JButton();
        FechaDateChooser = new com.toedter.calendar.JDateChooser();
        Cedula1ComboBox = new javax.swing.JComboBox();
        Cedula2ComboBox = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        ReferenciaFamiliarScrollPane = new javax.swing.JScrollPane();
        ReferenciaFamiliarPanel = new javax.swing.JPanel();
        RFFechaLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        RFLimpiarButton = new javax.swing.JButton();
        RFNombreLabel = new javax.swing.JLabel();
        RFGenReferenciaButton = new javax.swing.JButton();
        RFCedulaLabel = new javax.swing.JLabel();
        RFFechaDateChooser = new com.toedter.calendar.JDateChooser();
        RFCedulaComboBox = new javax.swing.JComboBox();
        RFTelLabel = new javax.swing.JLabel();
        RFCedula2ComboBox = new javax.swing.JComboBox();
        RFNombreTextField = new javax.swing.JTextField();
        RFCedulaFormattedTextField = new javax.swing.JFormattedTextField();
        RFTelTextField = new javax.swing.JTextField();
        RFNombre2Label = new javax.swing.JLabel();
        RFCedula2Label = new javax.swing.JLabel();
        RFSexoLabel = new javax.swing.JLabel();
        RFNombre2TextField = new javax.swing.JTextField();
        RFCedula2FormattedTextField = new javax.swing.JFormattedTextField();
        RFHombreRadioButton = new javax.swing.JRadioButton();
        RFMujerRadioButton = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        RFRelFamiliarLabel = new javax.swing.JLabel();
        RFRelFamiliaTextField = new javax.swing.JTextField();
        ConstTrabajoScrollPane = new javax.swing.JScrollPane();
        ConstTrabajoPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        TraNombreLabel = new javax.swing.JLabel();
        TraRifLabel = new javax.swing.JLabel();
        TraTelefonoLabel = new javax.swing.JLabel();
        TraDireccionLabel = new javax.swing.JLabel();
        TraNombreResLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TraCargoResLabel = new javax.swing.JLabel();
        TraNombreTextField = new javax.swing.JTextField();
        TraRifTextField = new javax.swing.JTextField();
        TraTelefonoTextField = new javax.swing.JTextField();
        TraDireccionTextField = new javax.swing.JTextField();
        TraNombreResTextField = new javax.swing.JTextField();
        TraCargoResTextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        TraNombreEmpLabel = new javax.swing.JLabel();
        TraCedulaEmpLabel = new javax.swing.JLabel();
        TraFechaEmpLabel = new javax.swing.JLabel();
        TraNombreEmpTextField = new javax.swing.JTextField();
        TraCedulaEmpFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        TraCiudadLabel = new javax.swing.JLabel();
        TraFechaActualLabel = new javax.swing.JLabel();
        TraCiudadTextField = new javax.swing.JTextField();
        TraLimpiarButton = new javax.swing.JButton();
        TraGenConstanciaButton = new javax.swing.JButton();
        TraCargoEmpLabel = new javax.swing.JLabel();
        TraCargoEmpTextField = new javax.swing.JTextField();
        TraSueldoEmpLabel = new javax.swing.JLabel();
        TraSueldoEmpTextField = new javax.swing.JTextField();
        TraSueldoEmpSpinner = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        TraSexoEmpLabel = new javax.swing.JLabel();
        TraHombreRadioButton = new javax.swing.JRadioButton();
        TraMujerRadioButton = new javax.swing.JRadioButton();
        TraFechaEmpDateChooser = new com.toedter.calendar.JDateChooser();
        TraFechaActualDateChooser = new com.toedter.calendar.JDateChooser();
        TraCedulaComboBox1 = new javax.swing.JComboBox();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        ResidenciaScrollPane = new javax.swing.JScrollPane();
        ResidenciaPanel = new javax.swing.JPanel();
        ResNombreLabel = new javax.swing.JLabel();
        ResCedulaLabel = new javax.swing.JLabel();
        ResNacLabel = new javax.swing.JLabel();
        ResDirLabel = new javax.swing.JLabel();
        ResAñosLabel = new javax.swing.JLabel();
        ResTelLabel = new javax.swing.JLabel();
        ResRazonLabel = new javax.swing.JLabel();
        ResFechaActualLabel = new javax.swing.JLabel();
        ResNombreTextField = new javax.swing.JTextField();
        ResCedulaFormattedTextField = new javax.swing.JFormattedTextField();
        ResNacTextField = new javax.swing.JTextField();
        ResDirTextField = new javax.swing.JTextField();
        ResTelTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ResRazonTextArea = new javax.swing.JTextArea();
        ResAñosSpinner = new javax.swing.JSpinner();
        ResLimpiarButton = new javax.swing.JButton();
        GenResCartaButton = new javax.swing.JButton();
        ResFechaActualDateChooser = new com.toedter.calendar.JDateChooser();
        ResCedulaComboBox = new javax.swing.JComboBox();
        AutorizacionNairubyScrollPane = new javax.swing.JScrollPane();
        AutorizacionNairubyPanel = new javax.swing.JPanel();
        ANNombreLabel = new javax.swing.JLabel();
        ANNombreTextField = new javax.swing.JTextField();
        ANCedulaLabel = new javax.swing.JLabel();
        ANCedulaComboBox = new javax.swing.JComboBox();
        ANCedulaFormattedTextField = new javax.swing.JFormattedTextField();
        ANSexoLabel = new javax.swing.JLabel();
        ANHombreRadioButton = new javax.swing.JRadioButton();
        ANMujerRadioButton = new javax.swing.JRadioButton();
        ANLimpiarButton = new javax.swing.JButton();
        ANGenAutorizacionNairubyButton = new javax.swing.JButton();
        ANFechaActualLabel = new javax.swing.JLabel();
        ANFechaActualDateChooser = new com.toedter.calendar.JDateChooser();
        ANRazonLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ANRazonTextArea = new javax.swing.JTextArea();
        BuenaConductaScrollPane = new javax.swing.JScrollPane();
        BuenaConductaPanel = new javax.swing.JPanel();
        BCNombreLabel = new javax.swing.JLabel();
        BCNombreTextField = new javax.swing.JTextField();
        BCCedulaLabel = new javax.swing.JLabel();
        BCCedulaComboBox = new javax.swing.JComboBox();
        BCCedulaFormattedTextField = new javax.swing.JFormattedTextField();
        BCNacLabel = new javax.swing.JLabel();
        BCNacTextField = new javax.swing.JTextField();
        BCDirLabel = new javax.swing.JLabel();
        BCDirTextField = new javax.swing.JTextField();
        BCAñosLabel = new javax.swing.JLabel();
        BCAñosSpinner = new javax.swing.JSpinner();
        BCTelLabel = new javax.swing.JLabel();
        BCTelTextField = new javax.swing.JTextField();
        BCFechaActualLabel = new javax.swing.JLabel();
        BCFechaActualDateChooser = new com.toedter.calendar.JDateChooser();
        BCProfesionLabel = new javax.swing.JLabel();
        BCProfesionTextField = new javax.swing.JTextField();
        BCRazonLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        BCRazonTextArea = new javax.swing.JTextArea();
        BCLimpiarButton = new javax.swing.JButton();
        GenBCCartaButton = new javax.swing.JButton();
        FeDeVidaScrollPane = new javax.swing.JScrollPane();
        FeDeVidaPanel = new javax.swing.JPanel();
        FDVNombresTextField = new javax.swing.JTextField();
        FDVNombresLabel = new javax.swing.JLabel();
        FDVApellidosLabel = new javax.swing.JLabel();
        FDVApellidosTextField = new javax.swing.JTextField();
        FDCCedulaLabel = new javax.swing.JLabel();
        FDVCedulaComboBox = new javax.swing.JComboBox();
        FDVCedulaFormattedTextField = new javax.swing.JFormattedTextField();
        BCNacLabel1 = new javax.swing.JLabel();
        FDVEdoCivilTextField = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        FDVEFLabel = new javax.swing.JLabel();
        FDVEFTextField = new javax.swing.JTextField();
        FDVMunicipioTextField = new javax.swing.JTextField();
        FDVMunicipioLabel = new javax.swing.JLabel();
        FDVParroquiaLabel = new javax.swing.JLabel();
        FDVParroquiaTextField = new javax.swing.JTextField();
        FDVCiudadTextField = new javax.swing.JTextField();
        FDVCiudadLabel = new javax.swing.JLabel();
        FDVNumCasaLabel = new javax.swing.JLabel();
        FDVCalleTextField = new javax.swing.JTextField();
        FDVCalleLabel6 = new javax.swing.JLabel();
        FDVAñosLabel = new javax.swing.JLabel();
        FDVAñosSpinner = new javax.swing.JSpinner();
        jSeparator7 = new javax.swing.JSeparator();
        FDVNumCasaSpinner = new javax.swing.JSpinner();
        BCFechaActualLabel1 = new javax.swing.JLabel();
        FDVFechaActualDateChooser = new com.toedter.calendar.JDateChooser();
        FDVLimpiarButton = new javax.swing.JButton();
        GenFDVCartaButton = new javax.swing.JButton();
        RenunciaScrollPane = new javax.swing.JScrollPane();
        RenunciaPanel = new javax.swing.JPanel();
        ReNombreLabel = new javax.swing.JLabel();
        ReNombreTextField = new javax.swing.JTextField();
        ReCedulaLabel = new javax.swing.JLabel();
        ReCedulaComboBox = new javax.swing.JComboBox();
        ReCedulaFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        ReNombreEmpresaLabel = new javax.swing.JLabel();
        ReNombreEmpresaTextField = new javax.swing.JTextField();
        ReRazonLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ReRazonTextArea = new javax.swing.JTextArea();
        ReCargoLabel = new javax.swing.JLabel();
        ReCargoTextField = new javax.swing.JTextField();
        ReFechaActualLabel = new javax.swing.JLabel();
        ReFechaActualDateChooser = new com.toedter.calendar.JDateChooser();
        ReLimpiarButton = new javax.swing.JButton();
        GenReCartaButton = new javax.swing.JButton();
        CambiarUbicacionButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        UbicacionLabel = new javax.swing.JLabel();
        LogoDarkestt = new javax.swing.JLabel();
        VersionLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(820, 578));

        GenCartasLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        GenCartasLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/GenCarta 02.png"))); // NOI18N

        TabPane.setPreferredSize(new java.awt.Dimension(790, 493));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("De");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Para");

        Nombre1Label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Nombre1Label.setText("Nombre");

        Cedula1Label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Cedula1Label.setText("Cédula");

        Dir1Label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Dir1Label.setText("Dirección");

        Tel1Label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Tel1Label.setText("Teléfono");

        Nombre1TextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Cedula1FormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        Cedula1FormattedTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Dir1TextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Tel1TextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Nombre2Label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Nombre2Label.setText("Nombre");

        Cedula2Label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Cedula2Label.setText("Cédula");

        SexoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SexoLabel.setText("Sexo");

        Nombre2TextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Cedula2FormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        Cedula2FormattedTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        SexoButtonGroup.add(HombreRadioButton);
        HombreRadioButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        HombreRadioButton.setText("Hombre");

        SexoButtonGroup.add(MujerRadioButton);
        MujerRadioButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MujerRadioButton.setText("Mujer");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Otros Datos");

        CiudadLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CiudadLabel.setText("Ciudad");

        FechaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FechaLabel.setText("Fecha");

        AñosConocidosLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AñosConocidosLabel.setText("Años de Conocidos");

        CiudadTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        AñosConocidosSpinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
        AñosConocidosSpinner.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        LimpiarButton.setText("Limpiar");
        LimpiarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LimpiarButtonMouseClicked(evt);
            }
        });

        GenReferenciaButton.setText("Generar Referencia");
        GenReferenciaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GenReferenciaButtonMouseClicked(evt);
            }
        });

        Cedula1ComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Cedula1ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "V", "E" }));

        Cedula2ComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Cedula2ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "V", "E" }));

        jSeparator1.setBackground(new java.awt.Color(51, 153, 255));
        jSeparator1.setForeground(new java.awt.Color(51, 153, 255));

        jSeparator2.setBackground(new java.awt.Color(0, 204, 51));
        jSeparator2.setForeground(new java.awt.Color(51, 153, 255));
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 10));

        javax.swing.GroupLayout ReferenciaPanelLayout = new javax.swing.GroupLayout(ReferenciaPanel);
        ReferenciaPanel.setLayout(ReferenciaPanelLayout);
        ReferenciaPanelLayout.setHorizontalGroup(
            ReferenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReferenciaPanelLayout.createSequentialGroup()
                .addGroup(ReferenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReferenciaPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(CiudadLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CiudadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(ReferenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ReferenciaPanelLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(LimpiarButton)
                                .addGap(58, 58, 58)
                                .addComponent(GenReferenciaButton))
                            .addGroup(ReferenciaPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ReferenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addGroup(ReferenciaPanelLayout.createSequentialGroup()
                                        .addComponent(FechaLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(FechaDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AñosConocidosLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AñosConocidosSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ReferenciaPanelLayout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(jLabel1))
                    .addGroup(ReferenciaPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(ReferenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ReferenciaPanelLayout.createSequentialGroup()
                                .addGroup(ReferenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Nombre1Label)
                                    .addComponent(Cedula1Label))
                                .addGap(18, 18, 18)
                                .addGroup(ReferenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Nombre1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ReferenciaPanelLayout.createSequentialGroup()
                                        .addComponent(Cedula1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Cedula1FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Tel1Label)
                                        .addGap(18, 18, 18)
                                        .addComponent(Tel1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(ReferenciaPanelLayout.createSequentialGroup()
                                .addComponent(Dir1Label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Dir1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ReferenciaPanelLayout.createSequentialGroup()
                                .addGap(322, 322, 322)
                                .addComponent(jLabel2))
                            .addGroup(ReferenciaPanelLayout.createSequentialGroup()
                                .addGroup(ReferenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Nombre2Label)
                                    .addComponent(Cedula2Label))
                                .addGap(18, 18, 18)
                                .addGroup(ReferenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Nombre2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ReferenciaPanelLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(Cedula2ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Cedula2FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(SexoLabel)
                                        .addGap(46, 46, 46)
                                        .addComponent(HombreRadioButton)
                                        .addGap(35, 35, 35)
                                        .addComponent(MujerRadioButton))))))
                    .addGroup(ReferenciaPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ReferenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        ReferenciaPanelLayout.setVerticalGroup(
            ReferenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReferenciaPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(ReferenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nombre1Label))
                .addGroup(ReferenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReferenciaPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(Cedula1Label))
                    .addGroup(ReferenciaPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ReferenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Cedula1ComboBox)
                            .addGroup(ReferenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Cedula1FormattedTextField)
                                .addComponent(Tel1Label)
                                .addComponent(Tel1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(ReferenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Dir1Label)
                    .addComponent(Dir1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addGroup(ReferenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre2Label)
                    .addComponent(Nombre2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ReferenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cedula2Label)
                    .addComponent(Cedula2FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cedula2ComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(SexoLabel)
                    .addComponent(HombreRadioButton)
                    .addComponent(MujerRadioButton))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ReferenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ReferenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AñosConocidosLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AñosConocidosSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ReferenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CiudadLabel)
                        .addComponent(CiudadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FechaLabel))
                    .addComponent(FechaDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(ReferenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LimpiarButton)
                    .addComponent(GenReferenciaButton))
                .addGap(29, 29, 29))
        );

        ReferenciaScrollPane.setViewportView(ReferenciaPanel);

        TabPane.addTab("Referencia", ReferenciaScrollPane);

        RFFechaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RFFechaLabel.setText("Fecha Actual");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("De");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Para");

        RFLimpiarButton.setText("Limpiar");
        RFLimpiarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RFLimpiarButtonMouseClicked(evt);
            }
        });

        RFNombreLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RFNombreLabel.setText("Nombre");

        RFGenReferenciaButton.setText("Generar Referencia Familiar");
        RFGenReferenciaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RFGenReferenciaButtonMouseClicked(evt);
            }
        });

        RFCedulaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RFCedulaLabel.setText("Cédula");

        RFCedulaComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RFCedulaComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "V", "E" }));

        RFTelLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RFTelLabel.setText("Teléfono");

        RFCedula2ComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RFCedula2ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "V", "E" }));

        RFNombreTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        RFCedulaFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        RFCedulaFormattedTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        RFTelTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        RFNombre2Label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RFNombre2Label.setText("Nombre");

        RFCedula2Label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RFCedula2Label.setText("Cédula");

        RFSexoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RFSexoLabel.setText("Sexo");

        RFNombre2TextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        RFCedula2FormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        RFCedula2FormattedTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        SexoButtonGroup3.add(RFHombreRadioButton);
        RFHombreRadioButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        RFHombreRadioButton.setText("Hombre");

        SexoButtonGroup3.add(RFMujerRadioButton);
        RFMujerRadioButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        RFMujerRadioButton.setText("Mujer");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Otros Datos");

        jSeparator8.setBackground(new java.awt.Color(51, 153, 255));
        jSeparator8.setForeground(new java.awt.Color(51, 153, 255));

        jSeparator9.setBackground(new java.awt.Color(0, 204, 51));
        jSeparator9.setForeground(new java.awt.Color(51, 153, 255));
        jSeparator9.setPreferredSize(new java.awt.Dimension(50, 10));

        RFRelFamiliarLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RFRelFamiliarLabel.setText("Relación Familiar");

        RFRelFamiliaTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout ReferenciaFamiliarPanelLayout = new javax.swing.GroupLayout(ReferenciaFamiliarPanel);
        ReferenciaFamiliarPanel.setLayout(ReferenciaFamiliarPanelLayout);
        ReferenciaFamiliarPanelLayout.setHorizontalGroup(
            ReferenciaFamiliarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReferenciaFamiliarPanelLayout.createSequentialGroup()
                .addGroup(ReferenciaFamiliarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReferenciaFamiliarPanelLayout.createSequentialGroup()
                        .addGroup(ReferenciaFamiliarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ReferenciaFamiliarPanelLayout.createSequentialGroup()
                                .addGap(359, 359, 359)
                                .addComponent(jLabel8))
                            .addGroup(ReferenciaFamiliarPanelLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(ReferenciaFamiliarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(ReferenciaFamiliarPanelLayout.createSequentialGroup()
                                        .addGroup(ReferenciaFamiliarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(RFNombreLabel)
                                            .addComponent(RFCedulaLabel))
                                        .addGap(18, 18, 18)
                                        .addGroup(ReferenciaFamiliarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(RFNombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(ReferenciaFamiliarPanelLayout.createSequentialGroup()
                                                .addComponent(RFCedulaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(RFCedulaFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(RFTelLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(RFTelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(ReferenciaFamiliarPanelLayout.createSequentialGroup()
                                        .addGap(322, 322, 322)
                                        .addComponent(jLabel9))
                                    .addGroup(ReferenciaFamiliarPanelLayout.createSequentialGroup()
                                        .addGroup(ReferenciaFamiliarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(RFNombre2Label)
                                            .addComponent(RFCedula2Label))
                                        .addGap(18, 18, 18)
                                        .addGroup(ReferenciaFamiliarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(RFNombre2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(ReferenciaFamiliarPanelLayout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(RFCedula2ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(RFCedula2FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(RFSexoLabel)
                                                .addGap(46, 46, 46)
                                                .addComponent(RFHombreRadioButton)
                                                .addGap(35, 35, 35)
                                                .addComponent(RFMujerRadioButton))))
                                    .addGroup(ReferenciaFamiliarPanelLayout.createSequentialGroup()
                                        .addComponent(RFRelFamiliarLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(RFRelFamiliaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(ReferenciaFamiliarPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ReferenciaFamiliarPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ReferenciaFamiliarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ReferenciaFamiliarPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(RFFechaLabel)
                                .addGap(18, 18, 18)
                                .addComponent(RFFechaDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(265, 487, Short.MAX_VALUE))
                            .addComponent(jSeparator9, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReferenciaFamiliarPanelLayout.createSequentialGroup()
                                .addComponent(RFLimpiarButton)
                                .addGap(58, 58, 58)
                                .addComponent(RFGenReferenciaButton)
                                .addGap(228, 228, 228)))))
                .addContainerGap())
            .addGroup(ReferenciaFamiliarPanelLayout.createSequentialGroup()
                .addGap(336, 336, 336)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ReferenciaFamiliarPanelLayout.setVerticalGroup(
            ReferenciaFamiliarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReferenciaFamiliarPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(ReferenciaFamiliarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RFNombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RFNombreLabel))
                .addGroup(ReferenciaFamiliarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReferenciaFamiliarPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(RFCedulaLabel))
                    .addGroup(ReferenciaFamiliarPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ReferenciaFamiliarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RFCedulaComboBox)
                            .addGroup(ReferenciaFamiliarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(RFCedulaFormattedTextField)
                                .addComponent(RFTelLabel)
                                .addComponent(RFTelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(25, 25, 25)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(7, 7, 7)
                .addGroup(ReferenciaFamiliarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RFNombre2Label)
                    .addComponent(RFNombre2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ReferenciaFamiliarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RFCedula2Label)
                    .addComponent(RFCedula2FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RFCedula2ComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(RFSexoLabel)
                    .addComponent(RFHombreRadioButton)
                    .addComponent(RFMujerRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ReferenciaFamiliarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RFRelFamiliarLabel)
                    .addComponent(RFRelFamiliaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ReferenciaFamiliarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RFFechaLabel)
                    .addComponent(RFFechaDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(ReferenciaFamiliarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RFLimpiarButton)
                    .addComponent(RFGenReferenciaButton))
                .addGap(19, 19, 19))
        );

        ReferenciaFamiliarScrollPane.setViewportView(ReferenciaFamiliarPanel);

        TabPane.addTab("Referencia Familiar", ReferenciaFamiliarScrollPane);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Empresa");

        TraNombreLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TraNombreLabel.setText("Nombre");

        TraRifLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TraRifLabel.setText("Rif");

        TraTelefonoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TraTelefonoLabel.setText("Teléfono");

        TraDireccionLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TraDireccionLabel.setText("Dirección");

        TraNombreResLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TraNombreResLabel.setText("Nombre");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Responsable");

        jLabel12.setText("(Quien Firma)");

        TraCargoResLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TraCargoResLabel.setText("Cargo");

        TraNombreTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        TraRifTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        TraTelefonoTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        TraDireccionTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        TraNombreResTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        TraCargoResTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Empleado");

        TraNombreEmpLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TraNombreEmpLabel.setText("Nombre");

        TraCedulaEmpLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TraCedulaEmpLabel.setText("Cédula");

        TraFechaEmpLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TraFechaEmpLabel.setText("Fecha Ingreso");

        TraNombreEmpTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        TraCedulaEmpFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        TraCedulaEmpFormattedTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Otros Datos");

        TraCiudadLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TraCiudadLabel.setText("Ciudad");

        TraFechaActualLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        TraFechaActualLabel.setText("Fecha Actual");

        TraCiudadTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        TraLimpiarButton.setText("Limpiar");
        TraLimpiarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TraLimpiarButtonMouseClicked(evt);
            }
        });

        TraGenConstanciaButton.setText("Generar Constancia de Trabajo");
        TraGenConstanciaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TraGenConstanciaButtonMouseClicked(evt);
            }
        });

        TraCargoEmpLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TraCargoEmpLabel.setText("Cargo");

        TraCargoEmpTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        TraSueldoEmpLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TraSueldoEmpLabel.setText("Sueldo");

        TraSueldoEmpTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        TraSueldoEmpSpinner.setModel(new SpinnerNumberModel(0, 0, 1000000, 1));
        TraSueldoEmpSpinner.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText(",00");

        TraSexoEmpLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TraSexoEmpLabel.setText("Sexo");

        SexoButtonGroup1.add(TraHombreRadioButton);
        TraHombreRadioButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TraHombreRadioButton.setText("Hombre");

        SexoButtonGroup1.add(TraMujerRadioButton);
        TraMujerRadioButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TraMujerRadioButton.setText("Mujer");

        TraCedulaComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TraCedulaComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "V", "E" }));

        jSeparator3.setBackground(new java.awt.Color(51, 153, 255));
        jSeparator3.setForeground(new java.awt.Color(51, 153, 255));

        jSeparator4.setBackground(new java.awt.Color(0, 204, 51));
        jSeparator4.setForeground(new java.awt.Color(51, 153, 255));

        jSeparator5.setBackground(new java.awt.Color(51, 153, 255));
        jSeparator5.setForeground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout ConstTrabajoPanelLayout = new javax.swing.GroupLayout(ConstTrabajoPanel);
        ConstTrabajoPanel.setLayout(ConstTrabajoPanelLayout);
        ConstTrabajoPanelLayout.setHorizontalGroup(
            ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConstTrabajoPanelLayout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(TraLimpiarButton)
                .addGap(37, 37, 37)
                .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TraGenConstanciaButton)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConstTrabajoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(94, 94, 94)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ConstTrabajoPanelLayout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConstTrabajoPanelLayout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConstTrabajoPanelLayout.createSequentialGroup()
                        .addComponent(TraTelefonoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TraTelefonoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConstTrabajoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(331, 331, 331))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConstTrabajoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(331, 331, 331))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConstTrabajoPanelLayout.createSequentialGroup()
                        .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TraSueldoEmpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(ConstTrabajoPanelLayout.createSequentialGroup()
                                    .addComponent(TraDireccionLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(TraDireccionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(ConstTrabajoPanelLayout.createSequentialGroup()
                                    .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TraNombreLabel)
                                        .addComponent(TraRifLabel))
                                    .addGap(18, 18, 18)
                                    .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TraNombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TraRifTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(ConstTrabajoPanelLayout.createSequentialGroup()
                                    .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TraNombreResLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TraNombreEmpLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TraCedulaEmpLabel)
                                        .addComponent(TraCargoResLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TraNombreResTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TraCargoResTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConstTrabajoPanelLayout.createSequentialGroup()
                                            .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(ConstTrabajoPanelLayout.createSequentialGroup()
                                                    .addComponent(TraCedulaComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(TraCedulaEmpFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(ConstTrabajoPanelLayout.createSequentialGroup()
                                                    .addGap(43, 43, 43)
                                                    .addComponent(TraFechaEmpDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(TraCargoEmpLabel)
                                                .addGroup(ConstTrabajoPanelLayout.createSequentialGroup()
                                                    .addComponent(TraSexoEmpLabel)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(TraHombreRadioButton)
                                                    .addGap(30, 30, 30)
                                                    .addComponent(TraMujerRadioButton))))
                                        .addGroup(ConstTrabajoPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(TraNombreEmpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(ConstTrabajoPanelLayout.createSequentialGroup()
                                    .addComponent(TraFechaEmpLabel)
                                    .addGap(356, 356, 356)
                                    .addComponent(TraCargoEmpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(ConstTrabajoPanelLayout.createSequentialGroup()
                                    .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TraSueldoEmpLabel)
                                        .addComponent(TraCiudadLabel))
                                    .addGap(28, 28, 28)
                                    .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(ConstTrabajoPanelLayout.createSequentialGroup()
                                            .addComponent(TraSueldoEmpSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel6))
                                        .addGroup(ConstTrabajoPanelLayout.createSequentialGroup()
                                            .addComponent(TraCiudadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(112, 112, 112)
                                            .addComponent(TraFechaActualLabel)
                                            .addGap(18, 18, 18)
                                            .addComponent(TraFechaActualDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(44, 44, 44))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConstTrabajoPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        ConstTrabajoPanelLayout.setVerticalGroup(
            ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConstTrabajoPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TraNombreLabel)
                    .addComponent(TraNombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TraRifTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TraRifLabel))
                    .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TraTelefonoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TraTelefonoLabel)))
                .addGap(18, 18, 18)
                .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TraDireccionLabel)
                    .addComponent(TraDireccionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TraNombreResLabel)
                    .addComponent(TraNombreResTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(11, 11, 11)
                .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TraCargoResTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TraCargoResLabel))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TraNombreEmpLabel)
                    .addComponent(TraNombreEmpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TraCedulaEmpFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TraCedulaEmpLabel)
                    .addComponent(TraCedulaComboBox1)
                    .addComponent(TraSexoEmpLabel)
                    .addComponent(TraHombreRadioButton)
                    .addComponent(TraMujerRadioButton))
                .addGap(18, 18, 18)
                .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TraFechaEmpLabel)
                    .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TraCargoEmpLabel)
                        .addComponent(TraCargoEmpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TraFechaEmpDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TraSueldoEmpLabel)
                    .addComponent(TraSueldoEmpSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TraSueldoEmpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConstTrabajoPanelLayout.createSequentialGroup()
                        .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TraCiudadLabel)
                            .addComponent(TraCiudadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TraFechaActualLabel))
                        .addGap(29, 29, 29)
                        .addGroup(ConstTrabajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TraLimpiarButton)
                            .addComponent(TraGenConstanciaButton)))
                    .addComponent(TraFechaActualDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        ConstTrabajoScrollPane.setViewportView(ConstTrabajoPanel);

        TabPane.addTab("Constancia de trabajo", ConstTrabajoScrollPane);

        ResNombreLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ResNombreLabel.setText("Nombre");

        ResCedulaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ResCedulaLabel.setText("Cédula");

        ResNacLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ResNacLabel.setText("Nacionalidad");

        ResDirLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ResDirLabel.setText("Dirección");

        ResAñosLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ResAñosLabel.setText("Años Residenciado");

        ResTelLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ResTelLabel.setText("Teléfono");

        ResRazonLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ResRazonLabel.setText("Razon de la Carta");

        ResFechaActualLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ResFechaActualLabel.setText("Fecha Actual");

        ResNombreTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ResCedulaFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        ResCedulaFormattedTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ResNacTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ResDirTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ResTelTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ResRazonTextArea.setColumns(20);
        ResRazonTextArea.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        ResRazonTextArea.setRows(5);
        jScrollPane1.setViewportView(ResRazonTextArea);

        ResAñosSpinner.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
        ResAñosSpinner.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ResLimpiarButton.setText("Limpiar");
        ResLimpiarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResLimpiarButtonMouseClicked(evt);
            }
        });

        GenResCartaButton.setText("Generar Carta de Residencia");
        GenResCartaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GenResCartaButtonMouseClicked(evt);
            }
        });

        ResCedulaComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ResCedulaComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "V", "E" }));

        javax.swing.GroupLayout ResidenciaPanelLayout = new javax.swing.GroupLayout(ResidenciaPanel);
        ResidenciaPanel.setLayout(ResidenciaPanelLayout);
        ResidenciaPanelLayout.setHorizontalGroup(
            ResidenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ResidenciaPanelLayout.createSequentialGroup()
                .addGroup(ResidenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ResidenciaPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(ResidenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ResidenciaPanelLayout.createSequentialGroup()
                                .addComponent(ResDirLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ResDirTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ResidenciaPanelLayout.createSequentialGroup()
                                .addComponent(ResCedulaLabel)
                                .addGap(30, 30, 30)
                                .addComponent(ResCedulaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ResCedulaFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ResNacLabel)
                                .addGap(18, 18, 18)
                                .addComponent(ResNacTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ResidenciaPanelLayout.createSequentialGroup()
                                .addComponent(ResNombreLabel)
                                .addGap(18, 18, 18)
                                .addComponent(ResNombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ResidenciaPanelLayout.createSequentialGroup()
                                .addGroup(ResidenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(ResidenciaPanelLayout.createSequentialGroup()
                                        .addComponent(ResAñosLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(ResAñosSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ResidenciaPanelLayout.createSequentialGroup()
                                        .addComponent(ResFechaActualLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ResFechaActualDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(65, 65, 65)
                                .addComponent(ResTelLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ResTelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ResidenciaPanelLayout.createSequentialGroup()
                                .addComponent(ResRazonLabel)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ResidenciaPanelLayout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(ResLimpiarButton)
                        .addGap(50, 50, 50)
                        .addComponent(GenResCartaButton)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        ResidenciaPanelLayout.setVerticalGroup(
            ResidenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ResidenciaPanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(ResidenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ResNombreLabel)
                    .addComponent(ResNombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ResidenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ResCedulaLabel)
                    .addComponent(ResCedulaFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResCedulaComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(ResNacLabel)
                    .addComponent(ResNacTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ResidenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ResDirLabel)
                    .addComponent(ResDirTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(ResidenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ResAñosLabel)
                    .addComponent(ResAñosSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResTelLabel)
                    .addComponent(ResTelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(ResidenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ResFechaActualLabel)
                    .addComponent(ResFechaActualDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ResidenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ResRazonLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ResidenciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ResLimpiarButton)
                    .addComponent(GenResCartaButton))
                .addContainerGap())
        );

        ResidenciaScrollPane.setViewportView(ResidenciaPanel);

        TabPane.addTab("Carta de Residencia", ResidenciaScrollPane);

        ANNombreLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ANNombreLabel.setText("Nombre");

        ANNombreTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ANCedulaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ANCedulaLabel.setText("Cédula");

        ANCedulaComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ANCedulaComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "V", "E" }));

        ANCedulaFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        ANCedulaFormattedTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ANSexoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ANSexoLabel.setText("Sexo");

        SexoButtonGroup2.add(ANHombreRadioButton);
        ANHombreRadioButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ANHombreRadioButton.setText("Hombre");

        SexoButtonGroup2.add(ANMujerRadioButton);
        ANMujerRadioButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ANMujerRadioButton.setText("Mujer");

        ANLimpiarButton.setText("Limpiar");
        ANLimpiarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ANLimpiarButtonMouseClicked(evt);
            }
        });

        ANGenAutorizacionNairubyButton.setText("Generar Autorización");
        ANGenAutorizacionNairubyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ANGenAutorizacionNairubyButtonMouseClicked(evt);
            }
        });

        ANFechaActualLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        ANFechaActualLabel.setText("Fecha Actual");

        ANRazonLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ANRazonLabel.setText("Razon de la Carta");

        ANRazonTextArea.setColumns(20);
        ANRazonTextArea.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        ANRazonTextArea.setRows(5);
        jScrollPane2.setViewportView(ANRazonTextArea);

        javax.swing.GroupLayout AutorizacionNairubyPanelLayout = new javax.swing.GroupLayout(AutorizacionNairubyPanel);
        AutorizacionNairubyPanel.setLayout(AutorizacionNairubyPanelLayout);
        AutorizacionNairubyPanelLayout.setHorizontalGroup(
            AutorizacionNairubyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AutorizacionNairubyPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ANLimpiarButton)
                .addGap(58, 58, 58)
                .addComponent(ANGenAutorizacionNairubyButton)
                .addGap(256, 256, 256))
            .addGroup(AutorizacionNairubyPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(AutorizacionNairubyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AutorizacionNairubyPanelLayout.createSequentialGroup()
                        .addComponent(ANRazonLabel)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(AutorizacionNairubyPanelLayout.createSequentialGroup()
                        .addComponent(ANFechaActualLabel)
                        .addGap(18, 18, 18)
                        .addComponent(ANFechaActualDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(AutorizacionNairubyPanelLayout.createSequentialGroup()
                        .addGroup(AutorizacionNairubyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ANNombreLabel)
                            .addComponent(ANCedulaLabel))
                        .addGroup(AutorizacionNairubyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AutorizacionNairubyPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(ANCedulaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ANCedulaFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ANSexoLabel)
                                .addGap(46, 46, 46)
                                .addComponent(ANHombreRadioButton)
                                .addGap(35, 35, 35)
                                .addComponent(ANMujerRadioButton))
                            .addGroup(AutorizacionNairubyPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(ANNombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(82, 82, 82))))
        );
        AutorizacionNairubyPanelLayout.setVerticalGroup(
            AutorizacionNairubyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AutorizacionNairubyPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(AutorizacionNairubyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ANNombreLabel)
                    .addComponent(ANNombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AutorizacionNairubyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ANCedulaLabel)
                    .addComponent(ANCedulaFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ANCedulaComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(ANSexoLabel)
                    .addComponent(ANHombreRadioButton)
                    .addComponent(ANMujerRadioButton))
                .addGap(18, 18, 18)
                .addGroup(AutorizacionNairubyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ANFechaActualLabel)
                    .addComponent(ANFechaActualDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AutorizacionNairubyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ANRazonLabel)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(AutorizacionNairubyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ANLimpiarButton)
                    .addComponent(ANGenAutorizacionNairubyButton))
                .addGap(113, 113, 113))
        );

        AutorizacionNairubyScrollPane.setViewportView(AutorizacionNairubyPanel);

        TabPane.addTab("Autorización Nairuby", AutorizacionNairubyScrollPane);

        BCNombreLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BCNombreLabel.setText("Nombre");

        BCNombreTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        BCCedulaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BCCedulaLabel.setText("Cédula");

        BCCedulaComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BCCedulaComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "V", "E" }));

        BCCedulaFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        BCCedulaFormattedTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        BCNacLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BCNacLabel.setText("Nacionalidad");

        BCNacTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        BCDirLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BCDirLabel.setText("Dirección");

        BCDirTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        BCAñosLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BCAñosLabel.setText("Años Residenciado");

        ResAñosSpinner.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
        BCAñosSpinner.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        BCTelLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BCTelLabel.setText("Teléfono");

        BCTelTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        BCFechaActualLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BCFechaActualLabel.setText("Fecha Actual");

        BCProfesionLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BCProfesionLabel.setText("Profesión");

        BCProfesionTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        BCRazonLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BCRazonLabel.setText("Razon de la Carta");

        BCRazonTextArea.setColumns(20);
        BCRazonTextArea.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        BCRazonTextArea.setRows(5);
        jScrollPane3.setViewportView(BCRazonTextArea);

        BCLimpiarButton.setText("Limpiar");
        BCLimpiarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BCLimpiarButtonMouseClicked(evt);
            }
        });

        GenBCCartaButton.setText("Generar Carta Buena Conducta");
        GenBCCartaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GenBCCartaButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BuenaConductaPanelLayout = new javax.swing.GroupLayout(BuenaConductaPanel);
        BuenaConductaPanel.setLayout(BuenaConductaPanelLayout);
        BuenaConductaPanelLayout.setHorizontalGroup(
            BuenaConductaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BuenaConductaPanelLayout.createSequentialGroup()
                .addGroup(BuenaConductaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BuenaConductaPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(BuenaConductaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(BuenaConductaPanelLayout.createSequentialGroup()
                                .addComponent(BCDirLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BCDirTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BuenaConductaPanelLayout.createSequentialGroup()
                                .addComponent(BCCedulaLabel)
                                .addGap(30, 30, 30)
                                .addComponent(BCCedulaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BCCedulaFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BCNacLabel)
                                .addGap(18, 18, 18)
                                .addComponent(BCNacTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BuenaConductaPanelLayout.createSequentialGroup()
                                .addComponent(BCNombreLabel)
                                .addGap(18, 18, 18)
                                .addComponent(BCNombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BuenaConductaPanelLayout.createSequentialGroup()
                                .addGroup(BuenaConductaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(BuenaConductaPanelLayout.createSequentialGroup()
                                        .addComponent(BCAñosLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(BCAñosSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(BuenaConductaPanelLayout.createSequentialGroup()
                                        .addComponent(BCFechaActualLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BCFechaActualDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(65, 65, 65)
                                .addGroup(BuenaConductaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(BuenaConductaPanelLayout.createSequentialGroup()
                                        .addComponent(BCTelLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BCTelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(BuenaConductaPanelLayout.createSequentialGroup()
                                        .addComponent(BCProfesionLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BCProfesionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(BuenaConductaPanelLayout.createSequentialGroup()
                                .addComponent(BCRazonLabel)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(BuenaConductaPanelLayout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(BCLimpiarButton)
                        .addGap(50, 50, 50)
                        .addComponent(GenBCCartaButton)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        BuenaConductaPanelLayout.setVerticalGroup(
            BuenaConductaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BuenaConductaPanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(BuenaConductaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BCNombreLabel)
                    .addComponent(BCNombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BuenaConductaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BCCedulaLabel)
                    .addComponent(BCCedulaFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BCCedulaComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(BCNacLabel)
                    .addComponent(BCNacTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BuenaConductaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BCDirLabel)
                    .addComponent(BCDirTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(BuenaConductaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BCAñosLabel)
                    .addComponent(BCAñosSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BCTelLabel)
                    .addComponent(BCTelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(BuenaConductaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BCFechaActualLabel)
                    .addComponent(BCFechaActualDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BuenaConductaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BCProfesionLabel)
                        .addComponent(BCProfesionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(BuenaConductaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BCRazonLabel)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BuenaConductaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BCLimpiarButton)
                    .addComponent(GenBCCartaButton))
                .addContainerGap())
        );

        BuenaConductaScrollPane.setViewportView(BuenaConductaPanel);

        TabPane.addTab("Carta Buena Conducta", BuenaConductaScrollPane);

        FDVNombresTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        FDVNombresLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FDVNombresLabel.setText("Nombres");

        FDVApellidosLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FDVApellidosLabel.setText("Apellidos");

        FDVApellidosTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        FDCCedulaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FDCCedulaLabel.setText("Cédula");

        FDVCedulaComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FDVCedulaComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "V", "E" }));

        FDVCedulaFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        FDVCedulaFormattedTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        BCNacLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BCNacLabel1.setText("Edo. Civil");

        FDVEdoCivilTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jSeparator6.setBackground(new java.awt.Color(51, 153, 255));
        jSeparator6.setForeground(new java.awt.Color(51, 153, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Dirección");

        FDVEFLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FDVEFLabel.setText("Entidad Federal");

        FDVEFTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        FDVMunicipioTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        FDVMunicipioLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FDVMunicipioLabel.setText("Municipio");

        FDVParroquiaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FDVParroquiaLabel.setText("Parroquia");

        FDVParroquiaTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        FDVCiudadTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        FDVCiudadLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FDVCiudadLabel.setText("Ciudad");

        FDVNumCasaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FDVNumCasaLabel.setText("Nº Casa");

        FDVCalleTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        FDVCalleLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FDVCalleLabel6.setText("Calle");

        FDVAñosLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FDVAñosLabel.setText("Años Residenciado");

        ResAñosSpinner.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
        FDVAñosSpinner.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jSeparator7.setBackground(new java.awt.Color(0, 204, 51));
        jSeparator7.setForeground(new java.awt.Color(51, 153, 255));
        jSeparator7.setPreferredSize(new java.awt.Dimension(50, 10));

        ResAñosSpinner.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
        FDVNumCasaSpinner.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        BCFechaActualLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BCFechaActualLabel1.setText("Fecha Actual");

        FDVLimpiarButton.setText("Limpiar");
        FDVLimpiarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FDVLimpiarButtonMouseClicked(evt);
            }
        });

        GenFDVCartaButton.setText("Generar Fe De Vida");
        GenFDVCartaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GenFDVCartaButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout FeDeVidaPanelLayout = new javax.swing.GroupLayout(FeDeVidaPanel);
        FeDeVidaPanel.setLayout(FeDeVidaPanelLayout);
        FeDeVidaPanelLayout.setHorizontalGroup(
            FeDeVidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FeDeVidaPanelLayout.createSequentialGroup()
                .addGroup(FeDeVidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FeDeVidaPanelLayout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(jLabel7))
                    .addGroup(FeDeVidaPanelLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(FeDeVidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(FeDeVidaPanelLayout.createSequentialGroup()
                                .addComponent(FDVCalleLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(FDVCalleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FeDeVidaPanelLayout.createSequentialGroup()
                                .addComponent(FDVCiudadLabel)
                                .addGap(18, 18, 18)
                                .addComponent(FDVCiudadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FeDeVidaPanelLayout.createSequentialGroup()
                                .addComponent(FDVEFLabel)
                                .addGap(18, 18, 18)
                                .addComponent(FDVEFTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)
                        .addGroup(FeDeVidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(FeDeVidaPanelLayout.createSequentialGroup()
                                .addComponent(FDVMunicipioLabel)
                                .addGap(18, 18, 18)
                                .addComponent(FDVMunicipioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FeDeVidaPanelLayout.createSequentialGroup()
                                .addGroup(FeDeVidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(FDVNumCasaLabel)
                                    .addComponent(FDVParroquiaLabel))
                                .addGap(18, 18, 18)
                                .addGroup(FeDeVidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(FDVParroquiaTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addComponent(FDVNumCasaSpinner)))))
                    .addGroup(FeDeVidaPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(FeDeVidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(FeDeVidaPanelLayout.createSequentialGroup()
                                .addComponent(FDVAñosLabel)
                                .addGap(18, 18, 18)
                                .addComponent(FDVAñosSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(BCFechaActualLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(FDVFechaActualDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(FeDeVidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(FeDeVidaPanelLayout.createSequentialGroup()
                                    .addGroup(FeDeVidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(FeDeVidaPanelLayout.createSequentialGroup()
                                            .addComponent(FDVNombresLabel)
                                            .addGap(18, 18, 18)
                                            .addComponent(FDVNombresTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(FeDeVidaPanelLayout.createSequentialGroup()
                                            .addComponent(FDCCedulaLabel)
                                            .addGap(30, 30, 30)
                                            .addComponent(FDVCedulaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(FDVCedulaFormattedTextField)))
                                    .addGap(18, 18, 18)
                                    .addGroup(FeDeVidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(FeDeVidaPanelLayout.createSequentialGroup()
                                            .addComponent(BCNacLabel1)
                                            .addGap(18, 18, 18)
                                            .addComponent(FDVEdoCivilTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(FeDeVidaPanelLayout.createSequentialGroup()
                                            .addComponent(FDVApellidosLabel)
                                            .addGap(18, 18, 18)
                                            .addComponent(FDVApellidosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FeDeVidaPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(FDVLimpiarButton)
                .addGap(50, 50, 50)
                .addComponent(GenFDVCartaButton)
                .addGap(233, 233, 233))
        );
        FeDeVidaPanelLayout.setVerticalGroup(
            FeDeVidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FeDeVidaPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(FeDeVidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FDVNombresLabel)
                    .addComponent(FDVNombresTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FDVApellidosLabel)
                    .addComponent(FDVApellidosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FeDeVidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FDCCedulaLabel)
                    .addComponent(FDVCedulaFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FDVCedulaComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(BCNacLabel1)
                    .addComponent(FDVEdoCivilTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FeDeVidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(FeDeVidaPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(FeDeVidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FDVEFLabel)
                            .addComponent(FDVEFTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FDVMunicipioLabel)
                            .addComponent(FDVMunicipioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FeDeVidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FDVCiudadLabel)
                            .addComponent(FDVCiudadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FDVParroquiaLabel)
                            .addComponent(FDVParroquiaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FeDeVidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FDVCalleLabel6)
                            .addComponent(FDVCalleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FDVNumCasaLabel)
                            .addComponent(FDVNumCasaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FeDeVidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FDVAñosLabel)
                            .addComponent(FDVAñosSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BCFechaActualLabel1)))
                    .addComponent(FDVFechaActualDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(FeDeVidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FDVLimpiarButton)
                    .addComponent(GenFDVCartaButton))
                .addGap(43, 43, 43))
        );

        FeDeVidaScrollPane.setViewportView(FeDeVidaPanel);

        TabPane.addTab("Fe De Vida", FeDeVidaScrollPane);

        ReNombreLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ReNombreLabel.setText("Nombre");

        ReNombreTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ReCedulaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ReCedulaLabel.setText("Cédula");

        ReCedulaComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ReCedulaComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "V", "E" }));

        ReCedulaFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        ReCedulaFormattedTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Empleado");

        jSeparator10.setBackground(new java.awt.Color(51, 153, 255));
        jSeparator10.setForeground(new java.awt.Color(51, 153, 255));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Empresa");

        ReNombreEmpresaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ReNombreEmpresaLabel.setText("Nombre Empresa");

        ReNombreEmpresaTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ReRazonLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ReRazonLabel.setText("Razon de la Carta");

        ReRazonTextArea.setColumns(20);
        ReRazonTextArea.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        ReRazonTextArea.setRows(5);
        jScrollPane4.setViewportView(ReRazonTextArea);

        ReCargoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ReCargoLabel.setText("Cargo");

        ReCargoTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ReFechaActualLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ReFechaActualLabel.setText("Fecha Actual");

        ReLimpiarButton.setText("Limpiar");
        ReLimpiarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReLimpiarButtonMouseClicked(evt);
            }
        });

        GenReCartaButton.setText("Generar Renuncia");
        GenReCartaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GenReCartaButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout RenunciaPanelLayout = new javax.swing.GroupLayout(RenunciaPanel);
        RenunciaPanel.setLayout(RenunciaPanelLayout);
        RenunciaPanelLayout.setHorizontalGroup(
            RenunciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RenunciaPanelLayout.createSequentialGroup()
                .addGap(0, 51, Short.MAX_VALUE)
                .addGroup(RenunciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RenunciaPanelLayout.createSequentialGroup()
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RenunciaPanelLayout.createSequentialGroup()
                        .addComponent(ReLimpiarButton)
                        .addGap(50, 50, 50)
                        .addComponent(GenReCartaButton)
                        .addGap(260, 260, 260))))
            .addGroup(RenunciaPanelLayout.createSequentialGroup()
                .addGroup(RenunciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RenunciaPanelLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(RenunciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ReNombreLabel)
                            .addComponent(ReCedulaLabel))
                        .addGap(18, 18, 18)
                        .addGroup(RenunciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ReNombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(RenunciaPanelLayout.createSequentialGroup()
                                .addComponent(ReCedulaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ReCedulaFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(RenunciaPanelLayout.createSequentialGroup()
                        .addGap(353, 353, 353)
                        .addComponent(jLabel13))
                    .addGroup(RenunciaPanelLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(RenunciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RenunciaPanelLayout.createSequentialGroup()
                                .addGroup(RenunciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ReNombreEmpresaLabel)
                                    .addComponent(ReCargoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(RenunciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ReCargoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ReNombreEmpresaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(RenunciaPanelLayout.createSequentialGroup()
                                .addGroup(RenunciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ReFechaActualLabel)
                                    .addComponent(ReRazonLabel))
                                .addGap(18, 18, 18)
                                .addGroup(RenunciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4)
                                    .addGroup(RenunciaPanelLayout.createSequentialGroup()
                                        .addComponent(ReFechaActualDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(RenunciaPanelLayout.createSequentialGroup()
                        .addGap(354, 354, 354)
                        .addComponent(jLabel15)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RenunciaPanelLayout.setVerticalGroup(
            RenunciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RenunciaPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(RenunciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReNombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReNombreLabel))
                .addGroup(RenunciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RenunciaPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(ReCedulaLabel))
                    .addGroup(RenunciaPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(RenunciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ReCedulaComboBox)
                            .addComponent(ReCedulaFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RenunciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReNombreEmpresaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReNombreEmpresaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RenunciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReCargoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReCargoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RenunciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ReRazonLabel)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(RenunciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ReFechaActualDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReFechaActualLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RenunciaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ReLimpiarButton)
                    .addComponent(GenReCartaButton))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        RenunciaScrollPane.setViewportView(RenunciaPanel);

        TabPane.addTab("Renuncia", RenunciaScrollPane);

        CambiarUbicacionButton.setText("Cambiar");
        CambiarUbicacionButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CambiarUbicacionButtonMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Ubicación: ");

        UbicacionLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        UbicacionLabel.setText("...");

        LogoDarkestt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/LogoDarkestt.png"))); // NOI18N

        VersionLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        VersionLabel.setText("Ver. 3.0.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CambiarUbicacionButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UbicacionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(VersionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GenCartasLabel)
                        .addGap(162, 162, 162)
                        .addComponent(LogoDarkestt)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GenCartasLabel)
                    .addComponent(VersionLabel)
                    .addComponent(LogoDarkestt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CambiarUbicacionButton)
                    .addComponent(jLabel4)
                    .addComponent(UbicacionLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LimpiarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LimpiarButtonMouseClicked
        // TODO add your handling code here:       
        Limpiar();
    }//GEN-LAST:event_LimpiarButtonMouseClicked

    private void GenReferenciaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenReferenciaButtonMouseClicked
        // TODO add your handling code here:                                  
           
        if(Nombre1TextField.getText().equals("") || Cedula1FormattedTextField.getText().equals("") || AñosConocidosSpinner.getValue().toString().equals("0") 
                || Nombre2TextField.getText().equals("") || Cedula2FormattedTextField.getText().equals("") || CiudadTextField.getText().equals("")
                || FechaDateChooser.getDate() == null || Dir1TextField.getText().equals("") || Tel1TextField.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Todos los campos del formulario deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        }else{                                 
            /*
            try {
                String name = "FORMATOS/Referencia.docx";
                //abrir formato
                WordprocessingMLPackage template;
                template = WordprocessingMLPackage.load(new File(name));

                MainDocumentPart documentPart = template.getMainDocumentPart();

                HashMap<String, String> mappings = new HashMap<>();
                mappings.put("Nombre1", Nombre1TextField.getText());
                mappings.put("Cedula1", Cedula1FormattedTextField.getText());
                mappings.put("años", AñosConocidosSpinner.getValue().toString());
                if(HombreRadioButton.isSelected()){
                    mappings.put("Sexo", "Ciudadano");
                }else{
                    mappings.put("Sexo", "Ciudadana");
                }                
                mappings.put("Nombre2", Nombre2TextField.getText());
                mappings.put("Cedula2", Cedula2FormattedTextField.getText());
                mappings.put("Ciudad", CiudadTextField.getText());
                mappings.put("dias", String.valueOf(FechaDateChooser.getDate().getDate()));
                mappings.put("mes", Meses[FechaDateChooser.getDate().getMonth()]);
                mappings.put("año", String.valueOf(FechaDateChooser.getDate().getYear() + 1900));
                mappings.put("Dir1", Dir1TextField.getText());
                mappings.put("Tel1", Tel1TextField.getText());

                documentPart.variableReplace(mappings);

                // Save it
                int i = 1;
                boolean Guardar = true;
                File Referencia;
                while(Guardar){
                    Referencia = new File( UbicacionLabel.getText()+"\\Referencia_"+i+".docx" );
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
            */
            
            HashMap<String, String> mappings = new HashMap<>();
            mappings.put("Nombre1", Nombre1TextField.getText());
            mappings.put("Cedula1", Cedula1ComboBox.getSelectedItem()+"-"+Cedula1FormattedTextField.getText());
            mappings.put("años", AñosConocidosSpinner.getValue().toString());
            if(HombreRadioButton.isSelected()){
                mappings.put("Sexo", "al ciudadano");
            }else{
                mappings.put("Sexo", "a la ciudadana");
            }                
            mappings.put("Nombre2", Nombre2TextField.getText());
            mappings.put("Cedula2", Cedula2ComboBox.getSelectedItem()+"-"+Cedula2FormattedTextField.getText());
            mappings.put("Ciudad", CiudadTextField.getText());
            mappings.put("dias", String.valueOf(FechaDateChooser.getDate().getDate()));
            mappings.put("mes", Meses[FechaDateChooser.getDate().getMonth()]);
            mappings.put("año", String.valueOf(FechaDateChooser.getDate().getYear() + 1900));
            mappings.put("Dir1", Dir1TextField.getText());
            mappings.put("Tel1", Tel1TextField.getText());
            
            H = new Hilo (mappings, UbicacionLabel.getText(), 0);
            H.start();
        }
    }//GEN-LAST:event_GenReferenciaButtonMouseClicked

    @SuppressWarnings("empty-statement")
    private void CambiarUbicacionButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CambiarUbicacionButtonMouseClicked
        // TODO add your handling code here:
        JFileChooser Chooser = new JFileChooser();
        Chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(Chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            UbicacionLabel.setText(Chooser.getSelectedFile().toString());
        }
        
        File f;
        f = new File("FORMATOS/Ubicacion.txt");
        //Escritura
        try{
            FileWriter w = new FileWriter(f);
            try (BufferedWriter bw = new BufferedWriter(w); PrintWriter wr = new PrintWriter(bw)) {
                wr.write(UbicacionLabel.getText());//escribimos en el archivo
            }
        }catch(IOException e){};
       
    }//GEN-LAST:event_CambiarUbicacionButtonMouseClicked

    private void TraLimpiarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TraLimpiarButtonMouseClicked
        // TODO add your handling code here:
        Limpiar();
    }//GEN-LAST:event_TraLimpiarButtonMouseClicked

    private void TraGenConstanciaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TraGenConstanciaButtonMouseClicked
        // TODO add your handling code here:
        
        
        if(TraNombreEmpTextField.getText().equals("") || TraRifTextField.getText().equals("") || TraTelefonoTextField.getText().equals("")
                || TraNombreEmpTextField.getText().equals("") || TraCedulaEmpFormattedTextField.getText().equals("") || TraFechaEmpDateChooser.getDate() == null
                || TraCargoEmpTextField.getText().equals("") || TraSueldoEmpTextField.getText().equals("") || TraCiudadTextField.getText().equals("")
                || TraFechaActualDateChooser.getDate() == null || TraNombreResTextField.getText().equals("") || TraCargoResTextField.getText().equals("") 
                || TraDireccionTextField.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Todos los campos del formulario deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            /*
            try {
                String name = "FORMATOS/ConstanciaTrabajo.docx";
                //abrir formato
                WordprocessingMLPackage template;
                template = WordprocessingMLPackage.load(new File(name));

                MainDocumentPart documentPart = template.getMainDocumentPart();
                
                HashMap<String, String> mappings = new HashMap<>();
                mappings.put("NombreEmpresa", TraNombreTextField.getText());
                mappings.put("RifEmpresa", TraRifTextField.getText());
                mappings.put("TelEmpresa", TraTelefonoTextField.getText());
                mappings.put("Nombre", TraNombreEmpTextField.getText());
                mappings.put("Cedula", TraCedulaEmpFormattedTextField.getText());
                mappings.put("diaDesde", String.valueOf(TraFechaEmpDateChooser.getDate().getDate()));
                mappings.put("mesDesde", Meses[TraFechaEmpDateChooser.getDate().getMonth()]);
                mappings.put("añoDesde", String.valueOf(TraFechaEmpDateChooser.getDate().getYear() + 1900));
                mappings.put("cargo", TraCargoEmpTextField.getText());
                mappings.put("SueldoLetras",  TraSueldoEmpTextField.getText());
                mappings.put("SueldoNro", (TraSueldoEmpSpinner.getValue().toString()+",00"));
                mappings.put("Ciudad", TraCiudadTextField.getText());
                mappings.put("diaFecha", String.valueOf(TraFechaActualDateChooser.getDate().getDate()));
                mappings.put("mesFecha", Meses[TraFechaActualDateChooser.getDate().getMonth()]);
                mappings.put("añoFecha", String.valueOf(TraFechaActualDateChooser.getDate().getYear() + 1900));
                mappings.put("NombreResponsable", TraNombreResTextField.getText());
                mappings.put("CargoResponsable", TraCargoResTextField.getText());
                mappings.put("DirEmpresa", TraDireccionTextField.getText());

                documentPart.variableReplace(mappings);

                // Save it
                int i = 1;
                boolean Guardar = true;
                File Referencia;
                while(Guardar){
                    Referencia = new File( UbicacionLabel.getText()+"\\ConstanciaTrabajo_"+i+".docx" );
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
            */
            
            HashMap<String, String> mappings = new HashMap<>();
            mappings.put("NombreEmpresa", TraNombreTextField.getText());
            mappings.put("RifEmpresa", TraRifTextField.getText());
            mappings.put("TelEmpresa", TraTelefonoTextField.getText());
           if(TraHombreRadioButton.isSelected()){
                mappings.put("Sexo", "el ciudadano");
            }else{
                mappings.put("Sexo", "la ciudadana");
            }
            mappings.put("Nombre", TraNombreEmpTextField.getText());
            mappings.put("Cedula", TraCedulaComboBox1.getSelectedItem()+"-"+TraCedulaEmpFormattedTextField.getText());
            mappings.put("diaDesde", String.valueOf(TraFechaEmpDateChooser.getDate().getDate()));
            mappings.put("mesDesde", Meses[TraFechaEmpDateChooser.getDate().getMonth()]);
            mappings.put("añoDesde", String.valueOf(TraFechaEmpDateChooser.getDate().getYear() + 1900));
            mappings.put("cargo", TraCargoEmpTextField.getText());
            mappings.put("SueldoLetras",  TraSueldoEmpTextField.getText());
            mappings.put("SueldoNro", (TraSueldoEmpSpinner.getValue().toString()+",00"));
            mappings.put("Ciudad", TraCiudadTextField.getText());
            mappings.put("diaFecha", String.valueOf(TraFechaActualDateChooser.getDate().getDate()));
            mappings.put("mesFecha", Meses[TraFechaActualDateChooser.getDate().getMonth()]);
            mappings.put("añoFecha", String.valueOf(TraFechaActualDateChooser.getDate().getYear() + 1900));
            mappings.put("NombreResponsable", TraNombreResTextField.getText());
            mappings.put("CargoResponsable", TraCargoResTextField.getText());
            mappings.put("DirEmpresa", TraDireccionTextField.getText());
            
            H = new Hilo (mappings, UbicacionLabel.getText(), 1);
            H.start();
        }
    }//GEN-LAST:event_TraGenConstanciaButtonMouseClicked

    private void ResLimpiarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResLimpiarButtonMouseClicked
        // TODO add your handling code here:
        Limpiar();
    }//GEN-LAST:event_ResLimpiarButtonMouseClicked

    private void GenResCartaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenResCartaButtonMouseClicked
        // TODO add your handling code here:
        
        
        if(ResNombreTextField.getText().equals("") || ResNacTextField.getText().equals("") || ResCedulaFormattedTextField.getText().equals("")
                || ResDirTextField.getText().equals("") || ResAñosSpinner.getValue().toString().equals("0") || ResTelTextField.getText().equals("")
                || ResRazonTextArea.getText().equals("") || ResFechaActualDateChooser.getDate() == null)
        {
            JOptionPane.showMessageDialog(this, "Todos los campos del formulario deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            /*
            try {
                String name = "FORMATOS/CartaResidencia.docx";
                //abrir formato
                WordprocessingMLPackage template;
                template = WordprocessingMLPackage.load(new File(name));

                MainDocumentPart documentPart = template.getMainDocumentPart();               
                
                HashMap<String, String> mappings = new HashMap<>();
                mappings.put("Nombre", ResNombreTextField.getText());
                mappings.put("Nacionalidad", ResNacTextField.getText());
                mappings.put("Cedula", ResCedulaFormattedTextField.getText());
                mappings.put("Dir", ResDirTextField.getText());
                mappings.put("añoV", ResAñosSpinner.getValue().toString());
                mappings.put("Tel", ResTelTextField.getText());
                mappings.put("Razon", ResRazonTextArea.getText());
                mappings.put("dia", String.valueOf(ResFechaActualDateChooser.getDate().getDate()));
                mappings.put("mes", Meses[ResFechaActualDateChooser.getDate().getMonth()]);
                mappings.put("año", String.valueOf(ResFechaActualDateChooser.getDate().getYear() + 1900));

                documentPart.variableReplace(mappings);

                // Save it
                int i = 1;
                boolean Guardar = true;
                File Referencia;
                while(Guardar){
                    Referencia = new File( UbicacionLabel.getText()+"\\CartaResidencia_"+i+".docx" );
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
            */
            
            HashMap<String, String> mappings = new HashMap<>();
            mappings.put("Nombre", ResNombreTextField.getText());
            mappings.put("Nacionalidad", ResNacTextField.getText());
            mappings.put("Cedula", ResCedulaComboBox.getSelectedItem()+"-"+ResCedulaFormattedTextField.getText());
            mappings.put("Dir", ResDirTextField.getText());
            mappings.put("añoV", ResAñosSpinner.getValue().toString());
            mappings.put("Tel", ResTelTextField.getText());
            mappings.put("Razon", ResRazonTextArea.getText());
            mappings.put("dia", String.valueOf(ResFechaActualDateChooser.getDate().getDate()));
            mappings.put("mes", Meses[ResFechaActualDateChooser.getDate().getMonth()]);
            mappings.put("año", String.valueOf(ResFechaActualDateChooser.getDate().getYear() + 1900));
            
            H = new Hilo (mappings, UbicacionLabel.getText(), 2);
            H.start();
        }
    }//GEN-LAST:event_GenResCartaButtonMouseClicked

    private void ANLimpiarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ANLimpiarButtonMouseClicked
        // TODO add your handling code here:
        Limpiar();
    }//GEN-LAST:event_ANLimpiarButtonMouseClicked

    private void ANGenAutorizacionNairubyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ANGenAutorizacionNairubyButtonMouseClicked
        // TODO add your handling code here:
                
        if(ANNombreTextField.getText().equals("") || ANCedulaFormattedTextField.getText().equals("") || ANFechaActualDateChooser.getDate() == null)
        {
            JOptionPane.showMessageDialog(this, "Todos los campos del formulario deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
                        
            HashMap<String, String> mappings = new HashMap<>();
            mappings.put("Nombre", ANNombreTextField.getText());
            mappings.put("Cedula", ANCedulaComboBox.getSelectedItem()+"-"+ANCedulaFormattedTextField.getText());
            if(ANHombreRadioButton.isSelected()){
                mappings.put("Sexo", "al ciudadano");
            }else{
                mappings.put("Sexo", "a la ciudadana");
            } 
            mappings.put("Razon", ANRazonTextArea.getText());
            mappings.put("dias", String.valueOf(ANFechaActualDateChooser.getDate().getDate()));
            mappings.put("mes", Meses[ANFechaActualDateChooser.getDate().getMonth()]);
            mappings.put("año", String.valueOf(ANFechaActualDateChooser.getDate().getYear() + 1900));
            
            H = new Hilo (mappings, UbicacionLabel.getText(), 5);
            H.start();
        }
    }//GEN-LAST:event_ANGenAutorizacionNairubyButtonMouseClicked

    private void BCLimpiarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BCLimpiarButtonMouseClicked
        // TODO add your handling code here:
        Limpiar();
    }//GEN-LAST:event_BCLimpiarButtonMouseClicked

    private void GenBCCartaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenBCCartaButtonMouseClicked
        // TODO add your handling code here:
        
        if(BCNombreTextField.getText().equals("") || BCNacTextField.getText().equals("") || BCCedulaFormattedTextField.getText().equals("")
                || BCDirTextField.getText().equals("") || BCAñosSpinner.getValue().toString().equals("0") || BCTelTextField.getText().equals("")
                || BCProfesionTextField.getText().equals("") || BCRazonTextArea.getText().equals("") || BCFechaActualDateChooser.getDate() == null)
        {
            JOptionPane.showMessageDialog(this, "Todos los campos del formulario deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            
            
            HashMap<String, String> mappings = new HashMap<>();
            mappings.put("Nombre", BCNombreTextField.getText());
            mappings.put("Nacionalidad", BCNacTextField.getText());
            mappings.put("Cedula", BCCedulaComboBox.getSelectedItem()+"-"+BCCedulaFormattedTextField.getText());
            mappings.put("Direccion", BCDirTextField.getText());
            mappings.put("AñosV", BCAñosSpinner.getValue().toString());
            mappings.put("Telefono", BCTelTextField.getText());
            mappings.put("Profesion", BCProfesionTextField.getText());
            mappings.put("Razon", BCRazonTextArea.getText());
            mappings.put("dias", String.valueOf(BCFechaActualDateChooser.getDate().getDate()));
            mappings.put("mes", Meses[BCFechaActualDateChooser.getDate().getMonth()]);
            mappings.put("año", String.valueOf(BCFechaActualDateChooser.getDate().getYear() + 1900));
            
            H = new Hilo (mappings, UbicacionLabel.getText(), 6);
            H.start();
        }
    }//GEN-LAST:event_GenBCCartaButtonMouseClicked

    private void FDVLimpiarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FDVLimpiarButtonMouseClicked
        // TODO add your handling code here:
        Limpiar();
    }//GEN-LAST:event_FDVLimpiarButtonMouseClicked

    private void GenFDVCartaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenFDVCartaButtonMouseClicked
        // TODO add your handling code here:
                
        if(FDVNombresTextField.getText().equals("") || FDVApellidosTextField.getText().equals("") || FDVCedulaFormattedTextField.getText().equals("")
                || FDVEdoCivilTextField.getText().equals("") || FDVEFTextField.getText().equals("") || FDVMunicipioTextField.getText().equals("") 
                || FDVCiudadTextField.getText().equals("") || FDVParroquiaTextField.getText().equals("") || FDVCalleTextField.getText().equals("")
                || FDVNumCasaSpinner.getValue().toString().equals("0") || FDVAñosSpinner.getValue().toString().equals("0") || FDVFechaActualDateChooser.getDate() == null)
        {
            JOptionPane.showMessageDialog(this, "Todos los campos del formulario deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            
            
            HashMap<String, String> mappings = new HashMap<>();
            mappings.put("Nombres", FDVNombresTextField.getText());
            mappings.put("Apellidos", FDVApellidosTextField.getText());
            mappings.put("Cedula", FDVCedulaComboBox.getSelectedItem()+"-"+FDVCedulaFormattedTextField.getText());
            mappings.put("EdoCivil", FDVEdoCivilTextField.getText());
            mappings.put("EF", FDVEFTextField.getText());
            mappings.put("Mncp", FDVMunicipioTextField.getText());
            mappings.put("Ciudad", FDVCiudadTextField.getText());
            mappings.put("Parr", FDVParroquiaTextField.getText());
            mappings.put("Calle", FDVCalleTextField.getText());
            mappings.put("NumCasa", FDVNumCasaSpinner.getValue().toString());
            mappings.put("AñosV", FDVAñosSpinner.getValue().toString());
            mappings.put("dias", String.valueOf(FDVFechaActualDateChooser.getDate().getDate()));
            mappings.put("mes", Meses[FDVFechaActualDateChooser.getDate().getMonth()]);
            mappings.put("año", String.valueOf(FDVFechaActualDateChooser.getDate().getYear() + 1900));                               
            
            H = new Hilo (mappings, UbicacionLabel.getText(), 7);
            H.start();
        }
    }//GEN-LAST:event_GenFDVCartaButtonMouseClicked

    private void RFLimpiarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RFLimpiarButtonMouseClicked
        // TODO add your handling code here:
        Limpiar();
    }//GEN-LAST:event_RFLimpiarButtonMouseClicked

    private void RFGenReferenciaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RFGenReferenciaButtonMouseClicked
        // TODO add your handling code here:
               
        if(RFNombreTextField.getText().equals("") || RFCedulaFormattedTextField.getText().equals("") || RFTelTextField.getText().equals("") 
                || RFNombre2TextField.getText().equals("") || RFCedula2FormattedTextField.getText().equals("") || RFRelFamiliaTextField.getText().equals("") 
                || RFFechaDateChooser.getDate() == null )
        {
            JOptionPane.showMessageDialog(this, "Todos los campos del formulario deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        }else{                                 
                        
            HashMap<String, String> mappings = new HashMap<>();
            mappings.put("Nombre", RFNombreTextField.getText());
            mappings.put("Cedula", RFCedulaComboBox.getSelectedItem()+"-"+RFCedulaFormattedTextField.getText());
            mappings.put("RelFamiliar", RFRelFamiliaTextField.getText());
            if(RFHombreRadioButton.isSelected()){
                mappings.put("Sexo", "el ciudadano");
            }else{
                mappings.put("Sexo", "la ciudadana");
            }                
            mappings.put("Nombre2", RFNombre2TextField.getText());
            mappings.put("Cedula2", RFCedula2ComboBox.getSelectedItem()+"-"+RFCedula2FormattedTextField.getText());
            mappings.put("dias", String.valueOf(RFFechaDateChooser.getDate().getDate()));
            mappings.put("mes", Meses[RFFechaDateChooser.getDate().getMonth()]);
            mappings.put("año", String.valueOf(RFFechaDateChooser.getDate().getYear() + 1900));
            mappings.put("Telefono", RFTelTextField.getText());
            
            H = new Hilo (mappings, UbicacionLabel.getText(), 8);
            H.start();
        }    
    }//GEN-LAST:event_RFGenReferenciaButtonMouseClicked

    private void ReLimpiarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReLimpiarButtonMouseClicked
        // TODO add your handling code here:
        Limpiar();
    }//GEN-LAST:event_ReLimpiarButtonMouseClicked

    private void GenReCartaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenReCartaButtonMouseClicked
        // TODO add your handling code here:
                
        if(ReNombreTextField.getText().equals("") || ReCedulaFormattedTextField.getText().equals("") || ReNombreEmpresaTextField.getText().equals("") 
                || ReCargoTextField.getText().equals("") || ReRazonTextArea.getText().equals("") || ReFechaActualDateChooser.getDate() == null )
        {
            JOptionPane.showMessageDialog(this, "Todos los campos del formulario deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        }else{                                 
                        
            HashMap<String, String> mappings = new HashMap<>();
            mappings.put("Nombre", ReNombreTextField.getText());
            mappings.put("Cedula", ReCedulaComboBox.getSelectedItem()+"-"+ReCedulaFormattedTextField.getText());
            mappings.put("Empresa", ReNombreEmpresaTextField.getText());                           
            mappings.put("Cargo", ReCargoTextField.getText());
            mappings.put("Razon", ReRazonTextArea.getText());
            mappings.put("dias", String.valueOf(ReFechaActualDateChooser.getDate().getDate()));
            mappings.put("mes", Meses[ReFechaActualDateChooser.getDate().getMonth()]);
            mappings.put("año", String.valueOf(ReFechaActualDateChooser.getDate().getYear() + 1900));            
            
            H = new Hilo (mappings, UbicacionLabel.getText(), 9);
            H.start();
        } 
    }//GEN-LAST:event_GenReCartaButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Planillas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Planillas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ANCedulaComboBox;
    private javax.swing.JFormattedTextField ANCedulaFormattedTextField;
    private javax.swing.JLabel ANCedulaLabel;
    private com.toedter.calendar.JDateChooser ANFechaActualDateChooser;
    private javax.swing.JLabel ANFechaActualLabel;
    private javax.swing.JButton ANGenAutorizacionNairubyButton;
    private javax.swing.JRadioButton ANHombreRadioButton;
    private javax.swing.JButton ANLimpiarButton;
    private javax.swing.JRadioButton ANMujerRadioButton;
    private javax.swing.JLabel ANNombreLabel;
    private javax.swing.JTextField ANNombreTextField;
    private javax.swing.JLabel ANRazonLabel;
    private javax.swing.JTextArea ANRazonTextArea;
    private javax.swing.JLabel ANSexoLabel;
    private javax.swing.JPanel AutorizacionNairubyPanel;
    private javax.swing.JScrollPane AutorizacionNairubyScrollPane;
    private javax.swing.JLabel AñosConocidosLabel;
    private javax.swing.JSpinner AñosConocidosSpinner;
    private javax.swing.JLabel BCAñosLabel;
    private javax.swing.JSpinner BCAñosSpinner;
    private javax.swing.JComboBox BCCedulaComboBox;
    private javax.swing.JFormattedTextField BCCedulaFormattedTextField;
    private javax.swing.JLabel BCCedulaLabel;
    private javax.swing.JLabel BCDirLabel;
    private javax.swing.JTextField BCDirTextField;
    private com.toedter.calendar.JDateChooser BCFechaActualDateChooser;
    private javax.swing.JLabel BCFechaActualLabel;
    private javax.swing.JLabel BCFechaActualLabel1;
    private javax.swing.JButton BCLimpiarButton;
    private javax.swing.JLabel BCNacLabel;
    private javax.swing.JLabel BCNacLabel1;
    private javax.swing.JTextField BCNacTextField;
    private javax.swing.JLabel BCNombreLabel;
    private javax.swing.JTextField BCNombreTextField;
    private javax.swing.JLabel BCProfesionLabel;
    private javax.swing.JTextField BCProfesionTextField;
    private javax.swing.JLabel BCRazonLabel;
    private javax.swing.JTextArea BCRazonTextArea;
    private javax.swing.JLabel BCTelLabel;
    private javax.swing.JTextField BCTelTextField;
    private javax.swing.JPanel BuenaConductaPanel;
    private javax.swing.JScrollPane BuenaConductaScrollPane;
    private javax.swing.JButton CambiarUbicacionButton;
    private javax.swing.JComboBox Cedula1ComboBox;
    private javax.swing.JFormattedTextField Cedula1FormattedTextField;
    private javax.swing.JLabel Cedula1Label;
    private javax.swing.JComboBox Cedula2ComboBox;
    private javax.swing.JFormattedTextField Cedula2FormattedTextField;
    private javax.swing.JLabel Cedula2Label;
    private javax.swing.JLabel CiudadLabel;
    private javax.swing.JTextField CiudadTextField;
    private javax.swing.JPanel ConstTrabajoPanel;
    private javax.swing.JScrollPane ConstTrabajoScrollPane;
    private javax.swing.JLabel Dir1Label;
    private javax.swing.JTextField Dir1TextField;
    private javax.swing.JLabel FDCCedulaLabel;
    private javax.swing.JLabel FDVApellidosLabel;
    private javax.swing.JTextField FDVApellidosTextField;
    private javax.swing.JLabel FDVAñosLabel;
    private javax.swing.JSpinner FDVAñosSpinner;
    private javax.swing.JLabel FDVCalleLabel6;
    private javax.swing.JTextField FDVCalleTextField;
    private javax.swing.JComboBox FDVCedulaComboBox;
    private javax.swing.JFormattedTextField FDVCedulaFormattedTextField;
    private javax.swing.JLabel FDVCiudadLabel;
    private javax.swing.JTextField FDVCiudadTextField;
    private javax.swing.JLabel FDVEFLabel;
    private javax.swing.JTextField FDVEFTextField;
    private javax.swing.JTextField FDVEdoCivilTextField;
    private com.toedter.calendar.JDateChooser FDVFechaActualDateChooser;
    private javax.swing.JButton FDVLimpiarButton;
    private javax.swing.JLabel FDVMunicipioLabel;
    private javax.swing.JTextField FDVMunicipioTextField;
    private javax.swing.JLabel FDVNombresLabel;
    private javax.swing.JTextField FDVNombresTextField;
    private javax.swing.JLabel FDVNumCasaLabel;
    private javax.swing.JSpinner FDVNumCasaSpinner;
    private javax.swing.JLabel FDVParroquiaLabel;
    private javax.swing.JTextField FDVParroquiaTextField;
    private javax.swing.JPanel FeDeVidaPanel;
    private javax.swing.JScrollPane FeDeVidaScrollPane;
    private com.toedter.calendar.JDateChooser FechaDateChooser;
    private javax.swing.JLabel FechaLabel;
    private javax.swing.JButton GenBCCartaButton;
    private javax.swing.JLabel GenCartasLabel;
    private javax.swing.JButton GenFDVCartaButton;
    private javax.swing.JButton GenReCartaButton;
    private javax.swing.JButton GenReferenciaButton;
    private javax.swing.JButton GenResCartaButton;
    private javax.swing.JRadioButton HombreRadioButton;
    private javax.swing.JButton LimpiarButton;
    private javax.swing.JLabel LogoDarkestt;
    private javax.swing.JRadioButton MujerRadioButton;
    private javax.swing.JLabel Nombre1Label;
    private javax.swing.JTextField Nombre1TextField;
    private javax.swing.JLabel Nombre2Label;
    private javax.swing.JTextField Nombre2TextField;
    private javax.swing.JComboBox RFCedula2ComboBox;
    private javax.swing.JFormattedTextField RFCedula2FormattedTextField;
    private javax.swing.JLabel RFCedula2Label;
    private javax.swing.JComboBox RFCedulaComboBox;
    private javax.swing.JFormattedTextField RFCedulaFormattedTextField;
    private javax.swing.JLabel RFCedulaLabel;
    private com.toedter.calendar.JDateChooser RFFechaDateChooser;
    private javax.swing.JLabel RFFechaLabel;
    private javax.swing.JButton RFGenReferenciaButton;
    private javax.swing.JRadioButton RFHombreRadioButton;
    private javax.swing.JButton RFLimpiarButton;
    private javax.swing.JRadioButton RFMujerRadioButton;
    private javax.swing.JLabel RFNombre2Label;
    private javax.swing.JTextField RFNombre2TextField;
    private javax.swing.JLabel RFNombreLabel;
    private javax.swing.JTextField RFNombreTextField;
    private javax.swing.JTextField RFRelFamiliaTextField;
    private javax.swing.JLabel RFRelFamiliarLabel;
    private javax.swing.JLabel RFSexoLabel;
    private javax.swing.JLabel RFTelLabel;
    private javax.swing.JTextField RFTelTextField;
    private javax.swing.JLabel ReCargoLabel;
    private javax.swing.JTextField ReCargoTextField;
    private javax.swing.JComboBox ReCedulaComboBox;
    private javax.swing.JFormattedTextField ReCedulaFormattedTextField;
    private javax.swing.JLabel ReCedulaLabel;
    private com.toedter.calendar.JDateChooser ReFechaActualDateChooser;
    private javax.swing.JLabel ReFechaActualLabel;
    private javax.swing.JButton ReLimpiarButton;
    private javax.swing.JLabel ReNombreEmpresaLabel;
    private javax.swing.JTextField ReNombreEmpresaTextField;
    private javax.swing.JLabel ReNombreLabel;
    private javax.swing.JTextField ReNombreTextField;
    private javax.swing.JLabel ReRazonLabel;
    private javax.swing.JTextArea ReRazonTextArea;
    private javax.swing.JPanel ReferenciaFamiliarPanel;
    private javax.swing.JScrollPane ReferenciaFamiliarScrollPane;
    private javax.swing.JPanel ReferenciaPanel;
    private javax.swing.JScrollPane ReferenciaScrollPane;
    private javax.swing.JPanel RenunciaPanel;
    private javax.swing.JScrollPane RenunciaScrollPane;
    private javax.swing.JLabel ResAñosLabel;
    private javax.swing.JSpinner ResAñosSpinner;
    private javax.swing.JComboBox ResCedulaComboBox;
    private javax.swing.JFormattedTextField ResCedulaFormattedTextField;
    private javax.swing.JLabel ResCedulaLabel;
    private javax.swing.JLabel ResDirLabel;
    private javax.swing.JTextField ResDirTextField;
    private com.toedter.calendar.JDateChooser ResFechaActualDateChooser;
    private javax.swing.JLabel ResFechaActualLabel;
    private javax.swing.JButton ResLimpiarButton;
    private javax.swing.JLabel ResNacLabel;
    private javax.swing.JTextField ResNacTextField;
    private javax.swing.JLabel ResNombreLabel;
    private javax.swing.JTextField ResNombreTextField;
    private javax.swing.JLabel ResRazonLabel;
    private javax.swing.JTextArea ResRazonTextArea;
    private javax.swing.JLabel ResTelLabel;
    private javax.swing.JTextField ResTelTextField;
    private javax.swing.JPanel ResidenciaPanel;
    private javax.swing.JScrollPane ResidenciaScrollPane;
    private javax.swing.ButtonGroup SexoButtonGroup;
    private javax.swing.ButtonGroup SexoButtonGroup1;
    private javax.swing.ButtonGroup SexoButtonGroup2;
    private javax.swing.ButtonGroup SexoButtonGroup3;
    private javax.swing.JLabel SexoLabel;
    private javax.swing.JTabbedPane TabPane;
    private javax.swing.JLabel Tel1Label;
    private javax.swing.JTextField Tel1TextField;
    private javax.swing.JLabel TraCargoEmpLabel;
    private javax.swing.JTextField TraCargoEmpTextField;
    private javax.swing.JLabel TraCargoResLabel;
    private javax.swing.JTextField TraCargoResTextField;
    private javax.swing.JComboBox TraCedulaComboBox1;
    private javax.swing.JFormattedTextField TraCedulaEmpFormattedTextField;
    private javax.swing.JLabel TraCedulaEmpLabel;
    private javax.swing.JLabel TraCiudadLabel;
    private javax.swing.JTextField TraCiudadTextField;
    private javax.swing.JLabel TraDireccionLabel;
    private javax.swing.JTextField TraDireccionTextField;
    private com.toedter.calendar.JDateChooser TraFechaActualDateChooser;
    private javax.swing.JLabel TraFechaActualLabel;
    private com.toedter.calendar.JDateChooser TraFechaEmpDateChooser;
    private javax.swing.JLabel TraFechaEmpLabel;
    private javax.swing.JButton TraGenConstanciaButton;
    private javax.swing.JRadioButton TraHombreRadioButton;
    private javax.swing.JButton TraLimpiarButton;
    private javax.swing.JRadioButton TraMujerRadioButton;
    private javax.swing.JLabel TraNombreEmpLabel;
    private javax.swing.JTextField TraNombreEmpTextField;
    private javax.swing.JLabel TraNombreLabel;
    private javax.swing.JLabel TraNombreResLabel;
    private javax.swing.JTextField TraNombreResTextField;
    private javax.swing.JTextField TraNombreTextField;
    private javax.swing.JLabel TraRifLabel;
    private javax.swing.JTextField TraRifTextField;
    private javax.swing.JLabel TraSexoEmpLabel;
    private javax.swing.JLabel TraSueldoEmpLabel;
    private javax.swing.JSpinner TraSueldoEmpSpinner;
    private javax.swing.JTextField TraSueldoEmpTextField;
    private javax.swing.JLabel TraTelefonoLabel;
    private javax.swing.JTextField TraTelefonoTextField;
    private javax.swing.JLabel UbicacionLabel;
    private javax.swing.JLabel VersionLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables
}
