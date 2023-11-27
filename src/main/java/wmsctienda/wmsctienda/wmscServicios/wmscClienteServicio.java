package wmsctienda.wmsctienda.wmscServicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wmsctienda.wmsctienda.wmscModelos.wmscCliente;
import wmsctienda.wmsctienda.wmscRepositorios.wmscClienteRepositorio;

import java.util.ArrayList;
import java.util.List;
@Service
public class wmscClienteServicio implements wmscInterfazServicio{

    @Autowired
    private wmscClienteRepositorio wmscClienteRepositori;
    public List<wmscCliente> wmscClienteListes(){
        return  wmscClienteRepositori.wmscClienteListas();
    }

    public wmscCliente wmscBuscarPorID(int wmscID) {
        return wmscClienteRepositori.wmscBuscarPorID(wmscID);
    }

    @Override
    public void wmscAgregar(Object wmscObj) {
    wmscClienteRepositori.wmscAgregar(wmscObj);
    }

    @Override
    public void wmscEliminarPorID(int wmscID) {
    wmscClienteRepositori.wmscEliminarPorID(wmscID);
    }

    @Override
    public void wmscActualizarPorId(Object wmscObj) {
    wmscClienteRepositori.wmscActualizarPorId(wmscObj);
    }
}
