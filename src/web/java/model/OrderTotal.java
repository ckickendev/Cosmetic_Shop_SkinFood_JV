package web.java.model;

import web.java.dao.TransportDAO;
import web.java.dao.UserDAO;

public class OrderTotal {
    private String id;
    private float total;
    private String note;
    private int transport;
    private int user;
    private String phone;
    private float discount;
    private int status;
  
    public OrderTotal(String id, float total, String note, int transport, int user, String phone, float discount,
	    int status) {
	super();
	this.id = id;
	this.total = total;
	this.note = note;
	this.transport = transport;
	this.user = user;
	this.phone = phone;
	this.discount = discount;
	this.status = status;
    }
    public float getDiscount() {
        return discount;
    }
    public void setDiscount(float discount) {
        this.discount = discount;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public float getTotal() {
        return total;
    }
    public String getFormatTotal() {
	return String.format("%1$,.0f", this.getTotal());
    }
    public String getFormatTotalAfterDiscount() {
	return String.format("%1$,.0f", (this.getTotal() * 100) / (100-this.getDiscount()));
    }
    
    public void setTotal(float total) {
        this.total = total;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public int getTransport() {
        return transport;
    }

    public String getTransportName() {
	return new TransportDAO().getTransportNameById(Integer.toString(this.getTransport()));
    }
    
    public String getTransportFee() {
	return String.format("%1$,.0f", new TransportDAO().getTransportFeeById(Integer.toString(this.getTransport()) ));
    }
    public void setTransport(int transport) {
        this.transport = transport;
    }
    public int getUser() {
        return user;
    }
    public User getUserModel() {
	return new UserDAO().getUserById(Integer.toString(this.getUser()));
    }
    public void setUser(int user) {
        this.user = user;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}