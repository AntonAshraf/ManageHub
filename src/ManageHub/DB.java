package ManageHub;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DB {

    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/shop"; // Replace "mydatabase"
    // with your actual
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "password";

    public static boolean insertCategory(String name, String description, String status) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL);

            String query = "INSERT INTO category_details (category_name, description, status) VALUES (?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setString(3, status);

            int rowsInserted = statement.executeUpdate();

            statement.close();
            conn.close();

            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully!");
                return true;
            } else {
                System.out.println("Data insertion failed!");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static void populateCategoryTable(DefaultTableModel model) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM category_details");

            // Populating the table model with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("category_id");
                String name = resultSet.getString("category_name");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");

                // Add a new row to the table model
                model.addRow(new Object[] { id, name, description, status });
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static boolean updateCategory (int id, String name, String description, String status) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String query = "UPDATE category_details SET category_name = ?, description = ?, status = ? WHERE category_id = ?";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setString(3, status);
            statement.setInt(4, id);

            int rowsUpdated = statement.executeUpdate();

            statement.close();
            conn.close();

            if (rowsUpdated > 0) {
                System.out.println("Data updated successfully!");
                return true;
            } else {
                System.out.println("Data update failed!");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public static boolean deleteCategory (int id) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String query = "DELETE FROM category_details WHERE category_id = ?";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();

            statement.close();
            conn.close();

            if (rowsDeleted > 0) {
                System.out.println("Data deleted successfully!");
                return true;
            } else {
                System.out.println("Data deletion failed!");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean insertBrand (String brand, String status) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String query = "INSERT INTO brand_details (brand, status) VALUES (?, ?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, brand);
            statement.setString(2, status);

            int rowsInserted = statement.executeUpdate();

            statement.close();
            conn.close();

            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully!");
                return true;
            } else {
                System.out.println("Data insertion failed!");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static void populateBrandTable(DefaultTableModel model) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM brand_details");

            // Populating the table model with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("idbrand");
                String brand = resultSet.getString("brand");
                String status = resultSet.getString("status");

                // Add a new row to the table model
                model.addRow(new Object[] { id, brand, status });
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean updateBrand (int id, String brand, String status) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String query = "UPDATE brand_details SET brand = ?, status = ? WHERE idbrand = ?";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, brand);
            statement.setString(2, status);
            statement.setInt(3, id);

            int rowsUpdated = statement.executeUpdate();

            statement.close();
            conn.close();

            if (rowsUpdated > 0) {
                System.out.println("Data updated successfully!");
                return true;
            } else {
                System.out.println("Data update failed!");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean deleteBrand (int id) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String query = "DELETE FROM brand_details WHERE idbrand = ?";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();

            statement.close();
            conn.close();

            if (rowsDeleted > 0) {
                System.out.println("Data deleted successfully!");
                return true;
            } else {
                System.out.println("Data deletion failed!");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean insertProduct (String name, String category, String idcategory, String brand, String idBrand, String price, String quantity, String status) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String query = "INSERT INTO product_details (product, category, idcategory, brand, idbrand, price, quantity, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, category);
            statement.setString(3, idcategory);
            statement.setString(4, brand);
            statement.setString(5, idBrand);
            statement.setString(6, price);
            statement.setString(7, quantity);
            statement.setString(8, status);

            
            int rowsInserted = statement.executeUpdate();

            statement.close();
            conn.close();

            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully!");
                return true;
            } else {
                System.out.println("Data insertion failed!");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static void populateProductTable(DefaultTableModel model) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM product_details");

            // Populating the table model with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("idproduct");
                String name = resultSet.getString("product");
                String category = resultSet.getString("category");
                String brand = resultSet.getString("brand");
                String price = resultSet.getString("price");
                String quantity = resultSet.getString("quantity");
                String status = resultSet.getString("status");

                // get id category and brand
                String idcategory = resultSet.getString("idcategory");
                String idBrand = resultSet.getString("idbrand");

                // Add a new row to the table model
                model.addRow(new Object[] { id, name, category, idcategory, brand, idBrand, price, quantity, status });

                
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean updateProduct (int id, String name, String category, String brand, String price, String quantity, String status) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String query = "UPDATE product_details SET product = ?, category = ?, brand = ?, price = ?, quantity = ?, status = ? WHERE idproduct = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, category);
            statement.setString(3, brand);
            statement.setString(4, price);
            statement.setString(5, quantity);
            statement.setString(6, status);
            statement.setInt(7, id);
            

            int rowsUpdated = statement.executeUpdate();

            statement.close();
            conn.close();

            if (rowsUpdated > 0) {
                System.out.println("Data updated successfully!");
                return true;
            } else {
                System.out.println("Data update failed!");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean deleteProduct (int id) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String query = "DELETE FROM product_details WHERE idproduct = ?";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();

            statement.close();
            conn.close();

            if (rowsDeleted > 0) {
                System.out.println("Data deleted successfully!");
                return true;
            } else {
                System.out.println("Data deletion failed!");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean populateBrandComboBox (javax.swing.JComboBox<String> jComboBox) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT brand FROM brand_details");

            // Populating the table model with data from the database
            while (resultSet.next()) {
                String brand = resultSet.getString("brand");

                // Add a new row to the table model
                jComboBox.addItem(brand);
            }

            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean populateCategoryComboBox (javax.swing.JComboBox<String> jComboBox) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT category_name FROM category_details");

            // Populating the table model with data from the database
            while (resultSet.next()) {
                String category = resultSet.getString("category_name");

                // Add a new row to the table model
                jComboBox.addItem(category);
            }

            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static String getBrandId (String brand) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT idbrand FROM brand_details WHERE brand = '" + brand + "'");

            // Populating the table model with data from the database
            while (resultSet.next()) {
                String id = resultSet.getString("idbrand");

                // Add a new row to the table model
                return id;
            }

            conn.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getCategoryId (String category) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT category_id FROM category_details WHERE category_name = '" + category + "'");

            // Populating the table model with data from the database
            while (resultSet.next()) {
                String id = resultSet.getString("category_id");

                // Add a new row to the table model
                return id;
            }

            conn.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String populateCustomerTable (DefaultTableModel model) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer_details");

            // Populating the table model with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("idcustomer");
                String name = resultSet.getString("customer");
                String address = resultSet.getString("shipping_address");
                String email = resultSet.getString("email");
                String gender = resultSet.getString("gender");
                String birthdate = resultSet.getString("birthdate");


                // Add a new row to the table model
                model.addRow(new Object[] { id, name, email, gender, birthdate, address });
            }

            conn.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static boolean insertCustomer (String name, String address, String gender, String email, String status) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String query = "INSERT INTO customer_details (customer, email, gender, birthdate, shipping_address) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setString(3, gender);
            statement.setString(4, email);
            statement.setString(5, status);

            int rowsInserted = statement.executeUpdate();

            statement.close();
            conn.close();

            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully!");
                return true;
            } else {
                System.out.println("Data insertion failed!");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean updateCustomer (int id, String name, String email, String gender, String shippingAddress) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String query = "UPDATE customer_details SET customer = ?, shipping_address = ?, email = ?, gender = ? WHERE idcustomer = ?";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, shippingAddress);
            statement.setString(3, email);
            statement.setString(4, gender);
            statement.setInt(5, id);

            int rowsUpdated = statement.executeUpdate();

            statement.close();
            conn.close();

            if (rowsUpdated > 0) {
                System.out.println("Data updated successfully!");
                return true;
            } else {
                System.out.println("Data update failed!");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean deleteCustomer (int id) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String query = "DELETE FROM customer_details WHERE idcustomer = ?";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();

            statement.close();
            conn.close();

            if (rowsDeleted > 0) {
                System.out.println("Data deleted successfully!");
                return true;
            } else {
                System.out.println("Data deletion failed!");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public static void populateTransactionTable(DefaultTableModel model) {
    try {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = conn.createStatement();

        // Modify the SQL query to join orderdproducts, order_details, and customer_details
        String sqlQuery = "SELECT op.idorderdproducts, od.idorder, od.idcustomer, od.date, op.idproduct, "
                + "op.product, op.brand, op.price, op.quantity, op.total "
                + "FROM orderdproducts op "
                + "JOIN order_details od ON op.idorder = od.idorder "
                + "JOIN customer_details cd ON od.idcustomer = cd.idcustomer";

        ResultSet resultSet = statement.executeQuery(sqlQuery);

        // Populating the table model with data from the database
        while (resultSet.next()) {
            int idorderdproducts = resultSet.getInt("idorderdproducts");
            String idorder = resultSet.getString("idorder");
            String idcustomer = resultSet.getString("idcustomer");
            String date = resultSet.getString("date");
            String idproduct = resultSet.getString("idproduct");
            String product = resultSet.getString("product");
            String brand = resultSet.getString("brand");
            String price = resultSet.getString("price");
            String quantity = resultSet.getString("quantity");
            String total = resultSet.getString("total");

            // Add a new row to the table model
            model.addRow(new Object[] { idorderdproducts, idorder, idcustomer, date, idproduct, product, brand, price, quantity, total });
        }

        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public static void populateOrderTable(DefaultTableModel model, int idcustomer) {
    try {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = conn.createStatement();

        // Modify the SQL query to include additional information
        String sqlQuery = "SELECT od.idorder, od.idcustomer, od.date, op.idproduct, "
                + "op.product, op.brand, op.price, op.quantity, op.total "
                + "FROM customer_details cd "
                + "JOIN order_details od ON cd.idcustomer = od.idcustomer "
                + "JOIN orderdproducts op ON od.idorder = op.idorder "
                + "WHERE cd.idcustomer = " + idcustomer;

        ResultSet resultSet = statement.executeQuery(sqlQuery);

        // Populating the table model with data from the database
        while (resultSet.next()) {
            String idcustomerr = resultSet.getString("idcustomer");
            String idproduct = resultSet.getString("idproduct");
            String product = resultSet.getString("product");
            String brand = resultSet.getString("brand");
            String price = resultSet.getString("price");
            String quantity = resultSet.getString("quantity");
            String total = resultSet.getString("total");

            // Add a new row to the table model
            model.addRow(new Object[] {idcustomerr,idproduct, product, brand, price, quantity, total });
        }

        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


}
