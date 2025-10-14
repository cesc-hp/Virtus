import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.3.3.RELEASE"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    kotlin("jvm") version "1.4.21"
    kotlin("plugin.spring") version "1.4.21"
    kotlin("plugin.jpa") version "1.4.21"
    id("org.jmailen.kotlinter") version "3.2.0"
}

apply(plugin = "io.spring.dependency-management")
apply(plugin = "war")

group = "com.virtus.api"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:11.0.0")
    implementation("com.graphql-java-kickstart:altair-spring-boot-starter:11.0.0")
    implementation("com.graphql-java-kickstart:voyager-spring-boot-starter:11.0.0")
    implementation("com.graphql-java-kickstart:graphql-java-tools:6.2.0")
    implementation("com.sun.activation:javax.activation:1.2.0")
    //Security
    //implementation("org.springframework.boot:spring-boot-starter-security")
    //implementation("io.jsonwebtoken:jjwt:0.9.1")
    //implementation("org.springframework.security:spring-security-test:test")
    //testImplementation("com.graphql-java-kickstart:graphql-spring-boot-starter-test:11.0.0")
    runtimeOnly("org.postgresql:postgresql")
    //testImplementation("org.springframework.boot:spring-boot-starter-test") {
    //	exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    //}
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}


tasks.withType<org.springframework.boot.gradle.tasks.run.BootRun> {
    jvmArgs= listOf("-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005")
}