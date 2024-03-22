import com.i27achademy.builds.Calculator

def call(Map pipelineParams) {
    library("com.i27achademy.slb")
    Calculator calculator = new Calculator(this)
    pipeline {
        agent any
        environment {
            APP_NAME = "${pipelineParams.appName}"
        }
        stages {
            stage ('AdditionStage') {
                steps {
                script {
                    echo "Printing Sum of 2 numbers"
                    println calculator.add(3,4)
                    echo "Microservice Name is: ${APP_NAME}"
                }
                }
            }
            stage ('Nothing') {
                steps {
                    echo "Printing text not from groovy files"
                }
            }
        }
    }
}
