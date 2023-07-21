package application;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import application.Valores.Pesos_Y_Masas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * Controlador para el conversor de pesos y masas que extiende la clase
 * abstracta Base. Contiene la logica principal para la conversion de pesos y
 * masas.
 * 
 * Los ID's que se ingresaron en los archivos FXML se vinculan al controlador
 * ControllerConversorPesoMasa para poder hacer uso de ellos en la logica que
 * conlleva.
 * 
 * Los elementos vinculados con {@code @FXML} son:
 * <ul>
 * <li>{@code Label}: Vincula los labels que mostraran el resultado y mensajes
 * de informacion para el usuario.</li>
 * <li>{@code TextField}: Vincula el TextField que se utilizara para ingresar el
 * valor a convertir.</li>
 * <li>{@code ComboBox}: Vincula los ComboBox que permitiran seleccionar las
 * opciones de pesos y masas de origen y destino.</li>
 * </ul>
 * 
 * Ademas, utiliza el Array {@code pesoMasaArray} para almacenar las opciones de
 * pesos y masas disponibles en los ComboBox.
 * 
 * El metodo {@code initialize(URL arg0, ResourceBundle arg1)} se utiliza para
 * inicializar las opciones de los ComboBox y anadir las banderas
 * correspondientes a las opciones de pesos y masas.
 * 
 * Los metodos heredados de la clase Base, tales como {@code opcionesMenu},
 * {@code getOpcionSeleccionada}, {@code metodoRevertir},
 * {@code metodoResetear}, y {@code metodoConvertir}, son implementados en esta
 * clase para realizar las acciones correspondientes en el conversor de pesos y
 * masas.
 * 
 * @since version 1.0
 * @author Marco CU
 * @see Base
 */
public class ControllerConversorPesoMasa extends Base {

	@FXML
	private Label myLabelMensajeInformacion, myLabelResultado;
	@FXML
	private ComboBox<String> ComboBoxDestinoOpcion, ComboBoxOrigenOpcion;
	@FXML
	private TextField myTextFieldInput;

	// Array para las opciones de pesos y masas
	private String[] pesoMasaArray = { "Quilates", "Miligramos", "Centigramos", "Decigramos", "Gramos", "Decagramos",
			"Hectogramos", "Kilogramo", "Toneladas métricas", "Onzas", "Libras", "Piedra", "Toneladas cortas",
			"Toneladas largas" };

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Llama a los atributos del metodo padre
		super.initialize(arg0, arg1);

		// Agrega las opciones de las Longitudes a los ComboBox
		ComboBoxOrigenOpcion.getItems().addAll(pesoMasaArray);
		ComboBoxDestinoOpcion.getItems().addAll(pesoMasaArray);
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
	 * Metodo para realizar la conversion de peso y masa.
	 * 
	 * <p>Este metodo se invoca cuando el usuario presiona el boton de "Convertir" en la interfaz grafica.
	 * Toma el valor ingresado por el usuario en el campo de texto {@code myTextFieldInput} y la opcion seleccionada
	 * en los ComboBox {@code ComboBoxOrigenOpcion} y {@code ComboBoxDestinoOpcion}.
	 * Luego, realiza la conversion de peso y masa segun las unidades seleccionadas utilizando las relaciones de cambio
	 * definidas en el enum {@link Pesos_Y_Masas}.
	 * El resultado de la conversion se muestra en el label {@code myLabelResultado} y se formatea para mostrar
	 * comas en los numeros y eliminar ceros no significativos a la derecha.</p>
	 * 
	 * <p>Si el campo de texto esta vacio o en blanco, muestra un mensaje de error en el label {@code myLabelResultado}
	 * indicando que se debe ingresar algun valor.</p>
	 * 
	 * <p>Si las opciones seleccionadas en los ComboBox son las mismas, muestra un mensaje de error en el label
	 * {@code myLabelResultado} indicando que no se puede realizar la conversion con la misma opcion de peso y masa.</p>
	 * 
	 * @param event El evento de accion que desencadena la conversion.
	 * @see Pesos_Y_Masas
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
				Double pesoMasa = Double.parseDouble(myTextFieldInput.getText());

				// Toma la opcion seleccionada de los ComboBox
				String pesoMasaOrigen = ComboBoxOrigenOpcion.getValue();
				String pesoMasaDestino = ComboBoxDestinoOpcion.getValue();

				// Variable para asignarle el resultado de la conversion
				double resultado;

				// Crea un objeto BigDecimal y elimina los ceros no significativos a la derecha
				// con stripTrailingZeros
				BigDecimal pesoMasaDecimal = new BigDecimal(myTextFieldInput.getText()).stripTrailingZeros();

				// Variables que toman el valor guardado por el enum Pesos_Y_Masas y busca las
				// coincidencias por nombres
				Pesos_Y_Masas pesoMasaOrigenValor = Pesos_Y_Masas.buscarPorNombre(pesoMasaOrigen);
				Pesos_Y_Masas pesoMasaDestinoValor = Pesos_Y_Masas.buscarPorNombre(pesoMasaDestino);

				// Logica para la conversion
				if (pesoMasaOrigenValor != null && pesoMasaDestinoValor != null) {

					// No permite que se usen las mismas opciones de peso y masa
					if (pesoMasaOrigenValor.equals(pesoMasaDestinoValor)) {
						myLabelResultado.setVisible(true);
						myLabelResultado
								.setText("No se puede realizar la conversión con la misma opción de peso y masa.");
					} else {
						// Si las unidades de peso y masa son diferentes, realiza la conversion
						resultado = pesoMasa * pesoMasaOrigenValor.getPesoMasaCambio()
								/ pesoMasaDestinoValor.getPesoMasaCambio();

						// Hace que resultado se convierta a BigDecimal y elimine todos los ceros no
						// significativos a la derecha
						BigDecimal resultadoBigDecimal = BigDecimal.valueOf(resultado).stripTrailingZeros();

						// Crea un objeto NumberFormat para formatear los numeros con comas
						NumberFormat numberFormat = NumberFormat.getInstance(Locale.getDefault());
						// Establece la cantidad maxima de decimales a mostrar
						numberFormat.setMaximumFractionDigits(30);

						// String para mostrar en el label Resultado formateado para que ponga las comas
						// a los numeros y que permita ver todos los ceros que contiene el numero y que
						// remplaza los guiones bajos por un espacio (Para los enum que tienen guion
						// bajo y hacer que se muestre sin guion bajo)
						String mensajeFinal = String.format("%s %s son: %s %s", numberFormat.format(pesoMasaDecimal),
								pesoMasaOrigenValor.name().replace("_", " "), numberFormat.format(resultadoBigDecimal),
								pesoMasaDestinoValor.name().replace("_", " "));

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
			myLabelResultado.setVisible(true);
			myLabelResultado.setText("Ingrese las opciones de peso y masa, por favor.");
		}
	}

}
