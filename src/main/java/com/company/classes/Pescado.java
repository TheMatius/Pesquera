package main.java.com.company.classes;

public class Pescado {
    private String nombre, proveedor, empleado;
    private float peso;
    private int numLoteProveedor, numLotePropio, indiceCalidad;

    public Pescado(String nombre, String proveedor, String empleado, float peso, int numLoteProveedor,
			int numLotePropio, int indiceCalidad) {
		this.nombre = nombre;
		this.proveedor = proveedor;
		this.empleado = empleado;
		this.peso = peso;
		this.numLoteProveedor = numLoteProveedor;
		this.numLotePropio = numLotePropio;
		this.indiceCalidad = indiceCalidad;
	}

    @Override
    public String toString() {
        return String.format("%-20s | %-10.1f | %-20d | %-20d | %-25s",
            nombre, peso, numLotePropio, indiceCalidad, proveedor);
    }
}