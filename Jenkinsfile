import java.text.SimpleDateFormat

def defDateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def defDate = new Date()
def defTimestamp = defDateFormat.format(defDate).toString()

pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Configura el nombre de la construcción
                    currentBuild.displayName = "MobileTesting-Rimac-SauceLabs [#${env.BUILD_NUMBER}]"
                }
                // Ejecuta Maven para la construcción
                sh 'mvn -X clean verify -DskipTests=true'
                // Archiva los artefactos generados
                archiveArtifacts 'target/*.jar'
            }
        }

        stage('Ejecutar Pruebas') {
            steps {
                script {
                    try {
                        // Captura errores en esta etapa y marca la etapa como fallida si hay errores
                        catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE', message: 'Test Suite had a failure') {
                            sh "mvn test -Denvironment=${v_SaucelabsPlatformName} -Dcucumber.features='src/test/resources/features/' -Dcucumber.filter.tags='${ESCENARIO}' -Dcucumber.plugin=json:target/site/result.json -Dcucumber.glue='stepdefinitions' -P installAppCloudActual"
                        }
                    } catch (ex) {
                        echo 'Finalizó ejecución con fallos...'
                        error('Failed')
                    }
                }
            }
        }
    }
}



