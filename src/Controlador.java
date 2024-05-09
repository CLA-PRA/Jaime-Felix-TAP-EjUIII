import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Controlador {
    Modelo miModelo;
    Vista miVista;

    public Controlador (Modelo miModelo, Vista miVista)
    {
        this.miModelo=miModelo;
        this.miVista=miVista;
    }
    
    public void iniciarVista()
    {
        // Oyente de elementos del menu
        MiOyente miOyente = new MiOyente();
        // Registrar oyente de eventos
        miVista.miVentana.mnuArcActualizar.addActionListener(miOyente);
        miVista.miVentana.mnuAyuda.addActionListener(miOyente);
        miVista.miVentana.mnuArcSalir.addActionListener(miOyente);

        miVista.miVentana.setVisible(true);
    }

    // Clase interna para oyende de evento
    class MiOyente implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            // Preguntar cual de las 3 opciones genero el evento
            String cual = e.getActionCommand();

            if (cual.equals("Actualizar..."))
            {
                miVista.miDIalogo = new MiDialogo(miVista.miVentana, "Catalogo de Productos de Computacion");
                
                // Oyente de botones de aacion
                OyenteBotonesAccion oba = new OyenteBotonesAccion();
                miVista.miDIalogo.miPanel.btnSalir.addActionListener(oba);
                
                // Hacer dialogo modal y mostrarlo
                miVista.miDIalogo.setModalityType(ModalityType.APPLICATION_MODAL); 
                miVista.miDIalogo.setVisible(true);
            }
            else if (cual.equals("Salir"))
            {
                // Preguntar si desea salir
                int opcion = JOptionPane.showConfirmDialog(miVista.miVentana,
                 "¿Deseas salir?", 
                 "Aplicacion de catalogo - MVC", 
                 JOptionPane.YES_NO_OPTION, 
                 JOptionPane.QUESTION_MESSAGE);

                if(opcion ==JOptionPane.YES_OPTION) 
                    miVista.miVentana.dispose();
                
            }
            else if (cual.equals("Acerca de..."))
            JOptionPane.showMessageDialog(miVista.miVentana, "Poner los datos del autor del programa"
            , "Acerca de", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }

    // Clase interna para oyentes de los botones de accion
    class OyenteBotonesAccion implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            // Preguntar cual boton genero el evento
            String cual = e.getActionCommand();

            if (cual.equals("Nuevo")) 
            {}
            else if (cual.equals("Modificar")) 
            {}
            else if (cual.equals("Guardar")) 
            {}
            else if (cual.equals("Cancelar")) 
            {}
            else if (cual.equals("Salir")) 
            {
                // Eliminar el cuadro de dialogo
                miVista.miDIalogo.dispose();
            }
        }
        
    }
}
