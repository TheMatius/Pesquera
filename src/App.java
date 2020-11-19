import javax.swing.JOptionPane;

public class App {
    private static int idxPescado = 0;
    private static Pescado[] pescados = new Pescado[50];
    public static void main(String[] args) throws Exception {
        int opt;
        String[] options = {"Producción", "Ventas"};
        do {
            opt = JOptionPane.showOptionDialog(null, "Seleccione una opción",
                "Pesquera Frutos del Mar", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            // Produccion
            if (opt == 0) {
                produccion();
            } else {

            }
        } while (opt != -1);
        // System.out.println();
        
    }

    public static void produccion() {
        String[] options = {"Agregar un pescado", "Ver lista de pescados"};
        int opt;
        String tipoPescado, proveedor;
        float peso;
        int numLoteProveedor, numLotePropio, indiceCalidad;
        do {
            opt = JOptionPane.showOptionDialog(null, "Seleccione una acción",
                "Sistema de producción", JOptionPane.DEFAULT_OPTION, 
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (opt == 0) {
                if (idxPescado < pescados.length) {
                    tipoPescado = JOptionPane.showInputDialog("Ingresa el tipo de pescado.");
                    proveedor = JOptionPane.showInputDialog("Ingresa el nombre del proveedor.");
                    peso = Float.parseFloat(JOptionPane.showInputDialog("Ingresa el peso del pescado."));
                    numLoteProveedor = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el lote del proveedor."));
                    numLotePropio = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el lote propio."));
                    indiceCalidad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el indice de calidad."));
                    pescados[idxPescado] = new Pescado(tipoPescado, proveedor, peso, numLoteProveedor, numLotePropio, indiceCalidad);
                    idxPescado++;
                } else {
                    JOptionPane.showMessageDialog(null, "Ya no puedes agregar más pescados", "Inventario lleno", JOptionPane.ERROR_MESSAGE);
                }
            } else if (opt == 1) {
                if (idxPescado < 1) {
                    JOptionPane.showMessageDialog(null, "La lista se encuentra vacía.", "Lista de pescados", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String msg = String.format("%-20s | %-35s | %-20s | %-20s | %-20s",
                        "Pescado", "Proveedor", "Peso", "Número lote", "Indice de calidad");
                    for (int i = 0; i < idxPescado; i++) {
                        msg += "\n" + pescados[i].toString();
                    }
                    JOptionPane.showMessageDialog(null, msg, "Lista de pescados", JOptionPane.PLAIN_MESSAGE);
                }
            }
        } while (opt != -1);
    }
}
