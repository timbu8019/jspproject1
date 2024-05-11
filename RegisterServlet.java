package com.insurance.register;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Underwriter underwriter = new Underwriter();
        underwriter.setUnderwriterId(Integer.parseInt(request.getParameter("underwriter-id1")));
        underwriter.setUnderwriterPassword(request.getParameter("password"));
        underwriter.setName(request.getParameter("name"));
        underwriter.setDob(request.getParameter("dob"));
        underwriter.setDoj(request.getParameter("doj"));

        String DOB = underwriter.getDob();
        String DOJ = underwriter.getDoj();

        if (!isValidDateFormat(DOB) || !isValidDateFormat(DOJ)) {
            response.getWriter().println("<script>alert('Invalid date format. Please enter dates in the format DD/MM/YYYY.');</script>");
            return;
        }

        try {
            SimpleDateFormat dF = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date dob = dF.parse(DOB);
            java.util.Date doj = dF.parse(DOJ);

            if (dob.after(doj)) {
                response.getWriter().println("<script>alert('Date Of Joining Should Be A Date After Date Of Birth.');</script>");
                return;
            }

            java.sql.Date dob1 = new java.sql.Date(dob.getTime());
            java.sql.Date doj1 = new java.sql.Date(doj.getTime());

            String defaultPassword = underwriter.getUnderwriterPassword();
            
            
            System.out.println(request.getParameter("underwriter-id1"));
            System.out.println(request.getParameter("password"));
            System.out.println(request.getParameter("name"));
            System.out.println(request.getParameter("dob"));
            System.out.println(request.getParameter("doj"));
           
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            String jdbcURL = "jdbc:sqlite:C:\\Users\\prave\\MySQLiteDB";
            Connection connection = null;

            try {
                connection = DriverManager.getConnection(jdbcURL);
                insertData(connection, underwriter, dob1, doj1, defaultPassword, "UND_ROLE");

                response.sendRedirect("AdminHomePage.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("<script>alert('Connection Failed.');</script>");
            }
        } catch (ParseException e) {
            response.getWriter().println("<script>alert('Invalid Date Format. Please enter dates in the format DD/MM/YYYY.');</script>");
        }
    }

    private static boolean isValidDateFormat(String date) {
        return date.matches("^\\d{2}/\\d{2}/\\d{4}$");
    }

    private static void insertData(Connection connection, Underwriter underwriter, Date dob1, Date doj1,
            String defaultPassword, String role) throws SQLException {
        String sql = "insert into UnderWriterRegistration(underwriterid, name, DOB, DOJ, defaultPassword, role) values (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, underwriter.getUnderwriterId());
            pstmt.setString(2, underwriter.getName());
            pstmt.setDate(3, dob1);
            pstmt.setDate(4, doj1);
            pstmt.setString(5, defaultPassword);
            pstmt.setString(6, role);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data inserted into DB for underwriter ID: " + underwriter.getUnderwriterId());
            } else {
                System.out.println("Failed to insert data for underwriter ID: " + underwriter.getUnderwriterId());
            }
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
            throw e;
        }
    }
}
