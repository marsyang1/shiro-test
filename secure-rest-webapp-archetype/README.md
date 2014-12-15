shiro-guice-jersey-bootstrap
============================

Secure RESTful Web Services Application Sample Project with Apache Shiro 1.2.3, Jersey 1.18.1 and Google Guice 3.0

Dependencies included
---------------------
- Servlet 2.5
- Jersey 1.18.1
- Guice 3.0
- Apache Shiro 1.2.3
- guice-persist 3.0
- gson 2.2.4
- joda-time 2.4
- JUnit 4.10

Requirements
------------
- Java 7
- Maven 3
- Tomcat 7

Building
--------
- Make the war file <code> mvn clean package </code>
- Deploy the war file in Tomcat 7 with Eclipse or manually

After Deploy on Application Server
----------------------------------
- The REST WS are accessible under /rest/*
- Front-End not yet implemented.

Creating a Local Maven Archetype
--------------------------------
- Generate an archetype: <code>mvn archetype:create-from-project</code>
- Go to <code>target/generated-sources/archetype</code> and run <code>mvn install</code>
- Create a fresh project from Archetype <code> mvn archetype:generate -DarchetypeCatalog=local </code> using <code>com.pampanet:secure-rest-webapp-archetype</code>
- You can select the archetype from Eclipse IDE from the "New Maven Project" Wizard

Apache Shiro Filters
--------------------
- Shiro's Default Filters: http://shiro.apache.org/web.html#Web-DefaultFilters
- In <code>com.pampanet.sample.shiro.modules.BootstrapShiroModule</code> are all the filters, placed in order.
- You can replace <code>com.pampanet.sample.shiro.modules.ShiroAnnotationsModule</code> with Shiro's default <code>ShiroAopModule</code> class.

Apache Shiro Users Configuration
--------------------------------
- Sample <code>shiro.ini</code> file in <code>src/main/resources</code>
- To configure more Realms and Filters, refer to Shiro's Documentation https://shiro.apache.org/static/current/apidocs/org/apache/shiro/realm/Realm.html
