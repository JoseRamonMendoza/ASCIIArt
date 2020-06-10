package asciiart;

import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;


/**
 * Clase que fungirá como vista para la aplicación
 *
 * @author jr199
 */
public class Vista extends JFrame {

    private JLabel jlTexto;
    private JTextPane jtaOutput;
    private JTextField jtfInput;
    private JComboBox jcbFuente;
    
    private Border border;
    
    

    public Vista() {
        //Definimos el layout
        super("AsciiArt");
        setLayout(new BorderLayout());

        //Definimos las funciones que armarán las partes del la ventana
        JPanel pNorte = crearNorte();
        add(pNorte, BorderLayout.NORTH);

        JPanel pSur = crearSur();
        add(pSur, BorderLayout.CENTER);

        //Creamos los listeners para los eventos
        addWindowListener(new CerrarVentana());
        jtfInput.addActionListener(new ConvertirTexto());

        //Visibilidad, tamaño y posición de la ventana
        setLocation(100,200);
        setVisible(true);
        setSize(1200, 300);
    }

    //Panel que creará la parte norte de la ventana
    public JPanel crearNorte() {
        //Definimos el layout
        JPanel pNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        //ponemos titulo a la sección
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border, "String");
        pNorte.setBorder(titledBorder);

        //Definimos las variables para el panel 
        jlTexto = new JLabel("Ingrese Texto: ");
        jtfInput = new JTextField(30);
        jcbFuente = new JComboBox();

        
        //Agregamos las variables al panel 
        pNorte.add(jlTexto);
        pNorte.add(jtfInput);
        pNorte.add(jcbFuente);
        //Agregamos las opciones al JComboBox
        jcbFuente.addItem("Asterisco");
        jcbFuente.addItem("Blocks");

        return pNorte;
    }

    //Panel que creará la parte sur de la ventana
    public JPanel crearSur() {
        //Seteamos el layout
        JPanel pSur = new JPanel(new BorderLayout());
        
        //ponemos titulo a la sección
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border, "Output");
        pSur.setBorder(titledBorder);

        //Instanciamos las variables para el panel
        jtaOutput = new JTextPane();
        
        //Cambiamos la fuente a Monospaced para que tenga el mismo ancho un espacio 
        //y un caracter
        Font fuente = new Font(Font.MONOSPACED, Font.PLAIN, 10);
        jtaOutput.setFont(fuente);
        
        String[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for(int i = 0; i < fuentes.length; i++){
            System.out.println(fuentes[i]);
        }
        
        
        //Creamos un scrollPane para que el pane tenga un Scroll siempre activo si
        //lo necesita
        JScrollPane scrollPane = new JScrollPane(jtaOutput);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //Agregamos los elementos
        pSur.add(scrollPane, BorderLayout.CENTER);
        
        
        return pSur;
    }

    
    
    
    //Eventos
    //Evento de cerrar ventana 
    class CerrarVentana implements WindowListener {

        //Evento de cierre de ventana
        @Override
        public void windowClosing(WindowEvent e) {
            //Para cerrar la ventana se necesitan 3 pasos
            //1 ocultar la ventana 
            setVisible(false);

            //2 liberar la memoria
            dispose();

            //3 finalizar la aplicación
            System.exit(0);
        }

        @Override
        public void windowOpened(WindowEvent e) {}

        @Override
        public void windowClosed(WindowEvent e) {}

        @Override
        public void windowIconified(WindowEvent e) {}

        @Override
        public void windowDeiconified(WindowEvent e) {}

        @Override
        public void windowActivated(WindowEvent e) {}

        @Override
        public void windowDeactivated(WindowEvent e) {}
    }
    
    //Evento que convierte el texto
    //primero capturamos la fuente que esta selecionada en el JComboBox
    //con el index capturado pasa a la función EscogerFont lo que hace es 
    //escoger la fuente y lo guarda en una variable que implemente la interfaz
    //Font, se convierte el texto y luego se pasa al elemento que queremos que 
    //lo muestre
    class ConvertirTexto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int itemSelecionado = jcbFuente.getSelectedIndex();
            Fuente font = FontManager.EscogerFont(itemSelecionado);
            StringBuffer texto = font._ConvertirTexto(jtfInput.getText());
            String output = texto.toString();
            
            jtaOutput.setText(output);
            
            jtfInput.selectAll();
        }
        
    }

    public static void main(String[] args) {
        new Vista();
    }
}
