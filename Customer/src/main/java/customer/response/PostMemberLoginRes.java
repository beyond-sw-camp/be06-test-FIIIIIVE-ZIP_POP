package customer.response;

public class PostMemberLoginRes {
    Integer customer_idx;
    String customer_id;
    String customer_passwd;

    public PostMemberLoginRes(Integer customer_idx, String customer_id, String customer_passwd) {
        this.customer_idx = customer_idx;
        this.customer_id = customer_id;
        this.customer_passwd = customer_passwd;
    }

    public Integer getCustomer_idx() {
        return customer_idx;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_idx(Integer customer_idx) {
        this.customer_idx = customer_idx;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_passwd() {
        return customer_passwd;
    }

    public void setCustomer_passwd(String customer_passwd) {
        this.customer_passwd = customer_passwd;
    }
}
