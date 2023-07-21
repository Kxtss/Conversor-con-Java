package application;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import application.Valores.Temperaturas;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * Controlador para el conversor de temperaturas que extiende la clase abstracta
 * Base. Contiene la logica principal para la conversion de temperaturas.
 * 
 * Los ID's que se ingresaron en los archivos FXML se vinculan al controlador
 * ControllerConversorTemperaturas para poder hacer uso de ellos en la logica
 * que conlleva.
 * 
 * Los elementos vinculados con {@code @FXML} son:
 * <ul>
 * <li>{@code Label}: Vincula los labels que mostraran el resultado y mensajes
 * de informacion para el usuario.</li>
 * <li>{@code TextField}: Vincula el TextField que se utilizara para ingresar el
 * valor a convertir.</li>
 * <li>{@code ComboBox}: Vincula los ComboBox que permitiran seleccionar las
 * temperaturas de origen y destino.</li>
 * </ul>
 * 
 * Ademas, utiliza el Array {@code temperaturasArray} para almacenar las
 * opciones de temperaturas disponibles en los ComboBox.
 * 
 * El metodo {@code initialize(URL arg0, ResourceBundle arg1)} se utiliza para
 * inicializar las opciones de los ComboBox.
 * 
 * Los metodos heredados de la clase Base, tales como {@code opcionesMenu},
 * {@code getOpcionSeleccionada}, {@code metodoRevertir},
 * {@code metodoResetear}, y {@code metodoConvertir}, son implementados en esta
 * clase para realizar las acciones correspondientes en el conversor de
 * temperaturas.
 * 
 * @since version 1.0
 * @author Marco CU
 * @see Base
 */
public class ControllerConversorTemperaturas extends Base {

	@FXML
	private Label myLabelMensajeInformacion, myLabelResultado;
	@FXML
	private ComboBox<String> ComboBoxDestinoOpcion, ComboBoxOrigenOpcion;
	@FXML
	private TextField myTextFieldInput;

	private String[] temperaturasArray = { "Celsius", "Fahrenheit", "Kelvin" };

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Llama a los atributos del metodo padre
		super.initialize(arg0, arg1);

		// Agrega las opciones de las Longitudes a los ComboBox
		ComboBoxOrigenOpcion.getItems().addAll(temperaturasArray);
		ComboBoxDestinoOpcion.getItems().addAll(temperaturasArray);
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
	 * <p>
	 * Realiza la conversion de temperaturas cuando se activa el evento del boton
	 * "Convertir". Obtiene el valor ingresado por el usuario en el TextField, asi
	 * como las opciones de temperaturas seleccionadas en los ComboBox (origen y
	 * destino). Luego, utiliza el enum {@link Temperaturas} para realizar las
	 * conversiones necesarias y muestra el resultado en el Label correspondiente.
	 * </p>
	 * 
	 * <p>
	 * En caso de que no se ingrese ningun valor en el TextField, se muestra un
	 * mensaje de error indicando que se debe ingresar un valor. Si las opciones de
	 * temperatura seleccionadas son iguales, se muestra un mensaje de error
	 * indicando que no se puede realizar la conversion entre la misma temperatura.
	 * </p>
	 * 
	 * <p>
	 * Si ocurre alguna excepcion durante el proceso de conversion, se muestra un
	 * mensaje de error generico.
	 * </p>
	 * 
	 * @param event el evento generado al hacer clic en el boton "Convertir".
	 * @see Temperaturas
	 * @since version 1.0
	 */
	@FXML
	protected void metodoConvertir(ActionEvent event) {
		try {
			// Se encarga de hacer visible el Label resultado con la operacion
			Platform.runLater(() -> myLabelResultado.setVisible(true));

			// Registra el input del usuario en el TextField
			String textoInput = myTextFieldInput.getText();

			// Verifica que el usuario ingrese algun valor en el TextField
			if (textoInput.isEmpty() || textoInput.isBlank()) {
				myLabelResultado.setVisible(true);
				myLabelResultado.setText("Ingrese algún valor por favor");
			} else {
				// Registra el texto del TextField y se asigna a la variable temperatura como
				// Double
				double temperatura = Double.parseDouble(myTextFieldInput.getText());

				// Registra las opciones seleccionadas de los ComboBox temperatura
				String temperaturaOrigen = ComboBoxOrigenOpcion.getValue();
				String temperaturaDestino = ComboBoxDestinoOpcion.getValue();

				// Variable para asignar el resultado de la conversion
				double resultado;

				// Obtiene el valor de las temperaturas del enum
				Temperaturas temperaturaOrigenValor = Temperaturas.valueOf(temperaturaOrigen);
				Temperaturas temperaturaDestinoValor = Temperaturas.valueOf(temperaturaDestino);

				if (temperaturaOrigenValor != null && temperaturaDestinoValor != null) {
					// No permite que se usen las mismas temperaturas
					if (temperaturaOrigenValor == temperaturaDestinoValor) {
						myLabelResultado.setVisible(true);
						myLabelResultado.setText("No se puede realizar la conversión con la misma temperatura.");
					} else {
						// Realiza la conversion utilizando el enum y sus metodos
						if (temperaturaOrigenValor == Temperaturas.Celsius) {
							if (temperaturaDestinoValor == Temperaturas.Fahrenheit) {
								resultado = Temperaturas.celsiusToFahrenheit(temperatura);
							} else { // Kelvin
								resultado = Temperaturas.celsiusToKelvin(temperatura);
							}
						} else if (temperaturaOrigenValor == Temperaturas.Fahrenheit) {
							if (temperaturaDestinoValor == Temperaturas.Celsius) {
								resultado = Temperaturas.fahrenheitToCelsius(temperatura);
							} else { // Kelvin
								resultado = Temperaturas.fahrenheitToKelvin(temperatura);
							}
						} else { // Kelvin
							if (temperaturaDestinoValor == Temperaturas.Celsius) {
								resultado = Temperaturas.kelvinToCelsius(temperatura);
							} else { // Fahrenheit
								resultado = Temperaturas.kelvinToFahrenheit(temperatura);
							}
						}

						// Formatea el resultado para mostrar solo los decimales necesarios
						// los miles
						DecimalFormat decimalFormat = new DecimalFormat("#,##0.##");
						String resultadoFormateado = decimalFormat.format(resultado);

						// Devuelve 2 decimales a temperatura (valor ingresado por el usuario) y pone
						// una coma cada 3 digitos
						String mensajeFinal = String.format("%,.2f %s son: %s %s", temperatura,
								temperaturaOrigenValor.name(), resultadoFormateado, temperaturaDestinoValor.name());

						// Muestra el label de informacion para copiar
						myLabelMensajeInformacion.setVisible(true);

						// Muestra el label del resultado
						myLabelResultado.setVisible(true);
						myLabelResultado.setText(mensajeFinal);
					}
				}
			}
		} catch (NumberFormatException e) {
			myLabelResultado.setText("Solo se permiten números.");
		} catch (IllegalArgumentException e) {
			myLabelResultado.setText("Ingrese las temperaturas por favor");
		} catch (Exception e) {
			myLabelResultado.setText("Error al realizar la conversión.");
		}
	}
}
