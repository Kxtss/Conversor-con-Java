package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Valores.BanderaDivisas;
import application.Valores.Divisas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * Controlador para el conversor de divisas que extiende la clase abstracta
 * Base. Contiene la logica principal para la conversion de divisas.
 * 
 * Los IDs que se ingresaron en los archivos FXML se vinculan al controlador
 * ControllerConversorDivisas para poder hacer uso de ellos en la logica que
 * conlleva.
 * 
 * Los elementos vinculados con {@code @FXML} son:
 * <ul>
 * <li>{@code Label}: Vincula los labels que mostraran el resultado y mensajes
 * de informacion para el usuario.</li>
 * <li>{@code TextField}: Vincula el TextField que se utilizara para ingresar el
 * valor a convertir.</li>
 * <li>{@code ComboBox}: Vincula los ComboBox que permitiran seleccionar las
 * divisas de origen y destino.</li>
 * </ul>
 * 
 * Ademas, utiliza el Array {@code divisasArray} para almacenar las opciones de
 * divisas disponibles en los ComboBox.
 * 
 * El metodo {@code initialize(URL arg0, ResourceBundle arg1)} se utiliza para
 * inicializar las opciones de los ComboBox y anadir las banderas
 * correspondientes a las opciones de divisas.
 * 
 * Los metodos heredados de la clase Base, tales como {@code opcionesMenu},
 * {@code getOpcionSeleccionada}, {@code metodoRevertir},
 * {@code metodoResetear}, y {@code metodoConvertir}, son implementados en esta
 * clase para realizar las acciones correspondientes en el conversor de divisas.
 * 
 * @since version 1.0
 * @author Marco CU
 * @see Base
 */
public class ControllerConversorDivisas extends Base {

	@FXML
	private Label myLabelResultado, myLabelMensajeInformacion;
	@FXML
	private TextField myTextFieldInput;
	@FXML
	private ComboBox<String> ComboBoxDestinoOpcion, ComboBoxOrigenOpcion;

	// Array para las opciones de las divisas
	private String[] divisasArray = { "MXN", "USD", "EUR", "GBP", "JPY", "KRW" };

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Llama a los atributos del metodo padre
		super.initialize(arg0, arg1);

		// Agrega las opciones de divisas a los ComboBox
		ComboBoxOrigenOpcion.getItems().addAll(divisasArray);
		ComboBoxDestinoOpcion.getItems().addAll(divisasArray);

		/**
		 * Anade las banderas de las opciones de los ComboBox
		 * 
		 * @see BanderaDivisas
		 * @since version 1.0
		 */
		BanderaDivisas.anadirBanderas(ComboBoxOrigenOpcion, ComboBoxDestinoOpcion);
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
	 * Realiza la conversion entre divisas basandose en los valores proporcionados
	 * en el enum {@link Divisas}.
	 * 
	 * <p>
	 * Este metodo se ejecuta cuando el usuario presiona el boton "Convertir" en la
	 * interfaz grafica del conversor de divisas. Realiza la logica para convertir
	 * el valor ingresado por el usuario desde la divisa de origen a la divisa de
	 * destino.
	 * </p>
	 * 
	 * <p>
	 * Si el usuario no ingresa un valor en el campo de texto o el valor ingresado
	 * no es valido, se muestra un mensaje de error en el Label
	 * {@code myLabelResultado} indicando que solo se permiten numeros.
	 * </p>
	 * 
	 * <p>
	 * Si el usuario selecciona las mismas divisas de origen y destino, se muestra
	 * un mensaje de error en el Label {@code myLabelResultado} indicando que no se
	 * puede realizar la conversion con la misma divisa.
	 * </p>
	 * 
	 * <p>
	 * Si la conversion es exitosa, se muestra el resultado en el Label
	 * {@code myLabelResultado} y se proporciona un Label oculto
	 * {@code myLabelMensajeInformacion} que permite copiar el resultado.
	 * </p>
	 * 
	 * @param event El evento que desencadena el metodo.
	 * @see Divisas
	 * @since version 1.0
	 * @author Marco CU
	 */
	@FXML
	protected void metodoConvertir(ActionEvent event) {
		try {
			String TextoInput = myTextFieldInput.getText();
			// Verifica que el usuario inrese algun valor en el campo del TextField
			if (TextoInput.isEmpty() || TextoInput.isBlank()) {
				myLabelResultado.setVisible(true);
				myLabelResultado.setText("Ingrese algún valor porfavor");
			} else {

				// Registra el texto del TextField y se asigna a la variable "dinero"
				double dinero = Double.parseDouble(myTextFieldInput.getText());

				// Registra las opciones seleccionadas de los ComboBox Divisa
				String divisaOrigen = ComboBoxOrigenOpcion.getValue();
				String divisaDestino = ComboBoxDestinoOpcion.getValue();

				// Variable para almacenar el resultado de la conversion
				double resultado;

				// Obtiene el valor de las Divisas desde el enum "Divisas"
				Divisas divisaOrigenValor = Divisas.valueOf(divisaOrigen);
				Divisas divisaDestinoValor = Divisas.valueOf(divisaDestino);

				if (divisaOrigenValor != null && divisaDestinoValor != null) {
					// No permite que se usen las mismas divisas
					if (divisaOrigenValor == divisaDestinoValor) {
						myLabelResultado.setVisible(true);
						myLabelResultado.setText("No se puede realizar la conversión con la misma divisa.");

					} else {
						// Si las divisas son diferentes, realiza la conversion
						resultado = dinero * divisaOrigenValor.getTasaDeCambio() / divisaDestinoValor.getTasaDeCambio();

						// Devuelve 2 decimales y pone una coma cada 3 digitos
						String mensajeFinal = String.format("%,.2f %s son: %,.2f %s", dinero, divisaOrigenValor.name(),
								resultado, divisaDestinoValor.name());

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

		} catch (Exception e) {
			myLabelResultado.setText("Ingrese las divisas porfavor");

		}

	}

}
