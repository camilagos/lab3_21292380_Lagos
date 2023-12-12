# lab3_21292380_Lagos
1. Para comenzar el menú se compila y ejecuta mediante: ./gradlew.bat build y ./gradlew.bat run.

2. En el menú principal se puede elegir registrar un usuario, o iniciar sesión.

3. Al elegir registrar un usuario se solicitará el nombre del nuevo usuario, y luego si será un usuario 
normal o admin. A continuación, se volverá al menú principal para iniciar sesión, si el usuario con 
el que se inicia sesión es normal o admin se desplegaran diferentes menús.

4. El usuario normal tendrá la opción de interactuar con el sistema ya existente, para eso se le 
solicitará el mensaje para interactuar, ver su historial de interacciones con el sistema y cerrar su 
sesión. Por otra parte, el usuario admin puede hacer esas mismas acciones con el sistema existente, 
o puede crear un nuevo sistema, donde se desplegará otro menú.

5. En este menú se sugiere seguir el orden de las opciones, primero se crean las opciones que 
quieran, luego pasa a crear un flujo, que se creara con las ultimas opciones creadas, si se quiere 
agregar una nueva opción se debe ingresar el código del flujo al que se debe agregar cuando se pida.
Posteriormente se debe crear el chatbot, que al igual que el flujo, se creara con los últimos flujos 
hechos. Luego para agregar un flujo a un chatbot se deben crear primeros las opciones, y luego 
elegir la opción agregar flujo, para crear el flujo a agregar, y elegir el código del chatbot al que se 
agregará. Finalmente, se podrá crear el sistema con todo lo generado antes, y automáticamente se 
redirigirá al menú principal, pero haciendo uso del nuevo sistema creado.