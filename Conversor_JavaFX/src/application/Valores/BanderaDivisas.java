package application.Valores;

import java.io.File;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

/**
 * Representa una bandera de un pais junto con su nombre y la URL de su imagen.
 * Permite agregar imagenes a las opciones de las ComboBox de divisas.
 * 
 * @since version 1.0
 * @author Marco CU
 */
public class BanderaDivisas {
	private String nombrePais;
	private String imagenURL;

	/**
	 * Crea una nueva instancia de BanderaDivisas con el nombre del pais y la URL de
	 * su imagen.
	 *
	 * @param nombrePais El nombre del pais.
	 * @param imagenURL  La URL de la imagen de la bandera.
	 * @since version 1.0
	 */
	public BanderaDivisas(String nombrePais, String imagenURL) {
		this.nombrePais = nombrePais;
		this.imagenURL = imagenURL;
	}

	/**
	 * Obtiene el nombre del pais asociado a la bandera.
	 *
	 * @return El nombre del pais.
	 * @since version 1.0
	 */
	public String getPais() {
		return nombrePais;
	}

	/**
	 * Obtiene la URL de la imagen de la bandera.
	 *
	 * @return La URL de la imagen de la bandera.
	 * @since version 1.0
	 */
	public String getImagen() {
		return imagenURL;
	}

	/**
	 * Anade banderas como imagenes a las opciones de las ComboBox de origen y
	 * destino de divisas.
	 *
	 * @param ComboBoxOrigenOpcion  El ComboBox de origen de divisas.
	 * @param ComboBoxDestinoOpcion El ComboBox de destino de divisas.
	 * @since version 1.0
	 * @author Marco CU
	 */
	public static void anadirBanderas(ComboBox<String> ComboBoxOrigenOpcion, ComboBox<String> ComboBoxDestinoOpcion) {

		ComboBoxOrigenOpcion.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			@Override
			public ListCell<String> call(ListView<String> param) {
				return new ListCell<String>() {
					private final ImageView imageView = new ImageView();

					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (empty || item == null) {
							setText(null);
							setGraphic(null);
						} else {
							setText(item);
							BanderaDivisas bandera = obtenerBandera(item);
							if (bandera != null) {
								Image image = new Image(new File(bandera.getImagen()).toURI().toString());
								imageView.setImage(image);
								imageView.setFitWidth(60); // Ajusta el ancho de la imagen
								imageView.setFitHeight(35); // Ajusta la altura de la imagen
								setGraphic(imageView);
							} else {
								setGraphic(null);
							}
						}
					}
				};
			}
		});

		ComboBoxDestinoOpcion.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			@Override
			public ListCell<String> call(ListView<String> param) {
				return new ListCell<String>() {
					private final ImageView imageView = new ImageView();

					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (empty || item == null) {
							setText(null);
							setGraphic(null);
						} else {
							setText(item);
							BanderaDivisas bandera = obtenerBandera(item);
							if (bandera != null) {
								Image image = new Image(new File(bandera.getImagen()).toURI().toString());
								imageView.setImage(image);
								imageView.setFitWidth(60); // Ajusta el ancho de la imagen
								imageView.setFitHeight(35); // Ajusta la altura de la imagen
								setGraphic(imageView);
							} else {
								setGraphic(null);
							}
						}
					}
				};
			}
		});
	}

	/**
	 * Obtiene la instancia de BanderaDivisas correspondiente a una divisa dada.
	 *
	 * @param divisa La divisa para la que se busca la bandera.
	 * @return La instancia de BanderaDivisas correspondiente a la divisa o null si
	 *         no se encuentra.
	 * @since version 1.0
	 * @author Marco CU
	 */
	private static BanderaDivisas obtenerBandera(String divisa) {
		if (divisa.equals("MXN")) {
			return new BanderaDivisas("MXN", "images/banderas/640px-Flag_of_Mexico.svg.png");
		} else if (divisa.equals("USD")) {
			return new BanderaDivisas("USD", "images/banderas/640px-Flag_of_the_United_States.svg.png");
		} else if (divisa.equals("EUR")) {
			return new BanderaDivisas("EUR", "images/banderas/640px-Flag_of_Europe.svg.png");
		} else if (divisa.equals("GBP")) {
			return new BanderaDivisas("GBP", "images/banderas/Flag_of_the_United_Kingdom_(3-5).svg.png");
		} else if (divisa.equals("JPY")) {
			return new BanderaDivisas("JPY", "images/banderas/640px-Flag_of_Japan.svg.png");
		} else if (divisa.equals("KRW")) {
			return new BanderaDivisas("KRW", "images/banderas/640px-Flag_of_South_Korea.svg.png");
		} else {
			return null;
		}
	}
}