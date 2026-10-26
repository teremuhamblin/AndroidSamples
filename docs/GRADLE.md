###### ~/docs/GRADLE.md >> markdown 
- — Documentation
# AndroidSamples

Elle couvre tout ce qu’un développeur ou maintainer doit savoir sur ton système Gradle : structure, rôle, CI/CD, optimisation, wrapper, propriétés, multi‑modules, bonnes pratiques, et extensions Enterprise.

###### AndroidSamples/docs/GRADLE.md

---

# 🛠️ GRADLE
📌 Introduction

Ce document explique la structure, le fonctionnement et les bonnes pratiques liées à Gradle dans le dépôt AndroidSamples v2.0 Enterprise.  
Il couvre :

- l’organisation du dossier gradle/  
- le rôle du wrapper  
- les propriétés CI/CD  
- la gestion multi‑modules  
- les optimisations Enterprise  
- les bonnes pratiques pour les mainteneurs  

---

🗂️ 1. Structure Gradle du dépôt

Le dépôt AndroidSamples utilise une structure Enterprise :
VOIR gradle/

📁 gradle/ci-gradle.properties
Fichier chargé uniquement dans le CI GitHub Actions.  
Il contient des optimisations pour :

- la mémoire JVM  
- le parallélisme  
- le cache Gradle  
- la stabilité du build  
- la réduction du temps de compilation  

Ce fichier n’est pas utilisé en local, ce qui évite de polluer les builds Android Studio.

📁 gradle/wrapper/gradle-wrapper.properties
Définit :

- la version de Gradle utilisée  
- l’URL de distribution  
- le mode de stockage du wrapper  

Ce fichier garantit que tous les développeurs et le CI utilisent la même version de Gradle, assurant une reproductibilité totale.

---

⚙️ 2. Le Gradle Wrapper

Le wrapper est composé de :

- gradlew  
- gradlew.bat  
- gradle/wrapper/gradle-wrapper.properties  
- gradle/wrapper/gradle-wrapper.jar  

🎯 Objectifs du wrapper

- Assurer une version unique de Gradle pour tout le monde  
- Permettre au CI de télécharger automatiquement la bonne version  
- Éviter les incompatibilités entre environnements  
- Garantir la stabilité des builds multi‑modules  

🔧 Version utilisée

Le dépôt utilise :

`
Gradle 8.5 (bin)
`

Compatible avec :

- Android Studio Koala  
- AGP 8.2 / 8.3  
- Kotlin 1.9+  
- CI GitHub Actions optimisé  

---

🧩 3. Gradle dans un projet multi‑modules Android Enterprise

AndroidSamples contient plusieurs modules :

`
projects/
sources/
`

Gradle gère ces modules via :

- settings.gradle.kts  
- build.gradle.kts de chaque module  
- les propriétés globales dans gradle/  

✔️ Avantages du multi‑modules

- séparation claire des responsabilités  
- compilation plus rapide  
- meilleure isolation du code  
- tests indépendants  
- CI plus efficace  
- architecture Enterprise propre  

---

🚀 4. Propriétés CI : ci-gradle.properties

Ce fichier optimise les builds CI :

Exemples de propriétés typiques

`
org.gradle.daemon=false
org.gradle.parallel=true
org.gradle.caching=true
org.gradle.jvmargs=-Xmx3g -XX:+UseParallelGC
kotlin.incremental=false
`

🎯 Objectifs

- éviter les crashs JVM dans GitHub Actions  
- réduire le temps de build  
- stabiliser les builds multi‑modules  
- éviter les problèmes de cache corrompu  

---

🛡️ 5. Optimisations Enterprise recommandées

Tu peux ajouter d’autres fichiers dans gradle/ pour améliorer ton dépôt :

🟦 enterprise-gradle.properties
Optimisation locale (Android Studio) :

`
org.gradle.caching=true
org.gradle.parallel=true
org.gradle.configureondemand=true
kotlin.incremental=true
`

🟧 security.properties
Renforce la sécurité du code compilé :

`
android.enableR8.fullMode=true
android.enableD8.desugaring=true
`

🟩 lint.properties
Centralise les règles Lint :

`
lint.abortOnError=false
lint.checkReleaseBuilds=true
`

🟥 versions.properties
Centralise les versions des dépendances :

`
androidx.core=1.13.1
material=1.12.0
zxing=4.3.0
`

---

🧬 6. Gradle & CI/CD (GitHub Actions)

Ton CI utilise :

`
.github/workflows/android-ci.yml
`

Ce workflow :

- charge ci-gradle.properties  
- compile tous les modules  
- exécute Lint  
- exécute les tests  
- utilise le cache Gradle  
- utilise le wrapper Gradle  

🔗 Liaison CI ↔ Gradle

Ton script CI :

`
.github/scripts/build_androidsamples.sh
`

charge explicitement :

`bash
export GRADLEOPTS="$GRADLEOPTS $(cat gradle/ci-gradle.properties | tr '\n' ' ')"
`

👉 Le dossier gradle/ est donc directement lié au CI.

---

📘 7. Bonnes pratiques pour les mainteneurs

✔️ Toujours utiliser ./gradlew
Ne jamais utiliser gradle directement.

✔️ Ne jamais modifier gradle-wrapper.jar
Toujours régénérer via :

`
./gradlew wrapper --gradle-version 8.5
`

✔️ Ne pas mettre de propriétés CI dans gradle.properties
Ce fichier doit rester local.

✔️ Garder ci-gradle.properties minimal et stable
Le CI doit être prévisible.

✔️ Versionner le wrapper
Toujours commit :

- gradlew  
- gradlew.bat  
- gradle/wrapper/*

---

🧭 8. FAQ Gradle

❓ Puis‑je ajouter d’autres fichiers dans gradle/ ?
Oui, mais uniquement des fichiers de configuration Enterprise.

❓ Le dossier gradle/ est‑il obligatoire ?
Non, mais fortement recommandé pour les projets Enterprise.

❓ Le wrapper doit‑il être mis à jour souvent ?
Non.  
Une mise à jour tous les 6–12 mois est suffisante.

---

🏁 Conclusion

Le dossier gradle/ est un élément essentiel de ton dépôt AndroidSamples v2.0 Enterprise.  
Il garantit :

- des builds stables  
- des performances optimales  
- une reproductibilité totale  
- une architecture propre  
- une intégration CI/CD professionnelle  

Tu peux l’étendre avec des fichiers optionnels pour améliorer encore la qualité du dépôt.

---
