package application.Valores;

/**
 * Enum que representa diferentes unidades de peso y masa y sus relaciones de
 * cambio con el <strong>gramo como unidad base</strong>.
 * 
 * <p>
 * Este enum proporciona las relaciones de cambio respecto al gramo
 * (Gramos) para las siguientes unidades de peso y masa:
 * </p>
 * <ul>
 * <li>Quilates</li>
 * <li>Miligramos</li>
 * <li>Centigramos</li>
 * <li>Decigramos</li>
 * <li>Gramos</li>
 * <li>Decagramos</li>
 * <li>Hectogramos</li>
 * <li>Kilogramo (Kilogramos)</li>
 * <li>Toneladas metricas (Toneladas_metricas)</li>
 * <li>Onzas</li>
 * <li>Libras</li>
 * <li>Piedra</li>
 * <li>Toneladas cortas (Toneladas_cortas)</li>
 * <li>Toneladas largas (Toneladas_largas)</li>
 * </ul>
 * 
 * <p>
 * Cada unidad de peso y masa tiene asociada una relacion de cambio con el
 * gramo, la cual se utiliza para realizar conversiones entre diferentes
 * unidades de peso y masa.
 * </p>
 * 
 * @since version 1.0
 * @author Marco CU
 */
public enum Pesos_Y_Masas {
	/**
	 * Representa un quilate. Es una medida de peso utilizada en gemologia. Equivale
	 * a 1.0 gramos.
	 */
	Quilates(1.0),

	/**
	 * Representa un miligramo. Equivale a 0.001 gramos.
	 */
	Miligramos(0.001),

	/**
	 * Representa un centigramo. Equivale a 0.01 gramos.
	 */
	Centigramos(0.01),

	/**
	 * Representa un decigramo. Equivale a 0.1 gramos.
	 */
	Decigramos(0.1),

	/**
	 * Representa un gramo. Es la unidad base de peso y masa.
	 */
	Gramos(1.0),

	/**
	 * Representa un decagramo. Equivale a 10.0 gramos.
	 */
	Decagramos(10.0),

	/**
	 * Representa un hectogramo. Equivale a 100.0 gramos.
	 */
	Hectogramos(100.0),

	/**
	 * Representa un kilogramo. Equivale a 1000.0 gramos.
	 */
	Kilogramo(1000.0),

	/**
	 * Representa una tonelada metrica. Equivale a 1000000.0 gramos.
	 */
	Toneladas_metricas(1000000.0),

	/**
	 * Representa una onza. Es una medida de peso utilizada en algunos paises.
	 * Equivale a 28.3495 gramos.
	 */
	Onzas(28.3495),

	/**
	 * Representa una libra. Es una medida de peso utilizada en algunos paises.
	 * Equivale a 453.592 gramos.
	 */
	Libras(453.592),

	/**
	 * Representa una piedra. Es una medida de peso utilizada en el sistema imperial
	 * britanico. Equivale a 6350.29 gramos.
	 */
	Piedra(6350.29),

	/**
	 * Representa una tonelada corta. Es una medida de peso utilizada en algunos
	 * paises. Equivale a 907185.0 gramos.
	 */
	Toneladas_cortas(907185.0),

	/**
	 * Representa una tonelada larga. Es una medida de peso utilizada en algunos
	 * paises. Equivale a 1016047.0 gramos.
	 */
	Toneladas_largas(1016047.0);

	private double pesoMasaCambio;

	/**
	 * Crea una nueva instancia de una unidad de peso y masa con la relacion de
	 * cambio especificada respecto al gramo.
	 * 
	 * @param pesoMasaCambio La relacion de cambio respecto al gramo.
	 * @since version 1.0
	 */
	Pesos_Y_Masas(double pesoMasaCambio) {
		this.pesoMasaCambio = pesoMasaCambio;
	}

	/**
	 * Obtiene la relacion de cambio de la unidad de peso y masa respecto al gramo.
	 * 
	 * @return La relacion de cambio respecto al gramo.
	 * @since version 1.0
	 */
	public double getPesoMasaCambio() {
		return pesoMasaCambio;
	}

	/**
	 * Busca una unidad de peso y masa por su nombre y devuelve la instancia
	 * correspondiente.
	 * 
	 * @param nombre El nombre de la unidad de peso y masa.
	 * @return La instancia de la unidad de peso y masa correspondiente, o
	 *         {@code null} si no se encuentra ninguna coincidencia.
	 * @since version 1.0
	 */
	public static Pesos_Y_Masas buscarPorNombre(String nombre) {
		for (Pesos_Y_Masas pesoMasa : values()) {
			if (pesoMasa.name().equalsIgnoreCase(nombre.replace(" ", "_"))) {
				return pesoMasa;
			}
		}
		return null;
	}
}