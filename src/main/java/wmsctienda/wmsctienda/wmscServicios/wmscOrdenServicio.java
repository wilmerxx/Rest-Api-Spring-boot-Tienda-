package wmsctienda.wmsctienda.wmscServicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wmsctienda.wmsctienda.wmscModelos.wmscOrden;
import wmsctienda.wmsctienda.wmscModelos.wmscProducto;
import wmsctienda.wmsctienda.wmscRepositorios.wmscOrdenRepositorio;

import java.util.ArrayList;
import java.util.List;
@Service
public class wmscOrdenServicio  implements wmscInterfazServicio{
    @Autowired
    wmscOrdenRepositorio wmscOrdenRepositori;

    public List<wmscOrden> wmscOrdenLista(){
        return this.wmscOrdenRepositori.wmscOrdenLista();
    }

    @Override
    public void wmscAgregar(Object wmscObj) {
        this.wmscOrdenRepositori.wmscAgregar(wmscObj);
    }

    //@Override
    public wmscOrden wmscBuscarPorID(int wmscID) {
        return this.wmscOrdenRepositori.wmscBuscarPorID(wmscID);
    }

    @Override
    public void wmscEliminarPorID(int wmscID) {

    }

    @Override
    public void wmscActualizarPorId(Object wmscObj) {

    }
}
