Projet personnel n�1
===
**D�veloppement d'une API REST de calcul g�om�trique.**
<br>
**Auteur:** Hiba GHADHAB - M2 TSI 2018/2019 - ENSG
<br>
**Op�rations g�om�triques:** Minimum Bounding Rectangle (MBR) et Minimum Bounding Circle (MBC).

Les web services d�velopp�s:
===

Mes deux op�rations (MBR et MBC) retournent les coordonn�es des points d'un polygone en format GeoJSON. 
Le polygone quelconque qu'on cherche � trouver son MBR et son MBC doit �tre sous format GeoJSON et dans un fichier � importer par l'utilisateur dans la page html. 
On peut tester notre API avec Swagger aussi. Le test sera sur un fichier qui se trouve d�j� dans le projet et qui s'appelle "file". Ce fichier contient un triangle.
Le lien du test de l'API avec Swagger est le suivant:
```
http://localhost:8080/swagger-ui.html#/main-controller
```
![swagger](https://gitlab.com/TSI2018/projet1/hiba-ghadhab/raw/master/Images/Swagger.PNG)

![triangle](https://gitlab.com/TSI2018/projet1/hiba-ghadhab/raw/master/Images/triangle.PNG)

* ***MBR_Geometry***

Le lien du test avec Swagger:
```url  
http://localhost:8080/swagger-ui.html#!/main-controller/MBR_GeometryUsingGET
```
* ***MBC_Geometry***

Lien de test avec Swagger:
```url  
http://localhost:8080/swagger-ui.html#!/main-controller/MBC_GeometryUsingGET
```

L'ex�cution de l'application:
===
Pour ex�cuter l'application, il faut t�l�charger le projet et lancer son ex�cutable (jar) par les commandes suivantes
```
git clone https://gitlab.com/TSI2018/projet1/hiba-ghadhab
cd hiba-ghadhab
cd target 
java -jar calculgeometrique-0.0.1-SNAPSHOT.jar
```
Ouvrir une autre fen�tre d'invite de commandes et taper les commandes suivantes pour afficher la page sur le navigateur:
```
cd hiba-ghadhab/Front
api's.html
```

Le fonctionnement:
===
J'ai ajout� une extension CORS � mon navigateur (Google Chrome) pour permettre l'appel de n'importe quel site via ajax � partir de n'importe quelle source. 

```
https://chrome.google.com/webstore/detail/allow-control-allow-origi/nlfbmbojpeacfghkpbjhddihlkkiljbi
```
 Apr�s le t�l�chargement, on doit l'activer.
 ![UploadFile](https://gitlab.com/TSI2018/projet1/hiba-ghadhab/raw/master/Images/cors.PNG)
 
<br>
L'image suivante repr�sente la page d'accueil. On trouve une carte, initialement, vide. On trouve aussi des boutons pour importer un fichier, pour afficher le MBR et pour afficher le MBC.
<br>
![Accueil](https://gitlab.com/TSI2018/projet1/hiba-ghadhab/raw/master/Images/Accueil.PNG)
<br>
Une fois le fichier est import�, on peut voir un message "file uploaded!" et le polygone s'affiche en bleu, comme suit: 
<br>
![UploadFile](https://gitlab.com/TSI2018/projet1/hiba-ghadhab/raw/master/Images/UploadFile.PNG)
Le fichier doit contenir un seul polygone. On peut tester sur l'un des deux fichiers (file et file2) qui existent d�j� dans le projet.
<br>
Apr�s l'importation du fichier, on peut cliquer sur MBR pour afficher le minimum bounding rectangle, du polygone du fichier import�, en rouge.
<br>
![MBR](https://gitlab.com/TSI2018/projet1/hiba-ghadhab/raw/master/Images/MBR.PNG)
<br>
Pour faire disparaitre le MBR, on clique une autre fois sur le bouton MBR.
<br>
En cliquant sur le bouton MBC, le minimum bounding circle du polygone s'affiche en vert. 
<br>
![MBC](https://gitlab.com/TSI2018/projet1/hiba-ghadhab/raw/master/Images/MBC.PNG)
<br>
Pour faire disparaitre le MBC, on clique une autre fois sur le bouton MBC.
<br>
Pour afficher le MBR et le MBC en m�me temps, on clique sur les deux boutons correspondants successivement.  On clique une autre fois pour les faire dispara�tre.
<br>
![MBRMBC](https://gitlab.com/TSI2018/projet1/hiba-ghadhab/raw/master/Images/MBRMBC.PNG)

Les difficult�s rencontr�es:
===

Une parmi les difficult�s rencontr�es au cours de ce projet �tait la gestion des d�pendances Maven. Le fichier pom.xml �tait tr�s d�licat. � cause d'une d�pendance suppl�mentaire ou manquante, tout le projet ne fonctionne plus. Il m'a fallu bien choisir mes d�pendances et toujours avoir un fichier pom "backup" pour mon projet.
<br>
**Bilan:** Le sujet de ce projet �tait une opportunit� de d�couvrir des nouvelles technologies comme Maven et Spring Boot, qui est la tendance d'aujourd'hui dans le d�veloppement web et des outils de d�veloppement int�ressantes comme Swagger. Ce projet m'a permis de faire pour la premi�re fois mes propres tests unitaires en java, de faire un ex�cutable et de r�diger un document ReadMe Markdown.
