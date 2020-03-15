# GamePad-CB-Driver
Driver Crash Bandicoot pour la prise en charge des manettes de jeux (majoritairement Xbox 360)

# Présentation
GamePad-CB-Driver est un logiciel tiers du demake de Crash Bandicoot. Il sert à détecter et dialoguer avec vos contrôleurs de jeux afin de les rendre utilisables sur Crash Bandicoot. Une connexion par socket est utilisée afin que vous puissiez intéragire depuis d'autres sources avec ce driver. Aucune installation n'est nécessaire, ce dernier est lancé par le jeu quand son utilisation est nécessaire.

Pour le moment, le driver est compatible exclusivement avec les manettes Xbox 360 (et potentiellement avec les manettes Xbox One)

# Utilisation
Pour pouvoir utiliser GamePad-CB-Driver, vous devez tout d'abord lancer le driver avec la commande suivante :
`java -jar gamepad_cb_driver.jar 2236`

> L'argument 2236 représente le port sur lequel va écouter le driver pour communiquer avec un client, vous pouvez le changer afin qu'il correspond à celui de votre programme client.

Maintenant que le driver est lancé, il attend une connexion client afin de pouvoir envoyer les informations relatives à la manette.
/!\ Tant qu'aucune connexion client n'est effectuée, le driver ne lira pas les entrées de la manette.

# Dialogue
Voici les différents messages envoyés par le driver :

- RIGHT  :  stick to the right ( > 500 )
- LEFT  :  stick to the left ( < -500 )
- STOP  :  stick return in the middle
- JUMP  :  shoulder left & right pressed
- TORNADO  :  trigger left & right pressed ( > 200 )
- B  :  key B pressed

# Dev'Log
- Création du projet
- Import de la librairie J360Controller
- Création du serveur socket
- Ajout de la méthode de communication
- Création du controlleur
- Implémentation des évenements de la manette
- Test et finalisation
