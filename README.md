# Asimov

## Projet d'application WEB JEE de l'année 2023/2024

Ce projet a été fait dans le cadre du cours de JEE d'ing 2 à CY-Tech.  
Il s'agit d'une plateforme d'achat de matériels électroniques.  

En arrivant sur le site les pages suivantes sont accessibles : Accueil, categories, produits, contact, connexion, inscription.   

Un compte client peut être accédé après la création d'un compte sur la page inscription ou via les identifiants d'un compte préinscrit comme suivant :   
> email : test@test 
> mot de passe : test

Une fois connecté en tant que client, on peut ajouter des produits au panier, consulter le panier et finaliser la commande sûr la page checkout.  
Une autre page nommée profil permet d'accéder à l'historique des commandes passées.

Les identifiants suivants : 
> email : seller@seller 
> mot de passe : seller

permettent d'accéder à un compte marchand. 
Ce dernier a accés à la page marchand qui permet de supprimer ou d'ajouter de nouveaux produits sur le site.

Enfin avec : 
> email: admin@admin 
> mot de passe : admin

On peut se connecter à un compte admin qui a access à un panneau d'administration permettant de supprimer ou d'ajouter des produits, 
des categories et des utilisateurs avec les roles souhaités.

## Démarrer le projet

Vous pouvez démarer le projet avec IntelliJ IDEA ou éxécutant les commandes suivantes :

```sh
mvn install
mvn package
java -jar target/asimov-0.0.1-SNAPSHOT.jar
```

Une fois ceci réalisé, insérez les utilisateurs, produits et catégories automatiquement en éxécutant le script suivant :

```sh
./insert.sh
```

## Version déployée 

Notre projet est pret pour la mise en production chez un hébergeur.  
Retrouvez un déploiement de celui ci à cette adresse :

[http://asimov.cleverapps.io/](http://asimov.cleverapps.io/)

