pipeline {
  agent any
  stages {
    stage('parellel') {
      parallel {
        stage('stage1') {
          steps {
            sh 'echo "test2"'
            sh 'echo "test3"'
          }
        }
        stage('stage2') {
          steps {
            sh 'echo "test1"'
          }
        }
      }
    }
    stage('stage') {
      steps {
        echo '"this is my life"'
      }
    }
    stage('stageLast') {
      steps {
        sh 'echo "last text content"'
      }
    }
  }
}