package application;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import application.Valores.Longitudes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * Controlador para el conversor de unidades de longitud que extiende la clase
 * abstracta Base. Contiene la logica principal para la conversion de unidades
 * de medida <em>(Longitudes)</em>.
 * 
 * Los IDs que se ingresaron en los archivos FXML se vinculan al controlador
 * ControllerConversorLongitud para poder hacer uso de ellos en la logica que
 * conlleva.
 * 
 * Los elementos vinculados con {@code @FXML} son:
 * <ul>
 * <li>{@code Label}: Vincula los labels que mostraran el resultado y mensajes
 * de informacion para el usuario.</li>
 * <li>{@code TextField}: Vincula el TextField que se utilizara para ingresar el
 * valor a convertir.</li>
 * <li>{@code ComboBox}: Vincula los ComboBox que permitiran seleccionar las
 * longitudes de origen y destino.</li>
 * </ul>
 * 
 * Ademas, utiliza el Array {@code medicionesArray} para almacenar las opciones
 * de longitudes disponibles en los ComboBox.
 * 
 * El metodo {@code initialize(URL arg0, ResourceBundle arg1)} se utiliza para
 * inicializar las opciones de los ComboBox correspondientes a las longitudes.
 * 
 * Los metodos heredados de la clase Base, tales como {@code opcionesMenu},
 * {@code getOpcionSeleccionada}, {@code metodoRevertir},
 * {@code metodoResetear}, y {@code metodoConvertir}, son implementados en esta
 * clase para realizar las acciones correspondientes en el conversor de
 * longitud.
 * 
 * 
 * Este controlador se encarga de manejar las interacciones con la interfaz
 * grafica del conversor de unidades de longitud. Permite realizar conversiones
 * entre diferentes unidades de longitud, tales como:
 * <ul>
 * <li>nanometros</li>
 * <li>micrones</li>
 * <li>milimetros</li>
 * <li>centimetros</li>
 * <li>metros</li>
 * <li>kilometros</li>
 * <li>pulgadas</li>
 * <li>pies</li>
 * <li>yardas</li>
 * <li>millas</li>
 * <li>millas Nauticas</li>
 * </ul>
 * 
 * 
 * <p>
 * El usuario puede ingresar un valor en el campo de texto, seleccionar las
 * unidades de longitud de origen y destino en los ComboBox y presionar el boton
 * "Convertir" para obtener el resultado de la conversion.
 * </p>
 * 
 * <p>
 * El resultado se muestra en el Label {@code myLabelResultado} y tambien se
 * proporciona un Label oculto {@code myLabelMensajeInformacion} que permite
 * hacerle saber al usuario como copiar el resultado.
 * </p>
 * 
 * @since version 1.0
 * @author Marco CU
 * @see Base
 */
public class ControllerConversorLongitud extends Base {

	@FXML
	private Label myLabelMensajeInformacion, myLabelResultado;
	@FXML
	private ComboBox<String> ComboBoxDestinoOpcion, ComboBoxOrigenOpcion;
	@FXML
	private TextField myTextFieldInput;

	// Array para las opciones de longitud (unidades de medida)
	private String[] medicionesArray = { "Nanometros", "Micrones", "Milimetros", "Centimetros", "Metros", "Kilometros",
			"Pulgadas", "Pies", "Yardas", "Millas", "Millas Nauticas" };

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Llama a los atributos del metodo padre
		super.initialize(arg0, arg1);

		// Agrega las opciones de las Longitudes a los ComboBox
		ComboBoxOrigenOpcion.getItems().addAll(medicionesArray);
		ComboBoxDestinoOpcion.getItems().addAll(medicionesArray);
	}

	// Metodo para las opciones del menu que se llama de la clase Base
	@FXML
	protected void opcionesMenu(MouseEvent event) throws IOException {
		super.opcionesMenu(event);
	}

	// Metodo para poner la opcion seleccionada en un label escondido en "???" que
	// se llama de la clase Base
	@FXML
	protected void getOpcionSeleccionada(ActionEvent event) {
		super.getOpcionSeleccionada(event);
	}

	// Metodo para cambiar de lugar las opciones selecionadas que se llama de la
	// clase Base
	@FXML
	protected void metodoRevertir(MouseEvent event) {
		super.metodoRevertir(event);
	}

	// Metodo para resetear todas las opciones que se llama de la clase Base
	@FXML
	protected void metodoResetear(ActionEvent event) {
		super.metodoResetear(event);
	}

	/**
	 * Realiza la conversion entre longitudes basandose en los valores
	 * proporcionados en el enum {@link Longitudes}.
	 * 
	 * <p>
	 * Este metodo se ejecuta cuando el usuario presiona el boton "Convertir" en la
	 * interfaz grafica del conversor de unidades de longitud. Realiza la logica
	 * para convertir el valor ingresado por el usuario desde las unidades de
	 * longitud de origen a las unidades de longitud de destino.
	 * </p>
	 * 
	 * <p>
	 * Si el usuario no ingresa un valor en el campo de texto o el valor ingresado
	 * no es valido, se muestra un mensaje de error en el Label
	 * {@code myLabelResultado} indicando que solo se permiten numeros.
	 * </p>
	 * 
	 * <p>
	 * Si el usuario selecciona las mismas unidades de longitud de origen y destino,
	 * se muestra un mensaje de error en el Label {@code myLabelResultado} indicando
	 * que no se puede realizar la conversion con la misma longitud.
	 * </p>
	 * 
	 * <p>
	 * Si la conversion es exitosa, se muestra el resultado en el Label
	 * {@code myLabelResultado} y se proporciona un Label oculto
	 * {@code myLabelMensajeInformacion} que permite copiar el resultado.
	 * </p>
	 * 
	 * @param event El evento que desencadena el metodo.
	 * @see Longitudes
	 * @since version 1.0
	 */
	@FXML
	protected void metodoConvertir(ActionEvent event) {
		try {
			String TextoInput = myTextFieldInput.getText();
			// Verifica si el input del TextField esta vacio
			if (TextoInput.isEmpty() || TextoInput.isBlank()) {
				myLabelResultado.setVisible(true);
				myLabelResultado.setText("Ingrese algún valor, por favor.");
			} else {
				// Registra el valor ingresado por el usuario y lo convierte a double
				Double longitud = Double.parseDouble(myTextFieldInput.getText());

				// Toma la opcion seleccionada de los ComboBox
				String longitudOrigen = ComboBoxOrigenOpcion.getValue();
				String longitudDestino = ComboBoxDestinoOpcion.getValue();

				// Variable para asignarle el resultado de la conversion
				double resultado;

				// Variables que toman el valor guardado por el enum Longitudes y busca las
				// coincidencias por nombres
				Longitudes longitudOrigenValor = Longitudes.buscarPorNombre(longitudOrigen);
				Longitudes longitudDestinoValor = Longitudes.buscarPorNombre(longitudDestino);

				// Crea un objeto BigDecimal y elimina los ceros no significativos a la derecha
				// con stripTrailingZeros
				BigDecimal longitudDecimal = new BigDecimal(myTextFieldInput.getText()).stripTrailingZeros();

				// Logica para la conversion
				if (longitudOrigenValor != null && longitudDestinoValor != null) {

					// No permite que se usen las mismas longitudes
					if (longitudOrigenValor.equals(longitudDestinoValor)) {
						myLabelResultado.setVisible(true);
						myLabelResultado.setText("No se puede realizar la conversión con la misma longitud.");
					} else {
						// Si las longitudes son diferentes, realiza la conversion
						resultado = longitud * longitudOrigenValor.getLongitudCambio()
								/ longitudDestinoValor.getLongitudCambio();

						// Hace que resultado se convierta a BigDecimal y elimine todos los ceros no
						// significativos a la derecha
						BigDecimal resultadoBigDecimal = BigDecimal.valueOf(resultado).stripTrailingZeros();

						// Crea un objeto NumberFormat para formatear los numeros con comas
						NumberFormat numberFormat = NumberFormat.getInstance(Locale.getDefault());
						// Establece la cantidad maxima de decimales a mostrar
						numberFormat.setMaximumFractionDigits(30);

						// String para mostrar en el label Resultado formateado para que ponga las comas
						// a los numeros y que permita ver todos los ceros que contiene el numero y que
						// remplaza los guiones bajos por un espacio (Para el enum de Millas_Nauticas y
						// hacer que se muestre sin guion bajo)
						String mensajeFinal = String.format("%s %s son: %s %s", numberFormat.format(longitudDecimal),
								longitudOrigenValor.name().replace("_", " "), numberFormat.format(resultadoBigDecimal),
								longitudDestinoValor.name().replace("_", " "));

						// Muestra el label de informacion para copiar
						myLabelMensajeInformacion.setVisible(true);

						// Muestra el label del resultado
						myLabelResultado.setVisible(true);
						myLabelResultado.setText(mensajeFinal);
					}
				}
			}

		} catch (NumberFormatException e) {
			myLabelResultado.setVisible(true);
			myLabelResultado.setText("Solo se permiten números.");
		} catch (Exception e) {
			e.printStackTrace();
			myLabelResultado.setVisible(true);
			myLabelResultado.setText("Ingrese las longitudes, por favor.");
		}
	}
}
