About our project:

You can run the system from Main (file BackendProgrammeringExamApplication).
This will let you see and use the system from Postman or H2 console database.

Each test can be initiated from each file in the test folder.
We made a system where each machine consists of multiple subassemblies, and each
subassembly consists of multiple parts.

Our system is complete, including all functionality and all tests.
We have implemented DataJPATest and SpringBootTest.
We have also included som extra functionality such as Responsentity and Faker,
and also created a customer/address and added an address/customer to. 
We also created environment for test- and prod code, with 2 different yaml files.

For now our system is created so that only one machine can be sold in per order.
Our factory only produces one machine of each type, this is by purpose a one to many relationship.

We discovered some difficulties with our unit tests for the Models Customer og Address.
We tried to solve this by having two environments for test and prod code.

This happens in the two classes "CustomerUnitTest" and "AddressUnitTest".
The test runs fine if you remove the sample data from commandlinerunner (this can be done
by adding an exclamation mark in the if in Main class l:41) --> typing  if (!environmentCheck) {}.
Otherwise the tests crashes with a nullpointexception. We have tried several different approaches to fix this problem.

Resources:
Our system are based from Jasons Repository on github, and code written in class.
The code is mainly based on these repositories:
Vet-clinic: https://github.com/jlwcrews2/vet-clinic/tree/main
JPA-demo: https://github.com/jlwcrews2/jpa-demo/tree/master
Source used for post and delete method: https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/
including the helper method in EndToEnd tests.
Source used for test/prod code environment: https://www.baeldung.com/spring-boot-properties-env-variables


