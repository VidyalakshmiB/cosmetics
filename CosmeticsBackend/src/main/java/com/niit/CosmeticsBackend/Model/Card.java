package com.niit.CosmeticsBackend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

    @Entity
	@Component
	@Table
	public class Card {
		@Id
		private String card_Id;
		private String card_No;
		private String holder_Name;
		private int exp_Date;
		private int exp_Month;
		private int exp_Year;
		
		@ManyToOne
		@JoinColumn(name="User_Id")
		private User user;
		
		
		public Card(){
			this.card_Id="CARD"+UUID.randomUUID().toString().substring(30).toUpperCase();
		}


		public String getCard_Id() {
			return card_Id;
		}


		public void setCard_Id(String card_Id) {
			this.card_Id = card_Id;
		}


		public String getCard_No() {
			return card_No;
		}


		public void setCard_No(String card_No) {
			this.card_No = card_No;
		}


		public String getHolder_Name() {
			return holder_Name;
		}


		public void setHolder_Name(String holder_Name) {
			this.holder_Name = holder_Name;
		}


		public int getExp_Date() {
			return exp_Date;
		}


		public void setExp_Date(int exp_Date) {
			this.exp_Date = exp_Date;
		}


		public int getExp_Month() {
			return exp_Month;
		}


		public void setExp_Month(int exp_Month) {
			this.exp_Month = exp_Month;
		}


		public int getExp_Year() {
			return exp_Year;
		}


		public void setExp_Year(int exp_Year) {
			this.exp_Year = exp_Year;
		}


		public User getUser() {
			return user;
		}


		public void setUser(User user) {
			this.user = user;
		}
		
		

}
