package wmsctienda.wmsctienda.wmscRepositorios;

public interface wmscInterfazRepositorio {
    public void wmscAgregar(Object wmscObj);
    //public Object wmscBuscarPorID(int wmscID);
    public void wmscEliminarPorID(int wmscID);

    public void wmscActualizarPorId(Object wmscObj);

}
