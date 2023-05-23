package be.telenet.origin.client.domain.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION;

@AnalyzeClasses(packages = "be.telenet.origin.client", importOptions = ImportOption.DoNotIncludeTests.class)
public class DomainArchitectureTest {

	private static final String JAVA_UTIL_LOGGING_PACKAGE = "java.util.logging..";
	private static final String SLF4J_PACKAGE = "org.slf4j..";
	private static final String LOGBACK_PACKAGE = "ch.qos.logback..";
	private static final String LOG4J_PACKAGE = "org.apache.logging..";
	private static final String QUARKUS_PACKAGE = "io.quarkus..";
	private static final String SPRING_FRAMEWORK_PACKAGE = "org.springframework..";

	@ArchTest
	private final ArchRule noInjectionAllowedInDomain = NO_CLASSES_SHOULD_USE_FIELD_INJECTION;

	@ArchTest
	private final ArchRule noSystemOutLoggingOrLoggingFramework =
			noClasses()
					.should()
					.dependOnClassesThat()
					.belongToAnyOf(System.class)
					.orShould()
					.dependOnClassesThat()
					.resideInAnyPackage(JAVA_UTIL_LOGGING_PACKAGE, SLF4J_PACKAGE, LOGBACK_PACKAGE, LOG4J_PACKAGE)
					.because("Use the debugger instead");

	@ArchTest
	private final ArchRule noDependenciesOnFrameworks =
			noClasses()
					.should()
					.dependOnClassesThat()
					.resideInAnyPackage(QUARKUS_PACKAGE, SPRING_FRAMEWORK_PACKAGE)
					.because("Dependencies on frameworks are not allowed within the domain");
}
