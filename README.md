# Rapid-Grocery-E-commerce

## Overview
**Rapid-Grocery-E-commerce** is a full-featured web application designed to streamline online grocery shopping. The system consists of two separate modules:

- **User Side:** A customer-facing interface for browsing products, managing shopping carts, and completing purchases.
- **Admin Panel:** An interface for administrators to manage product categories, products, and essential details.

---

## Features

### Admin Panel
- 🔒 **Secure Access**: Only authorized administrators can log in.
- 🗂 **Category Management**: Add, edit, and delete product categories.
- 📦 **Product Management**: Add, edit, and delete products.
- 🔄 **Real-Time Updates**: Instantly reflect changes on the user side.

### User Side
- 🏠 **Home Page**: Displays products categorized for easy navigation.
- 🛒 **Shopping Cart**: Add products and proceed to checkout.
- 💳 **Payment Integration**: Razorpay test mode for seamless transactions.

---

## Technologies Used

### Backend
- **Java**
- JavaServer Pages (**JSP**)
- **Servlets**
- **Spring MVC**
- **RESTful APIs**
- **PostgreSQL** (Database)
- **Apache Server** (Deployment)

### Frontend
- **JavaScript**
- **AJax**
- **jQuery**
- **Bootstrap**
- **CSS**

---

## Installation and Setup

### Prerequisites
Ensure you have the following installed:
- ✅ **Java Development Kit (JDK)**
- ✅ **Apache Server**
- ✅ **PostgreSQL**

### Steps to Install
1. **Clone the Repository:**
   ```sh
   git clone https://github.com/yourusername/Rapid-Grocery-E-commerce.git
   ```

2. **Database Configuration:**
   - Set up a **PostgreSQL** database.
   - Update database connection details in configuration files.

3. **Build and Deploy:**
   - Compile the application using **Eclipse** or another preferred IDE.
   - Deploy the application on **Apache Server**.

4. **Access the Application:**
   - **User Side:** `http://localhost:8080/user`
   - **Admin Panel:** `http://localhost:8080/admin`

---

## Usage

### Admin Panel
- Login with your administrator credentials.
- Manage categories and products effortlessly.

### User Side
- Browse products and add items to the cart.
- Proceed to checkout and complete the payment.

---

## Contributing

We welcome contributions to enhance the functionality and features of this project! 🚀

1. **Fork the repository**.
2. **Create a new branch:**
   ```sh
   git checkout -b feature-branch
   ```
3. **Commit your changes:**
   ```sh
   git commit -m 'Add new feature'
   ```
4. **Push to the branch:**
   ```sh
   git push origin feature-branch
   ```
5. **Submit a pull request.**
