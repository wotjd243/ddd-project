tasks.getByName<Jar>("bootJar") { enabled = false }
tasks.getByName<Jar>("jar") { enabled = true }

dependencies {
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("mysql:mysql-connector-java")
}
