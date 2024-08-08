import java.text.SimpleDateFormat

def defDateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def defDate = new Date()
def defTimestamp = defDateFormat.format(defDate).toString()

pipeline {
    agent any
    tools {
        maven 'M3'
        jdk 'jdk11'
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '20'))
    }

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


        stage('Reporte') {
            steps {
                script {
                    try {
                        sh ("mvn serenity:aggregate -DskipTests=true")
                        echo 'Ejecucion de pruebas sin errores...'
                        sh ("echo ${defTimestamp}")
                        publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: "${WORKSPACE}/target/site/serenity", reportFiles: 'index.html', reportName: 'Evidencias de Prueba', reportTitles: 'Reporte de Pruebas'])
                        echo 'Reporte realizado con exito'
                    } catch (ex) {
                        echo 'Reporte realizado con Fallos'
                        error('Failed')
                    }
                }
            }
        }
    }
}

