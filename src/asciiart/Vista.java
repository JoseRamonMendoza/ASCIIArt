package asciiart;

import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import java.util.EventListener;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;

/**
 * Clase que fungirá como vista para la aplicación
 * 
 * Se utiliza Swing para la UGI, implementa el método main,
 * La lógica del programa está encerrada por el patrón de diseño Estrategy
 * por lo que no es necesario cambiar casi nada para implementar otra tipografía
 * solo se agrega otro elemento a JComboBox
 *
 * @author jr199
 * @since 1.0.0
 */
public class Vista extends JFrame {

    private JLabel jlTexto;
    private JTextPane jtaOutput;
    private JTextField jtfInput;
    private JComboBox jcbFuente;

    private Border border;

    //En el constructor se define la creación de la vista
    public Vista() {
        //Definimos el titulo de la ventana
        super("AsciiArt");
        //Definimos el layout
        setLayout(new BorderLayout());

        //Definimos las funciones que armarán las partes del la ventana
        //Dos paneles uno en el norte y otro en el centro
        JPanel pNorte = crearNorte();
        add(pNorte, BorderLayout.NORTH);

        JPanel pSur = crearSur();
        add(pSur, BorderLayout.CENTER);

        //Creamos los listeners para los eventos
        addWindowListener(new CerrarVentana());
        jtfInput.addKeyListener(new ConvertirTexto());
        jcbFuente.addActionListener(new SelecionarFont());

        //Visibilidad, tamaño y posición de la ventana
        setLocation(100, 200);
        setVisible(true);
        setSize(1200, 320);

        //inicio la ventana con el foco en el text area
        jtfInput.requestFocus();
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
        jtfInput = new JTextField(50);
        jcbFuente = new JComboBox();

        //Agregamos las variables al panel 
        pNorte.add(jlTexto);
        pNorte.add(jtfInput);
        pNorte.add(jcbFuente);
        
        //Agregamos las opciones al JComboBox
        //<--Cuando se implemente otra tipografía esto es lo que se tendrá que cambiar
        //se tendrá que agregar otro Item con el nombre de esa tipografía-->
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
        jtaOutput = new JTextPane() {

            //Difinimos el scroll de panel como horizontal
            @Override
            public boolean getScrollableTracksViewportWidth() {
                return getUI().getPreferredSize(this).width
                        <= getParent().getSize().width;
            }

        };

        //Hacer que el scroll horizontal siempre esté activo
        JScrollPane scrollPane = new JScrollPane(jtaOutput);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        //Hacer que el scroll nunca se actualize y te regrese al principio cuando se ingresa texto
        DefaultCaret caret = (DefaultCaret) jtaOutput.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);

        //Cambiamos la fuente a Monospaced para que tenga el mismo ancho un espacio 
        //y un caracter
        Font fuente = new Font(Font.MONOSPACED, Font.PLAIN, 10);
        jtaOutput.setFont(fuente);

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

        //Los otros métodos vienen por la implementación de la interfaz
        //los dejamos vacíos
        @Override
        public void windowOpened(WindowEvent e) {
        }

        @Override
        public void windowClosed(WindowEvent e) {
        }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowActivated(WindowEvent e) {
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
        }
    }

    
    /**
     * Evento que convierte el texto
     *primero capturamos la fuente que esta selecionada en el JComboBox
     *con el index capturado pasa a la función EscogerFont lo que hace es 
     *escoger la fuente y lo guarda en una variable que implemente la interfaz
     *Fuente, se convierte el texto y luego se pasa al elemento que queremos que 
     *lo muestre
     * @since 1.0.0
     */
    class ConvertirTexto implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        //Cada regreso de presionar una letra...
        @Override
        public void keyReleased(KeyEvent e) {
            //capturo el index del la fuente seleccionada en el combo box
            int itemSelecionado = jcbFuente.getSelectedIndex();

            //<--Aquí se encierra la lógica del patrón Strategy-->
            //creo una variable del tipo de la interfaz y llamo su único método
            //común entre todas ellas
            //escogo la estrategia con el index capturado
            Fuente font = FontManager.EscogerFont(itemSelecionado);

            //capturo el texto de entrada
            String textoEntrada = jtfInput.getText();

            //convierto el texto de entrada con la estrategia capturada
            StringBuffer texto = font._ConvertirTexto(textoEntrada);

            //convierto el texto a un string
            String output = texto.toString();

            //imprimo el string
            jtaOutput.setText(output);

            //valido los elementos de la ventana
            validate();
        }
    }

    //Evento del combo box, cada que se seleciona una opción del combo
    //cambia el foco(cursor) al elemento de entrada de texto
    class SelecionarFont implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            jtfInput.requestFocus();
        }

    }

    public static void main(String[] args) {
        new Vista();
    }
}
