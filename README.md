# Java Quiz Application

## Overview
This is a Java-based Quiz Application built using Java Swing for the graphical user interface and MongoDB cloud services for storing quiz data. The application supports user authentication.

## Features
- **User Authentication**: Secure login and registration system.
- **Quiz Functionality**: Users must type the correct answer with proper spelling to score points.
- **Database Support**: Uses MongoDB Atlas for storing quiz questions and user scores.
- **Results & Analysis**: Displays results and stores user performance data.
- **Secure Credential Storage**: Uses HashiCorp Vault for managing database credentials securely.
- **Cross-Platform Support**: Can be packaged into an executable (.exe) using `jpackage`.

## Installation
1. **Clone the repository**:
   ```sh
   git clone <repository_url>
   cd java-quiz-application
   ```
2. **Set up the database**:
   - Configure MongoDB Atlas connection.
3. **Configure Vault**:
   - Ensure HashiCorp Vault is running.
   - Store MongoDB credentials securely in Vault.
4. **Run the application**:
   ```sh
   java -jar quiz-app.jar
   ```

## Download
You can download the `.exe` version of the application from the following link:  
[Download Quiz Application](https://drive.google.com/file/d/1mvvby7XZzBTJHwy3sd6ol5hOZssTbW-K/view?usp=sharing)


## Technologies Used
- **Java Swing** - GUI
- **MongoDB Atlas** - Database
- **HashiCorp Vault** - Secure credential storage
- **JPackage** - Creating Windows `.exe` installer

## Contributing
1. Fork the repository.
2. Create a new branch: `git checkout -b feature-branch`.
3. Commit your changes: `git commit -m "Add new feature"`.
4. Push to the branch: `git push origin feature-branch`.
5. Submit a pull request.