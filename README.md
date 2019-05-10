Projet personnel n°1
===
**Développement d'une API REST de calcul géométrique.**
<br>
**Auteur:** Hiba GHADHAB - M2 TSI 2018/2019 - ENSG
<br>
**Opérations géométriques:** Minimum Bounding Rectangle (MBR) et Minimum Bounding Circle (MBC).

Les web services développés:
===

Mes deux opérations (MBR et MBC) retournent les coordonnées des points d'un polygone en format GeoJSON. 
Le polygone quelconque qu'on cherche à trouver son MBR et son MBC doit être sous format GeoJSON et dans un fichier à importer par l'utilisateur dans la page html. 
On peut tester notre API avec Swagger aussi. Le test sera sur un fichier qui se trouve déjà dans le projet et qui s'appelle "file". Ce fichier contient un triangle.
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

L'exécution de l'application:
===
Pour exécuter l'application, il faut télécharger le projet et lancer son exécutable (jar) par les commandes suivantes
```
git clone https://gitlab.com/TSI2018/projet1/hiba-ghadhab
cd hiba-ghadhab
cd target 
java -jar calculgeometrique-0.0.1-SNAPSHOT.jar
```
Ouvrir une autre fenêtre d'invite de commandes et taper les commandes suivantes pour afficher la page sur le navigateur:
```
cd hiba-ghadhab/Front
api's.html
```

Le fonctionnement:
===
J'ai ajouté une extension CORS à mon navigateur (Google Chrome) pour permettre l'appel de n'importe quel site via ajax à partir de n'importe quelle source. 

```
https://chrome.google.com/webstore/detail/allow-control-allow-origi/nlfbmbojpeacfghkpbjhddihlkkiljbi
```
 Après le téléchargement, on doit l'activer.
 ![UploadFile](https://gitlab.com/TSI2018/projet1/hiba-ghadhab/raw/master/Images/cors.PNG)
 
<br>
L'image suivante représente la page d'accueil. On trouve une carte, initialement, vide. On trouve aussi des boutons pour importer un fichier, pour afficher le MBR et pour afficher le MBC.
<br>
![Accueil](https://gitlab.com/TSI2018/projet1/hiba-ghadhab/raw/master/Images/Accueil.PNG)
<br>
Une fois le fichier est importé, on peut voir un message "file uploaded!" et le polygone s'affiche en bleu, comme suit: 
<br>
![UploadFile](https://gitlab.com/TSI2018/projet1/hiba-ghadhab/raw/master/Images/UploadFile.PNG)
Le fichier doit contenir un seul polygone. On peut tester sur l'un des deux fichiers (file et file2) qui existent déjà dans le projet.
<br>
Après l'importation du fichier, on peut cliquer sur MBR pour afficher le minimum bounding rectangle, du polygone du fichier importé, en rouge.
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
Pour afficher le MBR et le MBC en même temps, on clique sur les deux boutons correspondants successivement.  On clique une autre fois pour les faire disparaître.
<br>
![MBRMBC](https://gitlab.com/TSI2018/projet1/hiba-ghadhab/raw/master/Images/MBRMBC.PNG)

Les difficultés rencontrées:
===

Une parmi les difficultés rencontrées au cours de ce projet était la gestion des dépendances Maven. Le fichier pom.xml était très délicat. À cause d'une dépendance supplémentaire ou manquante, tout le projet ne fonctionne plus. Il m'a fallu bien choisir mes dépendances et toujours avoir un fichier pom "backup" pour mon projet.
<br>
**Bilan:** Le sujet de ce projet était une opportunité de découvrir des nouvelles technologies comme Maven et Spring Boot, qui est la tendance d'aujourd'hui dans le développement web et des outils de développement intéressantes comme Swagger. Ce projet m'a permis de faire pour la première fois mes propres tests unitaires en java, de faire un exécutable et de rédiger un document ReadMe Markdown.
