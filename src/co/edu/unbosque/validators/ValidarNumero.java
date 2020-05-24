package co.edu.unbosque.validators;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.mysql.cj.util.StringUtils;

@FacesValidator("validarNumero")
public class ValidarNumero implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		
		String valor = arg2.toString();
		
		if (StringUtils.isStrictlyNumeric(valor)) {
			//nada
		}else {
			FacesMessage msg = new FacesMessage("El número es inválido");
			throw new ValidatorException(msg);
		}

	}

}