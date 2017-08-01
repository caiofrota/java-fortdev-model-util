package br.com.fortdev.modelutil.exceptions;

/**
 * Primary key null exception.
 * 
 * @author Caio Frota <contato@caiofrota.com.br>
 * @version 1.0
 * @since 1.0
 */
public class PrimaryKeyNullException extends GenericModelException {

	private static final long serialVersionUID = -3476921541710731170L;

	public PrimaryKeyNullException() {
		super(ModelExceptionLevel.FAIL, "Primary key cannot be null");
	}

}
