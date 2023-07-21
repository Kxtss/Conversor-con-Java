package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;

/**
 * Este proyecto fue hecho con el fin de hacer el <strong>Challenge ONE Back End
 * - Java</strong> <i>Sprint 01: Crea tu propio conversor de moneda</i>.
 * 
 * 
 * El programa debe transformar una moneda a otras divisas:
 * <ul>
 * <li>Convertir de la moneda de tu pais a Dolar</li>
 * <li>Convertir de la moneda de tu pais a Euros</li>
 * <li>Convertir de la moneda de tu pais a Libras Esterlinas</li>
 * <li>Convertir de la moneda de tu pais a Yen Japones</li>
 * <li>Convertir de la moneda de tu pais a Won sur-coreano</li>
 * </ul>
 * Y que tambien pueda convertir inversamente.
 * 
 * Ademas de que incluye otros tipos de conversores como:
 * <ul>
 * <li>Conversor de longitudes (Unidades de medida)</li>
 * <li>Conversor de Peso y Masa</li>
 * <li>Conversor de Temperatura</li>
 * </ul>
 * 
 * 
 * <p>
 * Este proyecto utiliza JavaFX, SceneBuilder, JDK 17, la extension "e(fx)clipse
 * 3.8.0" de la Marketplace de Eclipse y ha sido creado en Eclipse IDE 2023-06
 * con los siguientes argumentos VM en la ejecucion para que funcione el
 * programa(Run Configurations -> Java Application):
 * <code>--module-path "\path\to\javafx-sdk-20\lib" --add-modules javafx.controls,javafx.fxml</code>
 * </p>
 * 
 * 
 * Enlaces de referencia:
 * <ul>
 * <li><a href="https://www.eclipse.org/downloads/">Descargar Eclipse
 * IDE</a></li>
 * <li><a href="https://gluonhq.com/products/javafx/">JavaFX</a></li>
 * <li><a href=
 * "https://gluonhq.com/products/scene-builder/">SceneBuilder</a></li>
 * <li><a href="https://openjfx.io/openjfx-docs/">Documentacion de
 * JavaFX</a></li>
 * </ul>
 * 
 * 
 * @since 19/7/2023
 * @version 1.0
 * @author Marco CU
 */
public class Main extends Application {

	/**
	 * Crea los metodos para cargar la escena principal que es la del Conversor de
	 * divisas.
	 *
	 * @param primaryStage El objeto Stage principal de JavaFX que representa la
	 *                     ventana principal.
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Escenas/EscenaConversorDivisas.fxml"));
			Scene scene = new Scene(root);

			// Crea un CSS reutilizable para una o mas escenas.
			String css = this.getClass().getResource("Escenas/StyleEscenas.css").toExternalForm();
			scene.getStylesheets().add(css); // Agrega el CSS.

			// Crea un icono para la aplicacion
			Image icono = new Image("C:\\Users\\marco\\OneDrive\\Documentos\\Alura - curso\\Challenges\\Conversor_JavaFX\\images\\CaraFelizIcono.jpg");
			primaryStage.getIcons().add(icono);
			
			primaryStage.setResizable(false); // No permite modificar el tamaño de la interfaz.
			primaryStage.setTitle("Conversor");
			primaryStage.setScene(scene);
			primaryStage.show();

			// Muestra una alerta al usuario al cerrar el programa.
			primaryStage.setOnCloseRequest(event -> {
				event.consume();
				logout(primaryStage);
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo principal del programa.
	 * 
	 * @param args Argumentos de linea de comandos (no se utilizan en este
	 *             proyecto).
	 * @since version 1.0
	 * @author Marco CU
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Crea una alerta para mostrar al usuario cuando cierre el programa y le
	 * pregunta si esta seguro de salir. Si el usuario confirma la salida, se cierra
	 * la ventana actual.
	 *
	 * @param stage El objeto Stage de la ventana actual.
	 * @since version 1.0
	 * @author Marco CU
	 */
	public void logout(Stage stage) {
		try {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Logout");
			alert.setHeaderText("¡Estás saliendo del conversor!");
			alert.setContentText("¿Seguro que quieres salir?");

			if (alert.showAndWait().get() == ButtonType.OK) {
				System.out.println("Salió del programa");
				stage.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
