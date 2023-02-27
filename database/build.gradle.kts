plugins {
    id("org.flywaydb.flyway") version "8.0.0"
}

flyway {
    url = "jdbc:mysql://localhost:3306/mono_repo?allowPublicKeyRetrieval=true&zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Seoul"
    user = "root"
    password = "1234567890"
}

dependencies {
    compileOnly("mysql:mysql-connector-java")
}
