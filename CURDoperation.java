import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CURDoperation {

	public static void main(String[] args) {
		Connection conn = getsqlConnection();
		try {

			if (conn != null) {
				String sqlInsert = "INSERT INTO employee_payroll (empid ,empname ,empsalary,dateofjoin) values (?,?,?,?)";
				PreparedStatement connecting = conn.prepareStatement(sqlInsert);
				connecting.setInt(1, 01);
				connecting.setString(2, "ShobhitRAnjan");
				connecting.setInt(3, 2400);
				connecting.setDate(4, null, null);
				
				int rowInserted=connecting.executeUpdate();
				if(rowInserted>0)
				{
					System.out.println("data is added !");
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}

	}

	private static Connection getsqlConnection() {
		Connection conn = null;
		String hostUrl = "jdbc:mysql://localhost:3306/payroll_services";
		String userName = "root";
		String password = "mymaths009;
		try {
			conn = DriverManager.getConnection(hostUrl, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return conn;

	}

}
