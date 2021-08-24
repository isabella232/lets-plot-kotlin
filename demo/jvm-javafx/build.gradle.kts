/*
 * Copyright (c) 2021. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

import org.gradle.internal.os.OperatingSystem

plugins {
    kotlin("jvm")
}

val jfx_platform = when {
    OperatingSystem.current().isWindows -> {
        "win"
    }
    OperatingSystem.current().isMacOsX -> {
        "mac"
    }
    OperatingSystem.current().isLinux -> {
        "linux"
    }
    else -> {
        "unknown"
    }
}

dependencies {
    val lets_plot_version: String by project
    val jfx_version : String by project
    implementation("org.jetbrains.lets-plot:lets-plot-jfx:$lets_plot_version")
    implementation("org.openjfx:javafx-base:$jfx_version:$jfx_platform")
    implementation("org.openjfx:javafx-controls:$jfx_version:$jfx_platform")
    implementation("org.openjfx:javafx-graphics:$jfx_version:$jfx_platform")
    implementation("org.openjfx:javafx-swing:$jfx_version:$jfx_platform")

    implementation(projects.plotApi)
    implementation(projects.demoCommon)
}

