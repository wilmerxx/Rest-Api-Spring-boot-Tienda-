package wmsctienda.wmsctienda.wmscModelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class wmscOrden {
    private int wmscOrderID;
    private int wmscClienteID;
    private int wmscAlmacenID;
    private int wsmcCantidadVentas;
    private String wmscFechaIngreso;
    private String wmscTiempo;
    private List<wmscProducto> wmscProductosList;
    private wmscCliente wmscCliente;
    private wmscAlmacen wmscAlmacen;
}
