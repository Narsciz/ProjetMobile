
*******************Lancement du serveur*******************
 Le serveur a �t� cod� et test� avec les outils suivant qui sont donc n�c�ssaire :
		-Base de donn�e mySql
		-WampServer 3.0.6 et son gestionnaire phpMyAdmin
		
 Le serveur est un projet Eclipse et il suffit donc de le lancer avec Eclipse (ouvrir Eclipe -> ouvrir projet ou import)

/!\ parfois, le package JDBC servant � la gestion de la base de donn�e et se situant dans l'arborescence suivante : servor/lib/musql-connector-java-5.0.5-bin.jar ne se charge pas dans le projet eclipse, il faut alors l'ajouter par eclipse

 V�rifier aussi que le package CommonClasses se situant � : servor/src/CommonClasses � lui aussi bien �t� charg� par eclipse

 La base de donn�e a �t� exporter dans le fichier coursenligne.sql situ� a la racine du projet. Il suffit avant le lancement du serveur, par phpmyadmin, d'importer ce fichier pour importer la base de donn�e (Structures et remplissage)

 Le serveur peut ensuite �tre lanc�, le main se trouvant dans le fichier MultiThreadedSocketServer.java


*******************Lancement du client*******************
	
Ouvrez Android studio, ouvrez le projet "Client" dans le dossier racine et enfin ex�cuter le projet dans un �mulateur ou sur votre propre mobile.

/!\ Les vid�os ne fonctionnent que sur mobile, l'�mulateur (du moins chez moi) ne semblent pas pouvoir afficher de vid�os.

Note : Si le serveur ne fonctionne pas, nous avons mis � disposition un mode de navigation qui ne fait ni appel au serveur ni � la base de donn�e, juste pour donner une id�e de la navigation de l'application avec des activit�s dont le contenu est toujours le m�me.
	
