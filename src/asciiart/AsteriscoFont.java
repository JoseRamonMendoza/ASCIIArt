package asciiart;

/**
 *
 * @author jr199
 */
public class AsteriscoFont implements Font {

    private final int H = 5;
    private final String _a = " #  ,# # ,### ,# # ,# # ";
    private final String _b = "##  ,# # ,##  ,# # ,##  ";
    private final String _c = " ## ,#   ,#   ,#   , ## ";
    private final String _d = "##  ,# # ,# # ,# # ,##  ";
    private final String _e = "### ,#   ,##  ,#   ,### ";
    private final String _f = "### ,#   ,##  ,#   ,#   ";
    private final String _g = " ## ,#   ,# # ,# # , ## ";
    private final String _h = "# # ,# # ,### ,# # ,# # ";
    private final String _i = "### , #  , #  , #  ,### ";
    private final String _j = "##  ,  # ,  # ,# # , #  ";
    private final String _k = "# # ,# # ,##  ,# # ,# # ";
    private final String _l = "#   ,#   ,#   ,#   ,### ";
    private final String _m = "# # ,### ,### ,# # ,# # ";
    private final String _n = "### ,# # ,# # ,# # ,# # ";
    private final String _o = " #  ,# # ,# # ,# # , #  ";
    private final String _p = "##  ,# # ,##  ,#   ,#   ";
    private final String _q = " #  ,# # ,# # , ## ,  # ";
    private final String _r = "##  ,# # ,##  ,# # ,# # ";
    private final String _s = " ## ,#   , #  ,  # ,##  ";
    private final String _t = "### , #  , #  , #  , #  ";
    private final String _u = "# # ,# # ,# # ,# # ,### ";
    private final String _v = "# # ,# # ,# # ,# # , #  ";
    private final String _w = "# # ,# # ,### ,### ,# # ";
    private final String _x = "# # ,# # , #  ,# # ,# # ";
    private final String _y = "# # ,# # , #  , #  , #  ";
    private final String _z = "### ,  # , #  ,#   ,### ";
    private final String interrogacion = "### ,  # , ## ,    , #  ";
    private final String espacio = "    ,    ,    ,    ,    ";
    private final String coma = "    ,    ,    , #  ,#   ,";
    private final String punto = "    ,    ,    ,    ,#   ";

    @Override
    public StringBuffer _ConvertirTexto(String textoEntrada) {
        StringBuffer textoSalida = new StringBuffer();
        String parts[];
        for (int j = 0; j < H; j++) {
            for (int i = 0; i < textoEntrada.length(); i++) {
                switch (textoEntrada.charAt(i)) {
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
                    case 120:
                        parts = _w.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 88:
                    case 121:
                        parts = _x.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 89:
                    case 122:
                        parts = _y.split(",");
                        textoSalida.append(parts[j]);
                        break;
                    case 90:
                    case 123:
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
