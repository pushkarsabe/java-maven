import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/TEST";
        String UserName = "host";
        String Password = "Mysql@123";
//        String query = "SELECT * FROM USER WHERE ID=1";
        String query = "SELECT * FROM USER";
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, UserName, Password);
            Statement st = con.createStatement();
            ResultSet  rs = st.executeQuery(query);
//            rs.next();
//            String name  = rs.getString("name");
//            System.out.println("Connection Established , name = "+name);
            while(rs.next()){
                System.out.print("id "+rs.getInt(1)+",");
                System.out.print("name = "+rs.getString(2)+",");
                System.out.print("SALARY = "+rs.getInt(3)+",");
                System.out.print("AGE = "+rs.getInt(4));
                System.out.println();
            }
            con.close();

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL Driver not found! Did you add the JAR to the classpath?");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection failed! Check your URL, username, or password.");
            e.printStackTrace();
        }
    }
}