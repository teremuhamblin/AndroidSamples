#!/bin/bash
set -xe

# ============================================================
# AndroidSamples CI Build Script (Enterprise Edition)
# ============================================================

# Charger les propriétés CI depuis la racine
if [ -f "ci-gradle.properties" ]; then
    export GRADLE_OPTS="$GRADLE_OPTS $(cat ci-gradle.properties | tr '\n' ' ')"
fi

# Build global AndroidSamples (multi-modules)
./gradlew \
    --no-parallel \
    --stacktrace \
    assembleDebug \
    lintDebug \
    testDebugUnitTest
