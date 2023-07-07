package be.telenet.origin.client.application.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchTests;

import static be.telenet.origin.client.application.architecture.ArchitectureTest.ROOT_PACKAGE;

@AnalyzeClasses(packages = ROOT_PACKAGE, importOptions = ImportOption.DoNotIncludeTests.class)
public final class ArchitectureTest {
    public static final String ROOT_PACKAGE = "be.telenet.origin.client";
    public static final String MODEL_PACKAGE = "model";
    public static final String APPLICATION_PACKAGE = "application";
    public static final String PORT_PACKAGE = "application.port";
    public static final String INCOMING_PORT_PACKAGE = "application.port.in";
    public static final String OUTGOING_PORT_PACKAGE = "application.port.out";
    public static final String SERVICE_PACKAGE = "application.service";
    public static final String ADAPTER_PACKAGE = "adapter";
    public static final String INCOMING_ADAPTER_PACKAGE = "adapter.in";
    public static final String OUTGOING_ADAPTER_PACKAGE = "adapter.out";
    public static final String BOOTSTRAP_PACKAGE = "bootstrap";

    public static String fullyQualified(String packageName) {
        return ROOT_PACKAGE + '.' + packageName + "..";
    }

    @ArchTest
    static final ArchTests dependencyRules = ArchTests.in(DependencyRules.class);
    @ArchTest
    static final ArchTests namingConventionRules = ArchTests.in(NamingConventionRules.class);
    @ArchTest
    static final ArchTests domainArchitectureRules = ArchTests.in(DomainArchitectureRules.class);
}
