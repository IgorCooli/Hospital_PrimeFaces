/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.EnderecosDao;
import br.edu.uniacademia.hospital.model.Enderecos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author igorcooli
 */
@Named
@ViewScoped
public class EnderecosBean implements Serializable {
    Enderecos enderecos = new Enderecos();

    List enderecosList = new ArrayList();

    public EnderecosBean() {
        enderecosList = new EnderecosDao().buscarTodas();
        enderecos = new Enderecos();
    }

    public void salvar(ActionEvent actionEvent) {
        new EnderecosDao().persistir(enderecos);
        enderecosList = new EnderecosDao().buscarTodas();
        enderecos = new Enderecos();
    }

    public void remover(ActionEvent actionEvent) {
        new EnderecosDao().remover(enderecos);
        enderecosList = new EnderecosDao().buscarTodas();
        enderecos = new Enderecos();
    }

    public Map getAllOptions() {
        List<Enderecos> lista = getAllEnderecos();
        Map<Enderecos, String> map = new HashMap<Enderecos, String>();
        lista.stream().forEach((e)-> 
                map.put(e, e.getLogradouro() + ' ' + e.getNumero())
        );
        return map;
    }

    public Enderecos buscar(String localidade) {
        return enderecos;
    }
    
    public Enderecos buscarPorId(String id) {
        new EnderecosDao().remover(enderecos);
        enderecos = new EnderecosDao().buscarPorId(id);
        return enderecos;
    }

    public void setEnderecos(Enderecos enderecos) {
        this.enderecos = enderecos;
    }

    public List<Enderecos> getAllEnderecos() {
        return enderecosList;
    }

    public void setAllEnderecos(List enderecosList) {
        this.enderecosList = enderecosList;
    }

    public List getEnderecosList() {
        return enderecosList;
    }

    public void setEnderecosList(List enderecosList) {
        this.enderecosList = enderecosList;
    }
    
    public Enderecos getEnderecos(){
        return this.enderecos;
    }
    
}
