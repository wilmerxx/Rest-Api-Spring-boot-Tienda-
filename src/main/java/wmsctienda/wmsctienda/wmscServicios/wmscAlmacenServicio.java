package wmsctienda.wmsctienda.wmscServicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wmsctienda.wmsctienda.wmscModelos.wmscAlmacen;
import wmsctienda.wmsctienda.wmscRepositorios.wmscAlmacenRepositorio;

import java.util.List;

@Service
public class wmscAlmacenServicio implements wmscInterfazServicio{
    @Autowired
    wmscAlmacenRepositorio wmscAlmacenRepositori;
    public List<wmscAlmacen> wmscAlmacenListas(){
        return wmscAlmacenRepositori.wmscAlmacenListas();
    }
    public wmscAlmacen wmscBuscarAlmacen(int wmscid){
        return wmscAlmacenRepositori.wmscBuscarPorId(wmscid);
    }
    @Override
    public void wmscAgregar(Object wmscObj) {
        wmscAlmacenRepositori.wmscAgregar(wmscObj);
    }

    @Override
    public void wmscEliminarPorID(int wmscID) {
        wmscAlmacenRepositori.wmscEliminarPorID(wmscID);
    }

    @Override
    public void wmscActualizarPorId(Object wmscObj) {
    wmscAlmacenRepositori.wmscActualizarPorId(wmscObj);
    }
}
