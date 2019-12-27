/*
 * Copyright 2019 vmadalin.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import dependencies.Dependencies
import dependencies.TestDependencies
import dependencies.AnnotationProcessorsDependencies
import extensions.implementation
import extensions.kapt
import extensions.exclude

plugins {
    id("commons.android-library")
}

dependencies {
    implementation(Dependencies.PAGING)
    implementation(Dependencies.NAVIGATION_UI)

    implementation(TestDependencies.MOCKITO)
    implementation(TestDependencies.ASSERTJ)
    implementation(TestDependencies.ROOM)
    implementation(TestDependencies.CORE)
    implementation(TestDependencies.ARCH_CORE)
    implementation(TestDependencies.RULES)
    implementation(TestDependencies.RUNNER)
    implementation(TestDependencies.COROUTINES_TEST)
    implementation(TestDependencies.FRAGMENT_TEST)
    implementation(TestDependencies.EXT)
    implementation(TestDependencies.MOCK_WEB_SERVER)

    // - Exclude groups for https://github.com/robolectric/robolectric/issues/5235
    implementation(TestDependencies.ROBOELECTRIC)?.let {
        it.exclude(group = "org.apache.maven", module = "maven-ant-tasks")
    }

    kapt(AnnotationProcessorsDependencies.AUTO_SERVICE)
}
