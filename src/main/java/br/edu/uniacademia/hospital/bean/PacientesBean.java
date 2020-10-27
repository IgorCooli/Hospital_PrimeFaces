/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.EnderecosDao;
import br.edu.uniacademia.hospital.dao.PacientesDao;
import br.edu.uniacademia.hospital.model.Pacientes;
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
public class PacientesBean implements Serializable {
    
    Pacientes pacientes = new Pacientes();

    List pacientesList = new ArrayList();
        
    String enderecoId;
    
    String nomePaciente;
    
    String pacientesId;
    
    public PacientesBean() {
        pacientesList = new PacientesDao().buscarTodas();
        pacientes = new Pacientes();
        enderecoId = null;
        nomePaciente = null;
        pacientesId = null;
    }
    
    
    public void salvar(ActionEvent actionEvent) {        
        
        pacientes.setEndereco(new EnderecosDao().buscarPorId(enderecoId));
        
        new PacientesDao().persistir(pacientes);
        
        nomePaciente = pacientes.getNomePaciente();
        
        pacientesList = new PacientesDao().buscarTodas();
        pacientes = new PacientesDao().buscar(nomePaciente);
        
    }
    
    public void remover(ActionEvent actionEvent) {
        
        new PacientesDao().remover(Long.valueOf(pacientesId));
        
        pacientesList = new PacientesDao().buscarTodas();
        pacientes = new Pacientes();
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public List getAllPacientes() {
        return pacientesList;
    }

    public void setAllPacientes(List pacientesList) {
        this.pacientesList = pacientesList;
    }

    public String getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(String enderecoId) {
        this.enderecoId = enderecoId;
    }
    
    
    
}
