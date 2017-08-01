package br.com.fortdev.modelutil.exceptions;

/**
 * Model exception level.
 * 
 * @author Caio Frota <contato@caiofrota.com.br>
 * @version 1.0
 * @since 1.0
 */
public enum ModelExceptionLevel {

	GENERIC(0), INFO(1), WARNING(2), FAIL(3);

	private int level;

	private ModelExceptionLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

}
