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
		id = id.toUpperCase();
		if (!DNIValido(id)) {
			throw new DNIException("Documento de identificación inválido");
		} else {
			this.id = id;
		}
	}

	public boolean compareTo(Handler handler) {
		// TODO Auto-generated method stub
		return toString().equals(handler.toString());
		
	}

	@Override
	public String toString() {
		return id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private boolean DNIValido(String nif) {
		StringBuilder aux;
		// Si es NIE, eliminar letra inicial para tratarlo como NIF
		/*
		 * Para el cálculo del dígito de control se sustituye:
		 * 
		 * X → 0 Y → 1 Z → 2 y se aplica el mismo algoritmo que para el NIF.
		 * http://www.interior.gob.es/web/servicios-al-ciudadano/dni/calculo-del
		 * -digito-de-control-del-nif-nie
		 */
		if (nif.startsWith("L") || nif.startsWith("K") || nif.startsWith("M"))
			nif = nif.substring(1);
		else if (nif.startsWith("X")) {
			aux = new StringBuilder(nif);
			aux.setCharAt(0, '0');
			nif = aux.toString();
		} else if (nif.startsWith("Y")) {
			aux = new StringBuilder(nif);
			aux.setCharAt(0, '1');
			nif = aux.toString();
		} else if (nif.startsWith("Z")) {
			aux = new StringBuilder(nif);
			aux.setCharAt(0, '2');
			nif = aux.toString();
		}
		System.out.println("nif resultante ->>>>" + nif);
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
