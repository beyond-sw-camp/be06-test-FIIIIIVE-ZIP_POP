package company.response;

public class PostMemberLoginRes {
    Integer company_idx;
    String company_id;
    String company_passwd;

    public PostMemberLoginRes(Integer company_idx, String company_id, String company_passwd) {
        this.company_idx = company_idx;
        this.company_id = company_id;
        this.company_passwd = company_passwd;
    }

    public Integer getCompany_idx() {
        return company_idx;
    }

    public String getCompany_id() {
        return company_id;
    }


    public void setCompany_idx(Integer company_idx) {
        this.company_idx = company_idx;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public void setCompany_name(String company_passwd) {
        this.company_passwd = company_passwd;
    }

    public String getCompany_passwd() {
        return company_passwd;
    }
}
