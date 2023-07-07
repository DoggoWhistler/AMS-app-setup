package be.telenet.origin.client.application.architecture;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static be.telenet.origin.client.application.architecture.ArchitectureTest.ADAPTER_PACKAGE;
import static be.telenet.origin.client.application.architecture.ArchitectureTest.APPLICATION_PACKAGE;
import static be.telenet.origin.client.application.architecture.ArchitectureTest.BOOTSTRAP_PACKAGE;
import static be.telenet.origin.client.application.architecture.ArchitectureTest.INCOMING_ADAPTER_PACKAGE;
import static be.telenet.origin.client.application.architecture.ArchitectureTest.INCOMING_PORT_PACKAGE;
import static be.telenet.origin.client.application.architecture.ArchitectureTest.MODEL_PACKAGE;
import static be.telenet.origin.client.application.architecture.ArchitectureTest.OUTGOING_ADAPTER_PACKAGE;
import static be.telenet.origin.client.application.architecture.ArchitectureTest.OUTGOING_PORT_PACKAGE;
import static be.telenet.origin.client.application.architecture.ArchitectureTest.PORT_PACKAGE;
import static be.telenet.origin.client.application.architecture.ArchitectureTest.SERVICE_PACKAGE;
import static be.telenet.origin.client.application.architecture.ArchitectureTest.fullyQualified;
import static com.tngtech.archunit.core.domain.JavaClass.Predicates.resideInAPackage;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class DependencyRules {

    @ArchTest
    static ArchRule noModelApplicationDependency = checkNoDependencyFromTo(MODEL_PACKAGE, APPLICATION_PACKAGE);
    @ArchTest
    static ArchRule noModelAdapterDependency = checkNoDependencyFromTo(MODEL_PACKAGE, ADAPTER_PACKAGE);
    @ArchTest
    static ArchRule noModelBootstrapDependency = checkNoDependencyFromTo(MODEL_PACKAGE, BOOTSTRAP_PACKAGE);
    @ArchTest
    static ArchRule noApplicationAdapterDependency = checkNoDependencyFromTo(APPLICATION_PACKAGE, ADAPTER_PACKAGE);
    @ArchTest
    static ArchRule noApplicationBootstrapDependency = checkNoDependencyFromTo(APPLICATION_PACKAGE, BOOTSTRAP_PACKAGE);
    @ArchTest
    static ArchRule noPortServiceDependency = checkNoDependencyFromTo(PORT_PACKAGE, SERVICE_PACKAGE);
    @ArchTest
    static ArchRule noAdapterServiceDependency = checkNoDependencyFromTo(ADAPTER_PACKAGE, SERVICE_PACKAGE);
    @ArchTest
    static ArchRule noAdapterBootstrapDependency = checkNoDependencyFromTo(ADAPTER_PACKAGE, BOOTSTRAP_PACKAGE);

    @ArchTest
    static ArchRule implementationsOfOutgoingPortsOnlyInAdapterOut =
            classes()
                    .that().implement(resideInAPackage(fullyQualified(OUTGOING_PORT_PACKAGE)))
                    .should()
                    .resideInAPackage(fullyQualified(OUTGOING_ADAPTER_PACKAGE))
                    .because("Outgoing ports can only be implemented by an outgoing adapter");

    @ArchTest
    static ArchRule implementationsOfIncomingPortsOnlyInApplicationService =
            classes()
                    .that().implement(resideInAPackage(fullyQualified(INCOMING_PORT_PACKAGE)))
                    .should()
                    .resideInAPackage(fullyQualified(SERVICE_PACKAGE))
                    .because("Incoming ports can only be implemented by an application service");

    @ArchTest
    static ArchRule usesOfIncomingPortsOnlyInAdapterIn = classes()
            .that().resideInAPackage(fullyQualified(INCOMING_PORT_PACKAGE))
            .should().onlyBeAccessed().byAnyPackage(fullyQualified(INCOMING_ADAPTER_PACKAGE))
            .because("Incoming ports can only be used by an incoming adapter");
    @ArchTest
    static ArchRule usesOfOutgoingPortsOnlyInApplicationService = classes()
            .that().resideInAPackage(fullyQualified(OUTGOING_PORT_PACKAGE))
            .should().onlyBeAccessed().byAnyPackage(fullyQualified(SERVICE_PACKAGE))
            .because("Outgoing ports can only be used by an application service");

    static ArchRule checkNoDependencyFromTo(
            String fromPackage, String toPackage) {

        return noClasses()
                .that()
                .resideInAPackage(fullyQualified(fromPackage))
                .should()
                .dependOnClassesThat()
                .resideInAPackage(fullyQualified(toPackage))
                .because("This violates the inward bound dependency rule of hexagonal architecture");
    }
}
