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
Fue hecho con JavaFX, SceneBuilder, extensión "e(fx)clipse 3.8.0", Eclipse IDE 2023-06 y Java SDK 17.

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

![Conversor Captura](https://github.com/Kxtss/prueba/assets/126207113/ddee9815-d850-4341-a4cf-da383a0da3a1)

# Documentación
En el <strong>index.html</strong> vienen los paquetes que contiene el proyecto (no sale el paquete de <i>Escenas</i> ya que este no contiene una clase). 

![Paquetes información](https://github.com/Kxtss/prueba/assets/126207113/471f3cc2-b0cd-4833-9902-24ace7c96ca3)

En el paquete de aplicación (<i>Package.application</i>) contiene la información documentada de las clases que brindan la lógica al programa.
![Paquete aplicación](https://github.com/Kxtss/prueba/assets/126207113/03fad442-e0ac-4bf6-a86a-0a5f1538fae3)

En el paquete de valores (<i>Package.Valores</i>) contiene la información documentada de las clases que brindan apoyo a las clases controladoras de la lógica. Estos almacenan los valores requeridos para que los Controladores funcionen correctamente en la conversión.

![Paquete Valores](https://github.com/Kxtss/prueba/assets/126207113/e35d0d38-7ded-409a-9c4b-5482056cd35c)

<em>Cada clase contiene una documentación detallada para que funciona cada método</em>

# Referencias
<ul>
  <li><a href="https://www.eclipse.org/downloads/">Descargar Eclipse IDE</a></li>
  <li><a href="https://gluonhq.com/products/javafx/">JavaFX</a></li>
  <li><a href="https://gluonhq.com/products/scene-builder/">SceneBuilder</a></li>
  <li><a href="https://openjfx.io/openjfx-docs/">Documentacion de JavaFX</a></li>
</ul>

# Conclusión
Esté fue mi proyecto, hay cosas que mejorar y una de ellas es poder implementar una API la cual haga el cambio de los valores de las divisas cada cierto tiempo, también dejo un archivo JAR que ahí contiene todos los archivos para usar.
