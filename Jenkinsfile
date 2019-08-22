node('master'){
stage('initialize'){
git credentialsId: 'fcaef341-35bd-4ce9-9884-e198792f39ee', url: 'https://github.com/ktn-naveen007/Cucumber_Aug22.git'
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