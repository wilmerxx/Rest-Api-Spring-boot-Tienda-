package wmsctienda.wmsctienda.wmscServicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wmsctienda.wmsctienda.wmscModelos.wmscProducto;
import wmsctienda.wmsctienda.wmscRepositorios.wmscProductoRepositorio;

import java.util.List;
@Service
public class wmscProductoServicio implements wmscInterfazServicio {

    @Autowired
    wmscProductoRepositorio wmscProductoRepo;
    public List<wmscProducto> wmscProductoList(){
        return wmscProductoRepo.wmscListaProductos();
    }

    @Override
    public void wmscAgregar(Object wmscObj) {
        this.wmscProductoRepo.wmscAgregar(wmscObj);

    }

    //@Override
    public wmscProducto wmscBuscarPorID(int wmscID) {
        return wmscProductoRepo.wmscBuscarPorID(wmscID);
    }

    @Override
    public void wmscEliminarPorID(int wmscID) {
        wmscProductoRepo.wmscEliminarPorID(wmscID);
    }

    @Override
    public void wmscActualizarPorId(Object wmscObj) {
        wmscProductoRepo.wmscActualizarPorId(wmscObj);
    }
}
