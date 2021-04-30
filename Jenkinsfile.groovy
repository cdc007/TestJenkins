
//@groovy.transform.Field def workspace
//   @groovy.transform.Field def path
//  @groovy.transform.Field def file

@Library('commonLib@master') _

def map1 = [name:"Jerry", age: 42, city: "New York", hobby:"Singing"]

timestamps {

       SharedLib(
           url: "https://api.beta.shipwire.com/exec/InventoryServices.php",
              approvers:${map1}
       )
}
