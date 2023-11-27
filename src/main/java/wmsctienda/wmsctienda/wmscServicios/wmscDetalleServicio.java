package wmsctienda.wmsctienda.wmscServicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wmsctienda.wmsctienda.wmscModelos.wmscDetalleOrden;
import wmsctienda.wmsctienda.wmscModelos.wmscProducto;
import wmsctienda.wmsctienda.wmscRepositorios.wmscDetalleRepositorio;

import java.util.List;
@Service
public class wmscDetalleServicio implements wmscInterfazServicio{
    @Autowired
    wmscDetalleRepositorio wmscDetalleRepositori;

    public List<wmscDetalleOrden> wmscDetalleOrdenList (){
        return wmscDetalleRepositori.wmscDetalleOrdenListas();
    }

    public List<wmscProducto> wmscProductoList(){
        return wmscDetalleRepositori.wmscProductoListas();
    }

    public wmscDetalleOrden wmscBuscarDetallePorID(int wmscDetalleID){
        return wmscDetalleRepositori.wmscBuscarDetalleOrden(wmscDetalleID);
    }

    @Override
    public void wmscAgregar(Object wmscObj) {
        wmscDetalleRepositori.wmscAgregar(wmscObj);
    }

    public void wmscAgregarProducto (wmscProducto wmscProduct){
        wmscDetalleRepositori.wmscAgregarProducto(wmscProduct);
    }

    @Override
    public void wmscEliminarPorID(int wmscID) {

    }

    @Override
    public void wmscActualizarPorId(Object wmscObj) {

    }
}
