# 20-21-PracticaFAlgorismia
FinalProject for Algorithm's subject


Cosas pendientes: 


-Crear las clases que hay en el UML (Marc)

-Ha desaparecido el paquete chesspieces (Nunca desapareció :) )

-Crear la función que lee el csv loadUsers() (Toni) - le pido un detalle al profe y eso ya esta casi acabado (Done by Marc y Toni)


Preguntas para el profe: 

Marc:- Revisión del paquete chesspieces: preguntar al profesor sobre la clase ChessPiece y los recursos estáticos y finales.

-En el enunciado no sale nada del correo pero en el codigo plantilla si que sale el correo, lo guardamos o no?

-Representación en un csv de un jugador: Nom,Llinatges,Tipus,N.Accessos.
-Datos de un jugador:                  : Nom,Llinatges,Tipus,N.Accessos,PartidesJugades,PartidesGuanyades,PartidesNoFinalitzades

Es decir, que la representación de un jugador tiene menos datos que los que deberia de tener un jugador. Se originan 2 maneras de arreglar esto.

1.Cambiar la manera en los que se almacenan los csv para que almacenen los datos extra.
2.Extraer los datos que faltan del csv con datos de partida (si hacemos esto habra que cambiar el codigo plantilla y poner que se carguen primero las partidas y luego los usuarios)


-Los csv tienen que tener siempre el mismo numero de columnas para cada linea? (mostrar el archivo usuaris2.csv) es que hay que guardar mas información para
un jugador que para un arbitro que para un socio. Que hacemos? Lo dejamos asi? Ponemos las columnas siempre iguales y si no necesitamos ese valor ponemos un -?

