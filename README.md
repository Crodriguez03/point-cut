Los aspectos de spring nos ayudan a evitar a repetir ciertas acciones en todo nuestro código. Los casos muy comunes suelen ser el de abrir la sesión antes de relizar una consulta a base de datos y después cerrarla. Gracias a los aspectos podemos realizar una acción antes de entrar en un método y realizar otra acción después de salir.

Hay varias formas de usar un aspecto:
- Mediante una anotación personalizada, con lo que cada método que esté anotado con ella se ejecutará la acción del aspecto.
- Definiendo un punto de corte a un método.
- Definiendo un punto de corte a una clase.

Por cada punto de corte definido podemos realizar las siguientes acciones: 
@Before - Acción antes de entrar en el método.
@After - Acción que se ejecuta al salir del método, incluso aunque se lance una excepción.
@AfterThrowing - Acción que se ejecuta cuando se lanza una excepción. Se ejecuta antes que la acción @After
@AfterReturning - Acción que se ejecuta al salir del método de forma correcta sin que se haya producido una excepción. Se ejecuta antes que la acción @After.
@Around - Esto engloba a todas las anteriores. Dentro se define la acción a realizar antes de entrar en el método, poder decidir si entrar o no en el método y la acción después de salir del método. Te permite capturar lo que devuelve el método y si se lanza una excepción, hay que capturarla para realizar la acción que corresponda.

Una cosa importante es que cuando se crea un aspecto lo que se está creando es un proxy que envuelve la clase del método, por lo que solo puede controlar las llamadas que se realizan desde fuera de la clase hacia dentro. Una vez que estás dentro de la clase y llamas a un método que tiene un punto de corte no funcionará. En resumen, una llamada interna de un método a otro dentro de la misma clase no va a hacer saltar un punto de corte.

Ejemplo:
