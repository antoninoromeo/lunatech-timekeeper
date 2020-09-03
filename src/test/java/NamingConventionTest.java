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

import javax.ws.rs.Path;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

/**
 * ArchUnit test to check for naming conventions.
 */
@AnalyzeClasses(packages = "fr.lunatech.timekeeper", importOptions = {ImportOption.DoNotIncludeTests.class})
public class NamingConventionTest {

    @ArchTest
    static ArchRule resources_should_be_postfixed_with_resource =
            classes()
                    .that().resideInAPackage("resources")
                    .and().areAnnotatedWith(Path.class)
                    .should().haveSimpleNameEndingWith("Resource");

    @ArchTest
    static ArchRule requests_should_have_name_ending_with_request =
            classes()
                    .that().resideInAPackage("..services.requests")
                    .should().haveSimpleNameEndingWith("Request");

    @ArchTest
    static ArchRule responses_should_have_name_ending_with_response =
            classes()
                    .that().resideInAPackage("..services.responses")
                    .should().haveSimpleNameEndingWith("Response");


}