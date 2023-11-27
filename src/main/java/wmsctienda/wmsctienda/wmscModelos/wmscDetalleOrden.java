package wmsctienda.wmsctienda.wmscModelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class wmscDetalleOrden {
    private int wmscDetalleOrdenID;
    private int wmscOrdenID;
    private int wmscProductoID;
    private double wmscTotal;
    List<wmscProducto> wmscProductoList;
    wmscOrden wmscOrde;
}
