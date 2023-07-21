package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * <strong>Clase con la logica principal del programa</strong> de conversion que
 * contiene las etiquetas principales de las escenas con su inyeccion de
 * {@code @FXML} para hacer uso correcto de dichos objetos.
 * 
 * Implementa la interfaz {@code Initializable} con la cual, en el metodo
 * {@code public void initialize(URL arg0, ResourceBundle arg1)}, se pueden
 * agregar las opciones de uso para el menu y las conversiones, ademas de
 * eventos como el de copiar el texto del resultado.
 * 
 * <em>La clase Base es abstracta ya que las clases hijas que extienden de Base
 * tienen que implementar su propia logica de conversion.</em>
 * 
 * @since 19/7/2023
 * @version 1.0
 * @author Marco CU
 */
public abstract class Base implements Initializable {

	/**
	 * Los ID's que se ingresaron en los archivos FXML estan vinculados al
	 * controlador Base para poder hacer uso de ellos en la logica que conlleva.
	 * 
	 * <ul>
	 * <li>{@code AnchorPane}: Vincula el Panel de Anclaje en el cual van todos los
	 * demas objetos de la interfaz.</li>
	 * <li>{@code Button}: Vincula los botones que hay en la interfaz y que se
	 * usaran como eventos.</li>
	 * <li>{@code Label}: Vincula los labels que contienen el texto del contenido e
	 * informacion para el usuario.</li>
	 * <li>{@code ComboBox}: Vincula los ComboBox que se usan para mostrar las
	 * opciones a seleccionar.</li>
	 * <li>{@code ListView}: Vincula el ListView que funciona como un menu de
	 * opciones para cambiar entre conversores.</li>
	 * <li>{@code TextField}: Vincula el TextField que se usara como input del
	 * usuario para poder complementar los ComboBox.</li>
	 * <li>{@code Stage}: Genera un objeto Stage para poder crear escenas en las
	 * opciones del menu.</li>
	 * <li>{@code Scene}: Genera un objeto Scene para poder mostrar la escena o el
	 * contenido del Parent.</li>
	 * <li>{@code Parent}: Genera un objeto Parent que se asigna a la variable root
	 * como referencia a los objetos que habra en la interfaz.</li>
	 * </ul>
	 * 
	 * @since version 1.0
	 * @author Marco CU
	 */
	@FXML
	private AnchorPane myPane;
	@FXML
	private Button convertirBoton, resetearBoton;
	@FXML
	private Label myLabelOrigen, myLabelDestino, myLabelResultado, myLabelsIncognitasOrigen, myLabelsIncognitasDestino,
			labelPromptOrigen, labelPromptDestino, myLabelMensajeInformacion;
	@FXML
	private ComboBox<String> ComboBoxOrigenOpcion, ComboBoxDestinoOpcion;
	@FXML
	private ListView<String> myListView;
	@FXML
	private TextField myTextFieldInput;
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;

	/**
	 * ArrayList vacio para que se inicialice el ComboBox que en cada clase hija se
	 * modifica el contenido que llevaran.
	 * 
	 * @since version 1.0
	 * @author Marco CU
	 */
	private String[] valoresArray = {};

	/**
	 * Array para las opciones del Menu (ListView)
	 * 
	 * @since version 1.0
	 * @author Marco CU
	 */
	private String[] listViewOpciones = { "Conversor de divisas", "Conversor de longitud", "Conversor de peso y masa",
			"Conversor de temperatura" };

	/**
	 * Initialize sirve para anadir las opciones de los ComboBox, anadir la lista
	 * del menu, anadir diferentes tipos de eventos al inicializar el programa.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Agrega las opciones al ComboBox
		ComboBoxOrigenOpcion.getItems().addAll(valoresArray);
		ComboBoxDestinoOpcion.getItems().addAll(valoresArray);

		// Agrega las opciones al menu
		myListView.getItems().addAll(listViewOpciones);

		// Crea metodo para copiar el texto del resultado
		myLabelResultado.setOnMouseClicked(event -> {
			if (event.getClickCount() == 2) {
				if (myLabelResultado.isVisible()) {
					Clipboard clipboard = Clipboard.getSystemClipboard();
					ClipboardContent content = new ClipboardContent();
					content.putString(myLabelResultado.getText());
					clipboard.setContent(content);

					mostrarMensaje("Se ha copiado a su portapapeles el texto");
				}
			}

		});

		// Cambia los "???" por las opciones seleccionadas en el ComboBox
		ComboBoxOrigenOpcion.setOnAction(event -> getOpcionSeleccionada(event));
		ComboBoxDestinoOpcion.setOnAction(event -> getOpcionSeleccionada(event));

		// Esconde el label del texto personalizado que tiene como prompt en el ComboBox
		// al hacer click
		labelPromptOrigen.setOnMouseClicked(event -> {
			if (event.getClickCount() == 1) {
				labelPromptOrigen.setVisible(false);
			}
		});

		// Esconde el label del texto personalizado que tiene como prompt en el ComboBox
		// al hacer click
		labelPromptDestino.setOnMouseClicked(event -> {
			if (event.getClickCount() == 1) {
				labelPromptDestino.setVisible(false);
			}
		});

		// Muestra el label de incognitas (???) al iniciar el programa
		myLabelsIncognitasOrigen.setVisible(true);
		myLabelsIncognitasDestino.setVisible(true);
		
		myLabelResultado.setVisible(false);
	}

	/**
	 * Metodo para mandar un mensaje como alerta al copiar el resultado
	 * 
	 * @param mensaje Sirve para poder inicializar el metodo de copiar mensaje
	 * @since version 1.0
	 * @author Marco CU
	 */
	private void copiarMensaje(String mensaje) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Información");
		alert.setHeaderText(null);
		alert.setContentText(mensaje);
		alert.showAndWait();
	}

	// Metodo para que cada clase muestre un mensaje personalizado
	private void mostrarMensaje(String mensaje) {
		copiarMensaje(mensaje);
	}

	// Mensaje para mostrar si ocurre un problema al cambiar las opciones de lugar
	// en el ComboBox
	private String errorMessage = "Error al cambiar las opciones.\n- Verifique las opciones";

	/**
	 * Metodo para cambiar de lugar las opciones seleccionadas al hacer click en la
	 * imagen de revertir, el cual hace pasar de un lado a otro los valores de los
	 * ComboBox y labels que contengan el valor seleccionado
	 * 
	 * @param event Parametro que sirve para mostrar el evento
	 * @since version 1.0
	 * @author Marco CU
	 */
	@FXML
	protected void metodoRevertir(MouseEvent event) {
		// Al usar el metodo hace visible el label resultado y esconde las incognitas
		myLabelResultado.setVisible(true);
		myLabelsIncognitasOrigen.setVisible(false);
		myLabelsIncognitasDestino.setVisible(false);

		try {
			// Toma el valor que hay en los ComboBoxes y los asigna a variables
			String revertirOrigen = ComboBoxOrigenOpcion.getValue();
			String revertirDestino = ComboBoxDestinoOpcion.getValue();
			// Logica para hacer el revertimiento de valores
			if (revertirOrigen != null && revertirDestino != null && !revertirOrigen.equals(revertirDestino)
					&& !revertirDestino.equals(revertirOrigen)) {
				ComboBoxDestinoOpcion.setValue(revertirDestino);
				myLabelOrigen.setText(revertirDestino);

				ComboBoxOrigenOpcion.setValue(revertirOrigen);
				myLabelDestino.setText(revertirOrigen);

				String valorOrigen = ComboBoxOrigenOpcion.getValue();
				String valorDestino = ComboBoxDestinoOpcion.getValue();
				ComboBoxOrigenOpcion.getSelectionModel().select(valorDestino);
				ComboBoxDestinoOpcion.getSelectionModel().select(valorOrigen);

				// myLabelResultado.setText("Se han cambiando de posicion las opciones");

				metodoConvertir(null);
			} else {
				myLabelResultado.setVisible(true);
				myLabelResultado.setText(errorMessage);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Metodo para las opciones del menu que genera las escenas correspondientes y
	 * con sus controladores para hacer uso de dichas opciones
	 * 
	 * @param event Parametro que sirve para mostrar el evento
	 * @throws IOException Lanza la excepcion por si ocurre algun problema ademas de
	 *                     ser requerida para que funcione el metodo
	 * @since version 1.0
	 * @author Marco CU
	 */
	@FXML
	protected void opcionesMenu(MouseEvent event) throws IOException {
		// Crea un css reusable para una o mas escenas
		String css = this.getClass().getResource("Escenas/StyleEscenas.css").toExternalForm();

		String opcionSeleccionada = myListView.getSelectionModel().getSelectedItem();
		if (opcionSeleccionada != null && opcionSeleccionada.equals("Conversor de divisas")) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("Escenas/EscenaConversorDivisas.fxml"));
				stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				scene.getStylesheets().add(css); // Agrega el css

				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				System.out.println(e);
			}

		} else if (opcionSeleccionada != null && opcionSeleccionada.equals("Conversor de longitud")) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("Escenas/EscenaConversorLongitud.fxml"));
				stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				scene.getStylesheets().add(css); // Agrega el css

				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e);
			}

		} else if (opcionSeleccionada != null && opcionSeleccionada.equals("Conversor de peso y masa")) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("Escenas/EscenaConversorPesoMasa.fxml"));
				stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				scene.getStylesheets().add(css); // Agrega el css

				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e);
			}

		} else if (opcionSeleccionada != null && opcionSeleccionada.equals("Conversor de temperatura")) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("Escenas/EscenaConversorTemperatura.fxml"));
				stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				scene.getStylesheets().add(css); // Agrega el css

				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}
	}

	/**
	 * Metodo para poner la opcion seleccionada en un label con visibilidad en false
	 * detras de los label de incognitas (???)
	 * 
	 * @param event Parametro que sirve para mostrar el evento
	 * @since version 1.0
	 * @author Marco CU
	 */
	@FXML
	protected void getOpcionSeleccionada(ActionEvent event) {
		String labelOpcionOrigen = ComboBoxOrigenOpcion.getValue();
		String labelOpcionDestino = ComboBoxDestinoOpcion.getValue();

		try {
			if (labelOpcionOrigen != null && !labelOpcionOrigen.equals("LabelPromptOrigen")) {
				myLabelOrigen.setText(labelOpcionOrigen);
				myLabelsIncognitasOrigen.setVisible(false);
			}
			if (labelOpcionDestino != null && !labelOpcionDestino.equals("LabelPromptDestino")) {
				myLabelDestino.setText(labelOpcionDestino);
				myLabelsIncognitasDestino.setVisible(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para resetear todas las opciones y dejarlas como default, como cuando
	 * se inicio el programa.
	 * 
	 * @param event Parametro que sirve para mostrar el evento.
	 * @since version 1.0
	 * @author Marco CU
	 */
	@FXML
	protected void metodoResetear(ActionEvent event) {
		try {

			myLabelResultado.setVisible(true);

			labelPromptOrigen.setVisible(true);
			labelPromptDestino.setVisible(true);

			String textoLabelOrigen = myLabelOrigen.getText();
			String textoLabelDestino = myLabelDestino.getText();

			if (textoLabelOrigen != null && !textoLabelOrigen.equals("???")) {
				myLabelOrigen.setText(null);
				ComboBoxOrigenOpcion.setValue(null);
			}

			if (textoLabelDestino != null && !textoLabelDestino.equals("???")) {
				myLabelDestino.setText(null);
				ComboBoxDestinoOpcion.setValue(null);
			}

			myLabelsIncognitasOrigen.setVisible(true);
			myLabelsIncognitasDestino.setVisible(true);
			myLabelMensajeInformacion.setVisible(false);
			myTextFieldInput.clear();

			myLabelResultado.setText("Se ha reseteado todo");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Metodo abstracto para que cada conversor implemente su propia logica.
	 * 
	 * @param event Parametro que sirve para mostrar el evento.
	 * @since version 1.0
	 * @author Marco CU
	 */
	protected abstract void metodoConvertir(ActionEvent event);

}
