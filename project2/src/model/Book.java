package model;

import javax.persistence.*;

@Entity
public class Book {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String bookname;
private String bookprice;
private String bookdescription;
private String filename;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public String getBookprice() {
	return bookprice;
}
public void setBookprice(String bookprice) {
	this.bookprice = bookprice;
}
public String getBookdescription() {
	return bookdescription;
}
public void setBookdescription(String bookdescription) {
	this.bookdescription = bookdescription;
}
public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
@Override
public String toString() {
	return "Book [id=" + id + ", bookname=" + bookname + ", bookprice=" + bookprice + ", bookdescription="
			+ bookdescription + ", filename=" + filename + "]";
}

}
