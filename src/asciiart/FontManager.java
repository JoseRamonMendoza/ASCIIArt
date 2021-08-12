// Un cambio
package asciiart;

import asciiart.Fuentes.*;

/**
 *Clase que fungirá como controlador utilizando el patrón strategy para cambiar
 * entre fuentes
 * @author jr199
 */
public class FontManager {
    public static Fuente EscogerFont(int fontChoosed){
        Fuente font = new Asterisco();
        switch(fontChoosed){
            case 0:
                font = new Asterisco();
                break;
            case 1:
                font = new Blocks();
                break;
        }
        
        return font;
    }
    
}
