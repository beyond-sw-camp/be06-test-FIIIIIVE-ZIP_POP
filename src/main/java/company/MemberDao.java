package company;

import board.response.GetBoardRes;
import com.zaxxer.hikari.HikariDataSource;
import config.DataSourceConfigCompany;
import company.request.PostMemberLoginReq;
import company.request.PostMemberSignupReq;
import company.response.PostMemberLoginRes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
    HikariDataSource dataSourceConfig;

    MemberDao() {
        dataSourceConfig = DataSourceConfigCompany.getInstance();
    }

    public Boolean create(PostMemberSignupReq dto) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        Integer result = null;
        try {
            connection = dataSourceConfig.getConnection();
            pstmt = connection.prepareStatement("INSERT INTO test.company (company_id, company_name,company_e_mail,company_passwd) VALUES (?, ?, ?, ?)");
            pstmt.setString(1, dto.getCompany_id());
            pstmt.setString(2, dto.getCompany_name());
            pstmt.setString(3, dto.getCompany_e_mail());
            pstmt.setString(4, dto.getCompany_passwd());
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
            pstmt = connection.prepareStatement("SELECT * FROM company WHERE company_id=? AND company_passwd=?");
            pstmt.setString(1, dto.getCompany_id());
            pstmt.setString(2, dto.getCompany_passwd());
            rs = pstmt.executeQuery();
            PostMemberLoginRes postMemberLoginRes = null;
            if (rs.next()) {
                postMemberLoginRes = new PostMemberLoginRes(rs.getInt("company_idx"), rs.getString("company_id"), rs.getString("company_passwd"));
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
