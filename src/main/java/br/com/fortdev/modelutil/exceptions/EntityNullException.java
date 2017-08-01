package br.com.fortdev.modelutil.exceptions;

/**
 * Entity null exception.
 * 
 * @author Caio Frota <contato@caiofrota.com.br>
 * @version 1.0
 * @since 1.0
 */
public class EntityNullException extends GenericModelException {

	private static final long serialVersionUID = -3476921541710731170L;

	public EntityNullException() {
		super(ModelExceptionLevel.FAIL, "Entity cannot be null");
	}

}
