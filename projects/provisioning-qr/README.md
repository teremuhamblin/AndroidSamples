###### README.md >> markdown
# Provisioning QR — Android Enterprise

Ce module démontre la génération d’un *QR Code compatible avec le provisioning
Android Enterprise* *(Device Owner / Profile Owner)*.

### Fonctionnalités
```text
- Génération du payload JSON Android Enterprise
- QR Code compatible provisioning DO/PO
- Exemple de Policy Controller intégré
```

### Structure
```text
- `ProvisioningPayload.kt` : payload JSON
- `QrGenerator.kt` : génération QR
- `MainActivity.kt` : affichage du QR
```

### Usage
- Scanner le QR lors du provisioning :
   - Paramètres → Options développeur → Déployer via QR Code

```text
Prêt à compiler dans Android Studio, avec :
   - Arborescence complète  
   - build.gradle module  
   - AndroidManifest.xml  
   - Code Kotlin fonctionnel
```

- **provisioning-qr/** qui est un module clé dans Android Enterprise.

---

### 🧩 Module : provisioning-qr/
#### 📦 Android Enterprise — QR Code Provisioning Module
- Structure complète du module :

```text
projects/
└── provisioning-qr/
    ├── build.gradle.kts
    ├── AndroidManifest.xml
    ├── README.md
    └── src/
        └── main/
            ├── java/
            │   └── com/
            │       └── androidsamples/
            │           └── provisioningqr/
            │               ├── MainActivity.kt
            │               ├── QrGenerator.kt
            │               └── ProvisioningPayload.kt
            └── res/
                ├── layout/
                │   └── activity_main.xml
                └── values/
                    └── strings.xml
```

---
