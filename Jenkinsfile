node('master'){
stage('initialize'){

 checkout scm
}
stage('compile'){
bat '''
mvn compile
'''
}
stage('unittest'){
bat '''
mvn test
'''
}
stage('reports'){
cucumber fileIncludePattern: '**/*.json', jsonReportDirectory: 'E:\\Merck\\Yash_Cucumber_POC\\target\\cucumber-reports', sortingMethod: 'ALPHABETICAL'
}
}