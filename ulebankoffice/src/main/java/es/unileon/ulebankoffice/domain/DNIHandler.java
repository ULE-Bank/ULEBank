/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Razvan Raducu
 *
 */
public class DNIHandler implements Handler {

	private String id;

	// La idea es que desde aquí se lance la excepción en caso de que el DNI sea
	// incorrecto y donde corresponda se capture para añadirlo al objeto Errors
	// que derivará en un hasErrors() de bindingResult
	public DNIHandler(String id) throws DNIException {
		if (!DNIValido(id)) {
			throw new DNIException("Documento de identificación inválido");
		} else {
			this.id = id;
		}
	}

	public boolean compareTo(Handler handler) {
		// TODO Auto-generated method stub
		// return toString().equals(handler.toString());
		return this.equals(handler);
	}

	@Override
	public String toString() {
		return "id";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private boolean DNIValido(String nif) {

		// Si es NIE, eliminar letra inicial para tratarlo como NIF
		if (nif.toUpperCase().startsWith("X") || nif.toUpperCase().startsWith("Y") || nif.toUpperCase().startsWith("Z")
				|| nif.toUpperCase().startsWith("L") || nif.toUpperCase().startsWith("K")
				|| nif.toUpperCase().startsWith("M"))
			nif = nif.substring(1);

		// Compruebo que el patrón con 7 u 8 dígitos del 0-9 seguidos de una
		// sola letra se cumple con la cadena "nif" resultante. Los paréntesis
		// se usan para definir grupos. El blackslash se debe escapar
		Pattern nifPattern = Pattern.compile("(\\d{7,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
		Matcher matcher = nifPattern.matcher(nif);

		if (matcher.matches()) {
			String letra = matcher.group(2);
			// Extraer letra del NIF
			String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
			int dni = Integer.parseInt(matcher.group(1));
			dni = dni % 23;
			String reference = letras.substring(dni, dni + 1);

			if (reference.equalsIgnoreCase(letra)) {
				return true;
			} else {
				return false;
			}
		} else
			return false;
	}

}
