package br.com.fortdev.modelutil.exceptions;

import br.com.fortdev.modelutil.bundle.ModelBundle;

/**
 * Generic model exception.
 * 
 * @author Caio Frota <contato@caiofrota.com.br>
 * @version 1.0
 * @since 1.0
 */
public class GenericModelException extends RuntimeException {

	private static final long serialVersionUID = 2753655245782069900L;

	private ModelExceptionLevel level;
	private Object[] params;

	public GenericModelException() {
		super();
	}

	public GenericModelException(ModelExceptionLevel level, String message) {
		super(message);
		this.level = level;
	}

	public GenericModelException(ModelExceptionLevel level, String message, Object... params) {
		this(level, message);
		this.params = params;
	}

	public ModelExceptionLevel getLevel() {
		return level;
	}

	public Object[] getParams() {
		return params;
	}

	/**
	 * Get exception message from resource bundle.
	 * 
	 * @param bundle
	 *            Resource bundle.
	 * @return Message.
	 */
	public String getMessage(ModelBundle bundle) {
		try {
			return bundle.message(this.getMessage(), this.getParams());
		} catch (Throwable e) {
			return this.getMessage();
		}
	}

}
