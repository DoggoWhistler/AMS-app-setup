# client-service-template

Use this template to kickstart new client services. The sample code is using DDD concepts and provides a REST API (can be used by Angular components or other clients), and consumes the TB API.
Unless your laptop does not have access to api gw, you can run this locally and fetch data from the TB API.

## Features

- low code, but still plain (native) java using quarkus 3
- cloud native, very fast and low resource consumption. boots in 40ms and stops in 10ms, 25mb memory footprint
- hexagonal architecture

## Design decisions
- Clean DDD with hexagonal architecture does not allow any framework dependencies in your domain. For better QOL and less boilerplate code, I decided to use lombok and mapstruct. This is a tradeoff, but I think it is worth it as the produced class files have no trace of these frameworks. They are compile time only.
- Jboss logging was used as this is handled by quarkus OOTB and can be natively compiled.

## Concepts used in this template

- Hexagonal architecture. The domain module should be the core of the application, and the other modules should be adapters to the domain. The domain module should not depend on any other module.
- Use interfaces as ports to avoid coupling between layers.
- Use MapStruct to map between layers.
- Use JUnit 5 and Mockito for unit tests.
- Pact tests can be used for API contract testing, but is currently experimental.
- OpenAPI / swagger. API's and application documented and with sample values.

## Running the application in dev mode

### Using IntelliJ (recommended, hot reloading of all modules)

Launch the "application" module as a quarkus application and go to http://localhost:8080/q/dev-v1/ to see the dev UI. When making **any** changes, quarkus will automatically reload the application. Can be used both in debug as normal mode.

### Using the command line (only hot reloads the application module)

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw clean install
./mvnw compile quarkus:dev
```

## Building the application

Build and run all tests:
```shell script
./mvnw clean verify
```

Build native executable and also run native tests:
```shell script
./mvnw package -Pnative
```

# Pact testing
Pacts are saved in application/target/pacts folder. To sync with pact broker:


To run pact broker locally:
```docker-compose -f application/src/main/docker/docker-compose-pact.yml up -d```
Or for rancher.io users:
```nerdctl compose -f application/src/main/docker/docker-compose-pact.yml up -d```

# Dependabot
Dependabot scans for available dependency updates of creates merge requests if new versions are available.
This includes both public as Telenet internal dependencies.
The configuration is stored in the .gitlab/dependabot.yml file.
As for now only the maven package manager is configured. Dependabot does support many more package managers.
Check the (full list here)[https://docs.github.com/en/code-security/dependabot/dependabot-version-updates/about-dependabot-version-updates#supported-repositories-and-ecosystems]

Create a scheduled pipeline with the following content to run dependabot:
CI/CD -> Schedules -> New schedule

| Variable             | Value                                                          | Remarks                                                                        |
|----------------------|----------------------------------------------------------------|--------------------------------------------------------------------------------|
| Description          | Dependabot                                                     | Descriptive name                                                               | 
| Interval Pattern     | Every Week                                                     | Once a week is more than sufficient                                            |
| Cron Timezone        | [UTC+2] Brussels                                               | Timezone                                                                       |
| Target branch or tag | main or develop                                                | Point to the branch to scan and to create PR's on                              |                    
| **Variables**        |                                                                | List of custom variables to define                                             |
| PACKAGE_MANAGER      | maven                                                          | The package manager to run. Check available managers . ./gitlab/dependabot.yml |
| DIRECTORY            | / (root)                                                       | Start scanning from this directory                                             |
| PROJECT_PATH         | css/css-backend/incubator/dependabot/ocapi-public-dependabot   | Points to the project containing the dependabot pipeline                       |                                                                            


We use the gitlab dependabot, which is a gitlab specific wrapper for the github dependabot. All info on how to configure dependabot can be found on the github dependabot documentation.


| Links                                               | Purpose                                       |
|-----------------------------------------------------|-----------------------------------------------|
| https://gitlab.com/dependabot-gitlab/dependabot     | Gitlab dependabot repo containing the wrapper |
| https://github.com/dependabot                       | Github dependabot repo containing the core    |
| https://docs.github.com/en/code-security/dependabot | Github dependabot documentation               |
