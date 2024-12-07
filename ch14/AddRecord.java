package ch14;

import java.sql.*;

public class AddRecord {
    public static void main(String[] args) {
        Connection conn;
        Statement stmt = null;

        String url = "jdbc:mysql://localhost:3306/bookdb_java";
        String user = "root";
        String password = "0427";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 완료");
            stmt = conn.createStatement();
            // int id = 0;

            printTable(stmt);
        } catch (ClassNotFoundException e) {
            System.out.println(e + "JDBC 드라이버 로드 에러");
        } catch (SQLException e) {
            System.out.println("SQL 실행 에러");
        }
    }

    private static void printTable(Statement stmt) {
        ResultSet srs;
        System.out.printf("%4s|%-30s|%-30s|%-10s\n", "id", "title", "publisher", "author");
        try {
            srs = stmt.executeQuery("select * from book");
            while (srs.next()) {
                System.out.printf("%4s|%-30s|%-30s|%-10s\n", new String(srs.getString("id")), srs.getString("title"), srs.getString("publisher"), srs.getString("author"));
            }
        } catch (SQLException e) {
            System.out.println("SQL 실행 에러");
        }
    }
}
