

@groovy.transform.Field def workspace
    @groovy.transform.Field def path
     @groovy.transform.Field def file

node{

    stage('prepare'){
        deleteDir()
        checkout scm
        println sh(script: 'pwd', returnStdout: true).trim()
        println env.GITTY

        echo "hhhhhhhhhhhhhhhhhhhhhhhhhhhh"
        println sh(script: 'ls -lrt', returnStdout: true).trim()

  
         workspace = env.WORKSPACE
        sh "chmod +x ${workspace}"
        echo "Current workspace is ${env.WORKSPACE}"
         path= "${workspace}/RestfulXML" 
         file= "${workspace}/RestfulXML/test.xml"
        final String content = readFile("${path}/test.xml")

        echo "${file} eeeeeeeeeeeeeeeeeeeeeeeeeeeeee"

        def response =sh (
                script: ''' #!/bin/bash/ +x
                  echo "${file} bbbbbbbbbbbbbbbbbbbbbbbbbbb"
curl -X POST --header "Content-Type:text/xml;charset=UTF-8" --data  '@"{$file}"' https://api.beta.shipwire.com/exec/InventoryServices.php
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
       // #!/bin/sh +x
//curl -s -X POST 'https://api.beta.shipwire.com/exec/InventoryServices.php' \
//--header 'Content-Type: application/xml' \
//-d @$file 


    }

}

