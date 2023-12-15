About our project:

You can run the system from Main (file BackendProgrammeringExamApplication).
This will let you see the system from Postman or H2.

Each test can be initiated from each file in the test folder.
We made a system where each machine consists of multiple subassemblies, and each
subassembly consists of multiple parts.

Our system is complete, including all functionallity and all tests.
We have implemented DataJPATest and SpringBootTest.
We have also included som extra functionality such as Responsentity and Faker,
and also created a customer/address and added an address/customer to.

For now our system is created so that only one machine can be sold in per order.
Our factory only produces one machine of each, this is by purpose a one to many relationship.

We discovered some difficulties with our unit tests for the classes Customer og Address.
In the class "CustomerUnitTest"; the test runs fine if you comment out the sammple data from commandlinerunner.
Otherwise tha tests creashes with a nullpointexpeption. We have tried several different approaches and fixes, but have yet to find a solution. 

Resources:
Our system are based on Jasons Repository on github, and code written in class.
The code is mainly based on these repositories:
Vet-clinic: https://github.com/jlwcrews2/vet-clinic/tree/main
JPA-demo: https://github.com/jlwcrews2/jpa-demo/tree/master
Source used for post and delete method: https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/


