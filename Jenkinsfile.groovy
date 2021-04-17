
node{
    
    stage('prepare'){
        deletedir
        checkout scm
        println sh(script: 'pwd', returnStdout: true).trim()
        println env.GITTY

        echo "hhhhhhhhhhhhhhhhhhhhhhhhhhhh"
        println sh(script: 'ls -lrt', returnStdout: true).trim()

        workspace = env.WORKSPACE
        echo "Current workspace is ${env.WORKSPACE}"
        path= "${workspace}/RequestXML/test.xml"
     //   def data = readFile(file: "${path}")
        
 //       echo "${data}"

    }
    stage('Audit tools') {

        sh '''
                           git version
                           
                        '''


    }
    stage('build'){

        // echo "Build version ${version} with stuffix ${VERSION_RC}"
        //sh '''
        //                         echo "run test.sh"
        //
        //                       ./test.sh
        //                    '''
        //          testshare message: 'hello frank'
        //          println this.getClass()

        //     def response = sh(script: 'curl https://cat-fact.herokuapp.com/facts/', returnStdout: true)
        //       sh "curl https://cat-fact.herokuapp.com/facts/"
        //    script {
        //     final String url = "https://dog.ceo/api/breeds/list/all"

        //     final String response = sh(script: "curl -s $url", returnStdout: true).trim()

        //     echo response
        //    echo "sssssssssssssssssssssssssssssssssssssss"
        //          }


    }

}


