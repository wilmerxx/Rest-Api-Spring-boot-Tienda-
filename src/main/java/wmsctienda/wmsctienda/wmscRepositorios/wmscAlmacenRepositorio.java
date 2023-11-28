package wmsctienda.wmsctienda.wmscRepositorios;

import org.springframework.stereotype.Repository;
import wmsctienda.wmsctienda.wmscModelos.wmscAlmacen;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class wmscAlmacenRepositorio  implements wmscInterfazRepositorio {
    List<wmscAlmacen> wmscAlmacenList = new ArrayList<>();
    public List<wmscAlmacen> wmscAlmacenListas(){
        return wmscAlmacenList;
    }
    public wmscAlmacen wmscBuscarPorId(int wmscid){
        wmscAlmacen wmscAlmacenBuscado = null;
        for (wmscAlmacen wmscAlmace: wmscAlmacenList) {
            if(wmscAlmace.getWmscAlmacenID() == wmscid){ wmscAlmacenBuscado = wmscAlmace;}
        }
        return wmscAlmacenBuscado;
    }
    @Override
    public void wmscAgregar(Object wmscObj) {
        wmscAlmacen wmscAlmace = (wmscAlmacen) wmscObj;
        this.wmscAlmacenList.add(wmscAlmace);
    }
    @Override
    public void wmscEliminarPorID(int wmscID) {
        wmscAlmacen wmscAlmace = wmscBuscarPorId(wmscID);
        if(wmscAlmace.getWmscAlmacenID() == wmscID){wmscAlmacenList.remove(wmscAlmace);}
    }
    @Override
    public void wmscActualizarPorId(Object wmscObj) {
        wmscAlmacen wmscAlmace = (wmscAlmacen) wmscObj;
        wmscAlmacen wmscAlmacenBuscado = wmscBuscarPorId(wmscAlmace.getWmscAlmacenID());
        if(!Objects.isNull(wmscAlmacenBuscado)){
            wmscAlmacenBuscado.setWmscAlmacenID(wmscAlmace.getWmscAlmacenID());
            wmscAlmacenBuscado.setWmscNombreAlmacen(wmscAlmace.getWmscNombreAlmacen());
        }
    }
}
