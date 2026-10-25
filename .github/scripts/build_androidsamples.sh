#!/bin/bash
set -xe

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
