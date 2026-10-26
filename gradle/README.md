###### ~/gradle/README.md >> markdown 

---

# 📁 Gradle
- — Configuration du Build (AndroidSamples v2.0)

Ce dossier contient les fichiers de configuration Gradle utilisés par le projet AndroidSamples.  
Il regroupe les paramètres essentiels pour :

- les builds CI/CD (GitHub Actions)  
- le wrapper Gradle  
- la stabilité et la reproductibilité des builds  
- la gestion multi‑modules du projet  

Ce dossier fait partie de l’architecture Enterprise du dépôt.

---

🗂️ Structure

```text
gradle/
├── wrapper/
│   └── gradle-wrapper.properties
│
├── README.md
├── ci-gradle.properties
├── enterprise-gradle.properties
├── enterprise-settings.gradle
├── lint.properties
├── security.properties
└── versions.properties
```

---

⚙️ 1. ci-gradle.properties

Fichier de configuration spécifique au CI/CD.

Il est chargé automatiquement par les workflows GitHub Actions pour optimiser :

- la mémoire JVM  
- le parallélisme  
- le cache Gradle  
- la stabilité du build  
- les performances sur les runners GitHub  

🎯 Objectif : garantir des builds rapides, stables et reproductibles dans le CI.

Ce fichier n’est pas utilisé en local, ce qui évite de perturber Android Studio.

---

🛠️ 2. wrapper/gradle-wrapper.properties

Fichier du Gradle Wrapper, utilisé par :

- ./gradlew  
- GitHub Actions  
- tous les développeurs du projet  

Il définit :

- la version de Gradle utilisée  
- l’URL de distribution  
- le mode de stockage du wrapper  

🎯 Objectif : assurer que tout le monde utilise exactement la même version de Gradle, pour éviter les incompatibilités.

---

🔗 Intégration avec le dépôt

Le dossier gradle/ est lié :

✔️ Au CI/CD
Les workflows GitHub Actions chargent ci-gradle.properties pour optimiser les builds.

✔️ Aux modules Android Enterprise
Tous les modules dans projects/ et sources/ utilisent le wrapper Gradle.

✔️ À la gouvernance du dépôt
Il garantit une architecture propre, stable et professionnelle.

---

🏁 Résumé

Le dossier gradle/ est un élément essentiel du projet AndroidSamples.  
Il assure :

- des builds cohérents  
- une configuration centralisée  
- une compatibilité totale entre développeurs et CI  
- une structure Enterprise propre et maintenable  

Ce dossier ne nécessite pas d’autres fichiers obligatoires, mais peut être étendu si nécessaire (lint, sécurité, versions, optimisation locale).

---
