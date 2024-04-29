package Com.admin.model;

public class Stock {
private int comstock;
private int domstock;
public Stock(int comstock, int domstock) {
	super();
	this.comstock = comstock;
	this.domstock = domstock;
}
public int getComstock() {
	return comstock;
}
public void setComstock(int comstock) {
	this.comstock = comstock;
}
public int getDomstock() {
	return domstock;
}
public void setDomstock(int domstock) {
	this.domstock = domstock;
}

}