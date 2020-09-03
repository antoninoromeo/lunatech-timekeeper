/*
 * Copyright 2020 Lunatech Labs
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

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "fr.lunatech.timekeeper", importOptions = {ImportOption.DoNotIncludeTests.class})
public class LayeredArchitectureTest { //NOSONAR
    @ArchTest
    public static final ArchRule services_should_only_be_accessed_by_Controllers_Health_Or_Other_Services = classes()
                    .that().resideInAPackage("..services")
                    .should().onlyBeAccessed().byAnyPackage("..resources..", "..services..","..health..");
}
