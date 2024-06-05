package company.request;

public class PostMemberLoginReq {
    String company_id;
    String company_passwd;

    public String getCompany_id() {
        return company_id;
    }

    public String getCompany_passwd() {
        return company_passwd;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public void setCompany_passwd(String company_passwd) {
        this.company_passwd = company_passwd;
    }
}
