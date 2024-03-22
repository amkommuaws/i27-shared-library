import com.i27achademy.builds.Calculator
Calculator calculator = new Calculator(this)
pipeline {
    agent any
    stages {
        stage ('AdditionStage') {
            steps {
              script {
                  echo "Printing Sum of 2 numbers"
                  println calculator.add(3,4)
              }
            }
        }
        stage ('Build') {
            steps {
                echo "Printing text not from groovy files"
            }
        }
    }
}