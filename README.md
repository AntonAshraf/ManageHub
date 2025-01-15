# ManageHub

ManageHub is a centralized platform designed to streamline and manage all aspects of business operations, from customer data to product inventory and transactions.

## Features

Current key features of ManageHub include:

- **Categories Management**: Organize products into hierarchical categories for better organization
- **Brand Management**: Track and manage different product brands and manufacturers
- **Product Management**: Complete inventory control with product details, stock levels, and pricing
- **Customer Management**: Maintain customer profiles, contact information, and purchase history
- **Order Processing**: Handle customer orders from creation to fulfillment
- **Transaction Management**: Track all financial transactions and generate detailed reports

## Screenshots

### Features

<div align="center">

| Home | Category Management |
|------|---------------------|
| ![Home](https://github.com/user-attachments/assets/ec8113e7-6743-4039-9f41-addb140ac280) | ![Manage Category](https://github.com/user-attachments/assets/609bee1f-ed65-4a04-acf8-5da1dbfc44f9) |

| Brand Management | Product Management |
|-----------------|---------------------|
| ![Manage Brand](https://github.com/user-attachments/assets/8bb766c7-2863-4f1e-9faf-678958b3e96b) | ![Manage Product](https://github.com/user-attachments/assets/31df94b5-dcce-438f-84a9-73adedca373d) |

| Customer Management | Order Processing |
|---------------------|------------------|
| ![Manage Customers](https://github.com/user-attachments/assets/921db20e-41fc-4fbf-be41-70fe178246ff) | ![Customer's order](https://github.com/user-attachments/assets/bf27dfca-ba91-46c3-b5b4-23e2d9058805) |

|Transaction History |
|--------------------|
| ![Transaction History](https://github.com/user-attachments/assets/3f0f5404-2e48-409c-868d-dd7186fcb5e9) |

</div>

### Authentication
<div align="center">
    
| Login | Sign up |
|----------------|-----------------|
| ![Login](https://github.com/user-attachments/assets/7076d6c4-36ca-49e2-8b40-1a2f37ed38b8) | ![Sign up](https://github.com/user-attachments/assets/660cc555-23eb-445e-b16e-4a69a4ebd027) |

</div>

### Warning Messages

<div align="center">
    
| Delete Confirmation | Error Message | Update Confirmation |
|---------------------|---------------|---------------------|
|![Delete Message](https://github.com/user-attachments/assets/cba71490-0cc1-4d63-a459-c20e57961561)  |  ![Not insert message](https://github.com/user-attachments/assets/b78dd4f5-ba92-4a6d-869b-6197375d3163) |![Update message](https://github.com/user-attachments/assets/9e55bfbb-6cc7-42dc-8f89-655306978c32)|

</div>

### Database Schema

![ERD Diagram](https://github.com/user-attachments/assets/1ca27f57-c399-430d-b2b3-74bf38e63bd2)

## Getting Started

### Prerequisites

- NetBeans IDE 8.2 or later
- Java JDK 8 or later
- MySQL Server 5.7 or later

### Installation Steps

1. Clone the repository
    ```bash git clone https://github.com/yourusername/ManageHub.git```

2. Open NetBeans IDE
    - Go to File > Open Project
    - Navigate to the ManageHub folder
    - Select the project and click Open

3. Configure Database
    - Open MySQL Workbench
    - Create a new schema named "shop"
    - Run the SQL script in the "Create_data.sql" file to create the tables
    - Run the SQL script in the "insert_data.sql" file to insert sample data

4. Run the Project
    - Right-click on the project in NetBeans
    - Select "Clean and Build"
    - Click "Run Project" or press F6

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
