import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {

    private static String url = "jdbc:mysql://127.0.0.1:3306/college";
    private static String user = "root";
    private static String password = "K1s@ng1t@";
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            //String insertData = "INSERT INTO students (name, roll_no, subject, marks) VALUES (?, ?, ?, ?)";

            // Inserting sample records
            String sql = "INSERT INTO students (Id,name, roll_no, subject, marks) VALUES ";
            sql += "(6,'Lavanya Baini', '511', 'ESY', 85), ";
            sql += "(7,'Samarth Joshi', '512', 'CSP', 78), ";
            sql += "(8,'Lavanya Yerguntala', '513', 'EST', 92), ";
            sql += "(9,'Nandini Kale', '514', 'MWC', 68), ";
            sql += "(10,'Sneha Kota', '515', 'MAR', 75)";
            st.executeUpdate(sql);

            // Selecting students with marks greater than 70
            sql = "SELECT * FROM students WHERE marks > 70";
            ResultSet rs = st.executeQuery(sql);

            // Displaying the results
            while (rs.next()) {
                int Id = rs.getInt("Id");
                String name = rs.getString("name");
                String rollNo = rs.getString("roll_no");
                String subject = rs.getString("subject");
                int marks = rs.getInt("marks");
                System.out.println("ID: " + Id + ", Name: " + name + ", Roll No: " + rollNo + ", Subject: " + subject + ", Marks: " + marks);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
