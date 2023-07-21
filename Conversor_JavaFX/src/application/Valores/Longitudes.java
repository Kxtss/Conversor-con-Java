package application.Valores;

/**
 * Enum que representa diferentes unidades de longitud y sus relaciones de cambio
 * con el <strong>metro como unidad base</strong>.
 * 
 * <p>Esta enumeracion proporciona las relaciones de cambio respecto al metro (Metros) para las siguientes unidades de longitud:</p>
 * <ul>
 * <li>Nanometros</li>
 * <li>Micrones</li>
 * <li>Milimetros</li>
 * <li>Centimetros</li>
 * <li>Metros</li>
 * <li>Kilometros</li>
 * <li>Pulgadas</li>
 * <li>Pies</li>
 * <li>Yardas</li>
 * <li>Millas terrestres (Millas)</li>
 * <li>Millas nauticas (Millas_Nauticas)</li>
 * </ul>
 * 
 * <p>Cada unidad de longitud tiene asociada una relacion de cambio con el metro,
 * la cual se utiliza para realizar conversiones entre diferentes unidades de longitud.</p>
 * 
 * @since version 1.0
 * @author Marco CU
 */
public enum Longitudes {
    /**
     * Representa un nanometro. Equivale a 1e-9 metros.
     */
    Nanometros(1e-9),
    
    /**
     * Representa un micrometro. Equivale a 1e-6 metros.
     */
    Micrones(1e-6),
    
    /**
     * Representa un milimetro. Equivale a 0.001 metros.
     */
    Milimetros(0.001),
    
    /**
     * Representa un centimetro. Equivale a 0.01 metros.
     */
    Centimetros(0.01),
    
    /**
     * Representa un metro. Es la unidad base de longitud.
     */
    Metros(1),
    
    /**
     * Representa un kilometro. Equivale a 1000 metros.
     */
    Kilometros(1000),
    
    /**
     * Representa una pulgada. Equivale a 0.0254 metros.
     */
    Pulgadas(0.0254),
    
    /**
     * Representa un pie. Equivale a 0.3048 metros.
     */
    Pies(0.3048),
    
    /**
     * Representa una yarda. Equivale a 0.9144 metros.
     */
    Yardas(0.9144),
    
    /**
     * Representa una milla terrestre. Equivale a 1609.34 metros.
     */
    Millas(1609.34),
    
    /**
     * Representa una milla nautica. Equivale a 1852 metros.
     */
    Millas_Nauticas(1852);

    private double longitudCambio;

    /**
     * Crea una nueva instancia de una longitud con la relacion de cambio especificada respecto al metro.
     * 
     * @param longitudCambio La relacion de cambio con el metro.
     * @since version 1.0
     */
    Longitudes(double longitudCambio) {
        this.longitudCambio = longitudCambio;
    }

    /**
     * Obtiene la relacion de cambio de la longitud respecto al metro.
     * 
     * @return La relacion de cambio con el metro.
     * @since version 1.0
     */
    public double getLongitudCambio() {
        return longitudCambio;
    }

    /**
     * Busca una longitud por su nombre en formato String y devuelve la instancia del enum correspondiente.
     * 
     * <p>Este metodo permite coincidir los nombres utilizados en los Array de {@code ControllerConversorLongitud}
     * con los nombres de los elementos de este enum {@code Longitudes}.</p>
     * 
     * <p>El nombre de la longitud en el parametro debe estar en formato String y puede contener espacios o guiones bajos.
     * El metodo realiza la comparacion ignorando mayusculas y minusculas, y reemplaza los espacios por guiones bajos
     * para que coincida con el formato de este enum.</p>
     * 
     * @param nombre El nombre de la longitud a buscar.
     * @return La instancia del enum {@code Longitudes} correspondiente, o {@code null} si no se encuentra ninguna coincidencia.
     * @since version 1.0
     * @author Marco CU
     */
    public static Longitudes buscarPorNombre(String nombre) {
        for (Longitudes longitud : values()) {
            if (longitud.name().equalsIgnoreCase(nombre.replace(" ", "_"))) {
                return longitud;
            }
        }
        return null;
    }
}
