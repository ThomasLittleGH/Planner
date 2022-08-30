/*
 * Clase Principal
 */
package planernutricional;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 * @author Little
 */
public class Main extends javax.swing.JFrame implements ActionListener {

  // Definición de arreglos
  public List<JButton> botones = new ArrayList<>(),
      bCalorias,
      bProteinas,
      bCarbohidratos,
      bVitA,
      bSugar,
      bVitK,
      bFibra,
      bCalcio; // Con el fin de optimizar el destacamiento de botones los organizo en arreglos una
               // vez inicie la aplicación
  public List<JProgressBar> barras;

  // Creo a conexion con la base de datos
  ConectarBD conBD = new ConectarBD();
  Connection conn = conBD.conexion();
  Querier query = new Querier();
  String selected_food_ids;

  // Definicion de variables
  FraCrearUsuario crearUsuario;
  boolean darkMode = true, barraColoreada = false;
  int periodo, periodoPrevio;

  public Main() {
    // LLamo a metodos que crean los arreglos necesarios basados en los datos de la base de datos
    conBD.crearArrayUsuarios();
    conBD.crearArrayDatosNutricionales();
    // Valido la existencia de un usuario para preguntar por sus datos
    validateUserExistance();
    // Inicializo los componentes
    initComponents();
    // Inicializo el combobox
    initComboboxUsuarios();
    // Establesco el modo claro de la ventana como el predeterminado
    setLightMode();
    // Creo un arreglo con los alimentos del usuario
    conBD.crearArrayAlimentos(getSelectedUserID(0));
    // LLamo a un método que agrupa las barras para una clasificación a futuro mas facil y acotada
    crearArregloBarras();
    // Utilizando los datos del arreglo alimentos creo un boton para cado alimento y lo muestro en
    // pantalla
    crearBoton();
    // Configuro las barras para mostrar los valores indicados
    initBarrasMetasNutricionales();
    // Ordeno los botones en arreglos especificos para optimizar el proceso de destacamiento cuando
    // sea requerido
    ordenarBotonesEnArreglos();
    // Una vez los botones han sido creados reseteo los colores para solucionar problemas
    formatearColorBotones();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jToggleButton1 = new javax.swing.JToggleButton();
    jScrollPane2 = new javax.swing.JScrollPane();
    jEditorPane1 = new javax.swing.JEditorPane();
    lblAviso = new javax.swing.JTabbedPane();
    panMain = new javax.swing.JPanel();
    panBoton = new javax.swing.JPanel();
    btnRun = new javax.swing.JButton();
    btnClear = new javax.swing.JButton();
    btnDescartarCambios = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    panAlimentos = new javax.swing.JPanel();
    panNutrientes = new javax.swing.JPanel();
    barCaloria = new javax.swing.JProgressBar();
    barProteina = new javax.swing.JProgressBar();
    barCarbohidrato = new javax.swing.JProgressBar();
    barSugar = new javax.swing.JProgressBar();
    barCalcio = new javax.swing.JProgressBar();
    barFat = new javax.swing.JProgressBar();
    barFibra = new javax.swing.JProgressBar();
    btnMostrarBotonesCalorias = new javax.swing.JButton();
    btnMostrarBotonesFibra = new javax.swing.JButton();
    btnMostrarBotonesVitK = new javax.swing.JButton();
    btnMostrarBotonesCalcio = new javax.swing.JButton();
    btnMostrarBotonesCarbohidratos = new javax.swing.JButton();
    btnMostrarBotonesProteinas = new javax.swing.JButton();
    btnMostrarBotonesVitA = new javax.swing.JButton();
    btnReestablecerColoresBotones = new javax.swing.JButton();
    panConfig = new javax.swing.JPanel();
    lblUsuario = new javax.swing.JLabel();
    cmbUsuarios = new javax.swing.JComboBox<>();
    cboxLightMode = new javax.swing.JCheckBox();
    btnCrearUsuario = new javax.swing.JButton();
    lblDiasPorPeriodo = new javax.swing.JLabel();
    spnDiasPeriodo = new javax.swing.JSpinner();
    btnConfirmarDuracionPeriodo = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    panModificarAlimentos = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    jScrollPane4 = new javax.swing.JScrollPane();
    tblAlimentos = new javax.swing.JTable();
    txtBuscarAlimento = new javax.swing.JTextField();
    btnBuscar = new javax.swing.JButton();
    btnAgregarAlimento = new javax.swing.JButton();

    jToggleButton1.setText("jToggleButton1");

    jScrollPane2.setViewportView(jEditorPane1);

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    setTitle("Planner Nutricional");
    setName("fraBase"); // NOI18N
    setResizable(false);
    setSize(new java.awt.Dimension(1309, 716));
    addWindowListener(
        new java.awt.event.WindowAdapter() {
          public void windowClosing(java.awt.event.WindowEvent evt) {
            formWindowClosing(evt);
          }
        });

    lblAviso.setToolTipText("");
    lblAviso.setPreferredSize(new java.awt.Dimension(1280, 720));

    panMain.setPreferredSize(new java.awt.Dimension(1280, 720));
    panMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    panBoton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    btnRun.setFont(new java.awt.Font("Krungthep", 1, 24)); // NOI18N
    btnRun.setText("TERMINAR PERIODO");
    btnRun.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRunActionPerformed(evt);
          }
        });
    panBoton.add(btnRun, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 430, 120));

    btnClear.setFont(new java.awt.Font("Krungthep", 1, 24)); // NOI18N
    btnClear.setText("REINICIAR PERIODO");
    btnClear.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnClearActionPerformed(evt);
          }
        });
    panBoton.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 440, 120));

    btnDescartarCambios.setFont(new java.awt.Font("Krungthep", 1, 24)); // NOI18N
    btnDescartarCambios.setText("DESCARTAR CAMBIOS");
    btnDescartarCambios.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnDescartarCambiosActionPerformed(evt);
          }
        });
    panBoton.add(
        btnDescartarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 120));

    panMain.add(panBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 1290, 120));

    jScrollPane1.setBorder(null);

    panAlimentos.setBorder(
        javax.swing.BorderFactory.createTitledBorder(
            null,
            "Alimentos",
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new java.awt.Font("Lucida Grande", 1, 24))); // NOI18N
    panAlimentos.setLayout(new java.awt.GridLayout(0, 5));
    jScrollPane1.setViewportView(panAlimentos);

    panMain.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 530));

    panNutrientes.setBorder(
        javax.swing.BorderFactory.createTitledBorder(
            null,
            "Nutrientes",
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

    barCaloria.setForeground(new java.awt.Color(0, 204, 204));
    barCaloria.setToolTipText("");
    barCaloria.setBorder(javax.swing.BorderFactory.createTitledBorder("Calorias"));

    barProteina.setForeground(new java.awt.Color(0, 204, 204));
    barProteina.setToolTipText("");
    barProteina.setBorder(javax.swing.BorderFactory.createTitledBorder("Proteinas"));

    barCarbohidrato.setForeground(new java.awt.Color(0, 204, 204));
    barCarbohidrato.setToolTipText("");
    barCarbohidrato.setBorder(javax.swing.BorderFactory.createTitledBorder("Carbohidratos"));

    barSugar.setForeground(new java.awt.Color(0, 204, 204));
    barSugar.setToolTipText("");
    barSugar.setBorder(javax.swing.BorderFactory.createTitledBorder("Azucar"));

    barCalcio.setForeground(new java.awt.Color(0, 204, 204));
    barCalcio.setToolTipText("");
    barCalcio.setBorder(javax.swing.BorderFactory.createTitledBorder("Calcio"));

    barFat.setForeground(new java.awt.Color(0, 204, 204));
    barFat.setToolTipText("");
    barFat.setBorder(javax.swing.BorderFactory.createTitledBorder("Grasas saturadas"));

    barFibra.setForeground(new java.awt.Color(0, 204, 204));
    barFibra.setToolTipText("");
    barFibra.setBorder(javax.swing.BorderFactory.createTitledBorder("Fibra"));

    btnMostrarBotonesCalorias.setText("Destacar Alimentos");
    btnMostrarBotonesCalorias.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnMostrarBotonesCaloriasActionPerformed(evt);
          }
        });

    btnMostrarBotonesFibra.setText("Destacar Alimentos");
    btnMostrarBotonesFibra.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnMostrarBotonesFibraActionPerformed(evt);
          }
        });

    btnMostrarBotonesVitK.setText("Destacar Alimentos");
    btnMostrarBotonesVitK.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnMostrarBotonesVitKActionPerformed(evt);
          }
        });

    btnMostrarBotonesCalcio.setText("Destacar Alimentos");
    btnMostrarBotonesCalcio.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnMostrarBotonesCalcioActionPerformed(evt);
          }
        });

    btnMostrarBotonesCarbohidratos.setText("Destacar Alimentos");
    btnMostrarBotonesCarbohidratos.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnMostrarBotonesCarbohidratosActionPerformed(evt);
          }
        });

    btnMostrarBotonesProteinas.setText("Destacar Alimentos");
    btnMostrarBotonesProteinas.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnMostrarBotonesProteinasActionPerformed(evt);
          }
        });

    btnMostrarBotonesVitA.setText("Destacar Alimentos");
    btnMostrarBotonesVitA.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnMostrarBotonesVitAActionPerformed(evt);
          }
        });

    btnReestablecerColoresBotones.setText("Reestablecer colores alimentos");
    btnReestablecerColoresBotones.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnReestablecerColoresBotonesActionPerformed(evt);
          }
        });

    javax.swing.GroupLayout panNutrientesLayout = new javax.swing.GroupLayout(panNutrientes);
    panNutrientes.setLayout(panNutrientesLayout);
    panNutrientesLayout.setHorizontalGroup(
        panNutrientesLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                panNutrientesLayout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        panNutrientesLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(
                                barCalcio,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                291,
                                Short.MAX_VALUE)
                            .addComponent(
                                barFibra,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(
                                barFat,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(
                                barSugar,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(
                                barCarbohidrato,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(
                                barProteina,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(
                                barCaloria,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        panNutrientesLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMostrarBotonesCalcio)
                            .addComponent(btnMostrarBotonesFibra)
                            .addComponent(btnMostrarBotonesVitK)
                            .addComponent(btnMostrarBotonesCarbohidratos)
                            .addComponent(btnMostrarBotonesVitA)
                            .addComponent(btnMostrarBotonesProteinas)
                            .addComponent(btnMostrarBotonesCalorias))
                    .addContainerGap(45, Short.MAX_VALUE))
            .addComponent(
                btnReestablecerColoresBotones,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE));
    panNutrientesLayout.setVerticalGroup(
        panNutrientesLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                panNutrientesLayout
                    .createSequentialGroup()
                    .addGroup(
                        panNutrientesLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(
                                panNutrientesLayout
                                    .createSequentialGroup()
                                    .addGroup(
                                        panNutrientesLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnMostrarBotonesCalorias)
                                            .addComponent(
                                                barCaloria,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                35,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(
                                        panNutrientesLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(
                                                barProteina,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                35,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnMostrarBotonesProteinas))
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(
                                        panNutrientesLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(
                                                barCarbohidrato,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                35,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnMostrarBotonesCarbohidratos))
                                    .addGap(19, 19, 19)
                                    .addComponent(btnMostrarBotonesVitA))
                            .addComponent(
                                barSugar,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                35,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        panNutrientesLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(
                                barFat,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                35,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMostrarBotonesVitK))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        panNutrientesLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(
                                barFibra,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                35,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMostrarBotonesFibra))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        panNutrientesLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(
                                barCalcio,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                36,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMostrarBotonesCalcio))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(
                        btnReestablecerColoresBotones,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        34,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 43, Short.MAX_VALUE)));

    panMain.add(
        panNutrientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 490, 410));

    panConfig.setBorder(
        javax.swing.BorderFactory.createTitledBorder(
            null,
            "Configuracion",
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new java.awt.Font("Lucida Grande", 1, 24))); // NOI18N

    lblUsuario.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
    lblUsuario.setText("Usuario:");

    cmbUsuarios.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            cmbUsuariosActionPerformed(evt);
          }
        });

    cboxLightMode.setText("Light Mode");
    cboxLightMode.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            cboxLightModeActionPerformed(evt);
          }
        });

    btnCrearUsuario.setText("Crear usuario");
    btnCrearUsuario.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCrearUsuarioActionPerformed(evt);
          }
        });

    lblDiasPorPeriodo.setText("Dias por periodo:");

    spnDiasPeriodo.addChangeListener(
        new javax.swing.event.ChangeListener() {
          public void stateChanged(javax.swing.event.ChangeEvent evt) {
            spnDiasPeriodoStateChanged(evt);
          }
        });

    btnConfirmarDuracionPeriodo.setText("Confirmar");
    btnConfirmarDuracionPeriodo.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnConfirmarDuracionPeriodoActionPerformed(evt);
          }
        });

    javax.swing.GroupLayout panConfigLayout = new javax.swing.GroupLayout(panConfig);
    panConfig.setLayout(panConfigLayout);
    panConfigLayout.setHorizontalGroup(
        panConfigLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                panConfigLayout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        panConfigLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(
                                panConfigLayout
                                    .createSequentialGroup()
                                    .addComponent(lblDiasPorPeriodo)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addComponent(
                                        spnDiasPeriodo,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnConfirmarDuracionPeriodo))
                            .addGroup(
                                panConfigLayout
                                    .createSequentialGroup()
                                    .addComponent(lblUsuario)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(
                                        cmbUsuarios,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        187,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(
                        panConfigLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                panConfigLayout
                                    .createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(
                                        btnCrearUsuario,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        190,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(
                                panConfigLayout
                                    .createSequentialGroup()
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addComponent(
                                        cboxLightMode,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        110,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap()))));
    panConfigLayout.setVerticalGroup(
        panConfigLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                panConfigLayout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        panConfigLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsuario)
                            .addComponent(cmbUsuarios)
                            .addComponent(btnCrearUsuario))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(
                        panConfigLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                cboxLightMode,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                20,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                btnConfirmarDuracionPeriodo,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                26,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDiasPorPeriodo)
                            .addComponent(
                                spnDiasPeriodo,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(63, 63, 63)));

    panMain.add(panConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 490, 120));

    jLabel1.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
    jLabel1.setText(
        "AVISO: El guardado es automatico y ocurre SOLO cuando se cierra la aplicación");
    panMain.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 650, 750, 20));

    lblAviso.addTab("MAIN", panMain);

    jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    jLabel2.setText("Barra de busqueda de alimentos:");

    tblAlimentos.setModel(
        new javax.swing.table.DefaultTableModel(
            new Object[][] {{null, null, null, null, null, null, null, null, null}},
            new String[] {
              "ID",
              "Nombre",
              "Calorias",
              "Proteinas",
              "Carbohidratos",
              "Grasas saturadas",
              "Azucar",
              "Fibra",
              "Calcio"
            }) {
          Class[] types =
              new Class[] {
                java.lang.Integer.class,
                java.lang.String.class,
                java.lang.Float.class,
                java.lang.Float.class,
                java.lang.Float.class,
                java.lang.Float.class,
                java.lang.Float.class,
                java.lang.Float.class,
                java.lang.Float.class
              };
          boolean[] canEdit =
              new boolean[] {true, false, false, false, false, false, false, false, false};

          public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
          }

          public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
          }
        });
    tblAlimentos.setEnabled(false);
    jScrollPane4.setViewportView(tblAlimentos);
    if (tblAlimentos.getColumnModel().getColumnCount() > 0) {
      tblAlimentos.getColumnModel().getColumn(0).setResizable(false);
      tblAlimentos.getColumnModel().getColumn(1).setResizable(false);
      tblAlimentos.getColumnModel().getColumn(2).setResizable(false);
      tblAlimentos.getColumnModel().getColumn(3).setResizable(false);
      tblAlimentos.getColumnModel().getColumn(4).setResizable(false);
      tblAlimentos.getColumnModel().getColumn(5).setResizable(false);
      tblAlimentos.getColumnModel().getColumn(6).setResizable(false);
      tblAlimentos.getColumnModel().getColumn(7).setResizable(false);
      tblAlimentos.getColumnModel().getColumn(8).setResizable(false);
    }

    txtBuscarAlimento.setToolTipText("Escriba el nombre del alimento a buscar");
    txtBuscarAlimento.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtBuscarAlimentoActionPerformed(evt);
          }
        });

    btnBuscar.setText("Buscar");
    btnBuscar.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnBuscarActionPerformed(evt);
          }
        });

    btnAgregarAlimento.setText("Anadir alimento");
    btnAgregarAlimento.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAgregarAlimentoActionPerformed(evt);
          }
        });

    javax.swing.GroupLayout panModificarAlimentosLayout =
        new javax.swing.GroupLayout(panModificarAlimentos);
    panModificarAlimentos.setLayout(panModificarAlimentosLayout);
    panModificarAlimentosLayout.setHorizontalGroup(
        panModificarAlimentosLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                panModificarAlimentosLayout
                    .createSequentialGroup()
                    .addGroup(
                        panModificarAlimentosLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(
                                javax.swing.GroupLayout.Alignment.LEADING,
                                panModificarAlimentosLayout
                                    .createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jScrollPane4))
                            .addGroup(
                                panModificarAlimentosLayout
                                    .createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addComponent(
                                        txtBuscarAlimento,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        800,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(
                                        btnBuscar,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        93,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                panModificarAlimentosLayout
                                    .createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(
                                        btnAgregarAlimento,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)))
                    .addGap(37, 37, 37)));
    panModificarAlimentosLayout.setVerticalGroup(
        panModificarAlimentosLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                panModificarAlimentosLayout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        panModificarAlimentosLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(
                                jLabel2,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(txtBuscarAlimento)
                            .addComponent(
                                btnBuscar,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        jScrollPane4,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        61,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        btnAgregarAlimento,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        36,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(525, Short.MAX_VALUE)));

    lblAviso.addTab("MODIFICAR ALIMENTOS (EXPERIMENTAL)", panModificarAlimentos);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(
                        lblAviso,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        1303,
                        javax.swing.GroupLayout.PREFERRED_SIZE)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAviso, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE));

    pack();
  } // </editor-fold>//GEN-END:initComponents

  // Metodo que restablece los valores de las barras
  public void restablecerValoresBarra() {
    for (JProgressBar barra : barras) {
      barra.setValue(0);
    }
  }

  // Reestablesco todos los valores y configuraciones del usuario
  private void btnClearActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnClearActionPerformed
    formatearColorBotones();
    formatearColorBarra();
    restablecerValoresBarra();
    guardarDatosUsuario();
  } // GEN-LAST:event_btnClearActionPerformed

  // Guardo los datos ingresados por el usuario, coloreo las barras dependiendo de su progreso para
  // su meta, y le muestro feedback
  private void btnRunActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnRunActionPerformed
    guardarDatosUsuario();

    colorearBarras();
    try {
      presentarFeedbackAlUsuario();
    } catch (SQLException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
  } // GEN-LAST:event_btnRunActionPerformed

  private void btnMostrarBotonesCaloriasActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnMostrarBotonesCaloriasActionPerformed
    // Formateo el estilo de los botones para que el usuario no se confunda
    formatearColorBotones();
    // Destaco los botones indicados para el usuario para que este pueda apreciar cuales aportan a
    // su barra indicada
    colorearBotones(bCalorias);
  } // GEN-LAST:event_btnMostrarBotonesCaloriasActionPerformed

  private void btnMostrarBotonesFibraActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnMostrarBotonesFibraActionPerformed
    // Formateo el estilo de los botones para que el usuario no se confunda
    formatearColorBotones();
    // Destaco los botones indicados para el usuario para que este pueda apreciar cuales aportan a
    // su barra indicada
    colorearBotones(bFibra);
  } // GEN-LAST:event_btnMostrarBotonesFibraActionPerformed

  private void btnMostrarBotonesVitKActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnMostrarBotonesVitKActionPerformed
    // Formateo el estilo de los botones para que el usuario no se confunda
    formatearColorBotones();
    // Destaco los botones indicados para el usuario para que este pueda apreciar cuales aportan a
    // su barra indicada
    colorearBotones(bVitK);
  } // GEN-LAST:event_btnMostrarBotonesVitKActionPerformed

  private void btnMostrarBotonesCalcioActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnMostrarBotonesCalcioActionPerformed
    // Formateo el estilo de los botones para que el usuario no se confunda
    formatearColorBotones();
    // Destaco los botones indicados para el usuario para que este pueda apreciar cuales aportan a
    // su barra indicada
    colorearBotones(bCalcio);
  } // GEN-LAST:event_btnMostrarBotonesCalcioActionPerformed

  private void btnMostrarBotonesCarbohidratosActionPerformed(
      java.awt.event.ActionEvent
          evt) { // GEN-FIRST:event_btnMostrarBotonesCarbohidratosActionPerformed
    // Formateo el estilo de los botones para que el usuario no se confunda
    formatearColorBotones();
    // Destaco los botones indicados para el usuario para que este pueda apreciar cuales aportan a
    // su barra indicada
    colorearBotones(bCarbohidratos);
  } // GEN-LAST:event_btnMostrarBotonesCarbohidratosActionPerformed

  private void btnMostrarBotonesProteinasActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnMostrarBotonesProteinasActionPerformed
    // Formateo el estilo de los botones para que el usuario no se confunda
    formatearColorBotones();
    // Destaco los botones indicados para el usuario para que este pueda apreciar cuales aportan a
    // su barra indicada
    colorearBotones(bProteinas);
  } // GEN-LAST:event_btnMostrarBotonesProteinasActionPerformed

  private void btnMostrarBotonesVitAActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnMostrarBotonesVitAActionPerformed
    // Formateo el estilo de los botones para que el usuario no se confunda
    formatearColorBotones();
    // Destaco los botones indicados para el usuario para que este pueda apreciar cuales aportan a
    // su barra indicada
    colorearBotones(bVitA);
  } // GEN-LAST:event_btnMostrarBotonesVitAActionPerformed

  private void formWindowClosing(
      java.awt.event.WindowEvent evt) { // GEN-FIRST:event_formWindowClosing
    // Modifico la secuencia de salida en caso de que al usuario se le haya olvidado guardar

    // Guardo los datos en la BD
    guardarDatosUsuario();

    // Cierro el programa
    System.exit(0);
  } // GEN-LAST:event_formWindowClosing

  private void btnConfirmarDuracionPeriodoActionPerformed(
      java.awt.event.ActionEvent
          evt) { // GEN-FIRST:event_btnConfirmarDuracionPeriodoActionPerformed
    // Cambio el texto para avisarle al usuario que el cambio ha sido efectuado
    lblDiasPorPeriodo.setText("Dias por periodo:");

    // Le asigno valores a las variables previamente declaradas para que almacene el periodo nuevo y
    // el antiguo
    periodoPrevio = periodo;
    periodo = (int) spnDiasPeriodo.getValue();

    // Llamo a un metodo que verifica el input y modifica las metas de las tablas
    modificarMetas(periodo, periodoPrevio);
  } // GEN-LAST:event_btnConfirmarDuracionPeriodoActionPerformed

  public int modificarMetas(int periodo, int periodoPrevio) {
    // Método que verifica que el periodo se encuentre en un rango de valores valido y ajusta las
    // tablas acorde.
    // Utilizo un metodo para evitar nesting al introducir condiciones
    if (periodo < 1) {
      this.periodo = 1;
      spnDiasPeriodo.setValue((Object) this.periodo);
      return 0;
    }
    if (periodo > 7) {
      this.periodo = 7;
      spnDiasPeriodo.setValue((Object) this.periodo);
      return 0;
    }
    /* Multiplico las metas de las tablas por el resultado entre la division del periodo previo y el nuevo
    con el fin de aumentar o disminuir el periodo sin recurrir a operaciones complicadas*/
    float aux = ((float) this.periodo / (float) periodoPrevio);
    barras.forEach(
        (barra) -> {
          barra.setMaximum(Math.round(barra.getMaximum() * aux));
        });
    // Actualizo los valores en la base de datos y vuelvo a crear el arreglo de metas para efectuar
    // los cambios
    guardarDatosUsuario();
    conBD.crearArrayDatosNutricionales();
    return 0;
  }

  private void spnDiasPeriodoStateChanged(
      javax.swing.event.ChangeEvent evt) { // GEN-FIRST:event_spnDiasPeriodoStateChanged
    // Le indico al usuario que el valor del periodo no es efectivo porque es distinto al original
    // Util cuando el usuario esta cambiando la cantidad de dias
    lblDiasPorPeriodo.setText("Dias por periodo:*");
  } // GEN-LAST:event_spnDiasPeriodoStateChanged

  private void btnCrearUsuarioActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnCrearUsuarioActionPerformed
    // Instancio un nuevo formulario que le permite al usuario crearse un perfil
    crearUsuario = new FraCrearUsuario(this);
    crearUsuario.setLocationRelativeTo(null);
    crearUsuario.setVisible(true);
  } // GEN-LAST:event_btnCrearUsuarioActionPerformed

  private void cboxLightModeActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_cboxLightModeActionPerformed
    // Dependiendo de si el usuario elige modo claro u oscuro cambio el estilo del formulario
    if (cboxLightMode.isSelected()) {
      setLightMode();
    } else {
      setDarkMode();
    }

    // Reestablesco el estilo de los botones para solucionar errores visuales
    formatearColorBotones();
  } // GEN-LAST:event_cboxLightModeActionPerformed

  public void refrescarUsuarios() {
    // Guardo los datos del usuarios para arreglos
    guardarDatosUsuario();
    // Refresco los valores y datos nutricionales para incluir a los nuevos usuarios
    conBD.crearArrayUsuarios();
    conBD.crearArrayDatosNutricionales();
    // Refresco los usuarios visibles en el comboBox
    initComboboxUsuarios();
  }

  private void cmbUsuariosActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_cmbUsuariosActionPerformed
    conBD.crearArrayAlimentos(getSelectedUserID(0));
    selected_food_ids = conBD.arregloUsuarios.get(getSelectedUserID(1)).getSelected_food_ids();
    crearArregloBarras();
    crearBoton();
    // Obtengo el nuevo periodo a mostrar
    periodo = conBD.arregloUsuarios.get(getSelectedUserID(1)).getPeriodo();
    spnDiasPeriodo.setValue((Object) periodo);

    // Al combiar de perfil (o usuario) inicializo las barras nutricionales con los nuevos datos y
    // obtengo la duracion del periodo
    initBarrasMetasNutricionales();

    // Ordeno los botones en arreglos especificos para ajustar por el cambio de usuario
    ordenarBotonesEnArreglos();
  } // GEN-LAST:event_cmbUsuariosActionPerformed

  private void btnReestablecerColoresBotonesActionPerformed(
      java.awt.event.ActionEvent
          evt) { // GEN-FIRST:event_btnReestablecerColoresBotonesActionPerformed
    // Formateo el estilo de los botones
    formatearColorBotones();
  } // GEN-LAST:event_btnReestablecerColoresBotonesActionPerformed

  private void btnDescartarCambiosActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnDescartarCambiosActionPerformed
    // Refresco el combobox para reinsertar los valores originales
    initComboboxUsuarios();
  } // GEN-LAST:event_btnDescartarCambiosActionPerformed

  private void txtBuscarAlimentoActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_txtBuscarAlimentoActionPerformed
  } // GEN-LAST:event_txtBuscarAlimentoActionPerformed

  private void btnBuscarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnBuscarActionPerformed
    // Busco el alimentos deseado e ingreso sus valores en la tabla
    try {

      APIDataHandler ADH = new APIDataHandler();

      DefaultTableModel tabla = new DefaultTableModel();
      tabla.addColumn("ID");
      tabla.addColumn("Nombre");
      tabla.addColumn("Calorias");
      tabla.addColumn("Proteinas");
      tabla.addColumn("Carbohidratos");
      tabla.addColumn("Grasas Saturadas");
      tabla.addColumn("Azucar");
      tabla.addColumn("Fibra");
      tabla.addColumn("Calcio");
      tblAlimentos.setModel(tabla);

      String[] datos = new String[10];

      Alimentos a = ADH.getRequestFoodInfo(txtBuscarAlimento.getText().replace(" ", "%20"), false);
      datos[0] = a.getId();
      datos[1] = txtBuscarAlimento.getText();
      datos[3] = Float.toString(a.getCalorias());
      datos[4] = Float.toString(a.getProteinas());
      datos[5] = Float.toString(a.getCarbohidratos());
      datos[6] = Float.toString(a.getFat());
      datos[7] = Float.toString(a.getSugar());
      datos[8] = Float.toString(a.getFibra());
      datos[9] = Float.toString(a.getCalcio());

      tabla.addRow(datos);
      tblAlimentos.setModel(tabla);

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  } // GEN-LAST:event_btnBuscarActionPerformed

  private void btnAgregarAlimentoActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnAgregarAlimentoActionPerformed
    // Busco y descargo el alimento deseado para luego agregarlo como botón
    try {
      selected_food_ids += " " + txtBuscarAlimento.getText();
      guardarDatosUsuario();

      APIDataHandler ADH = new APIDataHandler();
      ADH.getRequestFoodInfo(txtBuscarAlimento.getText(), true);

      // Recreo el arreglo Alimentos con el nuevo alimento

      conBD.crearArrayAlimentos(getSelectedUserID(0));

      JOptionPane.showMessageDialog(null, "Alimento Insertado");
    } catch (Exception e) {
      e.getMessage();
    }
  } // GEN-LAST:event_btnAgregarAlimentoActionPerformed

  public static void main(String args[]) {
    /* Se crea y se muestra el formulario */
    java.awt.EventQueue.invokeLater(
        new Runnable() {
          public void run() {
            new Main().setVisible(true);
          }
        });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JProgressBar barCalcio;
  private javax.swing.JProgressBar barCaloria;
  private javax.swing.JProgressBar barCarbohidrato;
  private javax.swing.JProgressBar barFat;
  private javax.swing.JProgressBar barFibra;
  private javax.swing.JProgressBar barProteina;
  private javax.swing.JProgressBar barSugar;
  private javax.swing.JButton btnAgregarAlimento;
  private javax.swing.JButton btnBuscar;
  private javax.swing.JButton btnClear;
  private javax.swing.JButton btnConfirmarDuracionPeriodo;
  private javax.swing.JButton btnCrearUsuario;
  private javax.swing.JButton btnDescartarCambios;
  private javax.swing.JButton btnMostrarBotonesCalcio;
  private javax.swing.JButton btnMostrarBotonesCalorias;
  private javax.swing.JButton btnMostrarBotonesCarbohidratos;
  private javax.swing.JButton btnMostrarBotonesFibra;
  private javax.swing.JButton btnMostrarBotonesProteinas;
  private javax.swing.JButton btnMostrarBotonesVitA;
  private javax.swing.JButton btnMostrarBotonesVitK;
  private javax.swing.JButton btnReestablecerColoresBotones;
  private javax.swing.JButton btnRun;
  private javax.swing.JCheckBox cboxLightMode;
  private javax.swing.JComboBox<String> cmbUsuarios;
  private javax.swing.JEditorPane jEditorPane1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane4;
  private javax.swing.JToggleButton jToggleButton1;
  private javax.swing.JTabbedPane lblAviso;
  private javax.swing.JLabel lblDiasPorPeriodo;
  private javax.swing.JLabel lblUsuario;
  private javax.swing.JPanel panAlimentos;
  private javax.swing.JPanel panBoton;
  private javax.swing.JPanel panConfig;
  private javax.swing.JPanel panMain;
  private javax.swing.JPanel panModificarAlimentos;
  private javax.swing.JPanel panNutrientes;
  private javax.swing.JSpinner spnDiasPeriodo;
  private javax.swing.JTable tblAlimentos;
  private javax.swing.JTextField txtBuscarAlimento;
  // End of variables declaration//GEN-END:variables

  public void crearBoton() {
    // Método que, primero borra todos los botones en pantalla y luego, por cada alimento en el
    // arreglo crea un boton con su nombre y lo muestra
    if (!botones.isEmpty()) {
      for (int i = 0; i < botones.size(); i++) {
        JButton b = botones.get(i);
        botones.remove(i);
      }
      panAlimentos.removeAll();
      panAlimentos.invalidate();
    }
    panAlimentos.updateUI();

    for (Alimentos arregloAlimento : conBD.arregloAlimentos) {
      System.out.println(arregloAlimento);
    }

    for (Alimentos a : conBD.arregloAlimentos) {
      // Obtengo el nombre del alimento y se lo asigno de nombre a un boton
      JButton boton = new JButton(a.getNombre().replace("%20", " "));
      boton.addActionListener(this);
      // Añado el boton al panel y lo refresco una vez termine el for, ordenandolo en el proceso
      panAlimentos.add(boton);
      botones.add(boton);
    }
    panAlimentos.updateUI();
  }

  public void initComboboxUsuarios() {
    // Elimino todos los usuarios del combobox
    cmbUsuarios.removeAllItems();

    // Por cada usuario presente en el arreglo le agrego el nombre al combobox
    for (Usuarios u : conBD.arregloUsuarios) {
      cmbUsuarios.addItem(u.getNombre());
    }

    // Obtengo el periodo del usuario predeterminado
    try {
      periodo = conBD.arregloUsuarios.get(getSelectedUserID(1)).getPeriodo();
      spnDiasPeriodo.setValue((Object) periodo);
    } catch (Exception e) {
      System.out.println("Error can be ignored!");
      System.out.println(e.getMessage());
    }
  }

  public void initBarrasMetasNutricionales() {
    // Obetengo el id del usuario seleccionado
    int id = getSelectedUserID(0);
    // Repito la declaracion para solucionar errores
    periodo = conBD.arregloUsuarios.get(getSelectedUserID(1)).getPeriodo();

    for (MetasNutricional mn : conBD.arregloMetasNutricionales) {
      if (mn.getId() == id) {
        // Convierto los float a int de la meta preservando las proporciones (no perdiendo datos) al
        // multiplicar por (10*periodo)
        barCaloria.setMaximum((int) mn.getCalorias() * (10 * periodo));
        barProteina.setMaximum((int) mn.getProteinas() * (10 * periodo));
        barCarbohidrato.setMaximum((int) mn.getCarbohidratos() * (10 * periodo));
        barSugar.setMaximum((int) mn.getSugar() * (10 * periodo));
        barFat.setMaximum((int) mn.getFat() * (10 * periodo));
        barFibra.setMaximum((int) mn.getFibra() * (10 * periodo));
        barCalcio.setMaximum((int) mn.getCalcio() * (10 * periodo));

        // Convierto los float a int del progreso preservando las proporciones (no perdiendo datos)
        // al multiplicar por (10*periodo)
        id = getSelectedUserID(1);
        barCaloria.setValue((int) conBD.arregloUsuarios.get(id).getCalorias());
        barProteina.setValue((int) conBD.arregloUsuarios.get(id).getProteinas());
        barCarbohidrato.setValue((int) conBD.arregloUsuarios.get(id).getCarbohidratos());
        barSugar.setValue((int) conBD.arregloUsuarios.get(id).getSugar());
        barFat.setValue((int) conBD.arregloUsuarios.get(id).getGrasa());
        barFibra.setValue((int) conBD.arregloUsuarios.get(id).getFibra());
        barCalcio.setValue((int) conBD.arregloUsuarios.get(id).getCalcio());
      }
    }
  }

  public int getSelectedUserID(int mode) {
    int id = 0, i = 0;
    // Recorro el arreglo de usuarios
    for (Usuarios u : conBD.arregloUsuarios) {
      // Si el nombre del usuario en el arreglo coincide con el usuario seleccionado en el combobox
      // entro al if
      if (u.getNombre() == cmbUsuarios.getSelectedItem()) {
        /* dependiendo del modo regreso distintos valores
        0 = id del usuario en la base de datos
        1 ( u otro numero ) = posicion en el combobox y arreglos
         */
        if (mode == 0) {
          id = u.getId();
        } else {
          id = i;
        }
      }
      // i sirve para contar la posicion del usuario dentro del arregñp
      i++;
    }

    return id;
  }

  public void agregarDatosABarra(String nombre) {
    /* Metodo que recorre los alimentos hasta encontrar el solicitado, una vez lo haga,
    agrega los valores nutricionales a las barras*/
    for (Alimentos alimento : conBD.arregloAlimentos) {
      if (alimento.getNombre().equals(nombre)) {
        System.out.println("Nombre: " + nombre);
        System.out.println("Calorias: " + alimento.getCalorias());
        System.out.println("Proteinas: " + alimento.getProteinas());
        System.out.println("Carbs: " + alimento.getCarbohidratos());
        System.out.println("Fat: " + alimento.getSugar());
        System.out.println("Sugar: " + alimento.getFat());
        System.out.println("Fibra: " + alimento.getFibra());
        System.out.println("Calcio: " + alimento.getCalcio());
        System.out.println("");
        System.out.println("-----");
        System.out.println("");

        barCaloria.setValue(barCaloria.getValue() + ((int) alimento.getCalorias() * (10)));
        barProteina.setValue(barProteina.getValue() + ((int) alimento.getProteinas() * (10)));
        barCarbohidrato.setValue(
            barCarbohidrato.getValue() + ((int) alimento.getCarbohidratos() * (10)));
        barSugar.setValue(barSugar.getValue() + ((int) alimento.getSugar() * (10)));
        barFat.setValue(barFat.getValue() + ((int) alimento.getFat() * (10)));
        barFibra.setValue(barFibra.getValue() + ((int) alimento.getFibra() * (10)));
        barCalcio.setValue(barCalcio.getValue() + ((int) alimento.getCalcio() * (10)));
        break;
      }
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // Si se apreta cualquier boton en la aplicacion, se revisa si este pertenece a los elementos,
    // si es asi, llama al metodo que agrega los datos del alimento a la barra
    if (botones.contains(e.getSource())) {
      if (barraColoreada) { // Si las barras estan coloreadas se regresan a su estado original
        formatearColorBarra();
      }
      String pos = botones.get(botones.indexOf(e.getSource())).getText();
      agregarDatosABarra(pos);
    }
  }

  public void colorearBarras() {
    // Metodo que colorea las barras dependiendo del progreso del usuario divido en la meta
    float progreso = 0;
    for (JProgressBar barra : barras) {
      progreso = (float) barra.getValue() / (float) barra.getMaximum();

      if (progreso <= 0.6) {
        barra.setForeground(Color.red);
      } else if (progreso < 0.9) {
        barra.setForeground(Color.orange);
      } else {
        barra.setForeground(Color.green);
      }
    }
    barraColoreada = true;
  }

  public void crearArregloBarras() {
    /*
       Metodo que instancia el arreglo barras y agrega las distintas barras dentro de este, ademas de darles un nombre con el cual identificarlos
    */
    barras = new ArrayList<>();

    barCaloria.setName("Calorias");
    barProteina.setName("Proteinas");
    barCarbohidrato.setName("Carbohidratos");
    barSugar.setName("Vitamina C");
    barFat.setName("Vitamina K");
    barFibra.setName("Fibra");
    barCalcio.setName("Calcio");

    barras.add(barCaloria);
    barras.add(barProteina);
    barras.add(barCarbohidrato);
    barras.add(barSugar);
    barras.add(barFat);
    barras.add(barFibra);
    barras.add(barCalcio);
  }

  public void setDarkMode() {
    // Metodo que establece el LaF en modo oscuro
    try {
      UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    // Refresta Look and Feel del jFrame
    SwingUtilities.updateComponentTreeUI(this);
    this.pack();
    darkMode = true;
  }

  public void setLightMode() {
    // Metodo que establece el LaF en modo claro
    try {
      UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    // Refresta Look and Feel del jFrame
    SwingUtilities.updateComponentTreeUI(this);
    this.pack();
    darkMode = false;
  }

  public void ordenarBotonesEnArreglos() {
    // Instancio los arreglos que almacenan a los botones
    bCalorias = new ArrayList<>();
    bProteinas = new ArrayList<>();
    bCarbohidratos = new ArrayList<>();
    bVitA = new ArrayList<>();
    bSugar = new ArrayList<>();
    bVitK = new ArrayList<>();
    bFibra = new ArrayList<>();
    bCalcio = new ArrayList<>();

    // Obtengo el id del usuario y establesco el margen en 0.1. El margen refiere al minimo
    // aporte que tiene que hacer un alimento a la meta para ser considerado como importante y luego
    // sea destacado cuando se necesite
    int id = getSelectedUserID(1);
    float margen = (float) 0.1;

    // Por cada boton en el arreglo lo emparejo con el alimento respectivo
    for (JButton boton : botones) {
      for (Alimentos alimento : conBD.arregloAlimentos) {
        if (alimento.getNombre().equals(boton.getText())) {
          // Si el aporte nutricional de un alimento es significativo entonces se agrega a un
          // arreglo especial
          if (alimento.getCalorias() / conBD.arregloMetasNutricionales.get(id).getCalorias()
              > margen) {
            bCalorias.add(boton);
          }
          if (alimento.getProteinas() / conBD.arregloMetasNutricionales.get(id).getProteinas()
              > margen) {
            bProteinas.add(boton);
          }
          if (alimento.getCarbohidratos()
                  / conBD.arregloMetasNutricionales.get(id).getCarbohidratos()
              > margen) {
            bCarbohidratos.add(boton);
          }
          if (alimento.getSugar() / conBD.arregloMetasNutricionales.get(id).getSugar() > margen) {
            bSugar.add(boton);
          }
          if (alimento.getFat() / conBD.arregloMetasNutricionales.get(id).getFat() > margen) {
            bVitK.add(boton);
          }
          if (alimento.getFibra() / conBD.arregloMetasNutricionales.get(id).getFibra() > margen) {
            bFibra.add(boton);
          }
          if (alimento.getCalcio() / conBD.arregloMetasNutricionales.get(id).getCalcio() > margen) {
            bCalcio.add(boton);
          }
          break;
        }
      }
    }
  }

  public void colorearBotones(List<JButton> arreglo) {
    // Metodo que colorea los botones de un arreglo dado con el fin de destarlos
    for (JButton boton : arreglo) {
      // Coloreo los botones de colores istintos dependiendo de si el usuario utiliza modo oscuro o
      // modo claro
      if (darkMode) {
        boton.setForeground(Color.darkGray);
        boton.setBackground(Color.white);
      } else {
        boton.setBackground(Color.yellow);
        boton.setForeground(Color.darkGray);
      }
    }
  }

  public void formatearColorBotones() {
    // Metodo que reglesa los colores a su estado original
    for (JButton boton : botones) {
      // Coloreo los botones de colores istintos dependiendo de si el usuario utiliza modo oscuro o
      // modo claro
      if (!darkMode) {
        boton.setForeground(Color.darkGray);
        boton.setBackground(Color.white);
      } else {
        boton.setBackground(Color.darkGray);
        boton.setForeground(Color.white);
      }
    }
  }

  public void presentarFeedbackAlUsuario() throws SQLException {
    // Definicion de variables
    float progreso = 0;
    String mensaje = "Nutrientes faltantes: \n";

    // Obtengo el progreso del usuario y se lo agrego al mensaje que luego le voy a mostrar
    for (JProgressBar barra : barras) {
      progreso = ((float) barra.getValue() / (float) barra.getMaximum()) * 100;
      if (progreso < 80) {
        mensaje += "> " + barra.getName() + ": " + Math.round(progreso) + "% del progreso \n";
      }
    }

    JOptionPane.showMessageDialog(null, mensaje);

    // Restablesco valores tabla para solucionar errores relacionados a los datos en las tablas
    formatearColorBotones();
    initBarrasMetasNutricionales(); // Inicio las tablas
    restablecerValoresBarra();
    guardarDatosUsuario();
  }

  public void formatearColorBarra() {
    // Metodo que regresa los colores de las barras a su estado original
    for (JProgressBar barra : barras) {
      barra.setForeground(Color.cyan);
    }
  }

  public void validateUserExistance() {
    // Metodo que revisa si el usuario tiene un perfil creado para crearlo en el momento
    if (conBD.arregloUsuarios.isEmpty()) {
      // Como el usuario no tiene perfil, le creo uno
      String nombre = "";
      float masa = 0;

      try {
        nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre: ") + " ";
        masa = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese su masa (kg): "));
      } catch (Exception e) {
        masa = -1;
        System.out.println(e);
      }
      if (masa < 1 || masa > 400) { // reviso si el masa del usuario es imbalido
        masa = 70;
        JOptionPane.showMessageDialog(null, "Masa no recibido (o es invalido), utilizando 70");
      }

      if (nombre.isEmpty()) {
        nombre = "user";
      }

      try {
        // Se definen instrucciones para ejecutar las sentencias SQL
        // Ingreso los datos en la base de datos
        query.insertUser(nombre, masa);

        // Llamo al metodo agregar fila
        query.insertMetasNutricionales(masa);

        JOptionPane.showMessageDialog(null, "Usuario creado!");

      } catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println("No se puede guardar");
      }

      // reinicio el programa
      Main.main(null);
    }
  }

  public void guardarDatosUsuario() {
    /* Metodo que guarda el progreso del usuario en la base de datos */
    System.out.println("Guardando data usuario");
    try {
      // Se definen instrucciones para ejecutar las sentencias SQL
      System.out.println(selected_food_ids);
      PreparedStatement pst =
          conn.prepareStatement(
              "UPDATE user set selected_food_ids = '"
                  + selected_food_ids
                  + "',periodo = '"
                  + periodo
                  + "', calorias = '"
                  + barCaloria.getValue()
                  + "',proteinas = '"
                  + barProteina.getValue()
                  + "',carbohidratos = '"
                  + barCarbohidrato.getValue()
                  + "',sugar = '"
                  + barSugar.getValue()
                  + "',fat = '"
                  + barFat.getValue()
                  + "',fibra = '"
                  + barFibra.getValue()
                  + "',calcio = '"
                  + barCalcio.getValue()
                  + "' WHERE id = '"
                  + getSelectedUserID(0)
                  + "'"); // Se pasa el codigo SQL de insercion al objeto PeparedStatement.
      pst.executeUpdate();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println("No se puede guardar");
    }
  }
}
