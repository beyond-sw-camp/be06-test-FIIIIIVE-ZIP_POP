package company.request;

public class PostMemberSignupReq {
    String company_id;
    String company_name;
    String company_e_mail;
    String company_passwd;

    public String getCompany_id() {
        return company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getCompany_e_mail() {
        return company_e_mail;
    }

    public String getCompany_passwd() {
        return company_passwd;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public void setCompany_e_mail(String company_e_mail) {
        this.company_e_mail = company_e_mail;
    }

    public void setCompany_passwd(String company_passwd) {
        this.company_passwd = company_passwd;
    }
}
