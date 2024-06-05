package customer;

import com.zaxxer.hikari.HikariDataSource;
import config.DataSourceConfigCustomer;
import customer.request.PostMemberLoginReq;
import customer.request.PostMemberSignupReq;
import customer.response.PostMemberLoginRes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
    HikariDataSource dataSourceConfig;

    MemberDao() {
        dataSourceConfig = DataSourceConfigCustomer.getInstance();
    }

    public Boolean create(PostMemberSignupReq dto) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        Integer result = null;
        try {
            connection = dataSourceConfig.getConnection();
            pstmt = connection.prepareStatement("INSERT INTO test.customer (customer_id, customer_name, " +
                    "customer_passwd, customer_addr, customer_phone, customer_e_mail, " +
                    "customer_point, cancel_waiting_num)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, dto.getCustomer_id());
            pstmt.setString(2, dto.getCustomer_name());
            pstmt.setString(3, dto.getCustomer_passwd());
            pstmt.setString(4, dto.getCustomer_addr());
            pstmt.setString(5, dto.getCustomer_phone());
            pstmt.setString(6, dto.getCustomer_e_mail());
            pstmt.setInt(7, dto.getCustomer_point());
            pstmt.setInt(8, dto.getCancel_waiting_num());
            result = pstmt.executeUpdate();

            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException sqlEx) {
                } // ignore
                pstmt = null;
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException sqlEx) {
                } // ignore
                connection = null;
            }
        }
        return false;
    }

    public PostMemberLoginRes find(PostMemberLoginReq dto) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = dataSourceConfig.getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM customer WHERE customer_id=? AND customer_passwd=?");
            pstmt.setString(1, dto.getCustomer_id());
            pstmt.setString(2, dto.getCustomer_passwd());
            rs = pstmt.executeQuery();
            PostMemberLoginRes postMemberLoginRes = null;
            if (rs.next()) {
                postMemberLoginRes = new PostMemberLoginRes(rs.getInt("customer_idx"), rs.getString("customer_id"), rs.getString("customer_passwd"));
            }

            return postMemberLoginRes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException sqlEx) {
                } // ignore
                pstmt = null;
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException sqlEx) {
                } // ignore
                connection = null;
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore
                rs = null;
            }
        }
    }
}
