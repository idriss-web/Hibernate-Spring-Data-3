
# Hibernate - Spring Data Many-to-Many

Dans ce projet, nous avons implémenté un système de gestion des utilisateurs et des rôles
en utilisant Spring Boot, Spring Data JPA, Hibernate et la base de données en mémoire H2.

Ce travail a pour objectif principal de démontrer la gestion d’une relation
Many-To-Many entre les entités User et Role, ainsi que l’utilisation d’un service métier
(UserService) pour gérer l’authentification et l’attribution des rôles aux utilisateurs.

## Technologies utilisées

Spring Boot  
Spring Data JPA  
Hibernate  
H2 Database  
Lombok  
Spring Web REST

## Architecture du projet

- Entités : User, Role
- Relation : Many-To-Many
- Service métier : UserService avec une implémentation transactionnelle
- Repositories Spring Data : UserRepository, RoleRepository
- Test initial au lancement (CommandLineRunner)
- Endpoint REST permettant de consulter un utilisateur par son username

## Description des entités

### User
- userId : String (UUID généré automatiquement)
- userName : String unique
- password : String
- roles : liste de rôles associée (Many-To-Many)

### Role
- id : Long (clé primaire auto-incrémentée)
- roleName : String
- users : liste d’utilisateurs associés (Many-To-Many inverse)

Une table d’association `USERS_ROLES` est automatiquement générée.

## Fonctionnalités

Ajouter des utilisateurs  
Ajouter des rôles  
Associer un rôle à un utilisateur  
Authentifier un utilisateur par login et mot de passe  
Consulter un utilisateur en API REST

## Exemple d’appel REST

GET /users/{username}

Réponse attendue (exemple)
{
  "userId": "...",
  "userName": "user1",
  "roles": [
    {"id": 1, "roleName": "STUDENT"},
    {"id": 2, "roleName": "USER"}
  ]
}

## Exécution du projet

1. Cloner le projet
2. Ouvrir dans IntelliJ et installer les dépendances Maven
3. Lancer la classe principale Hibernate_Spring_Data_Many_To_Many_Case
4. Accéder à H2 console : http://localhost:8080/h2-console
5. Tester les appels API

## Captures d’écran

- screenshot: screenshots/a.png
- screenshot: screenshots/b.png
- screenshot: screenshots/c.png
- screenshot: screenshots/d.png
- screenshot: screenshots/e.png
- screenshot: screenshots/f.png
- screenshot: screenshots/g.png
- screenshot: screenshots/h.png
- screenshot: screenshots/i.png
- screenshot: screenshots/j.png
- screenshot: screenshots/k.png
- screenshot: screenshots/l.png


## Conclusion

Ce projet représente une base solide pour développer des systèmes complets de gestion
des utilisateurs et de leurs privilèges d’accès. Il met en pratique l’ORM JPA avec
Hibernate ainsi que le développement REST basé sur Spring Boot.

