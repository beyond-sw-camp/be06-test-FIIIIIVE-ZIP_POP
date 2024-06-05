package customer.request;

public class PostMemberLoginReq {
    String customer_id;
    String customer_passwd;

    public String getCustomer_id() {
        return customer_id;
    }

    public String getCustomer_passwd() {
        return customer_passwd;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public void setCustomer_passwd(String customer_passwd) {
        this.customer_passwd = customer_passwd;
    }
}
