package company;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.BaseResponse;
import company.request.PostMemberLoginReq;
import company.response.PostMemberLoginRes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import static config.BaseResponseMessage.*;

@WebServlet("/company/login")
public class MemberLoginServlet extends HttpServlet {
    MemberDao dao;
    ObjectMapper mapper;

    @Override
    public void init() {
        dao = new MemberDao();
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // ------------------- 클라이언트로부터 요청을 받아서 Dto에 저장하는 부분 -------------------
        BufferedReader reader = req.getReader();
        StringBuilder json = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            json.append(line);
        }

        PostMemberLoginReq dto = mapper.readValue(json.toString(), PostMemberLoginReq.class);
        // ------------------- ------------------- -------------------


        // ------------------- 로그인 확인하는 Dao의 메소드 실행 -------------------
        PostMemberLoginRes result = dao.find(dto);
//        Boolean result = false;
        // ------------------- ------------------- -------------------


        // ------------------- Dao의 처리 결과에 따른 응답 설정 부분 -------------------
        String jsonResponse;
        if (result != null) {
            req.getSession().setAttribute("isLogin", true);
            req.getSession().setAttribute("company_id", result.getCompany_id());
            req.getSession().setAttribute("company_passwd", result.getCompany_passwd());

            BaseResponse response = new BaseResponse(MEMBER_LOGIN_SUCCESS);
            jsonResponse = mapper.writeValueAsString(response);
        } else {
            BaseResponse response = new BaseResponse(MEMBER_LOGIN_FAIL);
            jsonResponse = mapper.writeValueAsString(response);
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse);
        // ------------------- ------------------- -------------------

    }
}
