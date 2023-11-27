package wmsctienda.wmsctienda.wmscRepositorios;

import org.springframework.stereotype.Repository;
import wmsctienda.wmsctienda.wmscModelos.wmscDetalleOrden;
import wmsctienda.wmsctienda.wmscModelos.wmscOrden;
import wmsctienda.wmsctienda.wmscModelos.wmscProducto;

import java.util.ArrayList;
import java.util.List;
@Repository
public class wmscDetalleRepositorio implements wmscInterfazRepositorio {

    public List<wmscDetalleOrden> wmscDetalleOrdenList = new ArrayList<>();
    public List<wmscProducto> wmscProductoList = new ArrayList<>();

    public List<wmscDetalleOrden> wmscDetalleOrdenListas(){
        return this.wmscDetalleOrdenList;
    }

    public List<wmscProducto> wmscProductoListas(){
        return this.wmscProductoList;
    }

    public wmscDetalleOrden wmscBuscarDetalleOrden(int wmscDetalleOredenID){
        wmscDetalleOrden wmscDetalleOrede = null;
        for (wmscDetalleOrden wmscDetalleOrdenBuscado:wmscDetalleOrdenList) {
            if(wmscDetalleOrdenBuscado.getWmscDetalleOrdenID() == wmscDetalleOredenID){
                wmscDetalleOrede = wmscDetalleOrdenBuscado;
            }
        }
        return wmscDetalleOrede;
    }

    @Override
    public void wmscAgregar(Object wmscObj) {
        wmscDetalleOrden wmscDetalleOrde = (wmscDetalleOrden) wmscObj;
        wmscDetalleOrdenList.add(wmscDetalleOrde);
    }

    public void wmscAgregarProducto(wmscProducto wmscProduct){
        wmscProductoList.add(wmscProduct);
    }

    @Override
    public void wmscEliminarPorID(int wmscID) {

    }

    @Override
    public void wmscActualizarPorId(Object wmscObj) {

    }
}
