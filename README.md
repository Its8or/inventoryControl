# Stock Control Java Application

## Overview
This application provides a simple graphical interface to manage inventory for a single product. It allows users to add to or remove from stock with real-time updates and persistent storage.

## Features
- Add items to inventory
- Remove items from inventory
- Persistent storage of inventory data
- Simple and intuitive graphical user interface
- Input validation to prevent errors

## Technologies Used
- Java
- GUI Libraries:
  - Swing
  - AWT

## How to Use
1. Launch the application
2. To add items to inventory:
   - Enter the quantity in the "Colocar no Estoque" field
   - Click "Adicionar" or press Enter
3. To remove items from inventory:
   - Enter the quantity in the "Remover do Estoque" field
   - Click "Retirar" or press Enter
4. The current inventory count is displayed at the top of the window
5. Inventory data is automatically saved when closing the application

## Project Structure
- `Main.java` - Entry point for the application
- `Application.java` - Contains the GUI implementation and file I/O operations
- `Estoque.java` - Interface defining stock management operations
- `EstoqueControls.java` - Implementation of stock management logic
- `EntradaInvalidaException.java` - Custom exception for input validation

## Building the Project
For detailed instructions on how to build an executable JAR file for this project, please refer to the [Steps.md](Steps.md) file.

## Background
This project was created to solve a real-world inventory management problem. It was inspired by a request to create an Excel spreadsheet for inventory tracking, which was then expanded into a standalone Java application to provide a more user-friendly interface and additional functionality.

## Future Improvements
- Support for multiple products
- Enhanced reporting capabilities
- Improved user interface design
- Data export functionality