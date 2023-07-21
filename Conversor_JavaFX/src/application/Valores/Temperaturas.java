package application.Valores;

/**
 * Enum de temperaturas que contiene los tipos de temperaturas disponibles para
 * la conversion: Celsius, Fahrenheit y Kelvin.
 * 
 * Ademas, proporciona metodos de conversion para realizar las operaciones entre
 * los diferentes tipos de temperaturas.
 * 
 * @since version 1.0
 * @author Marco CU
 */
public enum Temperaturas {
	/**
	 * Representa una temperatura en grados Celsius.
	 */
	Celsius,

	/**
	 * Representa una temperatura en grados Fahrenheit.
	 */
	Fahrenheit,

	/**
	 * Representa una temperatura en grados Kelvin.
	 */
	Kelvin;

	/**
	 * Convierte una temperatura en grados Celsius a Fahrenheit.
	 * 
	 * @param celsius temperatura en grados Celsius a convertir.
	 * @return temperatura convertida a Fahrenheit.
	 * @since version 1.0
	 * @author Marco CU
	 */
	public static double celsiusToFahrenheit(double celsius) {
		return (celsius * 9 / 5) + 32;
	}

	/**
	 * Convierte una temperatura en grados Fahrenheit a Celsius.
	 * 
	 * @param fahrenheit temperatura en grados Fahrenheit a convertir.
	 * @return temperatura convertida a Celsius.
	 * @since version 1.0
	 * @author Marco CU
	 */
	public static double fahrenheitToCelsius(double fahrenheit) {
		return (fahrenheit - 32) * 5 / 9;
	}

	/**
	 * Convierte una temperatura en grados Celsius a Kelvin.
	 * 
	 * @param celsius temperatura en grados Celsius a convertir.
	 * @return temperatura convertida a Kelvin.
	 * @since version 1.0
	 * @author Marco CU
	 */
	public static double celsiusToKelvin(double celsius) {
		return celsius + 273.15;
	}

	/**
	 * Convierte una temperatura en grados Kelvin a Celsius.
	 * 
	 * @param kelvin temperatura en grados Kelvin a convertir.
	 * @return temperatura convertida a Celsius.
	 * @since version 1.0
	 * @author Marco CU
	 */
	public static double kelvinToCelsius(double kelvin) {
		return kelvin - 273.15;
	}

	/**
	 * Convierte una temperatura en grados Fahrenheit a Kelvin.
	 * 
	 * @param fahrenheit temperatura en grados Fahrenheit a convertir.
	 * @return temperatura convertida a Kelvin.
     * @since version 1.0
     * @author Marco CU
	 */
	public static double fahrenheitToKelvin(double fahrenheit) {
		double celsius = fahrenheitToCelsius(fahrenheit);
		return celsiusToKelvin(celsius);
	}

	/**
	 * Convierte una temperatura en grados Kelvin a Fahrenheit.
	 * 
	 * @param kelvin temperatura en grados Kelvin a convertir.
	 * @return temperatura convertida a Fahrenheit.
     * @since version 1.0
     * @author Marco CU
	 */
	public static double kelvinToFahrenheit(double kelvin) {
		double celsius = kelvinToCelsius(kelvin);
		return celsiusToFahrenheit(celsius);
	}
}
