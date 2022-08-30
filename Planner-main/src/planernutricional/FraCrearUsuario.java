package planernutricional;

import java.awt.HeadlessException;

// Clase que muestra un formulario con el cual se crean usuarios
public class FraCrearUsuario extends javax.swing.JFrame {

    // Declaracion de variables
    Querier query = new Querier();
    Main ma;

    // Metodo constructor que almacena la clase Main de la cual se llamo a la clase actual
    public FraCrearUsuario(Main ma) {
        initComponents();
        this.ma = ma;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panCrearUsuario = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear Usuario");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("fraCrearUsuario"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panCrearUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombre.setText("Nombre");
        panCrearUsuario.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 9, -1, -1));

        lblPeso.setText("Masa (kg:)");
        panCrearUsuario.add(lblPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 37, -1, -1));

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        panCrearUsuario.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 62, 155, 63));

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panCrearUsuario.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 62, 155, 63));
        panCrearUsuario.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 6, 212, -1));
        panCrearUsuario.add(txtPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 34, 212, -1));

        getContentPane().add(panCrearUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -4, 330, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        crearUsuario();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JPanel panCrearUsuario;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables

    
    // Metodo que crea un usuario utilizando los valores ingresados en el formulario
    public void crearUsuario() throws HeadlessException {
        // Definicion de variables
        float masa;
        String nombre;
        
        // Obtengo los datos del formulario y muestro error si es necesario
        try {
            masa = Float.parseFloat(txtPeso.getText());
            nombre = txtNombre.getText() + " ";
        } catch (NumberFormatException e) {
            masa = 70;
            nombre = "usuario";
            System.out.println(e);
        }
        
        // Reviso que los valores sean validos
        if (masa < 1 || masa
                > 400) { 
            masa = 70;
        }

        if (nombre.trim()
                .isEmpty()) {
            nombre = "usuario";
        }

        try {
            // Llamo a un metodo que ingresa el usuario en la base de datos
            query.insertUser(nombre, masa);

            // Llamo a un metodo que ingresa las nuevas metas nutricionales en la base de datos
            query.insertMetasNutricionales(masa);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("No se puede guardar");
        }

        // Refresco el combobox de usuarios en la clase main y cierro el formulario
        ma.refrescarUsuarios();
        dispose();

    }
}
