package asciiart.Fuentes;

import asciiart.Fuente;

/**
 *Clase que funciona como uno de los modelos, una tipografía de letra
 * Implementa al interfaz fuente que solo tiene un método _ConvertirTexto
 * esto se hace para implementar el patrón de diseño Estrategy
 * @author jr199
 * @since 1.0.0
 */
public class Avatar implements Fuente {
    //cada clase debe de tener su altura representada por alturaLentra
    //y las letras que soporta así como caracteres especiales
    private final int alturaLentra = 6;
    private final String _a = " ____ ," 
            +"/  _ \\," 
            +"| / \\|," 
            +"| |-||," 
            +"\\_/ \\|,"
            + "      ";
    private final String _b = " ____ ," +
"/  _ \\," +
"| | //," +
"| |_\\\\," +
"\\____/,"
            + "      ";
    private final String _c = " ____ ," +
"/   _\\," +
"|  /  ," +
"|  \\_ ," +
"\\____/,"
            + "      ";
    private final String _d = " ____ ," +
"/  _ \\," +
"| | \\|," +
"| |_/|," +
"\\____/,"
            + "      ";
    private final String _e = " _____," +
"/  __/," +
"|  \\  ," +
"|  /_ ," +
"\\____\\,"
            + "      ";
    private final String _f = " _____," +
"/    /," +
"|  __\\," +
"| |   ," +
"\\_/   ,"
            + "      ";
    private final String _g = " _____," +
"/  __/," +
"| |  _," +
"| |_//," +
"\\____\\,"
            + "      ";
    private final String _h = " _    ," +
"/ \\ /|," +
"| |_||," +
"| | ||," +
"\\_/ \\|,"
            + "      ";
    private final String _i = " _ ," +
"/ \\," +
"| |," +
"| |," +
"\\_/,"
            + "      ";
    private final String _j = "    _ ," +
"   / |," +
"   | |," +
"/\\_| |," +
"\\____/,"
            + "      ";
    private final String _k = " _  __," +
"/ |/ /," +
"|   / ," +
"|   \\ ," +
"\\_|\\_\\,"
            + "      ";
    private final String _l = " _    ," +
"/ \\   ," +
"| |   ," +
"| |_/\\," +
"\\____/,"
            + "      ";
    private final String _m = " _     ," +
"/ \\__/|," +
"| |\\/||," +
"| |  ||," +
"\\_/  \\|,"
            + "      ";
    private final String _n = " _     ," +
"/ \\  /|," +
"| |\\ ||," +
"| | \\||," +
"\\_/  \\|,"
            + "      ";
    private final String _o = " ____ ," +
"/  _ \\," +
"| / \\|," +
"| \\_/|," +
"\\____/,"
            + "      ";
    private final String _p = " ____ ," +
"/  __\\," +
"|  \\/|," +
"|  __/," +
"\\_/   ,"
            + "      ";
    private final String _q = " ____ ," +
"/  _ \\," +
"| / \\|," +
"| \\_\\|," +
"\\____\\,"
            + "      ";
    private final String _r = " ____ ," +
"/  __\\," +
"|  \\/|," +
"|    /," +
"\\_/\\_\\,"
            + "      ";
    private final String _s = " ____ ," +
"/ ___\\," +
"|    \\," +
"\\___ |," +
"\\____/,"
            + "      ";
    private final String _t = " _____ ," +
"/__ __\\," +
"  / \\  ," +
"  | |  ," +
"  \\_/  ,"
            + "      ";
    private final String _u = " _    ," +
"/ \\ /\\," +
"| | ||," +
"| \\_/|," +
"\\____/,"
            + "      ";
    private final String _v = " _    ," +
"/ \\ |\\," +
"| | //," +
"| \\// ," +
"\\__/  ,"
            + "      ";
    private final String _w = " _     ," +
"/ \\  /|," +
"| |  ||," +
"| |/\\||," +
"\\_/  \\|,"
            + "      ";
    private final String _x = "___  _," +
"\\  \\//," +
" \\  / ," +
" /  \\ ," +
"/__/\\\\,"
            + "      ";
    private final String _y = "___  _," +
"\\  \\//," +
" \\  / ," +
" / /  ," +
"/_/   ,"
            + "      ";
    private final String _z = " ____ ," +
"/_   \\," +
" /   /," +
"/   /_," +
"\\____/,"
            + "      ";
    private final String interrogacion = " ____ ," +
"/ _  \\," +
"\\/ \\ |," +
"   / /," +
"   \\/ ," +
"   \\/ ,"
            + "      "; 
    private final String espacio = "  ,  ,  ,  ,  ,  ";
    private final String coma = "  ," +
"  ," +
"  ," +
" _," +
"|/,"
            + "      ";
    private final String punto = "  ," +
"  ," +
"  ," +
"__," +
"\\/,"
            + "      ";

    /**
     * Para convertir el texto a ascii art primero se ingresan los caracteres
     * con los caracteres a convertir se hace un bucle de la altura de la letra
     * después, otro bucle de longitud del texto dentro del primero,
     * el segundo bucle revisará el texto ingresado letra por letra, y sumara al texto de salida
     * la primera fila del texto.
     * 
     * Para cada caso, se revisa la letra ingresada con us switch, se compara con su número ascii
     * y después se hace un array de esa letra, cada elemento del array es una fila 
     * de esa letra, el array se hace con un split tomando las variables de la clase
     * @param textoEntrada El texto a convertir
     * @return StringBuffer el texto convertiro a ascii con la tipografía de la clase
     * @since 1.0.0
     */
    @Override
    public StringBuffer _ConvertirTexto(String textoEntrada) {
        StringBuffer textoSalida = new StringBuffer();
        String parts[];
        for (int j = 0; j < alturaLentra; j++) {
            for (int i = 0; i < textoEntrada.length(); i++) {
                switch (textoEntrada.charAt(i)) {
                    case 10:
                        break;
                    case 32:
                        parts = espacio.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 44:
                        parts = coma.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 46:
                        parts = punto.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 65:
                    case 97:
                        parts = _a.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 66:
                    case 98:
                        parts = _b.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 67:
                    case 99:
                        parts = _c.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 68:
                    case 100:
                        parts = _d.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 69:
                    case 101:
                        parts = _e.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 70:
                    case 102:
                        parts = _f.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 71:
                    case 103:
                        parts = _g.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 72:
                    case 104:
                        parts = _h.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 73:
                    case 105:
                        parts = _i.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 74:
                    case 106:
                        parts = _j.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 75:
                    case 107:
                        parts = _k.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 76:
                    case 108:
                        parts = _l.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 77:
                    case 109:
                        parts = _m.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 78:
                    case 110:
                        parts = _n.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 79:
                    case 111:
                        parts = _o.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 80:
                    case 112:
                        parts = _p.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 81:
                    case 113:
                        parts = _q.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 82:
                    case 114:
                        parts = _r.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 83:
                    case 115:
                        parts = _s.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 84:
                    case 116:
                        parts = _t.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 85:
                    case 117:
                        parts = _u.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 86:
                    case 118:
                        parts = _v.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 87:
                    case 119:
                        parts = _w.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 88:
                    case 120:
                        parts = _x.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 89:
                    case 121:
                        parts = _y.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 90:
                    case 122:
                        parts = _z.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    default:
                        parts = interrogacion.split(",");
                        textoSalida.append(parts[j]);
                        break;
                }//fin switch
            }//fin for i
            textoSalida.append("\n");

        }//fin for j
        return textoSalida;
    }
}
