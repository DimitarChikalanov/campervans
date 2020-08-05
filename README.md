# campervans
Spring Boot, Rest, JPA, Lombok, Postgresql, Sentry, DataDog
1.Bottom up levels
	model - model.entity
o	tables relationships Unidirectional.
o	Abstract class BaseEntity, MappedSuperClass, contains primary key id.
	Repository 
o	ImageRepositiry – extends JpaRepository
o	RetalsRepository- extends JpaRepository uses:
	Spring queries 
	Native query (JPQL)
	Service
o	RentalService –interface contains service methods’ names
o	RentalServiceImp implements RentalService
o	The all methods of services check input parameters and throw illegal argument exception when they are called with  incorrect parameters. This checking prevents  illegal SQL queries .Error reporting to sentry before throwing exception.
	RentalController
o	RestController
o	RequestMapping (path=”/rental”)
o	Trace annotation used for dataDog tracing

2. Resources
	Application properties 
o	DataBase set up has to be configured.
o	dataDog.yaml configuration
o	sentry.properties configuration
