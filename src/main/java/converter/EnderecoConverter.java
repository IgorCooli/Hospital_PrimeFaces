/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import br.edu.uniacademia.hospital.dao.EnderecosDao;
import br.edu.uniacademia.hospital.model.Enderecos;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author igorcooli
 */

@FacesConverter(value = "EnderecoConverter")
public class EnderecoConverter implements Converter, Serializable {

    private static final long serialVersionUID = 1L;

    public EnderecoConverter() {
        // TODO Auto-generated constructor stub
    }

    public Enderecos getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                return new EnderecosDao().buscarPorId(value);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw new ConverterException(
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Erro ao converter endereco!"));
            }
        } else {
            return null;
        }
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj != null) {
            return obj.toString();
        } else {
            return null;
        }
    }

}
