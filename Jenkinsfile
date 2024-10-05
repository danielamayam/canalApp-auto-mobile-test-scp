import java.text.SimpleDateFormat

def defDateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def defDate = new Date()
def defTimestamp = defDateFormat.format(defDate).toString()

pipeline {
    agent any

    stages {
        stage('SonarQube Analysis') {
            when {
                anyOf {
                    branch 'develop'
                    branch 'main'
                }
                not {
                    triggeredBy 'UserIdCause'
                }
            }
            steps {
                script {
                    def scannerHome = tool 'SonarScanner'
                    withSonarQubeEnv('SonarQube Server') {
                        sh "${scannerHome}/bin/sonar-scanner \
                            -Dsonar.projectKey=MobileTesting-Rimac-SauceLabs \
                            -Dsonar.projectName='MobileTesting Rimac SauceLabs' \
                            -Dsonar.sources=src \
                            -Dsonar.java.binaries=target/classes"
                    }
                }
            }
        }

        stage('Quality Gate') {
            when {
                anyOf {
                    branch 'develop'
                    branch 'main'
                }
                not {
                    triggeredBy 'UserIdCause'
                }
            }
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    // Configura el nombre de la construcción
                    currentBuild.displayName = "MobileTesting-Rimac-SauceLabs [#${env.BUILD_NUMBER}]"
                }
                // Ejecuta Maven para la construcción
                sh 'mvn -X clean verify'
            }
        }

        stage('Ejecutar Pruebas') {
            steps {
                script {
                    try {
                        // Captura errores en esta etapa y marca la etapa como fallida si hay errores
                        catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE', message: 'Test Suite had a failure') {
                            sh "mvn clean test -Denvironment=${v_SaucelabsPlatformName} -Dcucumber.features='src/test/resources/features/' -Dcucumber.filter.tags='${ESCENARIO}' -Dcucumber.glue='stepdefinitions' -P installAppCloudActual -DskipIntegrationTests=true"
                        }
                    } catch (ex) {
                        echo 'Finalizó ejecución con fallos...'
                        error('Failed')
                    }
                }
            }
        }
    }

    post {
        always {
            script {
                try {
                    sh ("mvn serenity:aggregate")
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