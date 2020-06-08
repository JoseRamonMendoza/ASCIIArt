package asciiart;

/**
 *
 * @author jr199
 */
public class Vista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String textoEntrada = "";

        Font font = FontManager.EscogerFont(1);
        StringBuffer texto = font._ConvertirTexto(textoEntrada);
        System.out.println(texto);
    }

}
