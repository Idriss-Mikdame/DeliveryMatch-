![séquence (1)](https://github.com/user-attachments/assets/f76716b0-f3d1-4c62-8049-a8cc94c0d32a)
<img width="641" alt="Capture d'écran 2025-06-22 220736" src="https://github.com/user-attachments/assets/e5bb4f4f-a706-480a-a7d4-abab35428015" />

<img width="503" alt="image" src="https://github.com/user-attachments/assets/59c5dd5f-be26-4796-a487-57d50915f319" />
# DeliveryMatch Platform

## 📖 Contexte du projet  
DeliveryMatch est une application de mise en relation entre expéditeurs et conducteurs pour le transport de colis. Elle propose à chaque utilisateur de s’inscrire et de se connecter pour gérer ses trajets ou ses envois. Un administrateur peut superviser la plateforme et générer des statistiques en temps réel.

---

## 📝 User Stories

### 👤 Utilisateur  
- **Créer un compte** : fournir nom, prénom, email, mot de passe.  
- **Se connecter / Se déconnecter** : accès sécurisé à ses fonctionnalités.  
- **Modifier profil** : mettre à jour ses informations personnelles.

### 🚗 Conducteur  
- **Publier une annonce** : lieu de départ, étapes, destination, dimensions max, type de marchandise, capacité disponible.  
- **Voir demandes reçues** : lister et décider d’accepter ou refuser.  
- **Accepter / Refuser une demande** : selon préférences ou capacité.  
- **Consulter historique** : trajets et colis transportés.

### 📦 Expéditeur  
- **Rechercher des annonces** : filtrer par destination, date, type de colis.  
- **Envoyer une demande de transport** : préciser dimensions, poids, type du colis.  
- **Consulter son historique** : suivis des demandes et colis expédiés.

### 🛠️ Administrateur  
- **Dashboard de gestion** : vue globale des utilisateurs, annonces, demandes.  
- **Valider / Suspendre un utilisateur** : attribuer un badge “Vérifié” après contrôle d’identité.  
- **Gérer les annonces** : consulter, modifier ou supprimer.  
- **Statistiques (Chart.js)** : nombre d’annonces, taux d’acceptation, utilisateurs actifs.

### 🎁 BONUS  
- **Notifications** : informer les utilisateurs (acceptation/refus, confirmation de livraison).  
- **Évaluations** : conducteurs évaluent expéditeurs et réciproquement après la livraison.

---

## 🔧 Technologies Utilisées

| Côté       | Technologie                           |
|------------|---------------------------------------|
| Backend    | Spring Boot, Spring Data JPA, Spring Security |
| Frontend   | Angular 16+, Angular Material, Bootstrap/Tailwind, Chart.js |
| Base de données | PostgreSQL ou MySQL             |
| Tests      | JUnit                                 |
| CI/CD      | Docker (conteneurisation)            |
| Documentation APIs | Swagger / Collection Postman  |

---

## 🚀 Démarrage rapide

1. **Cloner le dépôt**  
   ```bash
   git clone https://github.com/ton-organisation/deliverymatch.git
   cd deliverymatch
