package wmsctienda.wmsctienda.wmscRepositorios;
import org.springframework.stereotype.Repository;
import wmsctienda.wmsctienda.wmscModelos.wmscCliente;
import wmsctienda.wmsctienda.wmscModelos.wmscProducto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Repository
public class wmscClienteRepositorio implements wmscInterfazRepositorio{
    List<wmscCliente> wmscClienteList = new ArrayList<>();
    public List<wmscCliente> wmscClienteListas(){
        return wmscClienteList;
    }
    @Override
    public void wmscAgregar(Object wmscObj) {
        wmscCliente wmscClient = (wmscCliente) wmscObj;
        wmscClienteList.add(wmscClient);
    }
    public wmscCliente wmscBuscarPorID(int wmscID) {
        wmscCliente wmscClientBuscado = null;
        for (wmscCliente wmscClient:wmscClienteList) {
            if(wmscClient.getWmscClienteID() == wmscID){wmscClientBuscado = wmscClient;}
        }
        return wmscClientBuscado;
    }

    public void wmscEliminarPorID(int wmscID) {
        wmscCliente wmscClient = wmscBuscarPorID(wmscID);
        if(wmscClient.getWmscClienteID() == wmscID){wmscClienteList.remove(wmscClient);}
    }
    @Override
    public void wmscActualizarPorId(Object wmscObj) {
        wmscCliente wmscClient = (wmscCliente) wmscObj;
        wmscCliente wmscClienteBuscado =  wmscBuscarPorID(wmscClient.getWmscClienteID());
        if(!Objects.isNull(wmscClienteBuscado)){
            wmscClienteBuscado.setWmscClienteID(wmscClient.getWmscClienteID());
            wmscClienteBuscado.setWmscNombresCompletos(wmscClient.getWmscNombresCompletos());
        }
    }
}
