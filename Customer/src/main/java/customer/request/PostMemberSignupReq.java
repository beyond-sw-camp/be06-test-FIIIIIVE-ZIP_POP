package customer.request;

public class PostMemberSignupReq {
    String customer_id;
    String customer_passwd;
    String customer_name;
    String customer_e_mail;
    String customer_phone;
    String customer_addr;
    Integer customer_point;
    Integer cancel_waiting_num;

    public String getCustomer_id() {
        return customer_id;
    }

    public String getCustomer_passwd() {
        return customer_passwd;
    }

    public String getCustomer_e_mail() {
        return customer_e_mail;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getCustomer_addr() {
        return customer_addr;
    }

    public Integer getCustomer_point() {
        return customer_point;
    }

    public Integer getCancel_waiting_num() {
        return cancel_waiting_num;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public void setCustomer_passwd(String customer_passwd) {
        this.customer_passwd = customer_passwd;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setCustomer_e_mail(String customer_e_mail) {
        this.customer_e_mail = customer_e_mail;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public void setCustomer_addr(String customer_addr) {
        this.customer_addr = customer_addr;
    }

    public void setCustomer_point(Integer customer_point) {
        this.customer_point = customer_point;
    }

    public void setCancel_waiting_num(Integer cancel_waiting_num) {
        this.cancel_waiting_num = cancel_waiting_num;
    }
}
