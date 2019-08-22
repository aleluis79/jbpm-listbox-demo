# SelectorDataProvider

## Compila JAR:
mvn clean install

Que genera MySelectorDataProvider-0.0.1-SNAPSHOT.jar en la carpeta Target

## Agregar el jar en el JBPM

Dentro de la carpeta jbpm-server-7.25.0.Final-dist\standalone\deployments abrir el war business-central.war usando 7zip, y agregar en:

    \WEB-INF\lib\errai-data-binding-4.6.0.Final.jar
    \WEB-INF\lib\MySelectorDataProvider-0.0.1-SNAPSHOT.jar

El JAR errai-data-binding-4.6.0.Final.jar se obtiene de https://mvnrepository.com/artifact/org.jboss.errai/errai-data-binding/4.6.0.Final
IMPORTANTE: la versión del JAR debe coincidir con la versión incluída en el WAR de los JARs errai-*.jar. Por ejemplo: errai-common-4.6.0.Final.jar

## Modificaciones manuales en el proyecto BPM

1) Clonar el proyecto por GIT

2) editar el archivo de definición del Formulario, por ejemplo: prueba\src\main\resources\com\myspace\prueba\Task-taskform.frm

3) En el Field del tipo ListBox, con el Name que se quiere configurar, hay que cambiar "dataProvider":"" por "dataProvider":"remote:org.jbpm.MySelectorDataProvider"
donde org.jbpm.MySelectorDataProvider es el package y clase creada en el JAR.

IMPORTANTE: el ListBox NO debe tener opciones. La propiedad debe estar vacía, como "options":[]

4) Hacer commit y push.

IMPORTANTE: es muy probable que si se hacen ediciones al Formulario desde el WorkBench, se pierdan estos cambios y haya que volver a hacerlos.

5) PRUEBAS: funciona en el WorkBench, pero en el Render que genera la API REST, se incluye el Control, pero sin los valores (sin opciones), por lo que no funciona. Comprobado en ambos renders (Bootstrap y Patternfly). Tampoco en se incluyen los valores en el REST que devuelve la definición del Formulario.

Desde http://localhost:8080/kie-server/docs/ 

curl -X GET "http://localhost:8080/kie-server/services/rest/server/containers/prueba/forms/tasks/42/content?renderer=patternfly" -H  "accept: text/html"

Devuelve: 

    <div class="form-group">
        <label for="field_592772040290695E9">Valor</label> 
        <select id="field_592772040290695E9" name="valor" class="form-control" >
        </select>
    </div>

O abriendo desde un browser: http://localhost:8080/kie-server/services/rest/server/containers/prueba/forms/tasks/42/content?renderer=bootstrap



