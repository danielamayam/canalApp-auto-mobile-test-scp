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
                    currentBuild.displayName = "MobileTesting-Rimac-SauceLabs [#${BUILD_NUMBER}]"
                }
                sh ("mvn -X clean verify -DskipTests=true")
                archive 'target/*.jar'
            }
        }

        stage('Ejecutar Pruebas') {
            steps {
                withVault([configuration: configuration, vaultSecrets: secrets]) {
                    script {
                        try {
                            catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE', message: 'Test Suite had a failure') {
                                sh ("mvn test -Denvironment=${v_SaucelabsPlatformName} -Dcucumber.features='src/test/resources/features/' -Dcucumber.filter.tags='${ESCENARIO}' -Dcucumber.plugin=json:target/site/result.json -Dcucumber.glue='stepdefinitions' -P installAppCloudActual")
                            }
                        } catch (ex) {
                            echo 'Finalizo ejecucion con fallos...'
                            error('Failed')
                        }
                    }
                }
            }
        }
    }
}


