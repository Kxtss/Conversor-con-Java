## Índice
* [Imortante](#Importante)

* [Conversor con JavaFX, SceneBuilder y JavaFX](#Conversor)

* [Documentación (Javadoc)](#Documentación)

* [Referencias](#Referencias)

* [Conclusión](#Conclusión)

<br>

# Importante
Este proyecto contiene un Javadoc en el cual se explica cada parte del proyecto de manera más detallada. Sin embargo, este no contiene caracteres UTF-8, que es el que nos permite tener acentos y la "ñ". Esto se debe a que al hacer el Javadoc en el archivo index.html, esos caracteres no se reflejaban. No obstante, el proyecto sí está codificado en UTF-8.

Es necesario proporcionar los argumentos en la configuración de arranque (o al ejecutar el código), ya que sin estos, la aplicación no funcionará correctamente. Además, es necesario agregar una librería o configurar JavaFX en las configuraciones del proyecto.

Video de referencia (En inglés): [JavaFX install & setup (IntelliJ) - Bro Code](https://youtu.be/Ope4icw6bVk?list=PLZPZq0r_RZOM-8vJA3NQFZB7JroDcMwev)

Video de referencia (En español): [Instalación de JavaFX en Eclipse IDE 2022](https://youtu.be/rs0ALuSzcgA)

También cabe a recalcar que el <code>stylesheet.css</code> del Javadoc sale con error de compilación (o por lo menos a mi) pero esto no afecta al código ya que es solo para el estilo que contiene el index.html del Javadoc

# Conversor
Este programa se hizo en base al <strong>Challenge ONE Back End - Java Sprint 01: Crea tu propio conversor de moneda</strong>.
Fue hecho con JavaFX, SceneBuilder, extensión "e(fx)clipse 3.8.0", Eclipse IDE 2023-06 y Java JDK 17.

Trae la posibilidad de hacer una conversión a:
<ul>
  <li>Divisas:
    <ul>
      <li>MXN - Pesos Mexicanos.</li>
      <li>USD - Dólares Estadounidenses.</li>
      <li>EUR - Euro.</li>
      <li>GBP - Libras Esterlinas.</li>
      <li>JPY - Yen Japonés.</li>
      <li>KRW - Won Surcoreano.</li>
    </ul>
  </li>
  <br>
  <li>Longitud (unidades de medida):
    <ul>
      <li>Nanómetros.</li>
      <li>Micrones.</li>
      <li>Milímetros.</li>
      <li>Centímetros.</li>
      <li>Metros.</li>
      <li>Kilómetros.</li>
      <li>Pulgadas.</li>
      <li>Pies.</li>
      <li>Yardas.</li>
      <li>Millas Terrestres (Millas).</li>
      <li>Millas Náuticas.</li>
    </ul>
  </li>
  <br>
  <li>Peso y masa:
    <ul>
      <li>Quilates.</li>
      <li>Miligramos.</li>
      <li>Centigramos.</li>
      <li>Decigramos.</li>
      <li>Gramos.</li>
      <li>Decagramos.</li>
      <li>Hectogramos.</li>
      <li>Kilogramos.</li>
      <li>Toneladas Métricas.</li>
      <li>Onzas.</li>
      <li>Libras.</li>
      <li>Piedra.</li>
      <li>Toneladas Cortas.</li>
      <li>Toneladas Largas.</li>
    </ul>
  </li>
  <br>
  <li>Temperatura:
    <ul>
      <li>Celsius.</li>
      <li>Fahrenheit.</li>
      <li>Kelvin.</li>
    </ul>
  </li>
</ul>
<br>

![Conversor Captura](https://github.com/Kxtss/Conversor-con-Java/assets/126207113/37a0305a-d720-4c96-977e-aa36223a4780)

# Documentación
En el <strong>index.html</strong> vienen los paquetes que contiene el proyecto (no sale el paquete de <i>Escenas</i> ya que este no contiene una clase). 

![Paquetes Información](https://github.com/Kxtss/Conversor-con-Java/assets/126207113/4a5fc76e-9f0d-45e9-8550-af6b18d15fdc)

En el paquete de aplicación (<i>Package.application</i>) contiene la información documentada de las clases que brindan la lógica al programa.
![Paquete Aplicación](https://github.com/Kxtss/Conversor-con-Java/assets/126207113/0fe1b8d1-3ddb-427e-ad59-2212503fe62e)

En el paquete de valores (<i>Package.Valores</i>) contiene la información documentada de las clases que brindan apoyo a las clases controladoras de la lógica. Estos almacenan los valores requeridos para que los Controladores funcionen correctamente en la conversión.

![Paquete Valores](https://github.com/Kxtss/Conversor-con-Java/assets/126207113/f3a9f834-e063-42e7-828a-9cfa0382edac)

<em>Cada clase contiene una documentación detallada para que funciona cada método</em>

# Referencias
<ul>
  <li><a href="https://www.eclipse.org/downloads/">Descargar Eclipse IDE</a></li>
  <li><a href="https://gluonhq.com/products/javafx/">JavaFX</a></li>
  <li><a href="https://gluonhq.com/products/scene-builder/">SceneBuilder</a></li>
  <li><a href="https://openjfx.io/openjfx-docs/">Documentacion de JavaFX</a></li>
  <li><a href="https://projects.eclipse.org/projects/technology.efxclipse">e(fx)clipse</a></li>
  <li><a href="https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html">Java JDK 17</a></li>
</ul>

# Conclusión
Esté fue mi proyecto, hay cosas que mejorar y una de ellas es poder implementar una API la cual haga el cambio de los valores de las divisas cada cierto tiempo, también dejo un archivo JAR que ahí contiene todos los archivos para usar.
