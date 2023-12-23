# Internal-Chatting-System

## Overview

A simple internal chatting system with both server and client applications developed in Java. The server facilitates communication between clients using sockets. The client application includes a graphical user interface (GUI) for user-friendly interaction.


## Features

+ User-friendly console interface.
+ Client-server architecture for multi-user communication.
+ User authentication using JDBC and MySQL for secure access.
+ Real-time messaging between connected clients.
+ Graceful handling of client disconnections.
+ Dynamic updating of the user list.


## Prerequisties

Before you begin, ensure you have met the following requirements:
+ Java Development Kit (JDK) installed.
+ MySQL database for user authentication.
+ Internet connectivity for client-server communication.
+ Basic understanding of Java socket programming, JDBC, and MySQL


## Installation

1. Clone the Repository:
```
git clone https://github.com/AdityaLakifangal/Internal-Chatting-System.git

```

2. Set up the MySQL database:
+ Create a database named chatting_application.
+ Create a table named login_info table with columns Name varchar(50), UserID varchar(50), Password varchar(50).

3. Compile and run the server application:
```
cd internal-chatting-system
javac ChatServerGUI.java
java ChatServerGUI
```

4. Compile and run the client application.


## Usage

1. Launch the server application first (keep it running on the background).
2. Launch one or more client applications (if using VS code run the program using "Run" option which comes above "Main" function).
3. Provide valid user credentials(credentials that are saved in the databses) to log in.
4. Start chatting with other connected clients.


## Error Handling

The application handles common errors such as invalid user credentials, connection issues, etc. Provides appropriate messages for errors and guides users to enter valid information.


## Limitations

+ The chatting application system focuses on simplicity and real-time messaging without advanced features such as file sharing or multimedia

+ The chatting application system is designed to support multiple users, but to enable this functionality, modifications are needed in both the backend and the graphical user interface (GUI)


## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.