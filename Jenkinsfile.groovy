node{

    stage('prepare'){
        deleteDir()
        checkout scm
        println sh(script: 'pwd', returnStdout: true).trim()
        println env.GITTY

        echo "hhhhhhhhhhhhhhhhhhhhhhhhhhhh"
        println sh(script: 'ls -lrt', returnStdout: true).trim()

        def workspace = env.WORKSPACE
        echo "Current workspace is ${env.WORKSPACE}"
        def content= "${workspace}/RestfulXML/test.xml"
      //  def content = readFile("${path}/test.xml")

        echo "${conten}"

        def response =sh (
                script: '''

 curl -s -X POST --header 'Content-Type: application/xml' https://api.shipwire.com/exec/InventoryServices.php 
 -d  "${content}"
               
            ''',
                returnStdout: true
        ).trim()

        echo "${response}"
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

