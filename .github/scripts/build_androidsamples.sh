#!/bin/bash
set -xe

# ============================================================
# AndroidSamples CI Build Script (Enterprise Edition)
# ============================================================

# Charger les propriétés CI depuis la racine si présentes
if [ -f "ci-gradle.properties" ]; then
    CI_PROPS=$(tr '\n' ' ' < ci-gradle.properties)
    export GRADLE_OPTS="${GRADLE_OPTS} ${CI_PROPS}"
fi

# Build global AndroidSamples (multi-modules)
./gradlew \
    --no-parallel \
    --stacktrace \
    clean \
    assembleDebug \
    lintDebug \
    testDebugUnitTest
