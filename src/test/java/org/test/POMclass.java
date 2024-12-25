package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMclass extends BaseClass {
	
	public POMclass() {
		
	
	PageFactory.initElements(driver, this);

	}
	
	@FindBy(id="username")
	private WebElement username ;
	
	@FindBy(id="password")
	private WebElement password ;
	
	@FindBy(id="login")
	private WebElement login ;
	
	
	@FindBy(xpath="//td[@class='login_register']")
	private WebElement register;
	
	
	public WebElement getRegister() {
		return register;
	}

	@FindBy(id="location")
	private WebElement location ;
	
	@FindBy(id="hotels")
	private WebElement hotels ;
	
	@FindBy(id="room_type")
	private WebElement roomType ;
	
	@FindBy(id="room_nos")
	private WebElement roomNos ;
	
	
	@FindBy(id="datepick_in")
	private WebElement checkIN ;
	
	@FindBy(id="datepick_out")
	private WebElement checkOut ;
	
	@FindBy(id="adult_room")
	private WebElement adultRoom ;
	
	@FindBy(id="child_room")
	private WebElement childtRoom ;
	
	@FindBy(id="Submit")
	private WebElement searchRoom ;
	
	
	@FindBy(id="radiobutton_0")
	private WebElement radioButoon ;
	
	
	@FindBy(id="continue")
	private WebElement continueButton ;
	
	
	@FindBy(id="first_name")
	private WebElement first_name ;
	
	
	@FindBy(id="last_name")
	private WebElement last_name ;
	
	@FindBy(id="address")
	private WebElement address ;
	
	@FindBy(id="cc_num")
	private WebElement ccNumber ;
	
	@FindBy(id="cc_type")
	private WebElement cc_type ;
	
	@FindBy(id="cc_exp_month")
	private WebElement cc_exp_month ;
	
	@FindBy(id="cc_exp_year")
	private WebElement cc_exp_year ;
	
	@FindBy(id="cc_cvv")
	private WebElement cc_cvv ;
	
	
	@FindBy(id="book_now")
	private WebElement book_now ;
	
	
	@FindBy(name="order_no")
	private WebElement order_no ;
	
	
	
	public WebElement getOrder_no() {
		return order_no;
	}

	public WebElement getRadioButoon() {
		return radioButoon;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getFirst_name() {
		return first_name;
	}

	public WebElement getLast_name() {
		return last_name;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCcNumber() {
		return ccNumber;
	}

	public WebElement getCc_type() {
		return cc_type;
	}

	public WebElement getCc_exp_month() {
		return cc_exp_month;
	}

	public WebElement getCc_exp_year() {
		return cc_exp_year;
	}

	public WebElement getCc_cvv() {
		return cc_cvv;
	}

	public WebElement getBook_now() {
		return book_now;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getRoomNos() {
		return roomNos;
	}

	public WebElement getCheckIN() {
		return checkIN;
	}

	public WebElement getCheckOut() {
		return checkOut;
	}

	public WebElement getAdultRoom() {
		return adultRoom;
	}

	public WebElement getChildtRoom() {
		return childtRoom;
	}

	public WebElement getSearchRoom() {
		return searchRoom;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}



	
	
}
