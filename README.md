About our project:

Run the system from Main (file BackendProgrammeringExamApplication).
This will let you use the system from Postman or H2 console database.
You can fetch all domainLists with api/"domainName"/page/pageNr (starts from 0).
All tests can be run from the folder "com.machineFactory", or individual.

We made a system where each machine consists of multiple subassemblies, and each
subassembly consists of multiple parts. Our system is created so only one machine can be sold in per order.
Our factory only produces one machine of each type, this is by purpose a one-to-many relationship.

The system is complete, including all functionality and all tests.
We have implemented DataJPATest and SpringBootTest.
We have included some extra functionality such as Responsentity and Faker,
and also created a customer/address and added an address/customer to it. 
We also created environment for test- and prod code, with 2 different yaml files.
The tests that doesn`t run correctly has the test annotation commented out with//@Test.
These tests might fail either when run from the machineFactory folder- og their domain folder.
We had some difficulty with some tests failing occasionally when being run from the folder, but not individually.
Example of this is the test "shouldFetchCustomersFromPage1Expect3" from file CustomerIntegrationTest.

We discovered some difficulties with our unit tests for the Models Customer og Address.
We tried to solve this by having two environments; for test and prod code.
This only occur in the two classes "CustomerUnitTest" and "AddressUnitTest", since these get in conflict with the test
data in commandlinerunner. The test runs fine if you remove the sample data from commandlinerunner (this can be done
by adding an exclamation mark in the if-statement in Main class l:41) --> typing  if (!environmentCheck) {}.
Otherwise, the tests crashes with a nullpointexception. We tried several different approaches to fix this problem, but could not make
it work.

From the exam txt:
"Additional functionality can be added, such as: Create a customer, and add an address to it Create an address and add it to a customer....."
Originally we wanted it to be possible to create a customer/address in postman, and then add a customer/address to id.
This would not work properly, and we only got a "null" in return. We also did not like how this code
mixed different domain-objects in same class etc.
We decided to do these points from Commandline runner instead, as in the example from Jason repo.
We have some code written for our original plan, which we have left in the project,
but added comments to it, so you can see the code we are talking about.
We also had difficulty with the put-method for addresses and customer, it works fine for all data except
the first 5 created from faker.

Resources:
Our system is based from Jasons Repository on github, and code written in class.
The code is mainly based on these repositories:
Vet-clinic: https://github.com/jlwcrews2/vet-clinic/tree/main
JPA-demo: https://github.com/jlwcrews2/jpa-demo/tree/master
Source used for post and delete method: https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/
including the helper method in EndToEnd tests.
Source used for test/prod code environment: https://www.baeldung.com/spring-boot-properties-env-variables


