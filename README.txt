I. CONFIGURATION

To run the app you need to have a running instance of MongoDB and you need to configure the connection in the application.properties file adequately.

Also if you change the active Spring Profile to spring.profiles.active=relational (or default), an embedded H2 database will be used.

II. RUNNING THE APPLICATION

You can run the app from the root folder with:

   mvn spring-boot:run

To start the frontend run the following command from the ./frontend directory:

   npm start
