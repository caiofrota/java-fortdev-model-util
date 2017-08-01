package br.com.fortdev.modelutil.bundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

/**
 * Model bundle.
 * 
 * @author Caio Frota <contato@caiofrota.com.br>
 * @version 1.0
 * @since 1.0
 */
@Service
public class ModelBundle {

	@Autowired
	private ResourceBundleMessageSource resourceBundle;

	/**
	 * Find message with text and replace params.
	 * 
	 * @param text
	 *            Text to find.
	 * @param params
	 *            Params to replace.
	 * @return Message.
	 */
	public String message(String text, Object... params) {
		return resourceBundle.getMessage(text, params, null);
	}

}
