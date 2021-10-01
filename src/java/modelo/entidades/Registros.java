
package modelo.entidades;


public class Registros {
    private int idRegistros;
    private int cantidadProducto;
    private double precioTotalProducto;
    Producto producto = new Producto();
    
    Venta venta;
    public Registros() {
        
    }

    public Registros(int cantidadProducto, double precioTotalProducto) {
        this.cantidadProducto = cantidadProducto;
        this.precioTotalProducto = precioTotalProducto;
        
    }

    public Registros(int idRegistros) {
        this.idRegistros = idRegistros;
    }
    //producto = new Producto();
    public void setNombreProducto(String nombre){
         
         producto.setNombreProducto(nombre); 
    }
    public void setCodigoProducto(String nombre){
             
             producto.setCodigoProducto(nombre); 
    }
    public void setPrecioVentaProducto(Double precio){
             
             producto.setPrecioVenta(precio); 
    }
    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getPrecioTotalProducto() {
        return precioTotalProducto;
    }
   
    public void setPrecioTotalProducto(double precioTotalProducto) {
        this.precioTotalProducto = precioTotalProducto;
    }
     
    public void addProducto(Producto x){
        this.producto = x;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }



    public int getIdRegistros() {
        return idRegistros;
    }

    public void setIdRegistros(int idRegistrod) {
        this.idRegistros = idRegistros;
    }

    public Venta getVenta() {
        
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }       
    
}
