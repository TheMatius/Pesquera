public class Pescado {
    private String tipoPescado, proveedor;
    private float peso;
    private int numLoteProveedor, numLotePropio, indiceCalidad;

    public Pescado(String tipoPescado, String proveedor, float peso, int numLoteProveedor, int numLotePropio,
            int indiceCalidad) {
        this.tipoPescado = tipoPescado;
        this.proveedor = proveedor;
        this.peso = peso;
        this.numLoteProveedor = numLoteProveedor;
        this.numLotePropio = numLotePropio;
        this.indiceCalidad = indiceCalidad;
    }

    public String getTipoPescado() {
        return tipoPescado;
    }

    public void setTipoPescado(String tipoPescado) {
        this.tipoPescado = tipoPescado;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getNumLoteProveedor() {
        return numLoteProveedor;
    }

    public void setNumLoteProveedor(int numLoteProveedor) {
        this.numLoteProveedor = numLoteProveedor;
    }

    public int getNumLotePropio() {
        return numLotePropio;
    }

    public void setNumLotePropio(int numLotePropio) {
        this.numLotePropio = numLotePropio;
    }

    public int getIndiceCalidad() {
        return indiceCalidad;
    }

    public void setIndiceCalidad(int indiceCalidad) {
        this.indiceCalidad = indiceCalidad;
    }

    @Override
    public String toString() {
        return String.format("%-20s | %-35s | %-20.1f | %-20d | %-20d",
            tipoPescado, proveedor, peso, numLotePropio, indiceCalidad);
    }
}
