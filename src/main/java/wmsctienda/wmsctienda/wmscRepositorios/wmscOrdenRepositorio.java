package wmsctienda.wmsctienda.wmscRepositorios;

import org.springframework.stereotype.Repository;
import wmsctienda.wmsctienda.wmscModelos.wmscOrden;
import wmsctienda.wmsctienda.wmscModelos.wmscProducto;

import java.util.ArrayList;
import java.util.List;
@Repository
public class wmscOrdenRepositorio implements wmscInterfazRepositorio{

    List<wmscOrden> wmscOrdenList = new ArrayList<>();
    List<wmscProducto> wmscProductoList = new ArrayList<>();
    public List<wmscOrden> wmscOrdenLista(){ return this.wmscOrdenList;}

    public List<wmscProducto> wmscProductoList(){
        return this.wmscProductoList;
    }

    @Override
    public void wmscAgregar(Object wmscObj) {
        wmscOrden wmscOrde = (wmscOrden) wmscObj;
        wmscOrdenList.add(wmscOrde);
    }

    public wmscOrden wmscBuscarPorID(int wmscID) {
        wmscOrden wmscOrde = null;
        for (wmscOrden wmscOrdenBuscado:wmscOrdenList) {
            if(wmscOrdenBuscado.getWmscOrderID() == wmscID){
                wmscOrde = wmscOrdenBuscado;
            }
        }
        return wmscOrde;
    }

    @Override
    public void wmscEliminarPorID(int wmscID) {

    }

    @Override
    public void wmscActualizarPorId(Object wmscObj) {

    }
}
