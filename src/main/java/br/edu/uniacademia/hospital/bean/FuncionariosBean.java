/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.EnderecosDao;
import br.edu.uniacademia.hospital.dao.FuncionariosDao;
import br.edu.uniacademia.hospital.dao.TipoFuncionarioDAO;
import br.edu.uniacademia.hospital.model.Enderecos;
import br.edu.uniacademia.hospital.model.Funcionarios;
import br.edu.uniacademia.hospital.model.TipoFuncionario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author igorcooli
 */
@Named
@ViewScoped
public class FuncionariosBean implements Serializable {
    Funcionarios funcionarios = new Funcionarios();

    List funcionariosList = new ArrayList();
    
    String enderecoId;
    
    String tipoFuncionario;
    
    Long funcionarioId;
    

    public FuncionariosBean() {
        funcionariosList = new FuncionariosDao().buscarTodas();
        funcionarios = new Funcionarios();
        tipoFuncionario = "";
        enderecoId = "";
        funcionarioId = funcionarios.getIdFuncionario();
    }
    
    
    public void salvar(ActionEvent actionEvent) {
        
        Enderecos endereco = new Enderecos();
        TipoFuncionario tipo = new TipoFuncionario();
        
        //endereco = new EnderecosDao().buscarPorId(enderecoId);
        
        //tipo = new TipoFuncionarioDAO().buscar(enderecoId);
        
        
        funcionarios.setEnderecosidEnderecos(new EnderecosDao().buscarPorId(enderecoId));
        funcionarios.setTipoFuncionarioidtipoFuncionario(new TipoFuncionarioDAO().buscarPorId(tipoFuncionario));
        
        new FuncionariosDao().persistir(funcionarios);
        
        funcionariosList = new FuncionariosDao().buscarTodas();
        funcionarios = new FuncionariosDao().buscar(enderecoId);
        
    }

    public void remover(ActionEvent actionEvent) {
        new FuncionariosDao().remover(funcionarioId);
        funcionariosList = new FuncionariosDao().buscarTodas();
        funcionarios = new Funcionarios();
    }

    public Funcionarios getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List getAllFuncionarios() {
        return funcionariosList;
    }

    public void setAllFuncionarios(List funcionariosList) {
        this.funcionariosList = funcionariosList;
    }

    public String getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(String enderecoId) {
        this.enderecoId = enderecoId;
    }

    public String getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(String tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }
    
    
    
}
