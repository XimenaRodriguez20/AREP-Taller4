# AREP-Taller4 AREP - Arquitecturas de Servidores de Aplicaciones, Meta protocolos de objetos, Patrón IoC, Reflexión

En este proyecto, se tiene un servidor Web de Java, el cual es capaz de recibir peticiones de distintos tipos, como GET y POST, los cuales retornan respuestas distintas, tambien tiene la capacidad de retornar diferentes tipos de documentos, es decir, tiene la capacidad de devolver documentos tipo HTML, JS, CSS e incluso distintos tipos de imagenes como JPG y PNG. La novedad de esta entrega esta en que ahora, gracias a la clase MySpringBoot y las clases que definen las anotaciones, el proyecto tiene la capacidad que antes de que inicie el servidor cargue a una lista los metodos dentro de las clases que tienen unas anotaciones especificas, logrando asi, un comportamiento similar al de SpringBoot, además una vez cargadas, el programa tiene la capacidad de determinar segun la URL de la peticion que reciba usar los metodos definidos con estas anotaciones, logrando asi nuevamente un comportamiento similar al de SpringBoot


## Prerequisitos 

 * Se debe tener minimo Maven, Java y Git. Si desea el paso a paso de cada uno de estas instalaciones de manera más visual para mejor comprensión, puede buscar una breve explicacion en Youtube, sin embargo, adjunto los links de las paginas oficiales donde indican paso a paso su respectiva instalación.
   
    - Git <br>
      <https://git-scm.com/book/es/v2/Inicio---Sobre-el-Control-de-Versiones-Instalaci%C3%B3n-de-Git>
   - Maven <br>
      <https://maven.apache.org/install.html>
   - Java <br>
      <https://www.java.com/es/download/help/windows_manual_download.html>
     
## Construido con

 * [Maven](https://maven.apache.org/) - Manejo de dependencias y la estructura de las carpetas
 * [Git](https://git-scm.com/) - Control de versiones
 * [Java](https://www.java.com/en/download/help/whatis_java.html) - Lenguaje de Programación
 * 
## Empezando

  * Para obtener una copia del proyecto en su maquina local:
    
    - Se debe ubicar en la carpeta donde desea bajar el proyecto y le da click donde señala la flecha y esribe cmd:
   
      ![image](https://github.com/XimenaRodriguez20/AREP-Taller2/assets/123812926/52f8f03c-3b3e-48cf-bd2c-f7b029c2d8bb)
   
    - Despues de esto debe escribir el el siguiente comando:
   
      ~~~                  
      git clone https://github.com/XimenaRodriguez20/AREP-Taller4.git
      ~~~                                                                   

  * Para poder correr el codigo abra el IDE de su preferencia y ejecute la clase: 
     - App

       ![image](https://github.com/XimenaRodriguez20/AREP-Taller4/assets/123812926/798a9113-c439-4999-91bf-be1d9d737ee9)


  ## Pruebas

  * Para evidenciar el funcionamiento del endpoint creado con anotaciones luego de consultar la url **http://localhost:35000/spring/hola** tambien se puede ver, que recibe parametros, pues dentro de la pagina se puede ver que parte de la URL se imprime junto con un mensaje por defecto:

  ![image](https://github.com/XimenaRodriguez20/AREP-Taller4/assets/123812926/83404e32-283a-400a-b992-c1929de8835b)

  * Para comprobar que no se afecto nada de las entregas anteriores haremos las siguientes prubras:

  * Para evidenciar lo que hace nuestro servidor con la petición get, abrimos un navergador web y escribrimos **localhost:35000/action/hola** :

  ![image](https://github.com/XimenaRodriguez20/AREP-Taller3/assets/123812926/9346c6b0-4c94-4a0d-9cf6-6b5a1d1322ce)

  Para evidenciar que esta jalando los archivos estaticos como html, css, js, escribimos en el navegador **localhost:35000/[respectivo archivo estatico que desee consultar]** 
  
  ![image](https://github.com/XimenaRodriguez20/AREP-Taller3/assets/123812926/4c75ba74-a898-4c73-8de6-b16b7b607852)

  ![image](https://github.com/XimenaRodriguez20/AREP-Taller3/assets/123812926/7b813e25-08a4-448b-b274-06ae23e97465)

  ![image](https://github.com/XimenaRodriguez20/AREP-Taller3/assets/123812926/5ab8527a-e656-4d8f-841f-4703e2024329)

  * Para buscar una pelicula debemos escribir el nombre de la pelicula y darle click al boton, en caso contrario si solo damos enter no nos va a dar ninguna información:
    
  ![image](https://github.com/XimenaRodriguez20/AREP-Taller2/assets/123812926/14d4b2e8-7840-4c24-868c-67bc0fa02578)

  ![image](https://github.com/XimenaRodriguez20/AREP-Taller2/assets/123812926/926e7d02-84b4-4b30-a0e0-94fa38ead6e9)

  * Para evidenciar que se esta obteniendo las imagenes desde el disco local, escribimos en el path de la pagina web el nombre del las imagenes que tenemos en disco local que son: john.jpeg y dolphin.jpg

  ![image](https://github.com/XimenaRodriguez20/AREP-Taller4/assets/123812926/19f23843-fe15-4d0a-9299-5b2e05ff96b8)

  ![image](https://github.com/XimenaRodriguez20/AREP-Taller2/assets/123812926/7faedfe9-51ea-4186-aecd-68ef24dec66a)

  ![image](https://github.com/XimenaRodriguez20/AREP-Taller2/assets/123812926/09f7d8bf-f2e2-489d-a931-63482627f7bb)

* Para la petición post, se puede probar colocando el siguiente path http://localhost:35000/action/recibido:

    ![image](https://github.com/XimenaRodriguez20/AREP-Taller3/assets/123812926/25e6b416-250d-4272-8702-d2f11fd01999)

*  Si desea  tambien en la terminal del IDE puede correr la carpeta test de la siguiente forma:

~~~
mvn test
~~~

## Arquitectura del programa

   ### HttpServer
   Es la clase que obtendra las solicitudes  y se encargara respectivamente de retonar la información que se solicita, esto a travez de el llamado a otros metodos de otras clases, a los cuales les suministra la URL obtenida, con la cual puede variar su comportamiento asi como la respuesta

   ### App 
   Sera quien nos permita ejecutar el servidor y asi mismo quien tendra las indicaciones lambda, para enta entrega en esta clase tambien se ejecuta un metodo que escanea todas las clases que cuenten con unas anotacoines especificas

   ### Controller
   Es la clase define cuales con los endpoints que se van a manejar, estos enpoints se configuran dentro de la anotacion "@GetMapping". Esto sirve al momento de que cuando la clase HttpServer reciba una peticion a un endpoint en especifico, este redireccione a alguno de estos metodos para obtener el resultado deseado
    
   ### Component
   Es la clase que configura la anotacion de clase, esta es la anotacion que esta escaneando MySpringBoot

  ### GetMapping
   Es la clase que configura la anotacion de metodos , esta es la anotacion que esta escaneando MySpringBoot
   
   ### MySpringBoot
   Es la clase que permite cargar los POJOs que cuenten con una anotacion en particular, tambien permite hacer la invocacion de metodos gracias a que al cargar los POJOs, guarda los metodos que cumplen con las anotaciones que estan hasta el momento creadas, de esta forma se puede ejecutar un metodo en particular si se tiene el valor de la anotacion como "/hola"

## Uso del Framekork para el desarrollador

Si desesa añadir un nuevo endpoint, unicamente tendra que crear un nuevo metodo en la clase Controller siguiendo la estructura de los otros metodos. En el @GetMapping debe colocar cual es el endpoint al cual desea redireccionar las peticiones y dentro del metodo definir el comportamiento que tendra, cabe aclarar que los endpoints deben ser distintos y lo que devuelva el metodo debe ser String:

![image](https://github.com/XimenaRodriguez20/AREP-Taller4/assets/123812926/99e01dbd-03b6-431f-a3df-892a9a410a3d)

Ahora bien, si desea crear mas anotacionse, debe crear una clase en la carpeta components y seguir la estructura de las dos clases que ya estan definidas, si desea crear una anotacion de clase use la estructura de la primera imagen, cambiando el nombre de la clase y si desea crear una anotacion para los metodos, use la estructura de la segunda iamgen:

![image](https://github.com/XimenaRodriguez20/AREP-Taller4/assets/123812926/2ffcdb5f-be25-4ab2-94a0-bde38570c590)

Si desea que la anotacion para metodos, reciba varios parametros, puede agregar mas atributos a la clase, sin embargo tenga en cuenta que a la hora de usar la anotacion tendra que colocar el nombre de la variable, es decir, si a la clase siguiente se agrega un nuevo atriburo como name, a la hora de usar la anotacion se deberia colocar @GetMapping("/hola", name="name"):

![image](https://github.com/XimenaRodriguez20/AREP-Taller4/assets/123812926/359b776a-e8c9-4845-abe1-de354826e5ea)

## Autor

* **Ximena Rodriguez** 
