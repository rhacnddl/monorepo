import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") version "2.6.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10" apply false
    kotlin("plugin.jpa") version "1.6.10" apply false
    kotlin("kapt") version "1.3.61"
    id("com.linecorp.build-recipe-plugin") version "1.1.1"
}

java.sourceCompatibility = JavaVersion.VERSION_11

allprojects {
    group = "com.gorany"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")

    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.springframework.boot")

    apply(plugin = "kotlin")
    apply(plugin = "kotlin-spring") //allopen
    apply(plugin = "kotlin-jpa")

    dependencies {
        //kotlin
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        // jpa
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("com.fasterxml.jackson.datatype:jackson-datatype-hibernate5")

        // jdbc
        implementation("org.mariadb.jdbc:mariadb-java-client") // AWS Secrets Manager JDBC 는 Wrapper 이기 때문에, 별도로 DB에 맞는 Driver 의존성을 추가해야한다.
        implementation("mysql:mysql-connector-java")

        //spring boot
        implementation("org.springframework.boot:spring-boot-starter-actuator")
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("io.micrometer:micrometer-registry-prometheus")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.springframework.boot:spring-boot-starter-validation") // kafka 에서 필요

        // https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
        implementation("org.apache.commons:commons-lang3:3.12.0")

        // logger
        implementation("net.logstash.logback:logstash-logback-encoder")
        implementation("io.github.microutils:kotlin-logging:1.12.5")

        // secret manger SecretCache for Other type of secret (API key, OAuth token, other.)
        implementation("com.amazonaws.secretsmanager:aws-secretsmanager-caching-java:1.0.1")
        implementation("com.amazonaws.secretsmanager:aws-secretsmanager-jdbc:1.0.10") // AWS Secrets Manager JDBC

        //retryable
        implementation("org.springframework.retry:spring-retry:1.2.5.RELEASE")


        // test
        implementation("com.h2database:h2")
        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        }

        //mockk
        testImplementation("io.mockk:mockk:1.12.0")
        testImplementation("com.ninja-squad:springmockk:2.0.3")
    }

    dependencyManagement {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }

        dependencies {
            dependency("net.logstash.logback:logstash-logback-encoder:6.6")
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }
}

project(":api") {
    dependencies {
        api(project(":common-lib"))
        implementation(project(":application"))
        runtimeOnly(project(":infrastructure"))

        testImplementation(project(":application"))
        testImplementation(project(":domain"))
        testImplementation(project(":infrastructure"))
    }
}

project(":application") {
    dependencies {
        api(project(":common-lib"))
        implementation(project(":domain"))
    }
}

project(":infrastructure") {
    dependencies {
        implementation(project(":domain"))
        implementation(project(":application"))
        api(project(":common-lib"))

        testImplementation(project(":domain"))
        testImplementation(project(":application"))
    }
}

project(":domain") {
    dependencies {
        api(project(":common-lib"))
    }
}

project(":domain") {
    val jar: Jar by tasks
    val bootJar: BootJar by tasks

    bootJar.enabled = false
    jar.enabled = true
}

project(":common-lib") {
    val jar: Jar by tasks
    val bootJar: BootJar by tasks

    bootJar.enabled = false
    jar.enabled = true
}

project(":application") {
    val jar: Jar by tasks
    val bootJar: BootJar by tasks

    bootJar.enabled = false
    jar.enabled = true
}

project(":infrastructure") {
    val jar: Jar by tasks
    val bootJar: BootJar by tasks

    bootJar.enabled = false
    jar.enabled = true
}
