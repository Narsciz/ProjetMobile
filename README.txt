
*******************Lancement du serveur*******************
 Le serveur a été codé et testé avec les outils suivant qui sont donc nécéssaire :
		-Base de donnée mySql
		-WampServer 3.0.6 et son gestionnaire phpMyAdmin
		
 Le serveur est un projet Eclipse et il suffit donc de le lancer avec Eclipse (ouvrir Eclipe -> ouvrir projet ou import)

/!\ parfois, le package JDBC servant à la gestion de la base de donnée et se situant dans l'arborescence suivante : servor/lib/musql-connector-java-5.0.5-bin.jar ne se charge pas dans le projet eclipse, il faut alors l'ajouter par eclipse

 Vérifier aussi que le package CommonClasses se situant à : servor/src/CommonClasses à lui aussi bien été chargé par eclipse

 La base de donnée a été exporter dans le fichier coursenligne.sql situé a la racine du projet. Il suffit avant le lancement du serveur, par phpmyadmin, d'importer ce fichier pour importer la base de donnée (Structures et remplissage)

 Le serveur peut ensuite être lancé, le main se trouvant dans le fichier MultiThreadedSocketServer.java


*******************Lancement du client*******************
	
Ouvrez Android studio, ouvrez le projet "Client" dans le dossier racine et enfin exécuter le projet dans un émulateur ou sur votre propre mobile.

/!\ Les vidéos ne fonctionnent que sur mobile, l'émulateur (du moins chez moi) ne semblent pas pouvoir afficher de vidéos.

Note : Si le serveur ne fonctionne pas, nous avons mis à disposition un mode de navigation qui ne fait ni appel au serveur ni à la base de donnée, juste pour donner une idée de la navigation de l'application avec des activités dont le contenu est toujours le même.
	
