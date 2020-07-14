import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

val kotlinReactVersion = "16.13.1-pre.110-kotlin-1.3.72"
val npmReactVersion = "16.13.1"

plugins {
    kotlin("js")
}

group = "xyz.cssxsh.web"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation("org.jetbrains:kotlin-react:$kotlinReactVersion")
    implementation("org.jetbrains:kotlin-react-dom:$kotlinReactVersion")
    implementation(npm("react", npmReactVersion))
    implementation(npm("react-dom", npmReactVersion))
}

kotlin.target.browser {
    runTask {
        devServer = KotlinWebpackConfig.DevServer(
                port = 3000,
                contentBase = listOf("$buildDir\\processedResources\\Js\\main")
        )
    }
}


