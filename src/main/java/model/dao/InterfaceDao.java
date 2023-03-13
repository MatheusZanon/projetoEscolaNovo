/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;
import java.util.List;
/**
 *
 * @author annak
 */
public interface InterfaceDao<Registro> {
    
    public abstract void incluir(Registro entidade) throws Exception;

    public abstract void editar(Registro entidade) throws Exception;

    public abstract void excluir(Registro entidade) throws Exception;

    public abstract Registro pesquisarPorId(int id) throws Exception;
    
    public abstract List<Registro> filtragem(String filtro) throws Exception;

    public abstract List<Registro> listar() throws Exception;
    
}


