package be.telenet.origin.client.application.architecture;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.library.GeneralCodingRules;

import static be.telenet.origin.client.application.architecture.ArchitectureTest.APPLICATION_PACKAGE;
import static be.telenet.origin.client.application.architecture.ArchitectureTest.MODEL_PACKAGE;
import static be.telenet.origin.client.application.architecture.ArchitectureTest.fullyQualified;

class DomainArchitectureRules {

    private static final String JAVA_UTIL_LOGGING_PACKAGE = "java.util.logging..";
    private static final String SLF4J_PACKAGE = "org.slf4j..";
    private static final String LOGBACK_PACKAGE = "ch.qos.logback..";
    private static final String LOG4J_PACKAGE = "org.apache.logging..";
    private static final String QUARKUS_PACKAGE = "io.quarkus..";
    private static final String SPRING_FRAMEWORK_PACKAGE = "org.springframework..";

    @ArchTest
    static ArchRule noInjectionAllowedInDomain = GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION; // TODO only app + model

    @ArchTest
    static ArchRule noSystemOutLoggingOrLoggingFrameworkInTheCoreApplication =
            ArchRuleDefinition.noClasses()
                    .that()
                    .resideInAPackage(fullyQualified(APPLICATION_PACKAGE))
                    .or()
                    .resideInAPackage(fullyQualified(MODEL_PACKAGE))
                    .should()
                    .dependOnClassesThat()
                    .belongToAnyOf(System.class)
                    .orShould()
                    .dependOnClassesThat()
                    .resideInAnyPackage(JAVA_UTIL_LOGGING_PACKAGE, LOGBACK_PACKAGE, LOG4J_PACKAGE, SLF4J_PACKAGE)
                    .because("Use the debugger instead");

    @ArchTest
    static ArchRule noDependenciesOnCDIFrameworksInTheCoreApplication =
            ArchRuleDefinition.noClasses()
                    .that()
                    .resideInAPackage(fullyQualified(APPLICATION_PACKAGE))
                    .or()
                    .resideInAPackage(fullyQualified(MODEL_PACKAGE))
                    .should()
                    .dependOnClassesThat()
                    .resideInAnyPackage(QUARKUS_PACKAGE, SPRING_FRAMEWORK_PACKAGE)
                    .because("Dependencies on frameworks are not allowed within the application");
}
