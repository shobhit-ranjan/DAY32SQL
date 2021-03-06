import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CURDoperation {

	public static void main(String[] args) {
		Connection conn = getsqlConnection();
		readEmployeePayroll();
		
	}

	private static void readEmployeePayroll() {
		System.out.println("Displaying all data of employee_payroll table");
		Connection conn = getsqlConnection();

		try {
			if (conn != null) {
				String readEmpPayroll = "SELECT * FROM employee_payrollday32";

				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(readEmpPayroll);
				while (resultSet.next()) {
					Integer id = resultSet.getInt(1);
					String name = resultSet.getString(2);
					Integer salary = resultSet.getInt(3);
					String date = resultSet.getString(4);
					String row = String.format(
							"User record: \n Id: %d, \n Name: %s,\n Salary: %d, \n Date: %s, \n", id,
							name, salary, date);
					System.out.println(row);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqlException) {
					System.out.println(sqlException.getMessage());

				}
			}
		}

	}
	private static Connection getsqlConnection() {
		Connection conn = null;
		String hostUrl = "jdbc:mysql://localhost:3306/payroll_services";
		String userName = "root";
		String password = "mymaths009!@A";
		try {
			conn = DriverManager.getConnection(hostUrl, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return conn;

	}

}
