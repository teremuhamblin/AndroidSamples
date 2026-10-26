###### ~/sources/README.md >> markdown 

---

# 📁 Sources
- — AndroidSamples v2.0
Ce dossier contient le code mutualisé utilisé par l’ensemble des modules Android Enterprise du projet.  
Il regroupe les composants essentiels, les outils internes et les fonctionnalités communes nécessaires au bon fonctionnement des projets situés dans projects/.

---

🧩 Structure

```text
sources/
├── core/
├── enterprise/
└── utils/
```

---

⚙️ 1. core/
Contient le noyau technique du projet.

Inclut généralement :
- BaseActivity / BaseFragment  
- gestion des permissions  
- gestion du logging  
- extensions Kotlin  
- configuration commune Android  

🎯 Objectif : fournir les fondations techniques utilisées par tous les modules.

---

🛡️ 2. enterprise/
Contient les composants liés à Android Enterprise.

Inclut :
- DeviceAdminReceiver  
- gestion des policies DO/PO  
- provisioning helpers  
- configuration Enterprise  
- classes communes aux modules Device Owner / Profile Owner  

🎯 Objectif : centraliser toute la logique Android Enterprise pour éviter la duplication dans les modules.

---

🧰 3. utils/
Contient les utilitaires génériques.

Inclut :
- helpers JSON  
- outils réseau  
- gestion des fichiers  
- cryptographie  
- helpers UI  
- outils internes réutilisables  

🎯 Objectif : fournir des outils transversaux pour simplifier le développement des modules.

---

🏁 Résumé
Le dossier sources/ est le socle commun du projet AndroidSamples.  
Il garantit une architecture propre, modulaire et maintenable, tout en évitant la duplication de code entre les différents modules Android Enterprise.

---
