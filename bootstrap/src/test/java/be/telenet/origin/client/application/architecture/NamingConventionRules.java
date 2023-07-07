package be.telenet.origin.client.application.architecture;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static be.telenet.origin.client.application.architecture.ArchitectureTest.PORT_PACKAGE;
import static be.telenet.origin.client.application.architecture.ArchitectureTest.INCOMING_PORT_PACKAGE;
import static be.telenet.origin.client.application.architecture.ArchitectureTest.ROOT_PACKAGE;
import static be.telenet.origin.client.application.architecture.ArchitectureTest.OUTGOING_PORT_PACKAGE;
import static be.telenet.origin.client.application.architecture.ArchitectureTest.SERVICE_PACKAGE;
import static be.telenet.origin.client.application.architecture.ArchitectureTest.fullyQualified;
import static com.tngtech.archunit.base.DescribedPredicate.describe;
import static com.tngtech.archunit.core.domain.JavaModifier.PUBLIC;
import static com.tngtech.archunit.core.domain.properties.HasModifiers.Predicates.modifier;
import static com.tngtech.archunit.lang.conditions.ArchConditions.have;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class NamingConventionRules {

    @ArchTest
    static ArchRule primaryPortsAreSuffixedWithUseCase =
            classes()
                    .that().resideInAPackage(fullyQualified(INCOMING_PORT_PACKAGE))
                    .should().haveSimpleNameEndingWith("UseCase")
                    .orShould().haveSimpleNameEndingWith("Exception")
                    .because("The incoming ports package should only contain incoming ports definitions or use case specific exceptions");
    @ArchTest
    static ArchRule secondaryPortsAreSuffixedWithRepository =
            classes()
                    .that().resideInAPackage(fullyQualified(OUTGOING_PORT_PACKAGE))
                    .should().haveSimpleNameEndingWith("Repository")
                    .orShould().haveSimpleNameEndingWith("Exception")
                    .because("The outgoing ports package should only contain outgoing ports definitions or use case specific exceptions");
    static ArchRule noClassesInPortPackageItself =
            noClasses()
                    .should().resideInAPackage(ROOT_PACKAGE + '.' + PORT_PACKAGE);

    @ArchTest
    static ArchRule inPortPackageWeOnlyFindPortDefinitions =
            classes()
                    .that()
                    .resideInAPackage(fullyQualified(PORT_PACKAGE))
                    .should().haveSimpleNameEndingWith("Repository")
                    .orShould().haveSimpleNameEndingWith("UseCase")
                    .orShould().haveSimpleNameEndingWith("Exception");

    @ArchTest
    static ArchRule applicationServicesShouldHaveOnlyOnePublicMethod =
            classes()
                    .that()
                    .resideInAPackage(fullyQualified(SERVICE_PACKAGE))
                    .should(have(describe("only one public method", javaClass ->
                            javaClass.getMethods().stream().filter(modifier(PUBLIC)).count() == 1
                    )))
                    .because("Application services should typically implement one use case, so contain one public method");

    @ArchTest
    static ArchRule classesNamedServiceShouldOnlyBeInApplicationServicePackage =
            classes()
                    .that()
                    .haveSimpleNameEndingWith("Service")
                    .should().resideInAPackage(fullyQualified(SERVICE_PACKAGE))
                    .because("Service classes should be avoided unless they implement an incoming port");

    @ArchTest
    static ArchRule interfacesNamesShouldNotContainTheWordInterface =
            noClasses()
                    .that()
                    .areInterfaces()
                    .should().haveSimpleNameContaining("Interface")
                    .because("Naming an interface with a suffix Interface is a bad practice");
}