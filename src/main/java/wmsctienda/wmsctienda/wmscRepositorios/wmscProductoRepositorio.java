package wmsctienda.wmsctienda.wmscRepositorios;

import org.springframework.stereotype.Repository;
import wmsctienda.wmsctienda.wmscModelos.wmscProducto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class wmscProductoRepositorio implements wmscInterfazRepositorio {
    private List<wmscProducto> wmscListaProducto = new ArrayList<>();
    public List<wmscProducto> wmscListaProductos(){
        return this.wmscListaProducto;
    }
    @Override
    public void wmscAgregar(Object wmscObj) {
        wmscProducto wmscProduct = (wmscProducto) wmscObj;
        if(!Objects.isNull(wmscProduct)){this.wmscListaProducto.add(wmscProduct);}
    }
    public wmscProducto wmscBuscarPorID(int wmscID) {
        wmscProducto wmscProductBuscado = null;
        for (wmscProducto wmscProduc:wmscListaProducto) {
            if(wmscProduc.getWmscProductoID() == wmscID){wmscProductBuscado = wmscProduc;}
        }
        return wmscProductBuscado;
    }
    @Override
    public void wmscEliminarPorID(int wmscID) {
        wmscProducto wmscProduct = wmscBuscarPorID(wmscID);
        if(wmscProduct.getWmscProductoID() == wmscID){wmscListaProducto.remove(wmscProduct);}
    }
    @Override
    public void wmscActualizarPorId(Object wmscObj) {
        wmscProducto wmscProduct = (wmscProducto) wmscObj;
        wmscProducto wmscProductoBuscado =  wmscBuscarPorID(wmscProduct.getWmscProductoID());
        if(!Objects.isNull(wmscProductoBuscado)){
            wmscProductoBuscado.setWmscProductoID(wmscProduct.getWmscProductoID());
            wmscProductoBuscado.setWmscPrecio(wmscProduct.getWmscPrecio());
            wmscProductoBuscado.setWmscNombre(wmscProduct.getWmscNombre());
            wmscProductoBuscado.setWmscDepartamentoID(wmscProduct.getWmscDepartamentoID());
        }
    }

}
