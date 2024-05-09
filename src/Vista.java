import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Vista {
    // Declarar la variable de Ventana
    MiVentana miVentana;
    // Declarar la variable del cuadro de dialogo
    MiDialogo miDIalogo;

    public Vista()
    {
        miVentana = new MiVentana("Aplicacion de Catalogo - MVC");
        miVentana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

}

class MiVentana extends JFrame
{
    JMenuItem mnuArcActualizar;
    JMenuItem mnuArcSalir;
    JMenuItem mnuAyuda;

    public MiVentana(String titulo)
    {
        super (titulo);
        
        // Establecer menu
        JMenuBar barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);

        // Crear menu archivo
        JMenu menuArchivo = new JMenu ("Archivo");
        menuArchivo.setMnemonic('A');

        // Crear opciones menu
        mnuArcActualizar = new JMenuItem("Actualizar...");
        mnuArcActualizar.setMnemonic('c');
        mnuArcSalir = new JMenuItem("Salir");
        mnuArcSalir.setMnemonic('S');
        
        // Agregar opciones al menu Archivo
        menuArchivo.add(mnuArcActualizar);
        menuArchivo.addSeparator();
        menuArchivo.add(mnuArcSalir);
      
        // Agregar menu Archivo en la barra menu
        barraMenu.add(menuArchivo);

         // Crear menu Ayuda
         JMenu menuAyuda = new JMenu ("Ayuda");
        menuAyuda.setMnemonic('u');

         // Crear opciones menu
         mnuAyuda = new JMenuItem("Acerca de...");
         mnuAyuda.setMnemonic('A');

         // Agregar opciones al menu Ayuda
        menuAyuda.add(mnuAyuda);

        // Agregar menu Archivo en la barra de menú
        barraMenu.add(menuAyuda);

        // Tamaño de la ventana 
        setSize(600,400);
    }
}

// Clase MiDialogo para Catalogo de Artículos
class MiDialogo extends JDialog
{
    MiPanel miPanel;

    // Constructor de dialogo
    public MiDialogo(JFrame padre, String titulo)
    {
        super(padre, titulo);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        // Agregar panel al cuadro de dialogo
        miPanel=new MiPanel();
        add(miPanel);

        setSize(500,410);
        setResizable(false);
    }

    // Clase interna personalizada MiPanel
    class MiPanel extends JPanel
    {
        // Declarar componentes del panel de navegancion
        JButton btnPrimero;
        JButton btnAnterior;
        JTextField txtClave;
        JTextField txtTotalRegistros;
        JButton btnSiguiente;
        JButton btnUltimo;

        // Declarar componentes del panel de datos generales
        JTextField txtNombre;
        JTextField txtDescripcion;
        JTextField txtMarca;
        JComboBox<String> cmbTipo;
        JCheckBox chkWindows;
        JCheckBox chkMacintosh;
        JCheckBox chkLinux;
        JCheckBox chkOtro;
        JTextField txtEspecificar;
        JTextField txtPrecioMenudeo;
        JTextField txtPrecioMedioMayoreo;
        JTextField txtPrecioMayoreo;
        JCheckBox chkActivo;

        // Declarar componentes del panel de botones de accion
        JButton btnNuevo;
        JButton btnModificar;
        JButton btnGuardar;
        JButton btnCancelar;
        JButton btnSalir;

        // Constructor para crear los conmponentes del cuadro de dialogo
        public MiPanel()
        {
            // Establecer administrador de esquema de tipo borde
            setLayout( new BorderLayout() );

            // Panel de navegacion 
            btnPrimero =new JButton("Primero");
            btnPrimero.setMnemonic('P');
            btnAnterior =new JButton("Anterior");
            btnAnterior.setMnemonic('A');
            JLabel etClave = new JLabel("Clave");
            txtClave =new JTextField(3);
            txtClave.setHorizontalAlignment(JTextField.CENTER);
            JLabel etDe = new JLabel("de");
            txtTotalRegistros = new JTextField(3);
            txtTotalRegistros.setHorizontalAlignment(JTextField.CENTER);
            txtTotalRegistros.setEditable(false);
            btnSiguiente =new JButton("Siguiente");
            btnSiguiente.setMnemonic('i');
            btnUltimo =new JButton("Ultimo");
            btnUltimo.setMnemonic('U');

            JPanel panelNavegacion = new JPanel();
            panelNavegacion.add(btnPrimero);
            panelNavegacion.add(btnAnterior);
            panelNavegacion.add(etClave);
            panelNavegacion.add(txtClave);
            panelNavegacion.add(etDe);
            panelNavegacion.add(txtTotalRegistros);
            panelNavegacion.add(btnSiguiente);
            panelNavegacion.add(btnUltimo);

            // Panel de datos generales
            JLabel etNombre = new JLabel("Nombre");
            txtNombre = new JTextField(20);
            JLabel etDescripción = new JLabel("Descripción");
            txtDescripcion = new JTextField(29);
            JLabel etMarca = new JLabel("Marca");
            txtMarca = new JTextField(20);
            JLabel etTipo = new JLabel("Tipo");
            String[] opcionesTipo = {"Hardware", "Software"};
            cmbTipo = new JComboBox<String>(opcionesTipo);
            chkWindows = new JCheckBox("Windows");
            chkMacintosh = new JCheckBox("Macintosh");
            chkLinux = new JCheckBox("Linux");
            chkOtro= new JCheckBox("Otros");
            JLabel etEspecificar = new JLabel("Especificar");
            txtEspecificar = new JTextField(10);
            JLabel etPrecioMenudeo = new JLabel("Precio por Menudeo");
            txtPrecioMenudeo = new JTextField(10);
            JLabel etPrecioMedioMayoreo = new JLabel("Precio por Medio Mayoreo");
            txtPrecioMedioMayoreo = new JTextField(10);
            JLabel etPrecioMayoreo = new JLabel("Precio por Mayoreo");
            txtPrecioMayoreo = new JTextField(10);

            JLabel etEstatus = new JLabel("Estatus:");   
            chkActivo = new JCheckBox("Activo");

            // Panel para contener los componentes
            JPanel panelGeneral = new JPanel();
            FlowLayout esquemaSimple = new FlowLayout(FlowLayout.LEFT);
            panelGeneral.setLayout(esquemaSimple);

            panelGeneral.add(Box.createHorizontalStrut(40));
            panelGeneral.add(etNombre);
            panelGeneral.add(Box.createHorizontalStrut(18));
            panelGeneral.add(txtNombre);
            panelGeneral.add(Box.createHorizontalStrut(100));
            panelGeneral.add(Box.createHorizontalStrut(40));
            panelGeneral.add(etDescripción);
            panelGeneral.add(txtDescripcion);
            panelGeneral.add(Box.createHorizontalStrut(40));
            panelGeneral.add(etMarca);
            panelGeneral.add(Box.createHorizontalStrut(27));
            panelGeneral.add(txtMarca);
            panelGeneral.add(Box.createHorizontalStrut(100));
            panelGeneral.add(Box.createHorizontalStrut(40));
            panelGeneral.add(etTipo);
            panelGeneral.add(Box.createHorizontalStrut(40));
            panelGeneral.add(cmbTipo);
            panelGeneral.add(Box.createHorizontalStrut(250));
            panelGeneral.add(Box.createHorizontalStrut(40));

            // Panel para agrupar los checkbox de sistemas operativos
            JPanel panelSistemaOperativo = new JPanel();
            panelGeneral.add(panelSistemaOperativo);
            GridLayout esquemaCuadricula = new GridLayout(2,3);
            panelSistemaOperativo.setLayout(esquemaCuadricula);
            // borde negro con titulo
            Border bordeNegro= BorderFactory.createLineBorder(Color.BLACK);
            TitledBorder bordeTitulo = BorderFactory.createTitledBorder(bordeNegro, "Sistemas Operativos");
            // panelSistemaOperativo.setBorder(bordeNegro);
            panelSistemaOperativo.setBorder(bordeTitulo);

            panelSistemaOperativo.add(chkWindows);
            panelSistemaOperativo.add(chkMacintosh);
            panelSistemaOperativo.add(chkLinux);
            panelSistemaOperativo.add(chkOtro);
            panelSistemaOperativo.add(etEspecificar);
            panelSistemaOperativo.add(txtEspecificar);

            panelGeneral.add(Box.createHorizontalStrut(40));
            panelGeneral.add(Box.createHorizontalStrut(40));
            panelGeneral.add(etPrecioMenudeo);
            panelGeneral.add(Box.createHorizontalStrut(39));
            panelGeneral.add(txtPrecioMenudeo);
            panelGeneral.add(Box.createHorizontalStrut(150));
            panelGeneral.add(Box.createHorizontalStrut(40));
            panelGeneral.add(etPrecioMedioMayoreo);
            panelGeneral.add(Box.createHorizontalStrut(5));
            panelGeneral.add(txtPrecioMedioMayoreo);
            panelGeneral.add(Box.createHorizontalStrut(150));
            panelGeneral.add(Box.createHorizontalStrut(40));
            panelGeneral.add(etPrecioMayoreo);
            panelGeneral.add(Box.createHorizontalStrut(42));
            panelGeneral.add(txtPrecioMayoreo);

            panelGeneral.add(Box.createHorizontalStrut(150));
            panelGeneral.add(Box.createHorizontalStrut(40));
            panelGeneral.add(etEstatus);
            panelGeneral.add(chkActivo);

            // Botones de accion
            btnNuevo = new JButton("Nuevo");
            btnNuevo.setMnemonic('N');

            btnModificar = new JButton("Modificar");
            btnModificar.setMnemonic('M');

            btnGuardar = new JButton("Guardar");
            btnGuardar.setMnemonic('G');

            btnCancelar = new JButton("Cancelar");
            btnCancelar.setMnemonic('C');

            btnSalir = new JButton("Salir");
            btnSalir.setMnemonic('S');

            // Panel para contener los botones
            JPanel panelBotones = new JPanel();
            panelBotones.add(btnNuevo);
            panelBotones.add(btnModificar);
            panelBotones.add(btnGuardar);
            panelBotones.add(btnCancelar);
            panelBotones.add(btnSalir);

            // Agregar panel de navegacion en la parte norte del cuadro de dialogo
            add(panelNavegacion, BorderLayout.NORTH);

            // agregar panel de datos generales en la parte central
            add(panelGeneral, BorderLayout.CENTER);

            // Agregar panel botones en la parte sur del cuadro de dialogo
            add(panelBotones, BorderLayout.SOUTH);

        }
    }

}