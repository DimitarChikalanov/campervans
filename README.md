# campervans
Spring Boot, Rest, JPA, Lombok, Postgresql, Sentry, DataDog

1.Bottom up levels
*	model - model.entity
-	tables relationships Unidirectional.

-	Abstract class BaseEntity, MappedSuperClass, contains primary key id.

*Repository 

-	ImageRepositiry – extends JpaRepository

-	RetalsRepository- extends JpaRepository uses:

-	Spring queries 

-	Native query (JPQL)

*	Service

-	RentalService – interface contains service methods’ names

-	RentalServiceImp implements RentalService

-ImageService - interface contains service methods’ names

-ImageServiceImpl implements ImageService

-	The all methods of services check input parameters and throw illegal argument exception when they are called with  incorrect parameters. This checking prevents  illegal SQL queries .Error reporting to sentry before throwing exception.
*       Controllers

-	RentalController

-	RestController

-	RequestMapping (path=”/rental”)

-	Trace annotation used for dataDog tracing

2. Resources
*	Application properties 

-	DataBase set up has to be configured.

-	dataDog.yaml configuration

-	sentry.properties configuration
