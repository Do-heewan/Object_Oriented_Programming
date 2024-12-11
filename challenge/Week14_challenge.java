package challenge;

import java.sql.*;

public class Week14_challenge {
    public static void main(String[] args) {
        Connection conn;
        Statement stmt = null;

        // 드라이버 설정 변수 선언
        String url = "jdbc:mysql://localhost:3306/bookdb_java";
        String user = "root";
        String password = "0427";

        try {
            Class.forName("com.mysql.jdbc.Driver"); // jdbc 드라이버 생성
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 완료");
            stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE book SET title = 'Pride & Prejudice', author = '제인 오스틴' WHERE id = 2"); // SQL문 작성

            printTable(stmt);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 에러");
        } catch (SQLException e) {
            System.out.println(e + "SQL 실행 에러");
        }
    }

    // SQL문 출력 메소드
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
