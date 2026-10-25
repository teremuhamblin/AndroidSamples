#!/bin/bash
set -xe
#!/bin/bash
set -xe

# Charger les propriétés CI depuis la racine
export GRADLE_OPTS="$GRADLE_OPTS $(cat ci-gradle.properties | tr '\n' ' ')"

# Build global AndroidSamples
./gradlew \
    --no-parallel \
    --stacktrace \
    assembleDebug \
    lintDebug \
    testDebugUnitTest
# Optimisations Gradle pour CI GitHub Actions
export GRADLE_OPTS="$GRADLE_OPTS \
 -Xms4g \
 -Xmx4g \
 -XX:+HeapDumpOnOutOfMemoryError \
 -Dorg.gradle.daemon=false \
 -Dorg.gradle.workers.max=2 \
 -Dkotlin.incremental=false \
 -Dkotlin.compiler.execution.strategy=in-process \
 -Dfile.encoding=UTF-8"

# Build unique du dépôt AndroidSamples (multi-modules)
./gradlew \
    --no-parallel \
    --stacktrace \
    assembleDebug \
    lintDebug \
    testDebugUnitTest
