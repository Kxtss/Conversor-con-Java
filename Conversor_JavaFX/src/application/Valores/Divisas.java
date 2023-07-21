package application.Valores;

/**
 * Enum que representa diferentes divisas y sus tasas de cambio respecto
 * al dolar estadounidense (USD).
 * 
 * Esta enumeracion proporciona las tasas de cambio para las siguientes divisas:
 * 
 * <ul>
 * <li> Dolar estadounidense (USD)</li>
 * <li> Peso mexicano (MXN)</li>
 * <li> Euro (EUR)</li>
 * <li> Libra esterlina (GBP)</li>
 * <li> Yen japones (JPY)</li>
 * <li> Won surcoreano (KRW)</li>
 * </ul>
 * 
 * <em>Cada divisa tiene asociada una tasa de cambio respecto al dolar
 * estadounidense, la cual se utiliza para realizar conversiones entre las
 * diferentes monedas</em>.
 * 
 * <strong>Fecha y hora de cuando se introdujo el valor de las divisas: 20-07-2023 10:20:16</strong>
 * 
 * @since version 1.0
 * @author Marco CU
 */
public enum Divisas {
	/**
	 * Representa el dolar estadounidense (USD) con una tasa de cambio de 1.0, <strong>ya
	 * que es la moneda base</strong>.
	 */
	USD(1),

	/**
	 * Representa el peso mexicano (MXN) con una tasa de cambio de 0.0597, respecto
	 * al dolar estadounidense (USD).
	 */
	MXN(0.0594),

	/**
	 * Representa el euro (EUR) con una tasa de cambio de 1.1236, respecto al dolar
	 * estadounidense (USD).
	 */
	EUR(1.1132),

	/**
	 * Representa la libra esterlina (GBP) con una tasa de cambio de 1.3091,
	 * respecto al dolar estadounidense (USD).
	 */
	GBP(1.2848),

	/**
	 * Representa el yen japones (JPY) con una tasa de cambio de 0.0072, respecto al
	 * dolar estadounidense (USD).
	 */
	JPY(0.0071),

	/**
	 * Representa el won surcoreano (KRW) con una tasa de cambio de 0.00079,
	 * respecto al dolar estadounidense (USD).
	 */
	KRW(0.00078);

	private double tasaDeCambio;
	
	/**
	 * Constructor privado para el enum Divisas.
	 * 
	 * @param tasaDeCambio La tasa de cambio respecto al dolar estadounidense (USD).
	 * @since version 1.0
	 */
	private Divisas(double tasaDeCambio) {
		this.tasaDeCambio = tasaDeCambio;
	}

	/**
	 * Obtiene la tasa de cambio respecto al dolar estadounidense (USD) para la divisa especifica.
	 * 
	 * @return La tasa de cambio respecto al dolar estadounidense (USD).
	 * @since version 1.0
	 */
	public double getTasaDeCambio() {
		return tasaDeCambio;
	}
}
