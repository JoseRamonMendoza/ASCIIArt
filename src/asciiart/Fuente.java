package asciiart;

/**
 *Interfaz común a todas las fuentes para que estas implementen el método
 * _ConvertirTexto, el cuál será la lógica completa para convertir 
 * e ingresar en un StringBuffer el texto que se le pase, cada tipografía 
 * puede tener sus variaciones, por eso se utiliza una interfaz
 * @author jr199
 * @since 1.0.0
 */
public interface Fuente {
    public StringBuffer _ConvertirTexto(String textoEntrada);
}
