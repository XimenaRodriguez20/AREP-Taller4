# AREP-Taller4 AREP - Arquitecturas de Servidores de Aplicaciones, Meta protocolos de objetos, Patrón IoC, Reflexión

Para este laboratorio deberemos servidor Web (tipo Apache) en Java. El servidor debe ser capaz de entregar páginas html e imágenes tipo PNG. Igualmente el servidor debe proveer un framework IoC para la construcción de aplicaciones web a partir de POJOS. Usando el servidor se debe construir una aplicación Web de ejemplo. El servidor debe atender múltiples solicitudes no concurrentes.

Para este taller desarrolle un prototipo mínimo que demuestre capcidades reflexivas de JAVA y permita por lo menos cargar un bean (POJO) y derivar una aplicación Web a partir de él. 

Debe entregar su trabajo al final del laboratorio. Luego puede complementar para entregarlo en 8 días. Se verificara y compararán el commit del día de inicio del laboratorio y el dela entrega final.

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

    ![image](https://github.com/XimenaRodriguez20/AREP-Taller3/assets/123812926/33193bfe-2e17-4e0f-bb59-7cd120c0d139)

    ![image](https://github.com/XimenaRodriguez20/AREP-Taller2/assets/123812926/7faedfe9-51ea-4186-aecd-68ef24dec66a)

    ![image](https://github.com/XimenaRodriguez20/AREP-Taller2/assets/123812926/09f7d8bf-f2e2-489d-a931-63482627f7bb)

* Para la petición post, se puede probar colocando el siguiente path http://localhost:35000/action/recibido:

    ![image](https://github.com/XimenaRodriguez20/AREP-Taller3/assets/123812926/25e6b416-250d-4272-8702-d2f11fd01999)

## Arquitectura del programa

   HttpServer
    Es la clase que obtendra las solicitudes  y se encargara respectivamente de retonar la información que se solicita

   App 
    Sera quien nos permita ejecutar el servidor y asi mismo quien tendra las indicaciones lambda



## Autor

* **Ximena Rodriguez** 
