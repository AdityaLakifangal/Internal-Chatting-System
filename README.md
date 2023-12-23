# Internal-Chatting-System

## Overview

A simple internal chatting system with both server and client applications developed in Java. The server facilitates communication between clients using sockets. The client application includes a graphical user interface (GUI) for user-friendly interaction.


## Features

+ Server-client architecture for internal communication.
+ Graphical user interface for the client application.
+ User authentication with MySQL database.


## Prerequisties

Before you begin, ensure you have met the following requirements:
+ Java Development Kit (JDK) installed.
+ MySQL database for user authentication.
+ Internet connectivity for client-server communication.


## Installation

1. Clone the Repository:
```
git clone https://github.com/your-username/internal-chatting-system.git

```

2. Set up the MySQL database:
+ Create a database named chatting_application.
+ Import the provided SQL script in the database folder.

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


## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.