package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int itemId;
	private String itemName;
	private String itemPrice;
	private String itemDescription;
	private String itemFilename;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getItemFilename() {
		return itemFilename;
	}
	public void setItemFilename(String itemFilename) {
		this.itemFilename = itemFilename;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice
				+ ", itemDescription=" + itemDescription + ", itemFilename=" + itemFilename + "]";
	}
	

}