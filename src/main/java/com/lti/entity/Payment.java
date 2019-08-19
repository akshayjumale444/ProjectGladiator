package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="AL_PAYMENT_DETAIL")
public class Payment {
	
	@Id
	@GeneratedValue
	@Column(name="PAYMENT_ID")
	private int paymentId;
	
	@Column(name="AMOUNT_PAID")
	private double amountPaid;
	
	@Column(name="PAYMENT_MODE")
	private String paymentMode;
	
	@OneToOne
	@JoinColumn(name="BOOKING_ID_FK")
	Booking booking;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	

}
